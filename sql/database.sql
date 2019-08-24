CREATE TABLE `Bank`
(
  `Bank_ID` long PRIMARY KEY,
  `Bank_Details` varchar(255)
);

CREATE TABLE `Branches`
(
  `Branch_ID` long PRIMARY KEY,
  `Address_ID` long,
  `Bank_ID` long,
  `Branch_Type_Code` varchar(10),
  `Branch_Details` varchar(255)
);

CREATE TABLE `Branch_Services`
(
  `Branch_Type_Code` varchar(10) PRIMARY KEY,
  `Service_List` varchar(255)
);

CREATE TABLE `Addresses`
(
  `Address_ID` long PRIMARY KEY,
  `Street` varchar(255),
  `City` varchar(255),
  `Zip` varchar(255),
  `Region` varchar(255),
  `Country` varchar(255),
  `State` varchar(255)
);

CREATE TABLE `User`
(
  `User_ID` long PRIMARY KEY,
  `Nickname` varchar(10) UNIQUE,
  `Password` varchar(50),
  `Access_Status_Code` long,
  `Name` varchar(20),
  `Middle_Name` varchar(20),
  `Last_Name` varchar(20),
  `Phone_Prefix` int(5),
  `Phone` int(20) UNIQUE,
  `Mail` varchar(20) UNIQUE,
  `Address_ID` long,
  `Branch_ID` long
);

CREATE TABLE `Access_Details`
(
  `Access_Status_Code` long PRIMARY KEY,
  `Access_Value` tinyint(1) COMMENT '1 can log in and 0 cannot',
  `Access_Details` varchar(255) COMMENT 'why you are banned'
);

CREATE TABLE `Roles`
(
  `User_ID` long PRIMARY KEY,
  `Autorities` varchar(255)
);

CREATE TABLE `Bank_Account`
(
  `Account_Number` int(50) PRIMARY KEY,
  `Country_Code` varchar(5),
  `User_ID` long,
  `Balance` decimal(50)
);

CREATE TABLE `Account_Country_Code`
(
  `Country_Code` varchar(5) PRIMARY KEY,
  `Currency` varchar(5)
);

CREATE TABLE `Transaction`
(
  `Transaction_ID` long PRIMARY KEY,
  `Sender_Account_Code` varchar(5),
  `Sender_Account_Number` int(50),
  `Date` Date,
  `Receiver_Name` varchar(255),
  `Receiver_Account_Code` varchar(5),
  `Receiver_Account_Number` varchar(50),
  `Amount` decimal COMMENT 'do not use float',
  `Description` varchar(255),
  `Status` varchar(255)
);

ALTER TABLE `Bank_Account` ADD FOREIGN KEY (`User_ID`) REFERENCES `User` (`User_ID`);

ALTER TABLE `Roles` ADD FOREIGN KEY (`User_ID`) REFERENCES `User` (`User_ID`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`Sender_Account_Number`) REFERENCES `Bank_Account` (`Account_Number`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`Bank_ID`) REFERENCES `Bank` (`Bank_ID`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`Address_ID`) REFERENCES `Addresses` (`Address_ID`);

ALTER TABLE `User` ADD FOREIGN KEY (`Branch_ID`) REFERENCES `Branches` (`Branch_ID`);

ALTER TABLE `User` ADD FOREIGN KEY (`Address_ID`) REFERENCES `Addresses` (`Address_ID`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`Branch_Type_Code`) REFERENCES `Branch_Services` (`Branch_Type_Code`);

ALTER TABLE `Bank_Account` ADD FOREIGN KEY (`Country_Code`) REFERENCES `Account_Country_Code` (`Country_Code`);

ALTER TABLE `User` ADD FOREIGN KEY (`Access_Status_Code`) REFERENCES `Access_Details` (`Access_Status_Code`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`Receiver_Account_Code`) REFERENCES `Account_Country_Code` (`Country_Code`);

