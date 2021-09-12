package E2E.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	/*@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		Log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to home page");
	}*/

	@Test
	public void basepageNavigation() throws IOException, InterruptedException {
		driver=initializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		//Thread.sleep(7000L);
		//One is inheritance
		//creating page object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
		//Compare the text from the browser with the actual text.
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
		log.info("Succefully validated text message");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
