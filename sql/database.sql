CREATE TABLE `Bank`
(
  `Bank_ID` long PRIMARY KEY,
  `Bank_Details` long
);

CREATE TABLE `Branches`
(
  `Branch_ID` long PRIMARY KEY,
  `Address_ID` long,
  `Bank_ID` long,
  `Branch_Type_Code` varchar(255),
  `Branch_Details` long
);

CREATE TABLE `Addresses`
(
  `Address_ID` long,
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
  `Nickname` varchar(255) UNIQUE,
  `Password` varchar(255),
  `Name` varchar(255),
  `Surname` varchar(255),
  `Phone` varchar(255),
  `Mail` varchar(255),
  `Address_ID` long,
  `Branch_ID` long
);

CREATE TABLE `Roles`
(
  `User_ID` long,
  `Autorities` varchar(255),
  `Enable` tinyint(1) COMMENT '1 can log in and 0 cannot'
);

CREATE TABLE `Bank_Account`
(
  `Account_number` varchar(255) PRIMARY KEY,
  `User_ID` long,
  `Currency` varchar(255),
  `Balance` decimal
);

CREATE TABLE `Transaction`
(
  `Transaction_ID` long PRIMARY KEY,
  `Sender_account_number` varchar(255),
  `Date` Date,
  `Receiver_Name` varchar(255),
  `Receiver_account` varchar(255),
  `Amount` decimal COMMENT 'do not use float',
  `Description` varchar(255),
  `Status` varchar(255)
);

ALTER TABLE `Bank_Account` ADD FOREIGN KEY (`User_ID`) REFERENCES `User` (`User_ID`);

ALTER TABLE `Roles` ADD FOREIGN KEY (`User_ID`) REFERENCES `User` (`User_ID`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`Sender_account_number`) REFERENCES `Bank_Account` (`Account_number`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`Bank_ID`) REFERENCES `Bank` (`Bank_ID`);

ALTER TABLE `Branches` ADD FOREIGN KEY (`Address_ID`) REFERENCES `Addresses` (`Address_ID`);

ALTER TABLE `User` ADD FOREIGN KEY (`Branch_ID`) REFERENCES `Branches` (`Branch_ID`);

ALTER TABLE `User` ADD FOREIGN KEY (`Address_ID`) REFERENCES `Addresses` (`Address_ID`);
