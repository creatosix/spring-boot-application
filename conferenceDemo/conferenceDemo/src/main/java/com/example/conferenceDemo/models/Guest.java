package com.example.conferenceDemo.models;

import java.io.Serializable;

public class Guest implements Serializable {
    private Long guestId;
    private String firstName;
    private String lastName;
    private String title;
    private String company;
    private String guestBio;

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGuestBio() {
        return guestBio;
    }

    public void setGuestBio(String guestBio) {
        this.guestBio = guestBio;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", guestBio='" + guestBio + '\'' +
                '}';
    }

    public Guest() {
    }
}

