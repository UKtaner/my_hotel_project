package com.ConcorthOthel.pages.US0010;

import com.ConcorthOthel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPage {
    public VerifyPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath = "//h2[@class='mb-4']")
        public WebElement profilePageTitleVerify;

        @FindBy(xpath = "//*[@class='text']")
        public WebElement roomsTitleVerify;

        @FindBy(xpath = "(//*[@href='/RoomDetail/408'])[1]")
        public WebElement roomDetailPageVerify;

         @FindBy(xpath = "//*[.='violet']")
        public WebElement selectedRoomPageVerify;

         @FindBy(xpath = "(//div[contains(text(), 'Reservation was made successfully')])[2]" )
         public WebElement reservationSuccessMessage;

    }
