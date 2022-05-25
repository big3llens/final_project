package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.universiry.models.Employee;

import java.util.List;

public interface EmployeeRepositories extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrganization_Id(Integer id);

    Employee findEmployeeByLastName(String name);
}
