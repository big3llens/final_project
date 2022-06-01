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

    public List<EmployeeDto> findAllByOrganization(Integer id){
        List<Employee> employeeList = repositories.findAllByOrganization_IdAndPrintOrderByStructuralSubdivisionAscDepartmentAscPrioritiesAsc(id, true);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee el: employeeList) {
            sb.setLength(0);
            employeeDtos.add(createDto(el));
        }
        return employeeDtos;
    }

    public EmployeeDto findEmployeeByLastName(String name){
        Employee tempEmp = repositories.findEmployeeByLastName(name);
        sb.setLength(0);
        return createDto(tempEmp);
    }

    public void hideEmployee( int id){
        repositories.hideEmployee( id);
    }

    public void saveOrUpdateEmployee(Employee employee){
        repositories.save(employee);
    }


    public EmployeeDto createDto(Employee employee){
        return new EmployeeDto(employee.getId(), sb.append(employee.getLastName()).append(" ").append(employee.getFirstName()).append(" ").append(employee.getMiddleName()).toString(),
                employee.getDepartment().getDepartmentName(), employee.getPosition(), employee.getLocalPhoneNumber(), employee.getPhoneNumberCity(), employee.getMobilePhoneNumber(), employee.getEmail());
    }

}
