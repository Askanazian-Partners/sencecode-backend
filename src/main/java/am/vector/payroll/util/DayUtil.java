package am.vector.payroll.util;

import am.vector.payroll.api.model.ShiftDayModel;
import am.vector.payroll.constatns.DayShift;
import am.vector.payroll.constatns.Holiday;
import am.vector.payroll.entity.Workday;

import java.time.LocalDate;
import java.util.HashMap;
import java.time.Month;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class DayUtil {
    public static Workday generateDay(LocalDate day){
            Workday workday = new Workday();
            workday.setDay(day);
            workday.setWeekDay(day.getDayOfWeek());
            Holiday holiday = getHolidayStatus(day);
            workday.setHoliday(holiday);

            DayShift dayShift = getShiftStatus(day);
            workday.setShiftDay(dayShift);

        return workday;
    }

    private static Holiday getHolidayStatus(LocalDate date){
        Month month = date.getMonth();
        int day = date.getDayOfMonth();

        if(month == Month.JANUARY){
            if(day<6) return Holiday.JAN01_05;
            else if(day==6) return Holiday.JAN06;
            else if(day==7) return Holiday.JAN07;
            else if(day==28) return Holiday.JAN28;
            else return Holiday.NONE;
        } else if(month == Month.MARCH){
            if(day==8) return Holiday.MAR08;
            else return Holiday.NONE;
        } else if(month == Month.APRIL){
            if(day==24) return Holiday.APR24;
            else return Holiday.NONE;
        } else if(month == Month.MAY){
            if(day==1) return Holiday.MAY01;
            else if(day==9) return Holiday.MAY09;
            else if(day==28) return Holiday.MAY28;
            else return Holiday.NONE;
        } else if(month == Month.JULY){
            if(day==5) return Holiday.JUL05;
            else return Holiday.NONE;
        } else if(month == Month.SEPTEMBER){
            if(day==21) return Holiday.SEP21;
            else return Holiday.NONE;
        } else if(month == Month.DECEMBER){
            if(day==31) return Holiday.DEC31;
            else return Holiday.NONE;
        } else return Holiday.NONE;
    }


    private static DayShift getShiftStatus(LocalDate date){
        Map<LocalDate, ShiftDayModel> shiftDays = DayUtil.getDayShifts();

        ShiftDayModel shiftDay = shiftDays.get(date);
        if(shiftDay != null){
          if(shiftDay.isWorking()){
              return DayShift.TO_WORKING;
          } else {
              return DayShift.TO_NONE_WORKING;
          }
        } else {
            return DayShift.NONE;
        }
    }

    private static Map<LocalDate, ShiftDayModel> getDayShifts(){
        Map<LocalDate, ShiftDayModel> shiftDays = new HashMap<>();
        Document doc = IOUtil.readXML("day_shift");
        NodeList nList = doc.getElementsByTagName("shiftDays");

        String dateShiftFrom, dateShiftTo, text, decree, reasonIsHoliday;
        LocalDate date;
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                ShiftDayModel shiftDayFrom = new ShiftDayModel();
                ShiftDayModel shiftDayTo = new ShiftDayModel();
                Element eElement = (Element) nNode;
                dateShiftFrom = eElement.getElementsByTagName("fromDate").item(0).getTextContent();
                dateShiftTo = eElement.getElementsByTagName("toDate").item(0).getTextContent();
                text = eElement.getElementsByTagName("text").item(0).getTextContent();
                decree = eElement.getElementsByTagName("decree").item(0).getTextContent();
                reasonIsHoliday = eElement.getElementsByTagName("reasonIsHoliday").item(0).getTextContent();

                date = LocalDate.parse(dateShiftFrom);
                shiftDayFrom.setWorking(false)
                        .setDate(date)
                        .setDecree(decree)
                        .setText(text)
                        .setReasonIsHoliday("true".equals(reasonIsHoliday));
                shiftDays.put(date, shiftDayFrom);

                date = LocalDate.parse(dateShiftTo);
                shiftDayFrom.setWorking(true)
                        .setDate(date)
                        .setDecree(decree)
                        .setText(text)
                        .setReasonIsHoliday("true".equals(reasonIsHoliday));
                shiftDays.put(date, shiftDayTo);
            }
        }
        return shiftDays;
    }

}
