package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.universiry.models.Employee;

import java.util.List;

public interface EmployeeRepositories extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrganization_IdAndPrintOrderByStructuralSubdivisionAscDepartmentAscPrioritiesAsc(Integer organizationId, Boolean print);

    Employee findEmployeeByLastName(String name);

    @Query( value="update project_schema.employee set print = false where id = :id", nativeQuery = true)
    void hideEmployee(@Param("id") Integer id);
}
