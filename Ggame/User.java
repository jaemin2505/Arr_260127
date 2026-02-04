package Ggame;

import lombok.Data;

@Data
class User {
    private String id;
    private String password;
    private String lastLogin;
    private Record record;

    public User(String id, String password, String lastLogin, Record record) {
        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
        this.record = record;
    }
}