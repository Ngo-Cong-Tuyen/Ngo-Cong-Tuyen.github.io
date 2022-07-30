package com.example.user.model;

import com.example.user.dto.UserDto;
import lombok.*;

import javax.persistence.*;
@NamedNativeQuery(
        name = "getAllUserDto",
        query = "select id,name,email,phone,address,avatar from user",
        resultSetMapping = "listUser"
)
@SqlResultSetMapping(
        name = "listUser",
        classes = @ConstructorResult(
                targetClass = UserDto.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "email"),
                        @ColumnResult(name = "phone"),
                        @ColumnResult(name = "address"),
                        @ColumnResult(name = "avatar")
                }
        )
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "passowrd", nullable = false)
    private String password;
}
