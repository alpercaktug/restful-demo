package io.github.alpercaktug.restfuldemo.data;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Student {

    private UUID studentId;
    private String name;
    private String surname;
    private int age;

}
