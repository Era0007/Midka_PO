package Std.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Data
@Setter

@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
