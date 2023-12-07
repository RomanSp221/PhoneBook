package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

   //precondition: User logged out
   @BeforeMethod
   public void ensurePrecondition() {
      if (!app.getUser().isLoginLinkPresent()) {
         app.getUser().clickOnSignOutButton();
      }
   }

   @Test
   public void loginRegistredUserPositiveTest() {
      app.getUser().clickOnLoginLink();
      logger.info("Test rans wit data" + UserData.EMAIL + " " + UserData.PASSWORD);
      app.getUser().fillLoginRegisterForm(new User()
             .setEmail(UserData.EMAIL)
             .setPassword(UserData.PASSWORD));
      app.getUser().clickOnLoginButton();
      Assert.assertTrue(app.getUser().isSignOutButtonPresent());
   }

   @Test
   public void loginRegistredUserNegativeTest() {
      app.getUser().clickOnLoginLink();
      app.getUser().fillLoginRegisterForm(new User()
             .setEmail("romasp221@gmail.com")
             .setPassword(UserData.PASSWORD));

      app.getUser().clickOnLoginButton();
      Assert.assertTrue(app.getUser().isSignOutButtonPresent());
   }

}