package com.example.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "identity_card")
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}