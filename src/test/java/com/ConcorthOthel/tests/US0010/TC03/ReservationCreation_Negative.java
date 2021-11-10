
package com.ConcorthOthel.tests.US0010.TC03;

import com.ConcorthOthel.pages.US0010.LoginPage;
import com.ConcorthOthel.pages.US0010.MainPage;
import com.ConcorthOthel.pages.US0010.RoomsPage;
import com.ConcorthOthel.pages.US0010.VerifyPage;
import com.ConcorthOthel.utilities.ConfigReader;
import com.ConcorthOthel.utilities.Driver;
import com.ConcorthOthel.utilities.JSUtils;
import com.ConcorthOthel.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReservationCreation_Negative {
    LoginPage loginPage;
    VerifyPage verifyPage;
    MainPage mainPage;
    RoomsPage roomsPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("QA_Environment"));

        mainPage=new MainPage();
        mainPage.mainPageLoginLink.click();

        Thread.sleep(2000);
        loginPage=new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("UserName"));
        loginPage.password.sendKeys(ConfigReader.getProperty("UserPassword"));
        loginPage.loginButton.click();

        Thread.sleep(2000);
        verifyPage=new VerifyPage();

        Assert.assertTrue(verifyPage.profilePageTitleVerify.isDisplayed());
      //  JSUtils.flash(verifyPage.profilePageTitleVerify);
    }

    @Test
    public void InputUploadError() throws InterruptedException, IOException {
//Go to "Rooms" page and make  advanced room search.
        roomsPage=new RoomsPage();
        roomsPage.roomsLink.click();

        Thread.sleep(2000);
        Assert.assertTrue(verifyPage.roomsTitleVerify.isDisplayed());
//scroll down to advanced search
        JSUtils.scrollIntoViewJS(roomsPage.advancedSearchBox);

//Advanced room search
        roomsPage.advancedCheckIn.clear();
        roomsPage.advancedCheckIn.sendKeys("11/25/2021");
        Thread.sleep(3000);
        roomsPage.advancedCheckOut.clear();
        // invalid checkout date
        Thread.sleep(3000);
        roomsPage.advancedCheckOut.sendKeys("11/28/2021");
       // ReusableMethods.getScreenshot("invalidCheckOut");

        roomsPage.advancedRoomType.sendKeys("Single");
        roomsPage.advancedAdultCount.sendKeys("1 Adult");
        roomsPage.advancedChildrenCount.sendKeys("0 Children");
        roomsPage.advancedLocationButton.sendKeys("Turkey");
        roomsPage.advancedSearchButton.click();

//Select a room and click on "Book Now" button.
        Thread.sleep(2000);
        Assert.assertTrue(verifyPage.roomDetailPageVerify.isDisplayed());
        JSUtils.scrollIntoViewJS(roomsPage.selectedRoomName);
        Thread.sleep(2000);
        roomsPage.bookNowButton.click();
       Thread.sleep(3000);

// Advanced_room_search inputs should automatically upload to selected_room page.
        ReusableMethods.getScreenshot("InputUploadError");
        Thread.sleep(3000);
        roomsPage.nameOnCreditCard.sendKeys("Ali Can");
        roomsPage.creditCardNumber.sendKeys("9999-8888-7777-6666");
        roomsPage.creditCardExpirationYear.sendKeys("2025");
        roomsPage.creditCardExpirationMonth.sendKeys("December");
        roomsPage.creditCardSecurityCode.sendKeys("123");
        roomsPage.messageBox.sendKeys("making a room reservation");
        Thread.sleep(1000);
        roomsPage.bookThisRoomButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(verifyPage.reservationSuccessMessage.isDisplayed());
        JSUtils.flash(verifyPage.reservationSuccessMessage);

        roomsPage.popUpOKButton.click();
       // ReusableMethods.getScreenshot("successMessage");
        Driver.closeDriver();




    }


}
