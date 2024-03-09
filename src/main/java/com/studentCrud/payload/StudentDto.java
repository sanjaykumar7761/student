package com.studentCrud.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String education;
    private String location;
}
