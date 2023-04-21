package org.example;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;


public class Randomize {


  String rndNameMin = RandomStringUtils.randomAlphabetic(2);
  String rndName = RandomStringUtils.randomAlphabetic(18);
  Boolean rndBool = RandomUtils.nextBoolean();

  String rndPhoneInValid = RandomStringUtils.randomNumeric(1000000,9999999);
  int runPhoneValid = RandomUtils.nextInt(10000000,99999999);

  String rndWrongNum = RandomStringUtils.randomNumeric(1, 15);

  String rndId = RandomStringUtils.randomAlphanumeric(24);

  String rndEmail = generateRandomEmail();

  private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
  private static final int LENGTH = 10;

  public static String generateRandomEmail() {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    // generate random characters for the email username
    for (int i = 0; i < LENGTH; i++) {
      char c = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
      sb.append(c);
    }

    // generate a random email domain
    String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "aol.com"};
    String domain = domains[random.nextInt(domains.length)];

    // return the random email
    return sb.toString() + "@" + domain;
  }

  public String getRndNameMin() {
    return rndNameMin;
  }

  public void setRndNameMin(String rndNameMin) {
    this.rndNameMin = rndNameMin;
  }

  public String getRndName() {
    return rndName;
  }

  public void setRndName(String rndName) {
    this.rndName = rndName;
  }

  public Boolean getRndBool() {
    return rndBool;
  }

  public void setRndBool(Boolean rndBool) {
    this.rndBool = rndBool;
  }

  public String getRndEmail() {
    return rndEmail;
  }

  public void setRndEmail(String rndEmail) {
    this.rndEmail = rndEmail;
  }

  public String getRndId() {
    return rndId;
  }

  public void setRndId(String rndId) {
    this.rndId = rndId;
  }

  public String getRndWrongNum() {
    return rndWrongNum;
  }

  public void setRndWrongNum(String rndWrongNum) {
    this.rndWrongNum = rndWrongNum;
  }

  public String getRndPhoneInValid() {
    return rndPhoneInValid;
  }

  public void setRndPhoneInValid(String rndPhoneInValid) {
    this.rndPhoneInValid = rndPhoneInValid;
  }

  public int getRunPhoneValid() {
    return runPhoneValid;
  }

  public void setRunPhoneValid(int runPhoneValid) {
    this.runPhoneValid = runPhoneValid;
  }
}
