package ru.geekbrains.universiry.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "project_schema", name = "office_adress")
@Data
public class OfficeAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "office_adress")
    private String officeAdress;
}
