package am.vector.payroll.api.adapter;

import am.vector.payroll.entity.Person;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class PersonTypeAdapter extends TypeAdapter<Person>{

    @Override
    public void write(JsonWriter jsonWriter, Person person) throws IOException {

    }

    @Override
    public Person read(JsonReader jsonReader) throws IOException {
        Person person = new Person();
        jsonReader.beginObject();
        while(jsonReader.hasNext()){
            if("ssn".equals(jsonReader.nextName()) ){
                person.setSsn(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return person;
    }
}
