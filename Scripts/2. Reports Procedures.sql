-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

USE `siprasoft` ;

-- -----------------------------------------------------
-- procedure PRC_BreakInService_ReportData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_BreakInService_ReportData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_BreakInService_ReportData`( IN workYear VARCHAR(4),
          IN controlGroup VARCHAR(100),IN weekStarting VARCHAR(10),IN weekEnding VARCHAR(10))
BEGIN
SELECT FIRST_NAME,LAST_NAME,SOC_SEC_NUMBER,SERVICE_STATUS,
WEEK_STARTING,WEEK_ENDING,WEEK_COUNT,CONTROL_GROUP,WORK_YEAR
FROM tbl_breakinservicereport WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup)
        AND (weekStarting IS NULL OR WEEK_STARTING=weekStarting)
        AND (weekEnding IS NULL OR WEEK_ENDING=weekEnding);
 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_BreakIn_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_BreakIn_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_BreakIn_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='BreakIn' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_BreakIn_ReferenceData_Week_Ending
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_BreakIn_ReferenceData_Week_Ending`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_BreakIn_ReferenceData_Week_Ending`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='BreakIn' AND FieldName='WeekEnding';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_BreakIn_ReferenceData_Week_Starting
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_BreakIn_ReferenceData_Week_Starting`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_BreakIn_ReferenceData_Week_Starting`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='BreakIn' AND FieldName='WeekStarting';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_BreakIn_ReferenceData_WorkYear
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_BreakIn_ReferenceData_WorkYear`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_BreakIn_ReferenceData_WorkYear`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='BreakIn' AND FieldName='WorkYear';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Demographics_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Demographics_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Demographics_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='DemoGraphics' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Demographics_ReferenceData_Parent_Company
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Demographics_ReferenceData_Parent_Company`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Demographics_ReferenceData_Parent_Company`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='DemoGraphics' AND FieldName='ParentCompany';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Demographics_ReferenceData_Payroll_Company
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Demographics_ReferenceData_Payroll_Company`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Demographics_ReferenceData_Payroll_Company`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='DemoGraphics' AND FieldName='PayrollCompany';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Demographics_ReferenceData_Production_Company
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Demographics_ReferenceData_Production_Company`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Demographics_ReferenceData_Production_Company`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='DemoGraphics' AND FieldName='ProductionCompany';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Demographics_ReferenceData_WorkYear
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Demographics_ReferenceData_WorkYear`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Demographics_ReferenceData_WorkYear`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='DemoGraphics' AND FieldName='WorkYear';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Demographics_ReportData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Demographics_ReportData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Demographics_ReportData`( IN workYear VARCHAR(4),
          IN controlGroup VARCHAR(100),IN parentCompnay VARCHAR(100),IN proudctioncompany VARCHAR(100),IN payrollCompany VARCHAR(100))
BEGIN
SELECT PARENT_COMPANY,PRODUCTION_COMPANY,SHOW_NAME,PAYROLL_COMPANY,FIRST_NAME,LAST_NAME,
UNION_TYPE,SOC_SEC_NUMBER,ACA_EMPLOYMENT_STATUS,SCHEDULE_CODE,PAY_RATE,
JOB_DESCRIPTION,GENDER,DATE_OF_BIRTH,EMAIL,ADDRESS,CITY,STATE,ZIP,CONTROL_GROUP,WORK_YEAR
FROM tbl_demographicsreport WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup)
        AND (parentCompnay IS NULL OR PARENT_COMPANY=parentCompnay)
        AND (proudctioncompany IS NULL OR PRODUCTION_COMPANY=proudctioncompany)
        AND (payrollCompany IS NULL OR PAYROLL_COMPANY=payrollCompany);
 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_ERCoverage_AnnualizedMonthlyCount
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_ERCoverage_AnnualizedMonthlyCount`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_ERCoverage_AnnualizedMonthlyCount`(
	  IN workYear VARCHAR(4),
          IN controlGroup VARCHAR(100)
         )
