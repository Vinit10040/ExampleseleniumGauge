package com.thoughtworks.gauge.maven.EDGE_title_01;


import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Pages.login;
import Pages.Jobpage;
import Config.ConfigReader;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class Edge_login_verifytitle {
   ConfigReader configreader=new ConfigReader();
	
    @Step("Open the Edge")
    public void implementation1() {
      // String app_url = System.getenv("APP_URL");
    	
    String app_url = configreader.getApplicationUrl();
        Driver.webDriver.get(app_url + "/");
        Driver.webDriver.manage().window().maximize();
    }
    @Step("Login to edge")
    public void loginToedge() throws InterruptedException
    {
    	 WebDriver webDriver = Driver.webDriver;
	        Thread.sleep(7000);
		 webDriver.findElement(login.usernametxt).sendKeys(configreader.getUsername());
		 
	 webDriver.findElement(login.passwordtxt).sendKeys(configreader.getPassword());
	 webDriver.findElement(login.loginbtn).click();
	 Thread.sleep(7000);
  
    }
    @Step("Verify title <title> of the edge application")
    public void edgeTitle(String title)
    {
    	String actualtitle= Driver.webDriver.getTitle();
		System.out.println(title);
		assertEquals(title,actualtitle);
	System.out.println("actual title is:"+actualtitle);
	
    }
    @Step("Logout from edge")
    public void logout()
    {
    	 WebDriver webDriver = Driver.webDriver;	      
		 webDriver.findElement(Jobpage.logoutbtn).click();
    }
    @Step("create edge job")
    public void edgeJob() throws InterruptedException
    {
    	 WebDriver webDriver = Driver.webDriver;
	     Thread.sleep(8000);
		 webDriver.findElement(Jobpage.jobbtn).click();
		 webDriver.findElement(Jobpage.newbtn).click();
		 webDriver.findElement(Jobpage.jobnametxt).sendKeys(configreader.getJobname());
		
    }
    
    @Step("Login to edge using <username> and <password>")
    public void edgeloginusingusernameandpwd(String username,String password) throws InterruptedException
    {
    	 WebDriver webDriver = Driver.webDriver;
	        Thread.sleep(5000);
		 webDriver.findElement(login.usernametxt).sendKeys(username);
		 
	 webDriver.findElement(login.passwordtxt).sendKeys(password);
	 webDriver.findElement(login.loginbtn).click();
	 Thread.sleep(5000);
	
    }
    
}
