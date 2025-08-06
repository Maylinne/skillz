package com.example.skills.controller;

import com.example.skills.dto.*;
import com.example.skills.entity.Difficulty;
import com.example.skills.entity.PlayerEntity;
import com.example.skills.mapper.PlayerMapper;
import com.example.skills.service.PlayerService;
import com.example.skills.service.SkillService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;
    private final PlayerService playerService;

    public SkillController(SkillService skillService,
                           PlayerService playerService) {
        this.skillService = skillService;
        this.playerService = playerService;
    }

    @PostMapping("/player")
    public ResponseEntity<String> upsertPlayer(@RequestBody @Valid BulkUploadDTO dto) {
        String message = "";
        try {
            PlayerDto playerDto = playerService.findById(dto.getPlayerId());
            message = playerService.updatePlayer(playerDto, dto).getName() + "updated";
        } catch (IllegalArgumentException e) {
            message = skillService.createPlayerWithSkills(dto).getName() + "created";
        }

        return ResponseEntity.ok("Player " + message);
    }

    @GetMapping("/definitions")
    public ResponseEntity<List<SkillDefinitionDto>> getSkillDefinitions() {
        List<SkillDefinitionDto> definitions = skillService.getDefinitions();
        return ResponseEntity.ok(definitions);
    }

    @GetMapping("/difficulties")
    public ResponseEntity<List<SkillDifficulty>> getDifficulties() {
        List<SkillDifficulty> difficulties = new ArrayList<>();
        for (Difficulty difficulty : Difficulty.values()) {
            difficulties.add(new SkillDifficulty(difficulty.name(), difficulty.thresholds()));
        }
        return ResponseEntity.ok(difficulties);
    }

    @GetMapping("/playerSkills/{id}")
    public ResponseEntity<List<SkillDto>> getPlayerSkills(@PathVariable Long id) {
        try {
            PlayerDto player = playerService.findById(id);
            return ResponseEntity.ok(player.getSkills());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) {
        try {
            PlayerDto player = playerService.findById(id);
            return ResponseEntity.ok(player);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