BEGIN
SELECT COUNT(*) AS COUNT FROM tbl_ercoverage 
WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup);
 
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_ERCoverage_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_ERCoverage_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_ERCoverage_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='ERCoverage' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_ERCoverage_ReferenceData_WorkYear
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_ERCoverage_ReferenceData_WorkYear`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_ERCoverage_ReferenceData_WorkYear`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='ERCoverage' AND FieldName='WorkYear';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_ERCoverage_Report_Generate_ReferenceData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_ERCoverage_Report_Generate_ReferenceData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_ERCoverage_Report_Generate_ReferenceData`()
BEGIN



			



	



	INSERT INTO  tbl_reportsreferencedata 

	SELECT 'ERCoverage','WorkYear',   WorkYear, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 

	(SELECT DISTINCT WORK_YEAR  AS WorkYear FROM tbl_ercoverage) AS Result;



	INSERT INTO  tbl_reportsreferencedata 

	SELECT 'ERCoverage','ControlGroup',   ControlGroup, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 

	(SELECT DISTINCT CONTROL_GROUP  AS ControlGroup FROM tbl_ercoverage) AS Result;



END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_ERCoverage_ReportsByAnnualizedMonthlyCount
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_ERCoverage_ReportsByAnnualizedMonthlyCount`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_ERCoverage_ReportsByAnnualizedMonthlyCount`(
	  IN workYear VARCHAR(4),
          IN controlGroup VARCHAR(100),
          IN annualizedMonthlyCount VARCHAR(10)
         )
BEGIN
SELECT CONTROL_GROUP,WORK_YEAR,WORK_MONTH,WORKED_POOL_FTE_STATUS,
   FIRST_NAME,LAST_NAME,HOURS_WORKED,WORKED_POOL_FTE_COUNT
   FROM tbl_ercoverage 
WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup);
 
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Eligibility_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Eligibility_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Eligibility_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='Eligibility' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Eligibility_ReferenceData_Type_Of_Hours
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Eligibility_ReferenceData_Type_Of_Hours`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Eligibility_ReferenceData_Type_Of_Hours`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='Eligibility' AND FieldName='TypeOfHours';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Eligibility_ReferenceData_Union_Status
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Eligibility_ReferenceData_Union_Status`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Eligibility_ReferenceData_Union_Status`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='Eligibility' AND FieldName='UnionStatus';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Eligibility_ReferenceData_WorkYear
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Eligibility_ReferenceData_WorkYear`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Eligibility_ReferenceData_WorkYear`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='Eligibility' AND FieldName='WorkYear';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_Eligibility_ReportData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_Eligibility_ReportData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_Eligibility_ReportData`(IN workYear VARCHAR(4),
          IN controlGroup VARCHAR(100),IN unionStatus VARCHAR(10),IN typeOfHours VARCHAR(10) )
BEGIN
SELECT FIRST_NAME,LAST_NAME,UNION_TYPE,SOC_SEC_NUMBER,MOST_RECENT_SHOW,MOST_RECENT_JOB_TITLE,
AVEAGE_WEEKLY_HOURS,TOTAL_HOURS,STANDARD_MEASURE_ELIGIBILITY,BENEFITS_EFFECTIVE,CONTROL_GROUP,WORK_YEAR
FROM tbl_eligibilityreport WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup)
        AND (unionStatus IS NULL OR UNION_TYPE=unionStatus)
        AND (typeOfHours IS NULL OR TOTAL_HOURS=typeOfHours);
 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresFullTime_ACAEligibleCount
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresFullTime_ACAEligibleCount`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresFullTime_ACAEligibleCount`(
	  IN workYear VARCHAR(4),
          IN workMonth VARCHAR(10),
          IN controlGroup VARCHAR(100)
         )
