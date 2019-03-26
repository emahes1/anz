package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculateStepDefinition {

	WebDriver driver;

	@Given("^user is already on Loan borrow Page$")
	public void user_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}

	@When("^user Selects Application Type as \\\"(.*)\\\"$")
	public void user_Selects_Application_Type_as_Single(String apptype) throws Throwable {
		driver.findElement(By.xpath("//label[contains(.,'Single')]")).click();
	}

	@When("^user Selects Number of Dependents as (\\d+)$")
	public void user_Selects_Number_of_Dependents_as(int arg1) throws Throwable {

		// Select dropdown = new Select(driver.findElement(By.id("mySelect")));
		// dropdown.selectByVisibleText("0");
		// select
		driver.findElement(By.xpath("//select")).click();
	}

	@When("^user Selects Property Type as home to live in$")
	public void user_Selects_Property_Type_as_home_to_live_in() throws Throwable {
		driver.findElement(By.xpath("//label[contains(.,'Home to live in')]")).click();
	}

	@When("^user Selects Income as (\\d+)$")
	public void user_Selects_Income_as(int arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@value='0']")).sendKeys(Integer.toString(arg1));
	}

	@When("^user Selects Other Income as (\\d+)$")
	public void user_Selects_Other_Income_as(int arg1) throws Throwable {
		driver.findElement(By.xpath("(//input[@value='0'])[2]")).sendKeys(Integer.toString(arg1));
	}

	@When("^user Selects Living Expenses as (\\d+)$")
	public void user_Selects_Living_Expenses_as(int arg1) throws Throwable {

		driver.findElement(By.id("expenses")).sendKeys(Integer.toString(arg1));
	}

	@When("^user Selects Current Home Repayments as (\\d+)$")
	public void user_Selects_Current_Home_Repayments_as(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^user Selects Other loan Repayments as (\\d+)$")
	public void user_Selects_Other_loan_Repayments_as(int arg1) throws Throwable {
		driver.findElement(By.id("otherloans")).sendKeys(Integer.toString(arg1));
	}

	@When("^user Selects Other Commitments as (\\d+)$")
	public void user_Selects_Other_Commitments_as(int arg1) throws Throwable {
		
	}

	@When("^user Selects Credit Card Limit as (\\d+)$")
	public void user_Selects_Credit_Card_Limit_as(int arg1) throws Throwable {
		driver.findElement(By.id("credit")).sendKeys(Integer.toString(arg1));
	}

	@When("^user selects Calculate$")
	public void user_selects_Calculate() throws Throwable {

		driver.findElement(By.cssSelector((".btn--borrow__calculate"))).click();
		Thread.sleep(6000);
	}

	@Then("^the  borrowing estimate of \\\"(.*)\\\" is shown to user$")
	public void the_borrowing_estimate_of_is_shown_to_user(String arg1) throws Throwable {
		String amt = driver.findElement(By.cssSelector((".borrow__result__text__amount"))).getText();
		Assert.assertEquals(amt, arg1,"Estimate is incorrect");
	}

	@Then("^the \\\"(.*)\\\" is shown to user$")
	public void the_borrowing_error_msg_of_is_shown_to_user(String error) throws Throwable {
		String error_msg = driver.findElement(By.className("borrow__error__text")).getText();
		Assert.assertEquals(error_msg, error, "Incorrect Error Message");
	}

	@When("^user Selects Start Over$")
	public void user_selects_StartOver() throws Throwable {

		driver.findElement(By.cssSelector((".borrow__error .start-over"))).click();
		
	}
	
	@Then("^form is cleared$")
	public void the_formisclearedr() throws Throwable {
		String living_exp=driver.findElement(By.id("expenses")).getAttribute("value");
		Assert.assertEquals( living_exp,"0", "Not reset to 0:");
	}

	
	@After
	public void teardown() {
		driver.quit();
	}

}
