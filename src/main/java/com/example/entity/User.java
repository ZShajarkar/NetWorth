package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotNull  @Column(unique = true) @Email(message = "Email must be valid")
    private String email;
    private String passWord;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private Liability liability;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private Asset asset;
}
