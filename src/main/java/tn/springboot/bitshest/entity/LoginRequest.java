package tn.springboot.bitshest.entity;

public class LoginRequest {

    private String email;
    private String password;
    private String token;

    // Getters et Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter et Setter pour le token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
