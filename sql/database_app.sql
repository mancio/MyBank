#drop all tables independently by foreigner keys
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS
bank, branches, branchservices, useraddresses, branchaddresses,
user, bankaccount, transaction, userrole, role;
SET foreign_key_checks = 1;


CREATE TABLE IF NOT EXISTS `bank` (
  `bankid` bigint PRIMARY KEY,
  `bankdetails` varchar(255)
);

CREATE TABLE IF NOT EXISTS `branchservices` (
  `branchtypecode` varchar(50) PRIMARY KEY,
  `servicelist` varchar(255)
);

CREATE TABLE IF NOT EXISTS `branchaddresses` (
  `baddressid` bigint PRIMARY KEY,
  `street` varchar(60),
  `city` varchar(60),
  `zip` varchar(60),
  `region` varchar(60),
  `country` varchar(60),
  `state` varchar(60)
);

CREATE TABLE IF NOT EXISTS `branches` (
  `branchid` bigint PRIMARY KEY,
  `baddressid` bigint,
  `bankid` bigint,
  `branchtypecode` varchar(50),
  `branchdetails` varchar(255),
  FOREIGN KEY (bankid) REFERENCES bank(bankid),
  FOREIGN KEY (branchtypecode) REFERENCES branchservices(branchtypecode),
  FOREIGN KEY (baddressid) REFERENCES branchaddresses(baddressid)
);


CREATE TABLE IF NOT EXISTS `useraddresses` (
  `uaddressid` bigint PRIMARY KEY,
  `street` varchar(60) NOT NULL,
  `city` varchar(60),
  `zip` varchar(60),
  `region` varchar(60),
  `country` varchar(60),
  `state` varchar(60)
);


CREATE TABLE IF NOT EXISTS `user` (
  `userid` bigint PRIMARY KEY,
  `username` varchar(60) UNIQUE,
  `password` varchar(60),
  `accessstatuscode` tinyint(1) COMMENT '1 ok, 0 banned',
  `name` varchar(60),
  `middlename` varchar(60),
  `lastname` varchar(60),
  `phoneprefix` int(5),
  `phone` int(20) UNIQUE,
  `mail` varchar(20) UNIQUE,
  `uaddressid` bigint,
  `branchid` bigint,
  FOREIGN KEY (branchid) REFERENCES branches(branchid),
  FOREIGN KEY (uaddressid) REFERENCES useraddresses(uaddressid)
);


CREATE TABLE IF NOT EXISTS `bankaccount` (
  `accountnumber` int(60) PRIMARY KEY,
  `countrycode` varchar(5),
  `userid` bigint,
  `balance` decimal(20,2),
  FOREIGN KEY (userid) REFERENCES user(userid)
);

CREATE TABLE IF NOT EXISTS `transaction` (
  `transactionid` bigint PRIMARY KEY,
  `accountnumber` int(60),
  `transferdate` Date,
  `receivername` varchar(255),
  `receiveraccountnumber` varchar(60),
  `transamount` decimal(20,2) COMMENT 'do not use float',
  `transdescription` varchar(255),
  `transstatus` varchar(255),
  FOREIGN KEY (accountnumber) REFERENCES bankaccount(accountnumber)
);

CREATE TABLE IF NOT EXISTS `role` (
  `roleid` bigint PRIMARY KEY,
  `rolename` varchar(255)
);

CREATE TABLE IF NOT EXISTS `userrole` (
  `userroleid` bigint PRIMARY KEY,
  `userid` bigint,
  `roleid` bigint,
  FOREIGN KEY (userid) REFERENCES user(userid),
  FOREIGN KEY (roleid) REFERENCES role(roleid)
);

