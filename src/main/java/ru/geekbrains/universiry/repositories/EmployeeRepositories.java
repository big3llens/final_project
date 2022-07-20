package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.universiry.dto.EditEmployeeDto;
import ru.geekbrains.universiry.dto.EmployeeDto;
import ru.geekbrains.universiry.models.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepositories extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrganization_IdAndIsPrintOrderByStructuralSubdivisionAscDepartmentAscPrioritiesAsc(Integer organizationId, Boolean print);


    @Transactional
    @Modifying
    @Query( value="select * from project_schema.employee where print = true order by organization_id asc, structural_subdivision_id asc, department_id asc, priorities asc;", nativeQuery = true)
    List <Employee> findAllEmployees();

    Optional<Employee> findEmployeeByLastName(String name);

    Optional<Employee> findEmployeeByLogin(String login);

    Optional<Employee> findById (Long id);

//    @Override
    Employee save(Employee emp);

    @Transactional
    @Modifying
    @Query( value="update project_schema.employee set print = :isPrint where id = :id", nativeQuery = true)
    void hideEmployee(@Param("isPrint") Boolean isPrint, @Param("id") Long id);


}
