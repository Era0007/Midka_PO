package Std.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Data
@Setter

@Table(name = "t_lectures")
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
