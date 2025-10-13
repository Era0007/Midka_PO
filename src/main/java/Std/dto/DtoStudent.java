package Std.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
}


