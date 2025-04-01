package com.fortunetelllers.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users_master")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @Id
    private String userId;
    @Column(name="user_name", nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(length = 1000)
    private String about;
    private String password;
    @Column(length = 1000)
    private String profilePic;
    private String gender;
    private boolean isEmailVerified;
    private String phoneNumber;
    private boolean isPhoneVerified;
    private boolean isUserEnabled = false;

    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contacts> contacts = new ArrayList<>();



}
