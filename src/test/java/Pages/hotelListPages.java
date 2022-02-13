package Pages;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class hotelListPages {

    public hotelListPages(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
