-- insert some testing values
INSERT INTO `QR9KltXLfl`.`bank`
(`bankid`,
`bankdetails`)
VALUES
(0,
"Test Bank");

INSERT INTO `QR9KltXLfl`.`bankaccount`
(`accountnumber`,
`balance`,
`countrycode`,
`userid`)
VALUES
("29NWBK60161331926819",
500.45,
"GB",
0);


INSERT INTO `QR9KltXLfl`.`branchaddresses`
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


INSERT INTO `QR9KltXLfl`.`branches`
(`branchid`,
`baddressid`,
`bankid`,
`branchdetails`,
`branchtypecode`)
VALUES
(0,
0,
0,
"ATM, office",
111);


