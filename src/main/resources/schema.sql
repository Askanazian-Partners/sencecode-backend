use payroll;

#CREATE USER 'admin'@'localhost' IDENTIFIED BY '59518';
#GRANT ALL PRIVILEGES ON * . * TO 'admin'@'localhost';

DROP TABLE IF EXISTS timesheet;
DROP TABLE IF EXISTS payslip;
DROP TABLE IF EXISTS absence;
DROP TABLE IF EXISTS contract;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employment;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS company;

CREATE TABLE person(
  ssn CHAR(10) PRIMARY KEY,
  code VARCHAR(10) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  middle_name VARCHAR(100),
  email VARCHAR(50) UNIQUE,
  cell CHAR(11) UNIQUE,
  birthday DATE,
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX person_Idx(tin, state)
);

# INSERT INTO person (ssn, code, first_name, last_name, middle_name, email, cell, birthday, tin, recorderUUID) VALUES('9876543210','0010','Abovyan','Davit','Levoni','davit.abovyan@yahoo.com','37499618335','1982-05-11','12345678', '123e4567e89b12d3a456426655440000');

CREATE TABLE company (
  tin CHAR(8) PRIMARY KEY,
  email VARCHAR(50) UNIQUE NOT NULL,
  cell CHAR(11) UNIQUE NOT NULL,
  name TEXT,
  address TEXT,
  work_week TINYINT,
  ceoSSN CHAR(10),
  cfoSSN CHAR(10),
  CONSTRAINT company_ceo_ssn_fk FOREIGN KEY (ceoSSN) REFERENCES person(ssn) ON DELETE CASCADE,
  CONSTRAINT company_cfo_ssn_fk FOREIGN KEY (cfoSSN) REFERENCES person(ssn) ON DELETE CASCADE
);

#INSERT INTO company VALUES ('12345678','davit.abovyan@gmai.com','37491618335','My company','Yerevan',6,'9876543210','0123456789');

CREATE TABLE employment (
  uuid CHAR(32) PRIMARY KEY,
  person_ssn CHAR(10) NOT NULL,
  hire_date DATE,
  termination_date DATE,
  vacation_balance TINYINT,
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX employee_ssn (tin, person_ssn),
  CONSTRAINT employee_ssn_fk FOREIGN KEY (person_ssn) REFERENCES person(ssn) ON DELETE CASCADE
);

#INSERT INTO employee (uuid, ssn, hire_day, termination_day, vacation_balance, tin) VALUES ('123e4567e89b12d3a456426655440000', '0123456789', '2018-05-02', '2018-06-04',20,'12345678' );

CREATE TABLE department (
  uuid CHAR(32) PRIMARY KEY,
  code VARCHAR(10) NOT NULL,
  name VARCHAR(255) NOT NULL,
  cost_center VARCHAR(10),
  head_ssn CHAR(10) NOT NULL,
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX department_idx (tin, state),
  CONSTRAINT department_head_fk FOREIGN KEY (head_ssn) REFERENCES person(ssn) ON DELETE CASCADE
);

# INSERT INTO department VALUES ('123e4567e89b12d3a456426655440000','0010','Accounting','7131','0123456789','CURRENT','12345678');


CREATE TABLE role (
  uuid CHAR(32) PRIMARY KEY,
  code VARCHAR(10) NOT NULL,
  name TEXT NOT NULL,
  description TEXT,
  labor_relation BIT,
  eligible_days TINYINT,
  department_uuid CHAR(32),
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX role_idx (tin, state),
  CONSTRAINT role_department_uuid_fk FOREIGN KEY (department_uuid) REFERENCES department(uuid) ON DELETE CASCADE
);

# INSERT INTO role VALUES ('123e4567e89b12d3a456426655440000','0001','Accountant','something',0,20,'123e4567e89b12d3a456426655440000','CURRENT','12345678');

CREATE TABLE contract (
  uuid CHAR(32) PRIMARY KEY,
  person_ssn CHAR(10) NOT NULL,
  role_uuid CHAR(32) NOT NULL,
  salary INT UNSIGNED NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE,
  daily_hours TINYINT,
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX contract_idx (tin, state),
  CONSTRAINT contract_ssn_fk FOREIGN KEY (person_ssn) REFERENCES person(ssn) ON DELETE CASCADE,
  CONSTRAINT contract_role_uuid_fk FOREIGN KEY (role_uuid) REFERENCES role(uuid) ON DELETE CASCADE
);

#INSERT INTO contract VALUES ('123e4567e89b12d3a456426655440000','0123456789','123e4567e89b12d3a456426655440000',250000,'2018-05-01',NULL,8,'CURRENT','12345678');

