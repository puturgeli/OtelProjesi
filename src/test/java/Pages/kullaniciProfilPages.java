package Pages;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class kullaniciProfilPages {

    public kullaniciProfilPages(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
