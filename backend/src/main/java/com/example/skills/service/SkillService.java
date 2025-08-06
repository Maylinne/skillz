package com.example.skills.service;

import com.example.skills.dto.*;
import com.example.skills.entity.*;
import com.example.skills.mapper.DefinitionMapper;
import com.example.skills.mapper.PlayerMapper;
import com.example.skills.mapper.SkillMapper;
import com.example.skills.repository.PlayerRepository;

import com.example.skills.repository.SkillDefinitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    private final PlayerRepository playerRepository;
    private final SkillDefinitionRepository definitionRepository;

    public SkillService(PlayerRepository playerRepository,
                        SkillDefinitionRepository definitionRepository) {
        this.playerRepository = playerRepository;
        this.definitionRepository = definitionRepository;
    }

    @Transactional
    public PlayerEntity createPlayerWithSkills(BulkUploadDTO dto) {
        PlayerDto player = new PlayerDto(dto.getPlayerName(), dto.getPlayerRace());

        player.setAttributes(dto.getAttributes());

        for (NamedSkillDto skill : dto.getSkills()) {
            SkillDto skillToAdd = DefinitionMapper.toSkill(skill.skillDef(), player, skill.value());
            player.addSkill(skillToAdd);
        }

        PlayerEntity playerEntity = PlayerMapper.toEntity(player);

        PlayerEntity savedPlayer = playerRepository.save(playerEntity);

        return savedPlayer;
    }

    public List<SkillDefinitionDto> getDefinitions() {
        List<SkillDefinitionEntity> allEntities = definitionRepository.findAll();

        List<SkillDefinitionDto> allDtos = new ArrayList<>();
        for (SkillDefinitionEntity entity : allEntities) {
            allDtos.add(DefinitionMapper.toDto(entity));
        }
        return allDtos;
    }
}
