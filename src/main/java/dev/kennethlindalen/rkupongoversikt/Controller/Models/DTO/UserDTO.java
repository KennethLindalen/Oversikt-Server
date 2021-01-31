package dev.kennethlindalen.rkupongoversikt.Controller.Models.DTO;

public class UserDTO {
    private String username;
    private String password;
    private boolean isActive;

    public UserDTO() {
    }

    public UserDTO(String username, String password, boolean isActive) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
