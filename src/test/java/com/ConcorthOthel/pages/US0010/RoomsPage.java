package com.ConcorthOthel.pages.US0010;

import com.ConcorthOthel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage {
    public RoomsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath= "//*[@href='/rooms']")
    public WebElement roomsLink;
// Advanced Search Box
    @FindBy(xpath = "//h3[@class='heading mb-4']")
    public WebElement advancedSearchBox;

    @FindBy(id="checkin_date")
    public WebElement advancedCheckIn;

    @FindBy(id = "checkout_date")
    public WebElement advancedCheckOut;

    @FindBy(id = "IDRoomType")
    public WebElement advancedRoomType;

    @FindBy(id = "AdultCount")
    public WebElement advancedAdultCount;

    @FindBy(id = "ChildrenCount")
    public WebElement advancedChildrenCount;

    @FindBy(id = "location")
    public WebElement advancedLocationButton;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement advancedSearchButton;
//Select a room and click on "Book Now" button .

    @FindBy(xpath = "(//*[.='violet'])[2]")
    public WebElement selectedRoomName;

    @FindBy(xpath = "(//*[@href='/RoomDetail/409'])[3]")
    public WebElement bookNowButton;

    @FindBy(id="checkin_date")
    public WebElement selectedRoomCheckIn;

    @FindBy(id="checkout_date")
    public WebElement selectedRoomCheckOut;

    @FindBy(id = "AdultCount")
    public WebElement selectedRoomAdultCount;

    @FindBy(id="ChildrenCount")
    public WebElement selectedRoomChildCount;

    @FindBy(id="NameOnCreditCard")
    public WebElement nameOnCreditCard;

    @FindBy(id="CreditCardNumber")
    public WebElement creditCardNumber;

    @FindBy(id="CreditCardExpirationYear")
    public WebElement creditCardExpirationYear;

    @FindBy(id="CreditCardExpirationMonth")
    public WebElement creditCardExpirationMonth;

    @FindBy(id="CVV")
    public WebElement creditCardSecurityCode;

    @FindBy(id = "Message")
    public WebElement messageBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement bookThisRoomButton;

    @FindBy(xpath = "//*[contains(text(), 'OK')]")
    public WebElement popUpOKButton;






}
