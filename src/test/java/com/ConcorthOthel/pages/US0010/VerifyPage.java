package com.ConcorthOthel.pages.US0010;

import com.ConcorthOthel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage {
    public DefaultPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }
}