CREATE PROCEDURE `createpolisea` ()
BEGIN
CREATE TABLE POLISEAHOLDERS (

            FNAME VARCHAR(50) not null,

            LNAME VARCHAR(50) PRIMARY KEY,

            AGE INT not null,

            HOME_OCEAN VARCHAR(50) not null,

			HOME_REEF VARCHAR(50) not null,

			HOME_DEPTH_METERS DECIMAL not null);
END
