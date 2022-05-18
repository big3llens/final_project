package ru.geekbrains.universiry.controllers;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.universiry.dto.EmployeeDto;
import ru.geekbrains.universiry.services.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/")
@Data
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/a")
    private String methodOn (){
        return "Главная.html";
    }

    @GetMapping("/b")
    @ResponseBody
    private List<EmployeeDto> doMethod (){
        return employeeService.findAll();
    }
}
