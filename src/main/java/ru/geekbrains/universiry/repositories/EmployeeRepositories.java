package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.universiry.models.Employee;

public interface EmployeeRepositories extends JpaRepository<Employee, Long> {

}
