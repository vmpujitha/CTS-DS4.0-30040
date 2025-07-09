package com.cts.spring_learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpringLearnApplication {
    public static void main(String[] args) {
        displayDate();
    }

    public static void displayDate() {
    	  ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
          SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
          try {
              Date date = format.parse("31/12/2018");
              System.out.println("Parsed Date: " + date);
          } catch (ParseException e) {
              e.printStackTrace();
        }
    }
}
