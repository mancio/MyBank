#drop all tables independently by foreigner keys
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS
bank, branches, branchservices, useraddresses, branchaddresses,
user, bankaccount, transaction, userrole, role;
SET foreign_key_checks = 1;
