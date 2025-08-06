package com.example.skills.service;

import com.example.skills.dto.BulkUploadDTO;
import com.example.skills.dto.PlayerDto;
import com.example.skills.entity.PlayerEntity;
import com.example.skills.mapper.PlayerMapper;
import com.example.skills.repository.PlayerRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public boolean existsById(Long id) {
        return repository.findById(id).isPresent();
    }

    public PlayerDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }
        Optional<PlayerEntity> optionalPlayerEntity = repository.findById(id);
        if (optionalPlayerEntity.isPresent()) {
            return PlayerMapper.toDto(optionalPlayerEntity.get());
        } else {
            throw new IllegalArgumentException("No player with id: " + id);
        }
    }


    public PlayerDto updatePlayer(PlayerDto playerDto, @Valid BulkUploadDTO dto) {
        return playerDto; //TODO IMPLEMENT
    }
}
