package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class StepDefinition extends base {

	@Given("^Intialize the browser with chrome$")
	public void intialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on secure sign in page$")
	public void click_on_Login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();//click login 
	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Successfully logged in failed");
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
    }

	@And("^close browsers$")
    public void close_browsers() throws Throwable {
		driver.close();
    }

}
