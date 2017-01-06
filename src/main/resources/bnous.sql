CREATE TABLE `employee_t` (
  `e_id` int(11) NOT NULL,
  `e_name` varchar(20) NOT NULL,
  `e_sex` varchar(10) NOT NULL,
  `e_title` VARCHAR(40) NOT NULL,
  `e_phone` VARCHAR(11) NOT NULL,
  `e_intro` TEXT,
  `order_by` int(11),
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pay_t`(
`p_id` int(11) NOT NULL,
`e_id` int(11) NOT NULL,
`p_per` VARCHAR(100),
`p_absence` INT(5),
`p_bonus` INT(11),
`p_fine` INT(11),
`p_total` INT(11),
`p_year` CHAR(5),
`p_mounth` CHAR(2),
`p_status` INT(1),
`p_time` datetime,
`order_by` int(11),
FOREIGN KEY (`e_id`) REFERENCES `employee_t`(`e_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `admin_t`(
`a_id` int(11) NOT NULL,
`a_name` VARCHAR (20) NOT NULL,
`a_pass` VARCHAR(20) NOT NULL,
`a_phone` int(11)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `new_t`(
`n_id` INT(11) NOT NULL,
`n_author` VARCHAR(20) NOT NULL,
`n_text` TEXT,
`n_time` datetime,
PRIMARY KEY(`n_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;