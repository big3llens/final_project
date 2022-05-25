package ru.geekbrains.universiry.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "project_schema", name = "structural_subdivision")
@Data
public class StructuralSubdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "structural_subdivision_name")
    private String name;
}
