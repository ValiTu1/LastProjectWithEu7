package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class SpartanMainPage extends SpartanBasePage{


    //create a useful method when I pass ID number, it shluld return me view button of that spartan


    public WebElement getSpartanView(String id){
        return Driver.get().findElement(By.xpath("//tbody//tr//td[.='"+id+"']/../td[5]"));
    }
}
