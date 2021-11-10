package com.ConcorthOthel.pages.US0010;

import com.ConcorthOthel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "navLogon")
    public WebElement mainPageLoginLink;
    }



