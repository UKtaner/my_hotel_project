package com.ConcorthOthel.tests.US0010.TC01;

import com.ConcorthOthel.pages.US0010.RoomsPage;
import com.ConcorthOthel.pages.US0010.VerifyPage;
import com.ConcorthOthel.pages.US0010.LoginPage;
import com.ConcorthOthel.pages.US0010.MainPage;
import com.ConcorthOthel.utilities.ConfigReader;
import com.ConcorthOthel.utilities.Driver;
import com.ConcorthOthel.utilities.JSUtils;
import com.ConcorthOthel.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReservationCreation {
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
        JSUtils.flash(verifyPage.profilePageTitleVerify);
    }

    @Test
    public void ReservationCreation() throws InterruptedException, IOException {
//Go to "Rooms" page and make  advanced room search.
    roomsPage=new RoomsPage();
    roomsPage.roomsLink.click();

        Thread.sleep(2000);
    Assert.assertTrue(verifyPage.roomsTitleVerify.isDisplayed());
//scroll down to advanced search
        JSUtils.scrollIntoViewJS(roomsPage.advancedSearchBox);

//Advanced room search
        roomsPage.advancedCheckIn.clear();
        roomsPage.advancedCheckIn.sendKeys("11/10/2021");
        Thread.sleep(2000);
        roomsPage.advancedCheckOut.clear();
        roomsPage.advancedCheckOut.sendKeys("11/20/2021");
        roomsPage.advancedRoomType.sendKeys("Single");
        roomsPage.advancedAdultCount.sendKeys("1 Adult");
        roomsPage.advancedChildrenCount.sendKeys("0 Children");
        roomsPage.advancedLocationButton.sendKeys("Turkey");
        roomsPage.advancedSearchButton.click();

//Select a room and click on "Book Now" button.
        Thread.sleep(2000);
        Assert.assertTrue(verifyPage.roomDetailPageVerify.isDisplayed());
        JSUtils.scrollIntoViewJS(roomsPage.selectedRoomName);
        roomsPage.bookNowButton.click();
        roomsPage.selectedRoomCheckIn.clear();
        Thread.sleep(1000);
        roomsPage.selectedRoomCheckIn.sendKeys("11/10/2021");
        roomsPage.selectedRoomCheckOut.clear();
        roomsPage.selectedRoomCheckOut.sendKeys("11/20/2021");
        roomsPage.selectedRoomAdultCount.sendKeys("1 Adult");
        roomsPage.selectedRoomChildCount.sendKeys("0 Children");
        JSUtils.scrollIntoViewJS(roomsPage.nameOnCreditCard);
        Thread.sleep(1000);
        roomsPage.nameOnCreditCard.sendKeys("Ali Can");
        roomsPage.creditCardNumber.sendKeys("9999-8888-7777-6666");
        roomsPage.creditCardExpirationYear.sendKeys("2025");
        roomsPage.creditCardExpirationMonth.sendKeys("December");
        roomsPage.creditCardSecurityCode.sendKeys("123");
        roomsPage.messageBox.sendKeys("making a room reservation");
        roomsPage.bookThisRoomButton.click();

        Assert.assertTrue(verifyPage.reservationSuccessMessageVerify.isDisplayed());
        JSUtils.flash(verifyPage.reservationSuccessMessageVerify);
        Thread.sleep(1000);
        roomsPage.popUpOKButton.click();
        Thread.sleep(1000);
        ReusableMethods.getScreenshot("09/11/2021");





    }


}
