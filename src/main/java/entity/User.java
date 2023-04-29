package entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passWord;
    @OneToOne(mappedBy = "user")
    private Liability liability;
    @OneToOne(mappedBy = "user")
    private Asset asset;
}
