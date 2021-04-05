package pages;

import base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {

	//Page Factory - OR Object Repository: 
		@FindBy(className = "title")
		public WebElement Dashtitle;
		
		@FindBy(xpath = "//img[@class='pull-left']")
		WebElement validateintelilogo;
	    
		@FindBy(xpath = "//img[@src='/img/brand/brains_logo.svg']")
		WebElement validatebrainlogo;
		
		@FindBy(xpath ="//li[@title='Set as Homepage']")
		WebElement Homebutton;
		
		@FindBy(xpath ="//li[@title='Duplicate Dashboard']")
		WebElement DuplicBtn;
		
		@FindBy(xpath ="//li[@title='Export Data']")
		WebElement ExpData;
		
		@FindBy(linkText="Learn how to create a Dashboard")
		WebElement creatDaslink;
		
		@FindBy(linkText="Learn how to create a Widget")
		WebElement creatwidg;
		
		@FindBy(linkText="Learn how to use the Dashboard Toolbar")
		WebElement useDash;
		
	    @FindBy(xpath="//h1[contains(text(),'Test dashboard')]")
		WebElement Dashname;
	    
	    @FindBy(xpath="//header/div[1]/div[3]/button[3]/i[1]")
	    WebElement DateTime;
	    
	    @FindBy(xpath="//a[@href='#live-range-selector']")
	    WebElement Livebtn;
	    
	    @FindBy(id="resolution")
	    WebElement resolution;
	    
	    @FindBy(xpath="//header/div[1]/div[3]/a[1]/i[1]")
	    WebElement Search;
	    
	    
	    @FindBy(css="li[title='Add Widget']")
	    WebElement widget;
	    
	    @FindBy(css="li[title='Shared with you']")
	    WebElement share;
	    
	    @FindBy(xpath="//button[contains(text(),'OK')]")
	    WebElement okbtn;
	    
	    @FindBy(xpath="//button[contains(text(),'Cancel')]")
	    WebElement Cnclbtn;
	    
	    
		//Initializing the Page Objects
		public DashboardPage() {
			PageFactory.initElements(driver,this);
		}
		
		//Actions
		public String validateLoginPageTitle() {
			return driver.getTitle();
		
		}
		
		public String validateDashname() {
			return Dashname.getText();
			
		
		}
		public boolean validatilogo() {
			
			return validateintelilogo.isDisplayed();
			
		}
		
        public boolean validatblogo() {
			
			return validatebrainlogo.isDisplayed();
			
		}
		
		
		public void HomeBtn() {
			
			Homebutton.click();
			
		}
		
		public void DuplicBtn() {
			
			DuplicBtn.click();
			
		}
		
		public void upload() {
			
			ExpData.click();
			
		}
		
		public void DateTime(String m,String h) 
		{
			DateTime.click();
			Livebtn.click();
			resolution.sendKeys(m);
			driver.findElement(By.id("hours")).sendKeys(h);
			driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
				
		}
        
		public void ReturnHomepage()
		{
		 	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click()", Search);
	    	JavascriptExecutor jst = (JavascriptExecutor) driver;
	    	jst.executeScript("arguments[0].click()", validateintelilogo);
			
		}
	
	    public WebElement Dashboardnmreturn() {
	    	
	    	return  Dashname;
	    }
		
        public String addwidget() {
	    	
	    	return widget.getAttribute("class");
	    }
        
         public String Share() {
	    	
	    	return share.getAttribute("class");
	    }
	    
	    public String errorshow() {
	    	
	    String errortext = driver.findElement(By.xpath("//div[@class='error show']")).getText();
		return errortext;
	    
	    }
        
	    public void clickpopupOKbtn() {
	            okbtn.click();
	    }
        
	    public void clickpopupCancelbtn() {
	    	Cnclbtn.click();
       }
	    
	    public String irrelevsearch(String Word) throws InterruptedException {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click()", Search);
	    	driver.findElement(By.xpath("//input[@ng-model='searchString']")).sendKeys(Word);
	    	 
	    	WebElement Output= driver.findElement(By.xpath("//h3[contains(text(),'No results found.')]"));
	    	Thread.sleep(50);
	       return Output.getText();
	    }
	    
}
