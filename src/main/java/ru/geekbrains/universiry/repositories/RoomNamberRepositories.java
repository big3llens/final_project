package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.universiry.models.RoomNumber;

public interface RoomNamberRepositories extends JpaRepository<RoomNumber, Integer> {
}
