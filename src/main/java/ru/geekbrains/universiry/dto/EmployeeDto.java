package ru.geekbrains.universiry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {
    private String name;
    private String position;
    private int locaPhoneNumber;
    private int phoneNumberCity;
    private long mobilePhoneNumber;
}
