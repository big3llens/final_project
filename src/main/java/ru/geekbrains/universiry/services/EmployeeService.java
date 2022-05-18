package ru.geekbrains.universiry.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.universiry.dto.EmployeeDto;
import ru.geekbrains.universiry.models.Employee;
import ru.geekbrains.universiry.repositories.EmployeeRepositories;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepositories repositories;

    public List<EmployeeDto> findAll(){
        List<Employee> employeeList = repositories.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Employee el: employeeList) {
            employeeDtos.add(new EmployeeDto(sb.append(el.getLastName()).append(" ").append(el.getFirstName()).append(" ").append(el.getMiddleName()).toString(),
                    el.getPosition(), el.getLocaPhoneNumber(), el.getPhoneNumberCity(), el.getMobilePhoneNumber()));
        }
        return employeeDtos;

    }

}
