package by.gormit.pojos;

import java.io.Serializable;

/**
 * Created by Gormit on 26.08.2015.
 * Entity - User.
 * Bean class for working with entity-User
 */
public class User implements Serializable {

    private static final long serialVersionUID = -750928108152897654L;

    private int id;
    private String name;
    private String surname;
    private String login;
    private String mail;
    private String phoneNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
