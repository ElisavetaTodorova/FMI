package com.example.notes;

public class LoginData {
  
  public String uid;
  public String password;

  public LoginData(String id, String count) {
    this.uid = id;
    this.password = count;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
