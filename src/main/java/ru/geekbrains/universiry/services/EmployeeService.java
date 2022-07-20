package ru.geekbrains.universiry.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.universiry.dto.EditEmployeeDto;
import ru.geekbrains.universiry.dto.EmployeeDto;
import ru.geekbrains.universiry.exceptions.ResourceNotFoundException;
import ru.geekbrains.universiry.models.Employee;
import ru.geekbrains.universiry.models.Role;
import ru.geekbrains.universiry.repositories.EmployeeRepositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepositories employeeRepositories;
    StringBuilder sb = new StringBuilder();

    public List<EmployeeDto> findAllByOrganization(Integer id){
        List<Employee> employeeList = employeeRepositories.findAllByOrganization_IdAndIsPrintOrderByStructuralSubdivisionAscDepartmentAscPrioritiesAsc(id, true);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee el: employeeList) {
            sb.setLength(0);
            employeeDtos.add(createDto(el));
        }
        return employeeDtos;
    }

    public EmployeeDto findEmployeeByLastName(String name){
        Employee tempEmp = employeeRepositories.findEmployeeByLastName(name).orElseThrow(() -> new ResourceNotFoundException(String.format("Сотрудника с фамилией: %s в справочнике нет", name)));
        return createDto(tempEmp);
    }

    public EditEmployeeDto findEditEmployeeByLastName(String name){
        Employee tempEmp = employeeRepositories.findEmployeeByLastName(name).orElseThrow(() -> new ResourceNotFoundException(String.format("Сотрудника с фамилией: %s в справочнике нет", name)));
        return createEditedDto(tempEmp);
    }

    public void hideEmployee(Long id){
        Boolean isPrint = !employeeRepositories.findById(id).get().isPrint();
        employeeRepositories.hideEmployee(isPrint, id);
        System.out.println(isPrint);
    }

    public void updateEmployee(EditEmployeeDto employeeDto){
        String[] lastName = employeeDto.getName().split("\\s");
        System.out.println(lastName[0]);
        Employee tempEmp = employeeRepositories.findById(employeeDto.getId()).orElseThrow(() -> new ResourceNotFoundException(String.format("Сотрудника с фамилией: %s в справочнике нет", employeeDto.getName())));
        tempEmp.setLastName(lastName[0]);
        tempEmp.setOrganization(employeeDto.getOrganization());
        tempEmp.setDepartment(employeeDto.getDepartment());
        tempEmp.setPosition(employeeDto.getPosition());
        tempEmp.setLocalPhoneNumber(employeeDto.getLocalPhoneNumber());
        tempEmp.setPhoneNumberCity(employeeDto.getPhoneNumberCity());
        tempEmp.setMobilePhoneNumber(employeeDto.getMobilePhoneNumber());
        tempEmp.setRoomNumber(employeeDto.getRoomNumber());
        tempEmp.setEmail(tempEmp.getEmail());
        if (employeeDto.getPrint().equals("false")) tempEmp.setPrint(Boolean.FALSE);
        else tempEmp.setPrint(Boolean.TRUE);
        tempEmp.setPrint(tempEmp.isPrint());
        employeeRepositories.save(tempEmp);
    }

    public void saveEmployee(EditEmployeeDto employeeDto){
        Employee tempEmp = new Employee();
        tempEmp.setDepartment(employeeDto.getDepartment());
        tempEmp.setOrganization(employeeDto.getOrganization());
        tempEmp.setPosition(employeeDto.getPosition());
        tempEmp.setLocalPhoneNumber(employeeDto.getLocalPhoneNumber());
        tempEmp.setPhoneNumberCity(employeeDto.getPhoneNumberCity());
        tempEmp.setMobilePhoneNumber(employeeDto.getMobilePhoneNumber());
        tempEmp.setRoomNumber(employeeDto.getRoomNumber());
        tempEmp.setEmail(tempEmp.getEmail());
        tempEmp.setPrint(Boolean.TRUE);
        employeeRepositories.save(tempEmp);
    }


    public EmployeeDto findEmployeeById(Long id){
        return createDto(employeeRepositories.findById(id).orElseThrow());
    }

    public void saveOrUpdateEmployee(Employee employee){
        employeeRepositories.save(employee);
    }

    public List<EmployeeDto> findAllEmployees(){
        List<Employee> le = employeeRepositories.findAllEmployees();
        List<EmployeeDto> lEmpDto = new ArrayList<>();
        for (Employee e: le) {
            lEmpDto.add(createDto(e));
        }
        return lEmpDto;
    }

    public EmployeeDto createDto(Employee employee){
        sb.setLength(0);
        return new EmployeeDto(employee.getId(), sb.append(employee.getLastName()).append(" ").append(employee.getFirstName()).append(" ").append(employee.getMiddleName()).toString(), employee.getLastName(),
                employee.getDepartment().getDepartmentName(), employee.getPosition(), employee.getLocalPhoneNumber(), employee.getPhoneNumberCity(), employee.getMobilePhoneNumber(), employee.getEmail(), employee.isPrint());
    }

    public EditEmployeeDto createEditedDto(Employee employee){
        sb.setLength(0);
        return new EditEmployeeDto(employee.getId(), employee.getLastName(), employee.getOrganization(), employee.getDepartment(), employee.getPosition(),
                employee.getLocalPhoneNumber(), employee.getPhoneNumberCity(), employee.getMobilePhoneNumber(), employee.getRoomNumber(), employee.getEmail(), "");
    }

    public Optional<Employee> findByLogin(String login) {
        return employeeRepositories.findEmployeeByLogin(login);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", login)));
        return new org.springframework.security.core.userdetails.User(employee.getLogin(), employee.getPassword(), mapRolesToAuthorities(employee.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
