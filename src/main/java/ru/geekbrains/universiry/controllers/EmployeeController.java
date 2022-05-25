package ru.geekbrains.universiry.controllers;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.universiry.dto.EmployeeDto;
import ru.geekbrains.universiry.models.EmployeeName;
import ru.geekbrains.universiry.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@Data
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/main")
    private String showMainPage (){
        return "Главная.html";
    }

    @GetMapping("/psb/{id}")
    @ResponseBody
    private List<EmployeeDto> doMethod (@PathVariable Integer id){
        return employeeService.findAll(id);
    }

//    @GetMapping("/searchByName/{name}")
//    @ResponseBody
//    private EmployeeDto findEmployeeByLastName(@PathVariable String name){
//        return employeeService.findEmployeeByLastName(name);
//    }

    @PostMapping("/searchByName")
    @ResponseBody
    private List<EmployeeDto> findEmployeeByLastName(@RequestBody EmployeeName name){
        List<EmployeeDto> ls = new ArrayList<>();
        ls.add(employeeService.findEmployeeByLastName(name.getName()));
        ls.add(employeeService.findEmployeeByLastName(name.getName()));
        return ls;
//        return employeeService.findEmployeeByLastName(name.getName());
    }
}
