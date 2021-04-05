# IntelliSense.io
QAAutomation
 This is a Test Automation Framework to test the functionality of the application.The given Dashboard page is tested. There are total of 14 test cases , which include both happy , unhappy and failed test cases. 10 Manual test cases are there in Excel Workbook , that contains the bug report etc in the sheets in it.There is a separate Test Closure report for the Manual Test Cases.Also , a Sample Allure Results are attached. For Automation Test cases , bug reporting is done using the JIRA Intigration . A JIRA Bug report is also attached . The Testing is done on the basis of User manual and the expected application behaviour.

Language - JAVA Framework - TestNG Design Pattern used - POM (Page Object Model) This project is completed under Maven repository. OOPs Concept

There are two folders main and test.
Documents attached are : 

1.Base File - This contains the driver and the browser initialization.

2.Config - This contains the URL and the Browser name that can changed as per requirement.

3.pages file - This contains  Dashboard page file with all

4.util - This contains the util like timeout etc that can be adjusted as per the needs.

There are two report that can be viewed :

The TestNG HTML Report in the output
Allure command : **Allure serve "path of the Allure result"** this will give you the Allure report.
Output : All test cases are passed as they satisfied the assertions and failed if they not.
