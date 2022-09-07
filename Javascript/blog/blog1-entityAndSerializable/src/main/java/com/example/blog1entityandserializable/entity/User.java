package com.example.blog1entityandserializable;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
    @EmbeddedId UserId userId;
    Email email;
}