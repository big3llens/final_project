package ru.geekbrains.universiry.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "project_schema", name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
