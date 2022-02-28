package com.example.Sales.Manager;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String firstName;
    private String lastName;
    private String email;
    private int numGuests;
    private String purpose;
    private LocalDateTime date;
    private String room;

    public Inquiry() {}

    public Inquiry(String firstName, String lastName, String email, int numGuests, String purpose, LocalDateTime date, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numGuests = numGuests;
        this.purpose = purpose;
        this.date = date;
        this.room = room;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
