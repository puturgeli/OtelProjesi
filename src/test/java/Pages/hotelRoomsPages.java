package Pages;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class hotelRoomsPages {


    public hotelRoomsPages(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
