package dev.kennethlindalen.rkupongoversikt.Security.JWT.Models;

import java.io.Serializable;

public class JWTRequest implements Serializable {

    public static final long serialVersionUID = 7008375124389347049L;

    private String username;
    private String password;

    public JWTRequest() {}

    public JWTRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
