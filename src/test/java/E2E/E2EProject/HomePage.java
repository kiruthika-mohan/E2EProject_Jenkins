package E2E.E2EProject;

import java.io.IOException;
import org.apache.logging.log4j.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider="getData")
	public void basepageNavigation(String username,String password,String text) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		//Thread.sleep(7000L);
		//One is inheritance
		//creating page object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
		//l.Popup().click();
		l.getLogin().click();//click login 
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//System.out.println(text);
		lp.getLogin().click();
		log.info(text);
	}
	@DataProvider
	public Object[][] getData() {
		//Rows stands for how many different data types test should run
		//Column stands for how many values per each test
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonresticteduser@qa.com";
		data[0][1]="123456";
		data[0][2]="Resticted User";
		//1st row
		data[1][0]="resticteduser@qa.com";
		data[1][1]="456789";
		data[1][2]="Non resticted User";
		
		return data;
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
