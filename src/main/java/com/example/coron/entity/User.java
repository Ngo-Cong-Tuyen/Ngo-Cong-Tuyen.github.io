package com.example.coron.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "province")
    private String provice;

    @Column(name = "district")
    private String district;

    @Column(name = "ward")
    private String ward;
    @Column(name = "enabled")
    private Boolean enabled = false;
    @Type(type = "json")
    @Column(name= "role", columnDefinition = "json")
    private List<String> role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        this.getRole().forEach(r -> roles.add(new SimpleGrantedAuthority("ROLE_"+ r)));
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public User(String name,String phone, String email, String password,String address, List<String> role) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
