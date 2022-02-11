package com.kodem.springboot.linkedinbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName="id")
    @JsonIgnore
    @NotNull
    private User user;

    @Column(name = "skill_name")
    private String skillName;

    protected Skill() {
    }

    public Skill(User user, String skillName) {
        this.user = user;
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", user=" + user +
                ", skillName='" + skillName + '\'' +
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

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
