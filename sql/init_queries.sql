-- insert some testing values

INSERT IGNORE INTO `ZCn3bDRv6O`.`bank`
(`bankid`,
`bankdetails`)
VALUES
(0,
"Test Bank");

INSERT IGNORE INTO `ZCn3bDRv6O`.`bankaccount`
(`senderaccountnumber`,
`balance`,
`userid`)
VALUES
("GB29NWBK60161331926819",
500.45,
0);


INSERT IGNORE INTO `ZCn3bDRv6O`.`branchaddresses`
(`baddressid`,
`city`,
`country`,
`region`,
`street`,
`zip`)
VALUES
(0,
"London",
"United Kingdom",
"Grass",
"St. Avenue 55",
"30888");


INSERT IGNORE INTO `ZCn3bDRv6O`.`branches`
(`branchid`,
`baddressid`,
`bankid`,
`branchdetails`,
`branchtypecode`)
VALUES
(0,
0,
0,
"Open every day from 9:00 to 20:00",
111);

INSERT IGNORE INTO `ZCn3bDRv6O`.`branchservices`
(`branchtypecode`,
`servicelist`)
VALUES
(111,
"ATM, office loans");

INSERT IGNORE INTO `ZCn3bDRv6O`.`role`
(`roleid`,
`rolename`)
VALUES
(0,
"USER");

INSERT IGNORE INTO `ZCn3bDRv6O`.`userrole`
(`userroleid`,
`roleid`,
`userid`)
VALUES
(0,
0,
0);

INSERT IGNORE INTO `ZCn3bDRv6O`.`useraddresses`
(`uaddressid`,
`city`,
`country`,
`region`,
`street`,
`zip`)
VALUES
(0,
"Birbingam",
"United Kingdom",
"Yellf",
"St. Fireball 57",
"45999");

INSERT IGNORE INTO `ZCn3bDRv6O`.`user`
(`userid`,
`accessstatuscode`,
`branchid`,
`middlename`,
`mail`,
`name`,
`password`,
`phone`,
`phoneprefix`,
`lastname`,
`uaddressid`,
`username`)
VALUES
(0,
1,
0,
"",
"figo@gmail.com",
"Mario",
"$2y$10$DwCKhjP6/D3eHCwOvkdy0ucQmWb9Wv4Y2aY.Oih4TrfnWLzTIuXe.",
"339870555",
"+77",
"Berry",
0,
"DickLong");

INSERT IGNORE INTO `ZCn3bDRv6O`.`transaction`
(`transactionid`,
`transamount`,
`transferdate`,
`transdescription`,
`receiveraccountnumber`,
`receivername`,
`senderaccountnumber`,
`transstatus`)
VALUES
(0,
100.50,
date(now()),
"dirty money",
"BG18RZBB91550123456789",
"Jose Piro",
"GB29NWBK60161331926819",
"complete");


