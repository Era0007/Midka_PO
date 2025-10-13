package Std.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoLecture {
    private Long id;
    private String name;
    private String description;
}
