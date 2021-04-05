package DashboardTests;



import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.DashboardPage;
import util.JiraPolicy;



public class DashboardTestcases extends TestBase {

		DashboardPage dashboardPage;
	

		public DashboardTestcases() {
			super();
		}
		

		@BeforeMethod
		public void setup() {
			initialization();
			dashboardPage = new DashboardPage();
			
		}
        
		@JiraPolicy(logTicketReady=true)
		@Test(priority=4)
		@Description("Verify Dashboard page title")
		@Feature("Feature 1: Page title")
		public void pageTitle() {
			String Title = dashboardPage.validateLoginPageTitle();
			System.out.println("The page title is: " + Title);
			Assert.assertEquals(Title, "Brains.App");
		}
        
		@JiraPolicy(logTicketReady=true)
		@Test(priority=2)
		@Description("Verify Dashboard name")
		@Feature("Feature 2: Dashboard name")
		public void dashboardname() {
			String Name = dashboardPage.validateDashname();
			System.out.println("The Dashboard name is: " + Name);
			Assert.assertEquals(Name, "Test dashboard");
		}
        
		@JiraPolicy(logTicketReady=true)
		@Test(priority=3)
		@Description("Verify the IntelliSense logo")
		@Feature("Feature 3: IntelliSense logo")
		public void verifyilogoTest() {
			boolean flag = dashboardPage.validatilogo();
			Assert.assertTrue(flag);
		}
		
		@JiraPolicy(logTicketReady=true)
		@Test(priority=14)
		@Description("Verify the brains.app logo")
		@Feature("Feature 4: brains.app logo")
		public void verifyblogoTest() {
			boolean flag = dashboardPage.validatblogo();
			Assert.assertTrue(flag);
		}
        
		@JiraPolicy(logTicketReady=true)
		@Test(priority=5)
		@Description("Verify Home button ")
		@Feature("Feature 5: HomeButton Click ")
		public void ClickHome() {
		 dashboardPage.HomeBtn();
			
		}
		@JiraPolicy(logTicketReady=true)
		@Test(priority=6)
		@Description("Verify Duplicate button")
		@Feature("Feature 6: Duplicate Dashboard click")
		public void ClickDuplica() {
		 dashboardPage.DuplicBtn();
			
		}
        
		@JiraPolicy(logTicketReady=true)
		@Test(priority=7)
		@Description("Verify Export Data")
		@Feature("Feature 7: Export Data click")
		public void ClickExportData() {

			dashboardPage.upload();
		}
		
		@JiraPolicy(logTicketReady=true)
		@Test(priority=8)
		@Description("Verify Home Page Return logo")
		@Feature("Feature 8: IntelliSense logo homepage return")
		public void LogoClickReturn() {
            
			dashboardPage.HomeBtn();
			dashboardPage.clickpopupOKbtn();;
			dashboardPage.ReturnHomepage();
			String Actual = dashboardPage.validateDashname();
			Assert.assertEquals(Actual, "Test dashboard");
		}
        
		@JiraPolicy(logTicketReady=true)
		@Test(priority=9)
		@Description("Verify DateTime")
		@Feature("Feature 9: Error Message")
		public void DateTimewronginput() throws InterruptedException {

			dashboardPage.DateTime("minute","18");
			Thread.sleep(50);
			String Actualtext= dashboardPage.errorshow();
		    String Expectedtext = "Warning: High resolution data, performance may be affected";
		    		
			System.out.println("Msg is " + Actualtext);
			Assert.assertEquals(Actualtext,Expectedtext,"Actual error msg matches the expected error msg");
		}

		
		@JiraPolicy(logTicketReady=true)
		@Test(priority=10)
		@Description("Verify the editable dashboard name")
		@Feature("Feature 10: Edit icon visibility")
		public void editable() {
		Actions action = new Actions(driver); 
		action.moveToElement(dashboardPage.Dashboardnmreturn()).build().perform(); 
		String Edit= dashboardPage.Dashboardnmreturn().getAttribute("class");
          System.out.println(Edit);
          Assert.assertEquals(Edit,"title title-editable","The Dashboard name is not editable as attributes not matching with expected");
				
		}
		
		@JiraPolicy(logTicketReady=true)
		@Test(priority=11)
		@Description("Verify add widget button is enabled")
		@Feature("Feature 11: add widget button ")
		public void AddwidgetDisabled(){
		String dable=dashboardPage.addwidget();
          Assert.assertEquals(dable,"btn btn-primary","As per user manual button should be enabled");
				
		}
		
		@JiraPolicy(logTicketReady=true)
		@Test(priority=12)
		@Description("Verify share button is enabled")
		@Feature("Feature 12: share button ")
		public void ShareDisabled(){
			String sable=dashboardPage.Share();
	          Assert.assertEquals(sable,"btn btn-primary","As per user manual button should be enabled");
				
		}
		
		@JiraPolicy(logTicketReady=true)
		@Test(priority=13)
		@Description("Unhappy Scenario : No Duplicate Dashboard page without name")
		@Feature("Feature 13: Duplicate Dashboard/Unhappy Test ")
		public void NoDuplicates() throws InterruptedException{
		
			dashboardPage.DuplicBtn();
			dashboardPage.clickpopupOKbtn();
			dashboardPage.clickpopupCancelbtn();
			Thread.sleep(60);
			String Error =dashboardPage.errorshow();
			System.out.println(Error);
			String Expected = "Please, name the dashboard" ;
			Assert.assertEquals(Error, Expected,"User should have been shown the error msg");
		}
		
		@JiraPolicy(logTicketReady=true)
	    @Test(priority=1)
		@Description("Unhappy Scenario : Searching with irrelevant word")
		@Feature("Feature 14: Search Feature/Unhappy Test ")
		public void irrelevantsearch() throws InterruptedException  {
		
			String msg = dashboardPage.irrelevsearch("99");
			System.out.println(msg);
			Assert.assertEquals(msg,"No results found.","User should have been shown No results");
		}
		
		
		
		
		@AfterMethod
		public void tearDown()  {
			driver.quit();
			
		}
		
}
