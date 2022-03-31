package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class SpartanBasePage {
    public SpartanBasePage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
