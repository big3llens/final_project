package ru.geekbrains.universiry.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "project_schema", name = "department")
@Data
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name")
    private String departmentName;
}
