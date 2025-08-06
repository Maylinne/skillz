package com.example.skills.repository;

import com.example.skills.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    PlayerEntity findByName(String name);
}
