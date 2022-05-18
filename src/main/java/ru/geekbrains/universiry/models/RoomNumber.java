package ru.geekbrains.universiry.models;

import javax.persistence.*;

@Entity
@Table(schema = "project_schema", name = "room_number")
public class RoomNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private int room_number;
}
