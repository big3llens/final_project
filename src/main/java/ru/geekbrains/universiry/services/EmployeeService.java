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
    StringBuilder sb = new StringBuilder();

    public List<EmployeeDto> findAll(Integer id){
        List<Employee> employeeList = repositories.findAllByOrganization_Id(id);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee el: employeeList) {
            sb.setLength(0);
            employeeDtos.add(new EmployeeDto(sb.append(el.getLastName()).append(" ").append(el.getFirstName()).append(" ").append(el.getMiddleName()).toString(),
                    el.getDepartment().getDepartmentName(), el.getPosition(), el.getLocalPhoneNumber(), el.getPhoneNumberCity(), el.getMobilePhoneNumber(), el.getEmail()));
        }
        return employeeDtos;
    }

    public EmployeeDto findEmployeeByLastName(String name){
        Employee tempEmp = repositories.findEmployeeByLastName(name);
        sb.setLength(0);
        return new EmployeeDto(sb.append(tempEmp.getLastName()).append(" ").append(tempEmp.getFirstName()).append(" ").append(tempEmp.getMiddleName()).toString(),
                tempEmp.getDepartment().getDepartmentName(), tempEmp.getPosition(), tempEmp.getLocalPhoneNumber(), tempEmp.getPhoneNumberCity(), tempEmp.getMobilePhoneNumber(), tempEmp.getEmail());
    }

}
