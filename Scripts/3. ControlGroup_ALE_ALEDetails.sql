USE siprasoft
/*Table structure for table `tbl_data_ale` */

DROP TABLE IF EXISTS `tbl_data_ale`;

CREATE TABLE `tbl_data_ale` (
  `ale_id` int(11) NOT NULL AUTO_INCREMENT,
  `ale_name` varchar(150) NOT NULL,
  `ale_fein` varchar(9) NOT NULL,
  `ale_address1` varchar(150) DEFAULT NULL,
  `ale_address2` varchar(150) DEFAULT NULL,
  `ale_city` varchar(75) DEFAULT NULL,
  `ale_province` varchar(75) DEFAULT NULL,
  `ale_state` varchar(75) DEFAULT NULL,
  `ale_zip` varchar(15) DEFAULT NULL,
  `ale_country` varchar(75) DEFAULT NULL,
  `ale_contact_first_name` varchar(50) DEFAULT NULL,
  `ale_contact_last_name` varchar(50) DEFAULT NULL,
  `ale_contact_contact_number` varchar(15) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(30) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  PRIMARY KEY (`ale_id`),
  UNIQUE KEY `UK_ALE_NAME` (`ale_name`),
  UNIQUE KEY `UK_ALE_FEIN` (`ale_fein`),
  UNIQUE KEY `UK_2eowwqj5n3oxucfnmn755p2gj` (`ale_name`,`ale_fein`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `tbl_data_ale_details` */

DROP TABLE IF EXISTS `tbl_data_ale_details`;

CREATE TABLE `tbl_data_ale_details` (
  `ale_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `ale_id` int(11) NOT NULL,
  `ale_tax_year` int(11) DEFAULT NULL,
  `is_aca_subscriber` varchar(1) NOT NULL DEFAULT 'N',
  `is_filing_authoritative_1094c` varchar(1) NOT NULL DEFAULT 'N',
  `is_aca_reporting_shared` varchar(1) NOT NULL DEFAULT 'N',
  `4980h_transition_relief` varchar(1) NOT NULL DEFAULT 'N',
  `additional_1095c_count` int(11) DEFAULT NULL,
  `control_group_id` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_jan` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_feb` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_mar` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_apr` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_may` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_jun` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_jul` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_aug` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_sep` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_oct` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_nov` int(11) DEFAULT NULL,
  `additiontional_fulltime_ee_dec` int(11) DEFAULT NULL,
  `additiontional_total_ee_jan` int(11) DEFAULT NULL,
  `additiontional_total_ee_feb` int(11) DEFAULT NULL,
  `additiontional_total_ee_mar` int(11) DEFAULT NULL,
  `additiontional_total_ee_apr` int(11) DEFAULT NULL,
  `additiontional_total_ee_may` int(11) DEFAULT NULL,
  `additiontional_total_ee_jun` int(11) DEFAULT NULL,
  `additiontional_total_ee_jul` int(11) DEFAULT NULL,
  `additiontional_total_ee_aug` int(11) DEFAULT NULL,
  `additiontional_total_ee_sep` int(11) DEFAULT NULL,
  `additiontional_total_ee_oct` int(11) DEFAULT NULL,
  `additiontional_total_ee_nov` int(11) DEFAULT NULL,
  `additiontional_total_ee_dec` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(30) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  PRIMARY KEY (`ale_details_id`),
  KEY `ale_id` (`ale_id`),
  KEY `control_group_id` (`control_group_id`),
  CONSTRAINT `tbl_data_ale_details_ibfk_1` FOREIGN KEY (`ale_id`) REFERENCES `tbl_data_ale` (`ale_id`),
  CONSTRAINT `tbl_data_ale_details_ibfk_2` FOREIGN KEY (`control_group_id`) REFERENCES `tbl_data_control_group` (`CONTROL_GROUP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `tbl_data_control_group` */

DROP TABLE IF EXISTS `tbl_data_control_group`;

CREATE TABLE `tbl_data_control_group` (
  `CONTROL_GROUP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTROL_GROUP_EIN` varchar(9) DEFAULT NULL,
  `CONTROL_GROUP_NAME` varchar(150) NOT NULL,
  `CREATED_BY` varchar(30) DEFAULT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `IS_ACTIVE` bit(1) DEFAULT NULL,
  `IS_DELETED` bit(1) DEFAULT NULL,
  `MEASUREMENT_END_DATE` date DEFAULT NULL,
  `MEASUREMENT_END_DATE_1` date DEFAULT NULL,
  `MEASUREMENT_END_DATE_2` date DEFAULT NULL,
  `MEASUREMENT_END_DATE_3` date DEFAULT NULL,
  `MEASUREMENT_END_DATE_4` date DEFAULT NULL,
  `MEASUREMENT_START_DATE` date DEFAULT NULL,
  `MODIFIED_BY` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CONTROL_GROUP_ID`),
  UNIQUE KEY `UK_CONTROL_GROUP_NAME` (`CONTROL_GROUP_NAME`),
  UNIQUE KEY `UK_3qi8c35dh3u3l1ir4t2kx8mx6` (`CONTROL_GROUP_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

