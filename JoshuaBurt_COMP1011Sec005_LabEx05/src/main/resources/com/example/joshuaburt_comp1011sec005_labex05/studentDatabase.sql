CREATE DATABASE institution;
USE institution;

CREATE TABLE Student (
studentID char(9) NOT NULL,
firstName varchar (20) NOT NULL,
lastName varchar (20) NOT NULL,
address varchar (30) NOT NULL,
city varchar(30) NOT NULL,
province char(2) NOT NULL,
postalCode char(6) NOT NULL,
PRIMARY KEY (studentID)
);
DROP TABLE Student;

INSERT INTO Student (studentID, firstName, lastName, address, city, province, postalCode) VALUES 
('000000001','Assad', 'Turk', '7 FinalFantasy Circle', 'Florence','IT','M1Y2H2'),
('000000010','Sadam', 'Barret', '7 FinalFantasy Square', 'Florence','IT','M1Y2H2'),
('000000011','Barack', 'Angeal', '7 FinalFantasy Lane', 'Vienna','AU','M1Y2H2'),
('000000100','Joseph', 'Genesis', '7 FinalFantasy Way', 'Vienna','AU','M1Y2H2'),
('000000101','Donald', 'Cloud', '7 FinalFantasy Street', 'Vieena','CZ','M1Y2H2'),
('000000110','Vladimir', 'Shinra', '7 FinalFantasy Sideroad', 'Florence','IT','M1Y2H2'),
('000000111','Justin', 'Zack-Fair', '7 FinalFantasy Trail', 'Rome','IT','M1Y2H2'),
('000001000','Boris', 'Chocobo', '7 FinalFantasy Terrace', 'Rome','IT','M1Y2H2'),
('000001001','Emanuel', 'Vincent', '7 FinalFantasy Rue', 'Rome','IT','M1Y2H2'),
('000001010','Kissinger','Jenova', '7 FinalFantasy Avenue', 'Sofia','BU','M1Y2H2'),
('000001011','Noah', 'Sephiroth', '7 FinalFantasy Route', 'Sofia','BU','M1Y2H2'),
('000001101','Test', 'Tube1', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000001110','Test', 'Tube2', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000001111','Test', 'Tube3', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010000','In', 'Vivo1', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010001','In', 'Vivo2', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010010','In', 'Vivo3', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010011','r2d2', 'One1', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010100','r2d2', 'One2', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010101','r2d2', 'One3', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010110','The', 'Thing1', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000010111','The', 'Thing2', '666 Research Lane', 'St. Helena','Island','M1Y2H2'),
('000011000','The', 'Thing3', '666 Research Lane', 'St. Helena','Island','M1Y2H2');