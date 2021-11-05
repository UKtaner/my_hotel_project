package utilities;

import Pages.PrivacyErrorPage;

public class PrivacyProblem {
    public void PrivacyProblem(){
        PrivacyErrorPage prep = new PrivacyErrorPage();
        try {
            prep.detailsButton.click();
            prep.proceedLink.click();
        }catch (Exception e){

        }
    }
}
