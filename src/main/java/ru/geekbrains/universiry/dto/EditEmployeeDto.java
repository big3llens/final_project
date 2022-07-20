package ru.geekbrains.universiry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.geekbrains.universiry.models.Department;
import ru.geekbrains.universiry.models.Organization;
import ru.geekbrains.universiry.models.RoomNumber;

@Data
@AllArgsConstructor
public class EditEmployeeDto {
    private Long id;
    private String name;
    private Organization organization;
    private Department department;
    private String position;
    private Integer localPhoneNumber;
    private Integer phoneNumberCity;
    private Long mobilePhoneNumber;
    private RoomNumber roomNumber;
    private String email;
    private String print;
}
