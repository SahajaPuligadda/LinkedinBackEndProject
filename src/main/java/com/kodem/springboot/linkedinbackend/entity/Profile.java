package com.kodem.springboot.linkedinbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", referencedColumnName="id")
    @JsonIgnore
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "location")
    private String location;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "about")
    private String about;

    @Column(name = "photo")
    private String photo;

    public Profile() {
    }

    public Profile(User user, String name, String tagline,
                   String workplace, String location,
                   String photo, String about) {
        this.user = user;
        this.name = name;
        this.tagline = tagline;
        this.location = location;
        this.workplace = workplace;
        this.about = about;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
//                ", user=" + user +
                ", name='" + name + '\'' +
                ", tagline='" + tagline + '\'' +
                ", location='" + location + '\'' +
                ", workplace='" + workplace + '\'' +
                ", about='" + about + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
