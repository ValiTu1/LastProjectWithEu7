package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class SpartanViewPage extends SpartanBasePage{

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "gender")
    public WebElement gender;

    @FindBy(id = "phone")
    public WebElement phone;


    public String getValue(String name){
        return Driver.get().findElement(By.id(name)).getAttribute("value");
    }

}
