package Pages;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class roomReservationPages {
    public roomReservationPages(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
