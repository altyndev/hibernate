package peaksoft.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "student-gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student-gen", sequenceName = "student", allocationSize = 1)
    private long id;
    private String name;
//    private String fullName;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
