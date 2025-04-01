package com.fortunetelllers.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="contacts")
@Table(name="contacts_master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contacts {
    @Id
    private String id;
    private String contactName;
    private String contactNumber;
    private String contactEmail;
    private String contactAddress;
    private String contactProfilePic;
    @Column(length = 1000)
    private String contactAbout;
    private boolean isFavorite = false;
    private String websiteLink;
    // private List<String> solialAccounts = new ArrayList<>();
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> socialLinks = new ArrayList<>();
}
