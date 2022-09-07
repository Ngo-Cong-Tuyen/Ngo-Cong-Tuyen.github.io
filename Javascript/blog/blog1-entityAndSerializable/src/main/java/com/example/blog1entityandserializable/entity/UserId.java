package com.example.blog1entityandserializable.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class UserId implements Serializable {
    private String name;
    private String lastName;

}