BEGIN
SELECT COUNT(*) AS COUNT FROM tbl_newhiresfulltimereport 
WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
	AND (workMonth IS NULL OR  WORK_MONTH=workMonth)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup);
 
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresFullTime_Generate_ReferenceData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresFullTime_Generate_ReferenceData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresFullTime_Generate_ReferenceData`()
BEGIN
			
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'EligibilityNewHiresFullTime','WorkYear',   WorkYear, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT WORK_YEAR  AS WorkYear FROM tbl_newhiresfulltimereport) AS Result;
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'EligibilityNewHiresFullTime','WorkMonth',   WorkMonth, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT WORK_MONTH  AS WorkMonth FROM tbl_newhiresfulltimereport) AS Result;
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'EligibilityNewHiresFullTime','ControlGroup',   ControlGroup, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT CONTROL_GROUP  AS ControlGroup FROM tbl_newhiresfulltimereport) AS Result;
	
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresFullTime_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresFullTime_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresFullTime_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresFullTime' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresFullTime_ReferenceData_WorkMonth
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresFullTime_ReferenceData_WorkMonth`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresFullTime_ReferenceData_WorkMonth`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresFullTime' AND FieldName='WorkMonth';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresFullTime_ReferenceData_WorkYear
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresFullTime_ReferenceData_WorkYear`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresFullTime_ReferenceData_WorkYear`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresFullTime' AND FieldName='WorkYear';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresFullTime_ReportByACAEligibleCount
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresFullTime_ReportByACAEligibleCount`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresFullTime_ReportByACAEligibleCount`(
	  IN workYear VARCHAR(4),
          IN workMonth VARCHAR(10),
          IN controlGroup VARCHAR(100),
          IN acaEligibleCount VARCHAR(20)
         )
BEGIN
   
   SELECT CONTROL_GROUP,LATEST_PRODUCTION_COMPANY,
   MOST_RECENT_SHOW,SOC_SEC_NUMBER,FIRST_NAME,
   LAST_NAME,LAST_WORK_DATE,HIRE_DATE,UNION_TYPE,PAYROLL_SOURCE,
   AVEAGE_HOURS,TOTAL_HOURS
   FROM tbl_newhiresfulltimereport 
WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
	AND (workMonth IS NULL OR  WORK_MONTH=workMonth)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup);
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_Generate_ReferenceData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_Generate_ReferenceData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_Generate_ReferenceData`()
BEGIN
			
		
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'EligibilityNewHiresNonFullTime','WorkYear',   WorkYear, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT WORK_YEAR  AS WorkYear FROM tbl_newhiresnonfulltimereport) AS Result;
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'EligibilityNewHiresNonFullTime','WorkMonth',   WorkMonth, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT WORK_MONTH  AS WorkMonth FROM tbl_newhiresnonfulltimereport) AS Result;
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'EligibilityNewHiresNonFullTime','ControlGroup',   ControlGroup, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT CONTROL_GROUP  AS ControlGroup FROM tbl_newhiresnonfulltimereport) AS Result;
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'EligibilityNewHiresNonFullTime','EmployeeType',   EmployeeType, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT EMPOYEE_TYPE  AS EmployeeType FROM tbl_newhiresnonfulltimereport) AS Result;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresNonFullTime' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_ReferenceData_EmployeeType
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_ReferenceData_EmployeeType`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_ReferenceData_EmployeeType`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresNonFullTime' AND FieldName='EmployeeType';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_ReferenceData_UnionType
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_ReferenceData_UnionType`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_ReferenceData_UnionType`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresNonFullTime' AND FieldName='UnionType';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_ReferenceData_WorkMonth
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_ReferenceData_WorkMonth`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_ReferenceData_WorkMonth`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresNonFullTime' AND FieldName='WorkMonth';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_ReferenceData_WorkYear
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_ReferenceData_WorkYear`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_ReferenceData_WorkYear`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='EligibilityNewHiresNonFullTime' AND FieldName='WorkYear';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_ReportByWeeksCount
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_ReportByWeeksCount`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_ReportByWeeksCount`(IN workYear VARCHAR(4),
          IN workMonth VARCHAR(10),
          IN controlGroup VARCHAR(100),
          IN unionType VARCHAR(10),
          IN employeeType VARCHAR(20),
          IN reportOfWeek VARCHAR(20)
         )
