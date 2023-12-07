package com.ait.phonebook.utils;

import com.ait.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

   @DataProvider
   public Iterator<Object[]> addNewContact() {
      List<Object[]> list = new ArrayList<>();

      list.add(new Object[]{"Oliver", "Kan", "1234567890", "romasp221@gmail.com", "Berlin", "goalkeeper"});
      list.add(new Object[]{"Oliver1", "Kan", "12345678901", "romasp222@gmail.com", "Berlin", "goalkeeper"});
      list.add(new Object[]{"Oliver2", "Kan", "12345678902", "romasp223@gmail.com", "Berlin", "goalkeeper"});
      return list.iterator();
   }

   @DataProvider
   public Iterator<Object[]> addNewContactFormCSV() throws IOException {
      List<Object[]> list = new ArrayList<>();

      BufferedReader reader = new BufferedReader(new FileReader
             ("C:ait QA_Lesson\\QA28_PhoneBook\\src\\test\\resources\\Contact.csv"));

      String line = reader.readLine();
      while (line != null) {
         String[] split = line.split(",");

         list.add(new Object[]{
                new Contact()
                       .setName(split[0])
                       .setLastname(split[1])
                       .setPhone(split[2])
                       .setEmail(split[3])
                       .setAddress(split[4])
                       .setDescription(split[5])});
         line = reader.readLine();
      }
      return list.iterator();
   }
}

