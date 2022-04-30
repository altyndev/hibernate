package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Getter @Setter
public class Person {

    @Id
    @GeneratedValue(generator = "person_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "person_gen", sequenceName = "person_sequence", allocationSize = 1)
    private long id;
    private String name;
    private String surName;
    private String email;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    public Person(String name, String surName, String email, int age) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", passport=" + passport +
                '}';
    }
}
