package com.example.skills.service;

import com.example.skills.dto.PlayerDto;
import com.example.skills.entity.AttributeEntity;
import com.example.skills.entity.PlayerEntity;
import com.example.skills.mapper.PlayerMapper;
import com.example.skills.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.skills.mapper.PlayerMapper.toDto;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public PlayerDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }
        Optional<PlayerEntity> optionalPlayerEntity = repository.findById(id);
        if (optionalPlayerEntity.isPresent()) {
            return toDto(optionalPlayerEntity.get());
        } else {
            throw new IllegalArgumentException("No player with id: " + id);
        }
    }


    @Transactional
    public PlayerDto updatePlayer(Long id, PlayerDto incoming) {
        PlayerEntity incomingEntity = PlayerMapper.toEntity(incoming);

        PlayerEntity managed = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        managed.setName(incoming.getName());
        managed.setRace(incoming.getRace());
        // update attributes
        for (AttributeEntity updatedAttr : incomingEntity.getAttributes()) {
            managed.getAttributes().stream()
                    .filter(a -> a.getId().equals(updatedAttr.getId()))
                    .findFirst()
                    .ifPresent(a -> a.setValue(updatedAttr.getValue()));
        }
        // skills, etc.
        return toDto(managed);
    }
}
