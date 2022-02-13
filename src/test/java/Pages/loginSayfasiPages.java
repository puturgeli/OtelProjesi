package Pages;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class loginSayfasiPages {

    public loginSayfasiPages(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
