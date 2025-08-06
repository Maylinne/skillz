package com.example.skills.dto;

import com.example.skills.entity.Race;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Objects;

public class BulkUploadDTO {
    private Long playerId;
    private @NotNull String playerName;
    private @NotNull Race playerRace;
    private @NotNull List<AttributeDto> attributes;
    private @NotNull List<NamedSkillDto> skills;

    public BulkUploadDTO(

            Long playerId,

            @NotNull
            String playerName,

            @NotNull
            Race playerRace,

            @NotNull
            List<AttributeDto> attributes,

            @NotNull
            List<NamedSkillDto> skills
    ) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerRace = playerRace;
        this.attributes = attributes;
        this.skills = skills;
    }

        public Long getPlayerId() {
                return playerId;
        }

        public void setPlayerId(Long playerId) {
                this.playerId = playerId;
        }

        public String getPlayerName() {
                return playerName;
        }

        public void setPlayerName(String playerName) {
                this.playerName = playerName;
        }

        public Race getPlayerRace() {
                return playerRace;
        }

        public void setPlayerRace(Race playerRace) {
                this.playerRace = playerRace;
        }

        public List<AttributeDto> getAttributes() {
                return attributes;
        }

        public void setAttributes(List<AttributeDto> attributes) {
                this.attributes = attributes;
        }

        public List<NamedSkillDto> getSkills() {
                return skills;
        }

        public void setSkills(List<NamedSkillDto> skills) {
                this.skills = skills;
        }
}
