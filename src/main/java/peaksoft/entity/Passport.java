package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@NoArgsConstructor
@Getter@Setter
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String INN;
    private String nationality;
    private String gender;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "passport")
    private Person person;
    public Passport(String INN, String nationality, String gender) {
        this.INN = INN;
        this.nationality = nationality;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", INN='" + INN + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