CREATE TABLE absence (
  uuid CHAR(32) PRIMARY KEY,
  leave_type ENUM('VACATION','SICK_LEAVE','MATERNITY_LEAVE','UNPAID_LEAVE') NOT NULL,
  amount INT UNSIGNED,
  ssn CHAR(10) NOT NULL,
  period CHAR(4) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE,
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX absence_period_ssn (tin, period, ssn),
  CONSTRAINT absence_ssn_fk FOREIGN KEY (ssn) REFERENCES person(ssn) ON DELETE CASCADE
);

# INSERT INTO absence VALUES ('123e4567e89b12d3a456426655440000','VACATION',25000,'0123456789','0517','2017-05-02',null,'CURRENT','12345678');

CREATE TABLE payslip (
  uuid CHAR(32) PRIMARY KEY,
  period CHAR(4) NOT NULL,
  person_ssn CHAR(10) NOT NULL,
  wage INT UNSIGNED NOT NULL,
  overtime INT UNSIGNED NOT NULL,
  bonus INT UNSIGNED NOT NULL,
  ssp INT UNSIGNED NOT NULL,
  it INT UNSIGNED NOT NULL,
  army INT UNSIGNED NOT NULL,
  has_update BIT,
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX absence_period_ssn (tin, period, person_ssn),
  CONSTRAINT payslip_ssn_fk FOREIGN KEY (person_ssn) REFERENCES person(ssn) ON DELETE CASCADE
);

# INSERT INTO payslip VALUES ('123e4567e89b12d3a456426655440000','0517','0123456789',15000,0,0,500,25000,1000,0,'CURRENT','12345678');

CREATE TABLE timesheet (
  uuid CHAR(32) PRIMARY KEY,
  period CHAR(4) NOT NULL,
  person_ssn CHAR(10) NOT NULL,
  day1 TINYINT UNSIGNED NOT NULL,
  day2 TINYINT UNSIGNED NOT NULL,
  day3 TINYINT UNSIGNED NOT NULL,
  day4 TINYINT UNSIGNED NOT NULL,
  day5 TINYINT UNSIGNED NOT NULL,
  day6 TINYINT UNSIGNED NOT NULL,
  day7 TINYINT UNSIGNED NOT NULL,
  day8 TINYINT UNSIGNED NOT NULL,
  day9 TINYINT UNSIGNED NOT NULL,
  day10 TINYINT UNSIGNED NOT NULL,
  day11 TINYINT UNSIGNED NOT NULL,
  day12 TINYINT UNSIGNED NOT NULL,
  day13 TINYINT UNSIGNED NOT NULL,
  day14 TINYINT UNSIGNED NOT NULL,
  day15 TINYINT UNSIGNED NOT NULL,
  day16 TINYINT UNSIGNED NOT NULL,
  day17 TINYINT UNSIGNED NOT NULL,
  day18 TINYINT UNSIGNED NOT NULL,
  day19 TINYINT UNSIGNED NOT NULL,
  day20 TINYINT UNSIGNED NOT NULL,
  day21 TINYINT UNSIGNED NOT NULL,
  day22 TINYINT UNSIGNED NOT NULL,
  day23 TINYINT UNSIGNED NOT NULL,
  day24 TINYINT UNSIGNED NOT NULL,
  day25 TINYINT UNSIGNED NOT NULL,
  day26 TINYINT UNSIGNED NOT NULL,
  day27 TINYINT UNSIGNED NOT NULL,
  day28 TINYINT UNSIGNED NOT NULL,
  day29 TINYINT UNSIGNED NOT NULL,
  day30 TINYINT UNSIGNED NOT NULL,
  day31 TINYINT UNSIGNED NOT NULL,
  total SMALLINT NOT NULL,
  state ENUM('CURRENT','DELETED','REMOVED'),
  tin CHAR(8) NOT NULL,
  recorderUUID CHAR(32) NOT NULL,
  recorded_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX timesheet_period_ssn (tin, period, person_ssn),
  CONSTRAINT timesheet_ssn_fk FOREIGN KEY (person_ssn) REFERENCES person(ssn) ON DELETE CASCADE
);

CREATE  TABLE user (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  enabled TINYINT NOT NULL ,
  PRIMARY KEY (username)
);

CREATE TABLE authority (
  roleID int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (roleID),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES user (username)
);

#show CHARACTER SET ;
#show COLLATION WHERE charset='utf8';

#SHOW create table contract;


INSERT INTO user(username,password,enabled)
VALUES ('priya','$2a$10$dwOg9ETAP0XlW4ukHXq95eWJJfGLv8o25u4kG/dj4PO6E1EHvd6a2', true);
INSERT INTO user(username,password,enabled)
VALUES ('naveen','$2a$10$UY502zz2svA9E/xHlpZ.5OKkzR5yFc3q5uxu2Dv/XKtOnikE1xDOu', true);
INSERT INTO authority (username, role)
VALUES ('priya', 'ROLE_USER');
INSERT INTO authority (username, role)
VALUES ('priya', 'ROLE_ADMIN');
INSERT INTO authority (username, role)
VALUES ('naveen', 'ROLE_ADMIN');