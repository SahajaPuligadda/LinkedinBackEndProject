package com.kodem.springboot.linkedinbackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private Set<Education> educations = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Experience> experiences = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Skill> skills = new HashSet<>();

    protected User() {
    }

    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public User(String email, String password,
                Profile profile, Set<Education> educations,
                Set<Experience> experiences, Set<Skill> skills) {
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.educations = educations;
        this.experiences = experiences;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
