package com.busyqa.crm.auth;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private long id;

    @Column(name="USERNAME", nullable=false, unique=true)
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// BCrypt Converter: https://www.browserling.com/tools/bcrypt
// jarc|foobar
// moe|password
