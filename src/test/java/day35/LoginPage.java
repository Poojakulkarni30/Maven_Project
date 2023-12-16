package day35;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	/*
	 * for using pom the syntax is 1. constructor 2. locators . action methods
	 * 
	 */

	WebDriver driver;

	LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginbtn;

	public void Setusername(String user) {

		username.sendKeys(user);
	}

	public void setpassword(String pwd) {

		password.sendKeys(pwd);

	}

	public void loginbtn() {

		loginbtn.click();

	}

}