BEGIN
   
   SELECT CONTROL_GROUP,WORK_YEAR,WORK_MONTH,LATEST_PRODUCTION_COMPANY,
   MOST_RECENT_SHOW,SOC_SEC_NUMBER,FIRST_NAME,
   LAST_NAME,LAST_WORK_DATE,HIRE_DATE,UNION_TYPE,PAYROLL_SOURCE,
   AVEAGE_HOURS,TOTAL_HOURS,EMPOYEE_TYPE
   FROM tbl_newhiresnonfulltimereport 
WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
	AND (workMonth IS NULL OR  WORK_MONTH=workMonth)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup)
	AND (unionType IS NULL OR  UNION_TYPE=unionType)
	AND (employeeType IS NULL OR  EMPOYEE_TYPE=employeeType)
	AND (reportOfWeek IS NULL OR  WEEKS_WORKED=reportOfWeek);
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_NewHiresNonFullTime_ReportCountByWeek
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_NewHiresNonFullTime_ReportCountByWeek`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_NewHiresNonFullTime_ReportCountByWeek`(IN workYear VARCHAR(4),
          IN workMonth VARCHAR(10),
          IN controlGroup VARCHAR(100),
          IN unionType VARCHAR(10),
          IN employeeType VARCHAR(20)
         )
