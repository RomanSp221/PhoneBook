package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase {

   @BeforeMethod
   public void ensurePrecondition() {
      if (!app.getUser().isLoginLinkPresent()) {
         app.getUser().clickOnSignOutButton();
      }
   }

   @Test
   public void registraterExistedUserNegativeTest() {

     app.getUser().clickOnLoginLink();

    app.getUser().fillLoginRegisterForm(new User()
             .setEmail(UserData.EMAIL)
             .setPassword(UserData.PASSWORD));

      app.getUser().clickOnRegistrationButton();

      Assert.assertTrue(app.getUser().isAlertPresent());
   }
}
