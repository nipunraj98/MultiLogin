package pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlity.DataProvider;

public class LoginPage 
{
WebDriver driver;

@FindBy(id="userEmail")
WebElement txt_email;

@FindBy(xpath = "//input[@id='userPassword']")
WebElement txt_password;

@FindBy (css="#login")
WebElement btn_login;

@FindBy(css="#toast-container")
WebElement invalidMsg;

@FindBy(xpath = "//i[contains(@class,'fa-sign-out')]")
WebElement signOut;

@FindBy (css="#toast-container")
WebElement loginsuccess;

public LoginPage(WebDriver driver) 
{
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

public void login(String email, String password) throws IOException, InterruptedException {
	
	
    txt_email.clear();
    txt_email.sendKeys(email);
    txt_password.clear();
    txt_password.sendKeys(password);
    
    btn_login.click();
    
   // String actual=signOut.getText();
}

public void clickSignOut() {
    signOut.click();
}

public boolean isSignOutDisplayed() {
    try {
        return loginsuccess.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}

}

