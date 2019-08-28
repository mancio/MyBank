CREATE TABLE `Bank`
(
  `Bank_ID` int PRIMARY KEY,
  `Bank_Details` varchar(255)
);

CREATE TABLE `Branches`
(
  `Branch_ID` int PRIMARY KEY,
  `B_Address_ID` int,
  `Bank_ID` int,
  `Branch_Type_Code` varchar(10),
  `Branch_Details` varchar(255)
);

CREATE TABLE `Branch_Services`
(
  `Branch_Type_Code` varchar(10) PRIMARY KEY,
  `Service_List` varchar(255)
);

CREATE TABLE `User_Addresses`
(
  `U_Address_ID` int PRIMARY KEY,
  `Street` varchar(255),
  `City` varchar(255),
  `Zip` varchar(255),
  `Region` varchar(255),
  `Country` varchar(255),
  `State` varchar(255)
);

CREATE TABLE `Branches_Addresses`
(
  `B_Address_ID` int PRIMARY KEY,
  `Street` varchar(255),
  `City` varchar(255),
  `Zip` varchar(255),
  `Region` varchar(255),
  `Country` varchar(255),
  `State` varchar(255)
);

CREATE TABLE `User`
(
  `User_ID` int PRIMARY KEY,
  `Nickname` varchar(10) UNIQUE,
  `Password` varchar(50),
  `Access_Status_Code` tinyint(1) COMMENT '1 ok, 0 banned',
  `Name` varchar(20),
  `Middle_Name` varchar(20),
  `Last_Name` varchar(20),
  `Phone_Prefix` int(5),
  `Phone` int(20) UNIQUE,
  `Mail` varchar(20) UNIQUE,
  `U_Address_ID` int,
  `Branch_ID` int
);

CREATE TABLE `Access_Details`
(
  `Access_Status_Code` tinyint(1) PRIMARY KEY,
  `Access_Description` varchar(255)
);

CREATE TABLE `Roles`
(
  `User_ID` int,
  `Authorities` varchar(255)
);

CREATE TABLE `Bank_Account`
(
  `Account_Number` int(50) PRIMARY KEY,
  `Country_Code` varchar(5),
  `User_ID` int,
  `Balance` decimal(50)
);

CREATE TABLE `Account_Country_Code`
(
  `Country_Code` varchar(5) PRIMARY KEY,
  `Currency` varchar(5)
);

CREATE TABLE `Transaction`
(
  `Transaction_ID` int PRIMARY KEY,
  `Sender_Account_Code` varchar(5),
  `Sender_Account_Number` int(50),
  `Date` Date,
  `Receiver_Name` varchar(255),
  `Receiver_Account_Code` varchar(5),
  `Receiver_Account_Number` varchar(50),
  `Amount` decimal(50) COMMENT 'do not use float',
  `Description` varchar(255),
  `Status` varchar(255)
);

ALTER TABLE `Bank_Account` ADD FOREIGN KEY (`User_ID`) REFERENCES `User` (`User_ID`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`Sender_Account_Number`) REFERENCES `Bank_Account` (`Account_Number`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`Bank_ID`) REFERENCES `Bank` (`Bank_ID`);

ALTER TABLE `User` ADD FOREIGN KEY (`Branch_ID`) REFERENCES `Branches` (`Branch_ID`);

ALTER TABLE `User` ADD FOREIGN KEY (`U_Address_ID`) REFERENCES `User_Addresses` (`U_Address_ID`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`B_Address_ID`) REFERENCES `Branches_Addresses` (`B_Address_ID`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`Branch_Type_Code`) REFERENCES `Branch_Services` (`Branch_Type_Code`);

ALTER TABLE `Bank_Account` ADD FOREIGN KEY (`Country_Code`) REFERENCES `Account_Country_Code` (`Country_Code`);

ALTER TABLE `Roles` ADD FOREIGN KEY (`User_ID`) REFERENCES `User` (`User_ID`);

ALTER TABLE `User` ADD FOREIGN KEY (`Access_Status_Code`) REFERENCES `Access_Details` (`Access_Status_Code`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`Receiver_Account_Code`) REFERENCES `Account_Country_Code` (`Country_Code`);

