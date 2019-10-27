CREATE TABLE IF NOT EXIST `bank` (
  `bank_ID` int PRIMARY KEY,
  `bank_details` varchar(255)
);

CREATE TABLE IF NOT EXIST `branches` (
  `branch_ID` int PRIMARY KEY,
  `b_address_ID` int,
  `bank_ID` int,
  `branch_type_code` varchar(10),
  `branch_details` varchar(255)
);

CREATE TABLE IF NOT EXIST `branch_services` (
  `branch_type_code` varchar(10) PRIMARY KEY,
  `service_list` varchar(255)
);

CREATE TABLE IF NOT EXIST `user_addresses` (
  `u_address_ID` int PRIMARY KEY,
  `street` varchar(255),
  `city` varchar(255),
  `zip` varchar(255),
  `region` varchar(255),
  `country` varchar(255),
  `state` varchar(255)
);

CREATE TABLE IF NOT EXIST `branch_addresses` (
  `b_address_ID` int PRIMARY KEY,
  `street` varchar(255),
  `city` varchar(255),
  `zip` varchar(255),
  `region` varchar(255),
  `country` varchar(255),
  `state` varchar(255)
);

CREATE TABLE IF NOT EXIST `user` (
  `user_ID` int PRIMARY KEY,
  `username` varchar(10) UNIQUE,
  `password` varchar(50),
  `access_status_code` tinyint(1) COMMENT '1 ok, 0 banned',
  `name` varchar(20),
  `middle_name` varchar(20),
  `last_name` varchar(20),
  `phone_prefix` int(5),
  `phone` int(20) UNIQUE,
  `mail` varchar(20) UNIQUE,
  `u_address_ID` int,
  `branch_ID` int
);

CREATE TABLE IF NOT EXIST `bank_account` (
  `account_number` int(50) PRIMARY KEY,
  `country_code` varchar(5),
  `user_ID` int,
  `balance` decimal(50)
);

CREATE TABLE IF NOT EXIST `transaction` (
  `transaction_ID` int PRIMARY KEY,
  `sender_account_number` int(50),
  `transfer_date` Date,
  `receiver_name` varchar(255),
  `receiver_account_number` varchar(50),
  `trans_amount` decimal(50) COMMENT 'do not use float',
  `trans_description` varchar(255),
  `trans_status` varchar(255)
);

CREATE TABLE IF NOT EXIST `user_role` (
  `user_role_ID` int PRIMARY KEY,
  `user_ID` int,
  `role_ID` varchar(255)
);

CREATE TABLE IF NOT EXIST `role` (
  `role_ID` int PRIMARY KEY,
  `role_name` varchar(255)
);


