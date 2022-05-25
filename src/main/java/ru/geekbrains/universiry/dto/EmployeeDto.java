package ru.geekbrains.universiry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {
    private String name;
    private String department;
    private String position;
    private Integer localPhoneNumber;
    private Integer phoneNumberCity;
    private Long mobilePhoneNumber;
    private String email;
}