BEGIN
SELECT WEEKS_WORKED,COUNT(1) AS COUNT FROM ( 
SELECT * FROM tbl_newhiresnonfulltimereport 
WHERE  (1=1) 
	AND (workYear IS NULL OR WORK_YEAR=workYear)
	AND (workMonth is null or  WORK_MONTH=workMonth)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup)
	AND (unionType IS NULL OR  UNION_TYPE=unionType)
	AND (employeeType IS NULL OR  EMPOYEE_TYPE=employeeType)
) AS Result
GROUP BY WEEKS_WORKED;
/* SELECT WEEKS_WORKED AS weeksWorked,COUNT(1) AS weeksWorkedCount FROM tbl_newhiresnonfulltimereport 
GROUP BY WEEKS_WORKED ;
HAVING (1=1) ;
/*AND (WORK_YEAR IS NULL OR WORK_YEAR=workYear);*/
 
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_OnGoingReport_Generate_ReferenceData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_OnGoingReport_Generate_ReferenceData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_OnGoingReport_Generate_ReferenceData`()
BEGIN
			
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'OnGoingReport','UnionType',   UnionType, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT UNION_TYPE  AS UnionType FROM tbl_ongoingreport) AS Result;
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'OnGoingReport','MeasurementEndDate',   MeasurementEndDate, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT MEASUREMENT_END_DATE  AS MeasurementEndDate FROM tbl_ongoingreport) AS Result;
	INSERT INTO  tbl_reportsreferencedata 
	SELECT 'OnGoingReport','ControlGroup',   ControlGroup, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 
	(SELECT DISTINCT CONTROL_GROUP  AS ControlGroup FROM tbl_ongoingreport) AS Result;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_OnGoing_CountByWeek
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_OnGoing_CountByWeek`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_OnGoing_CountByWeek`(
          IN controlGroup VARCHAR(100),
          IN measurementEndDate VARCHAR(20),
          IN avgWeeklyThreshold VARCHAR(3),
          IN unionType VARCHAR(10)
         )
BEGIN
SELECT WEEKS_WORKED,COUNT(1) AS COUNT FROM ( 
SELECT * FROM tbl_ongoingreport 
WHERE  (1=1) 
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup)
        AND (measurementEndDate IS NULL OR  MEASUREMENT_END_DATE=measurementEndDate)
        AND (avgWeeklyThreshold IS NULL OR  AVEAGRE_WEEKLY_THRESHOLD=avgWeeklyThreshold)
	AND (unionType IS NULL OR  UNION_TYPE=unionType)
) AS Result
GROUP BY WEEKS_WORKED;
 
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_OnGoing_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_OnGoing_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_OnGoing_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='OnGoingReport' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_OnGoing_ReferenceData_MeasurementEndDate
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_OnGoing_ReferenceData_MeasurementEndDate`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_OnGoing_ReferenceData_MeasurementEndDate`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='OnGoingReport' AND FieldName='MeasurementEndDate';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_OnGoing_ReferenceData_UnionType
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_OnGoing_ReferenceData_UnionType`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_OnGoing_ReferenceData_UnionType`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='OnGoingReport' AND FieldName='UnionType';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_OnGoing_ReportsForCountByWeek
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_OnGoing_ReportsForCountByWeek`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_OnGoing_ReportsForCountByWeek`(
          IN controlGroup VARCHAR(100),
          IN measurementEndDate VARCHAR(20),
          IN avgWeeklyThreshold VARCHAR(3),
          IN unionType VARCHAR(10),
          IN reportForWeek VARCHAR(10)
         )
BEGIN
SELECT CONTROL_GROUP,LATEST_PRODUCTION_COMPANY,
   MOST_RECENT_SHOW,SOC_SEC_NUMBER,FIRST_NAME,
   LAST_NAME,LAST_WORK_DATE,HIRE_DATE,UNION_TYPE,WEEKS_SINCE_LAST_WORKED,
   AVEAGE_HOURS_SMP,TOTAL_HOURS,EMPOYEE_TYPE
   FROM tbl_ongoingreport 
WHERE  (1=1) 
	AND (controlGroup IS NULL OR CONTROL_GROUP=controlGroup)
	AND (measurementEndDate IS NULL OR  MEASUREMENT_END_DATE=measurementEndDate)
        AND (avgWeeklyThreshold IS NULL OR  AVEAGRE_WEEKLY_THRESHOLD=avgWeeklyThreshold)
	AND (unionType IS NULL OR  UNION_TYPE=unionType)
	AND (reportForWeek IS NULL OR  WEEKS_WORKED=reportForWeek);
 
    END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_PayrollDataActivity_ReferenceData_ControlGroup
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_PayrollDataActivity_ReferenceData_ControlGroup`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_PayrollDataActivity_ReferenceData_ControlGroup`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='PayrollDataActivity' AND FieldName='ControlGroup';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_PayrollDataActivity_ReferenceData_WorkYear
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_PayrollDataActivity_ReferenceData_WorkYear`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_PayrollDataActivity_ReferenceData_WorkYear`()
BEGIN
	SELECT FieldValue FROM tbl_reportsreferencedata WHERE ReportName='PayrollDataActivity' AND FieldName='WorkYear';
   END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_PayrollDataActivity_Report_Generate_ReferenceData
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_PayrollDataActivity_Report_Generate_ReferenceData`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_PayrollDataActivity_Report_Generate_ReferenceData`()
BEGIN







	INSERT INTO  tbl_reportsreferencedata 

	SELECT 'PayrollDataActivity','WorkYear',   WorkYear, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 

	(SELECT DISTINCT WORK_YEAR  AS WorkYear FROM tbl_payroll_data_activity) AS Result;



	INSERT INTO  tbl_reportsreferencedata 

	SELECT 'PayrollDataActivity','ControlGroup',   ControlGroup, 1, 'Reporting',NOW(),'Reporting',NOW() FROM 

	(SELECT DISTINCT CONTROL_GROUP  AS ControlGroup FROM tbl_payroll_data_activity) AS Result;

			







END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure PRC_PayrollDataActivity_ReportsForPayrollDataActivity
-- -----------------------------------------------------

USE `siprasoft`;
DROP procedure IF EXISTS `siprasoft`.`PRC_PayrollDataActivity_ReportsForPayrollDataActivity`;

DELIMITER $$
USE `siprasoft`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRC_PayrollDataActivity_ReportsForPayrollDataActivity`(
   IN workYear VARCHAR(4),
          IN controlGroup VARCHAR(100)
         )
BEGIN
SELECT SOC_SEC_NUMBER,FIRST_NAME,LAST_NAME,EIN,PRODUCTION_COMPANY,
   HIRE_DATE,LAST_DATE_WORKED,PROJECT,CLIENT_ID,SOURCE,EMPLOYMENT_STATUS,
   UNION_TYPE,JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER,CONTROL_GROUP 
   FROM tbl_payroll_data_activity 
WHERE  (1=1) 
 AND (workYear IS NULL OR WORK_YEAR=workYear)
        AND (controlGroup IS NULL OR  CONTROL_GROUP=controlGroup);
 
    END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
