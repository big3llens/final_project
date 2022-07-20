package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.universiry.models.Department;

public interface DepartmentRepositories extends JpaRepository<Department, Long> {

}
