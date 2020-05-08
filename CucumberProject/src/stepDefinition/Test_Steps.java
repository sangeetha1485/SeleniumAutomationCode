package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
		public static WebDriver driver;
	@Given("^user is on home page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\HP\\Documents\\selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.store.demoqa.com");
	}

	@When("^user navigates to login page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']")).click();
		driver.findElement(By.linkText("My Account")).click();
	}

	@When("^user enters \"(.*?)\" and \"(.*?)\"$")
		public void user_enters_and(String username,String password) throws Throwable {
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement element=	driver.findElement(By.xpath("//input[@id='username']")); 

		js.executeScript("arguments[0].scrollIntoView();", element);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username); 	 
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	    driver.findElement(By.name("login")).click();
	}

	
	@Then("^close the browser$")
	public void close_the_browser()
	{
		driver.quit();
	}
//	
	@Then("^Message displayed login successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		
		String title=driver.getTitle();
		
		System.out.println("Login Successfully");
	}

	@When("^user logout from the application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement (By.linkText("Log out")).click();
	}

	@Then("^message displayed logout successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
	}
}