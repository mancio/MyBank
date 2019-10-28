# drop all tables
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS
bank, branches, branch_services, user_addresses, branch_addresses,
user, bank_account, transaction, user_role, role;
SET foreign_key_checks = 1;


CREATE TABLE IF NOT EXISTS `bank` (
  `bank_ID` bigint PRIMARY KEY,
  `bank_details` varchar(255)
);

CREATE TABLE IF NOT EXISTS `branch_services` (
  `branch_type_code` varchar(50) PRIMARY KEY,
  `service_list` varchar(255)
);

CREATE TABLE IF NOT EXISTS `branch_addresses` (
  `b_address_ID` bigint PRIMARY KEY,
  `street` varchar(60),
  `city` varchar(60),
  `zip` varchar(60),
  `region` varchar(60),
  `country` varchar(60),
  `state` varchar(60)
);

CREATE TABLE IF NOT EXISTS `branches` (
  `branch_ID` bigint PRIMARY KEY,
  `b_address_ID` bigint,
  `bank_ID` bigint,
  `branch_type_code` varchar(50),
  `branch_details` varchar(255),
  FOREIGN KEY (bank_ID) REFERENCES bank(bank_ID),
  FOREIGN KEY (branch_type_code) REFERENCES branch_services(branch_type_code),
  FOREIGN KEY (b_address_ID) REFERENCES branch_addresses(b_address_ID)
);


CREATE TABLE IF NOT EXISTS `user_addresses` (
  `u_address_ID` bigint PRIMARY KEY,
  `street` varchar(60) NOT NULL,
  `city` varchar(60),
  `zip` varchar(60),
  `region` varchar(60),
  `country` varchar(60),
  `state` varchar(60)
);


CREATE TABLE IF NOT EXISTS `user` (
  `user_ID` bigint PRIMARY KEY,
  `username` varchar(60) UNIQUE,
  `password` varchar(60),
  `access_status_code` tinyint(1) COMMENT '1 ok, 0 banned',
  `name` varchar(60),
  `middle_name` varchar(60),
  `last_name` varchar(60),
  `phone_prefix` int(5),
  `phone` int(20) UNIQUE,
  `mail` varchar(20) UNIQUE,
  `u_address_ID` bigint,
  `branch_ID` bigint,
  FOREIGN KEY (branch_ID) REFERENCES branches(branch_ID),
  FOREIGN KEY (u_address_ID) REFERENCES user_addresses(u_address_ID)
);


CREATE TABLE IF NOT EXISTS `bank_account` (
  `account_number` int(60) PRIMARY KEY,
  `country_code` varchar(5),
  `user_ID` bigint,
  `balance` decimal(20,2),
  FOREIGN KEY (user_ID) REFERENCES user(user_ID)
);

CREATE TABLE IF NOT EXISTS `transaction` (
  `transaction_ID` bigint PRIMARY KEY,
  `sender_account_number` int(60),
  `transfer_date` Date,
  `receiver_name` varchar(255),
  `receiver_account_number` varchar(60),
  `trans_amount` decimal(20,2) COMMENT 'do not use float',
  `trans_description` varchar(255),
  `trans_status` varchar(255),
  FOREIGN KEY (sender_account_number) REFERENCES bank_account(account_number)
);

CREATE TABLE IF NOT EXISTS `role` (
  `role_ID` bigint PRIMARY KEY,
  `role_name` varchar(255)
);

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_role_ID` bigint PRIMARY KEY,
  `user_ID` bigint,
  `role_ID` bigint,
  FOREIGN KEY (user_ID) REFERENCES user(user_ID),
  FOREIGN KEY (role_ID) REFERENCES role(role_ID)
);

