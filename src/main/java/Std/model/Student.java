package Std.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    private List <Group> groups;
    @ManyToMany(fetch = FetchType.EAGER)
    private List <Lecture> lectures;
}
