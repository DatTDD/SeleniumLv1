package com.railway.dataobject;

public enum Account {

    VALID_ACCOUNT("dattdd129@gmail.com", "12345678"),
    BLANK_USERNAME_ACCOUNT("", "12345678"),
    INVALID_PASSWORD_ACCOUNT("dattdd129@gmail.com","123ABC"),
    ACCOUNT_WITHOUT_ACCTIVE("dcypnfhi@sharklasers.com","12345678");

    private String username;
    private String password;

    Account(String username, String password){
        this.username = username;
        this.password = password;

    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

}
