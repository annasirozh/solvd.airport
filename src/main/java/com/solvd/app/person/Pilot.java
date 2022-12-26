package com.solvd.app.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pilot extends Person {
      public static final Logger logger = LogManager.getLogger(Pilot.class);
      private static String qualification;

      //блок инициализации
      static {
            qualification = "high";
      }
      public Pilot(String nameOfPerson, String surnameOfPerson, String qualification) {
            super(nameOfPerson, surnameOfPerson);
            this.qualification = qualification;
      }

      public static String getQualification() {
            return qualification;
      }

      public static void setQualification(String qualification) {
            Pilot.qualification = qualification;
      }

      @Override
      public void displayInformationAboutPerson() {
            logger.info("Pilot name: %s \t Pilot surname: %s \n Pilot qualification: %s \n", super.getNameOfPerson(),super.getSurnameOfPerson(),qualification);
      }
}
