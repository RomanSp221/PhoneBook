package com.ait.phonebook.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.ContactData;
import com.ait.phonebook.utils.DataProviders;
import com.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddNewContactTests extends TestBase {

//   @BeforeClass
//   public void beforeClass() {
//      System.out.println("********* Before class! *******");
//   }
//
//   @AfterClass
//   public void afterClass() {
//      System.out.println("****** After class! *****");
//   }

   @BeforeMethod
   public void ensurePrecondition() {
      if (!app.getUser().isLoginLinkPresent()) {
         app.getUser().clickOnSignOutButton();
      }
      app.getUser().clickOnLoginLink();
      app.getUser().fillLoginRegisterForm(new User()
             .setEmail(UserData.EMAIL)
             .setPassword(UserData.PASSWORD));
      app.getUser().clickOnLoginButton();
   }

   @AfterMethod
   public void postCondition() {

      app.getContact().removeContact();
   }

   @Test(dataProvider = " addNewContact", dataProviderClass = DataProviders.class)
   public void addNewContactFromDataProviderPOsitiveTest(String name, String lastname, String phone,
                                                         String email, String address, String description) {
      app.getContact().clickOnAddLink();

      app.getContact().fillContactForm(new Contact()
             .setName(ContactData.NAME)
             .setLastname(ContactData.LAST_NAME)
             .setPhone(ContactData.PHONE)
             .setEmail(ContactData.EMAIL)
             .setAddress(ContactData.ADDRESS)
             .setDescription(ContactData.DESCRIPTION));

      app.getContact().clickOnSaveButton();
   }

   @Test(dataProvider = " addNewContactFromCSV", dataProviderClass = DataProviders.class)
   public void addNewContactFromDataProviderCSWPositiveTest(Contact contact) {
      logger.info("Tests run with data: " + contact.toString());
      app.getContact().clickOnAddLink();

      app.getContact().fillContactForm(contact);

      app.getContact().clickOnSaveButton();

      Assert.assertTrue(app.getContact().isContactCreatedByText(ContactData.NAME));

   }
}





