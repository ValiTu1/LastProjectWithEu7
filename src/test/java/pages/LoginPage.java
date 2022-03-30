package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class LoginPage extends BasePage{
    @FindBy(name = "username")
    public WebElement usernameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement button;

    public void login(){
        usernameBox.sendKeys(ConfigurationReader.get("web.table.username"));
        passwordBox.sendKeys(ConfigurationReader.get("web.table.password"));
        button.click();
    }
}
