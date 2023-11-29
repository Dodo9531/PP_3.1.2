package web.models;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Users")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    public User() {
    }

    ;

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
