package com.example.skills;

import com.example.skills.dto.Category;
import com.example.skills.entity.*;
import com.example.skills.repository.PlayerRepository;
import com.example.skills.repository.SkillDefinitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static com.example.skills.dto.AttributeName.*;
import static com.example.skills.dto.Category.*;
import static com.example.skills.entity.SkillDefinitionDifficulty.*;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner initSkillDefinitions(SkillDefinitionRepository skillDefinitionRepository,
                                           PlayerRepository playerRepository) {
        return args -> {
            if (skillDefinitionRepository.count() == 0) {
                skillDefinitionRepository.saveAll(getAllSkillDefs());
            }

            if (playerRepository.count() == 0) {
                playerRepository.save(getPlayer("Zaheera"));
            }
        };

    }

    private static List<SkillDefinitionEntity> getAllSkillDefs() {
        List<SkillDefinitionEntity> combatSkills = List.of(
                new SkillDefinitionEntity("Fájdalomtűrés", HARD, STAMINA, HARCI),
                new SkillDefinitionEntity("Rövidkard", HARD, DEXTERITY, HARCI),
                new SkillDefinitionEntity("fegyverdobás", HARD, DEXTERITY, HARCI),
                new SkillDefinitionEntity("Buzogány(1h)", HARD, STRENGTH, HARCI),
                new SkillDefinitionEntity("Nehézvértviselet", NORMAL, STAMINA, HARCI),
                new SkillDefinitionEntity("Rögtönzött fegyver", HARD, DEXTERITY, HARCI),
                new SkillDefinitionEntity("Földharc", NORMAL, STRENGTH, HARCI),
                new SkillDefinitionEntity("Ostromgép", NORMAL, INTELLIGENCE, HARCI),
                new SkillDefinitionEntity("Kétkezes harc", HARD, DEXTERITY, HARCI),
                new SkillDefinitionEntity("Pajzshasználat", NORMAL, DEXTERITY, HARCI),
                new SkillDefinitionEntity("Taktika", NORMAL, INTELLIGENCE, HARCI),
                new SkillDefinitionEntity("Fegyverismeret", NORMAL, INTELLIGENCE, HARCI),
                new SkillDefinitionEntity("Harcművészet", NORMAL, SPEED, HARCI),
                new SkillDefinitionEntity("Kardművészet", VERY_HARD, DEXTERITY, HARCI),
                new SkillDefinitionEntity("Pusztakezes harc", NORMAL, STRENGTH, HARCI),
                new SkillDefinitionEntity("Pusztítás", HARD, STRENGTH, HARCI),
                new SkillDefinitionEntity("Nyeles fegyverek | Dao", HARD, DEXTERITY, HARCI),
                new SkillDefinitionEntity("Állóharc", NORMAL, STAMINA, HARCI),
                new SkillDefinitionEntity("Vakharc", HARD, PERCEPTION, HARCI),
                new SkillDefinitionEntity("Rövid bot", HARD, DEXTERITY, HARCI)
        );

        List<SkillDefinitionEntity> underworldSkills = List.of(
                new SkillDefinitionEntity("Álcázás/Álruha", NORMAL, DEXTERITY, ALVILAGI),
                new SkillDefinitionEntity("Hamisítás", HARD, INTELLIGENCE, ALVILAGI),
                new SkillDefinitionEntity("Jelbeszéd", NORMAL, INTELLIGENCE, ALVILAGI),
                new SkillDefinitionEntity("Kocsmai verekedés", EASY, STRENGTH, ALVILAGI),
                new SkillDefinitionEntity("Méregkeverés", NORMAL, INTELLIGENCE, ALVILAGI),
                new SkillDefinitionEntity("Orvtámadás", NORMAL, DEXTERITY, ALVILAGI),
                new SkillDefinitionEntity("Kínzás", NORMAL, WILLPOWER, ALVILAGI),
                new SkillDefinitionEntity("Kendőnyelv", HARD, INTELLIGENCE, ALVILAGI),
                new SkillDefinitionEntity("Szerencsejáték(kártyázás)", NORMAL, CHARISMA, ALVILAGI),

                // Percent-based skills
                new SkillDefinitionEntity("Csapdakeresés", PERCENT, PERCEPTION, ALVILAGI),
                new SkillDefinitionEntity("Lopakodás", PERCENT, DEXTERITY, ALVILAGI),
                new SkillDefinitionEntity("Rejtőzés", PERCENT, DEXTERITY, ALVILAGI),
                new SkillDefinitionEntity("Rejtekhely kutatás", PERCENT, PERCEPTION, ALVILAGI),
                new SkillDefinitionEntity("Zárnyitás", PERCENT, DEXTERITY, ALVILAGI),
                new SkillDefinitionEntity("Zsebmetszés", PERCENT, DEXTERITY, ALVILAGI),
                new SkillDefinitionEntity("Észlelés", PERCENT, PERCEPTION, ALVILAGI),
                new SkillDefinitionEntity("Követés/Lerázás", PERCENT, PERCEPTION, ALVILAGI)
        );

        List<SkillDefinitionEntity> civilSkills = List.of(
                new SkillDefinitionEntity("Csomózás", NORMAL, DEXTERITY, VILAGI),
                new SkillDefinitionEntity("Csapdaállítás", NORMAL, DEXTERITY, VILAGI),
                new SkillDefinitionEntity("Lovaglás", EASY, SPEED, VILAGI),
                new SkillDefinitionEntity("Értékbecslés", EASY, INTELLIGENCE, VILAGI),
                new SkillDefinitionEntity("Állatismeret", EASY, INTELLIGENCE, VILAGI),
                new SkillDefinitionEntity("Futás", EASY, SPEED, VILAGI),
                new SkillDefinitionEntity("Hajózás", NORMAL, INTELLIGENCE, VILAGI),
                new SkillDefinitionEntity("Hangutánzás", NORMAL, CHARISMA, VILAGI),
                new SkillDefinitionEntity("Helyismeret(Doran)", EASY, INTELLIGENCE, VILAGI),
                new SkillDefinitionEntity("Idomítás", NORMAL, CHARISMA, VILAGI),
                new SkillDefinitionEntity("Időjóslás", NORMAL, INTELLIGENCE, VILAGI),
                new SkillDefinitionEntity("Kocsihajtás", EASY, DEXTERITY, VILAGI),
                new SkillDefinitionEntity("Nyomolvasás", NORMAL, PERCEPTION, VILAGI),
                new SkillDefinitionEntity("Szakma(Csiszolás)", NORMAL, DEXTERITY, VILAGI),
                new SkillDefinitionEntity("Úszás", EASY, SPEED, VILAGI),
                new SkillDefinitionEntity("Vadonjárás", NORMAL, PERCEPTION, VILAGI),

                // Percent-based
                new SkillDefinitionEntity("Akrobatika", PERCENT, DEXTERITY, VILAGI),
                new SkillDefinitionEntity("Esés", PERCENT, SPEED, VILAGI),
                new SkillDefinitionEntity("Mászás", PERCENT, STRENGTH, VILAGI)
        );

        List<SkillDefinitionEntity> scientificSkills = List.of(
                new SkillDefinitionEntity("Történelem", NORMAL, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Alkímia", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Élettan", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Navigáció", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Herbalizmus", NORMAL, PERCEPTION, TUDOMANYOS),
                new SkillDefinitionEntity("Írás/Olvasás", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Jog/Törvénykezés", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Legendaismeret", NORMAL, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Mechanika", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Oktatás", HARD, CHARISMA, TUDOMANYOS),
                new SkillDefinitionEntity("Orvoslás", VERY_HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Ősi nyelv(Kyr)", VERY_HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Számtan/Mértan", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Térképészet", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Vallásismeret(Krad)", NORMAL, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Vallásismeret(Pyarr)", HARD, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Történelem(Doran)", NORMAL, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Ásványtan", NORMAL, INTELLIGENCE, TUDOMANYOS),
                new SkillDefinitionEntity("Legendaismeret(Doran)", NORMAL, INTELLIGENCE, TUDOMANYOS)
        );

        List<SkillDefinitionEntity> socialSkills = List.of(
                new SkillDefinitionEntity("Ékesszólás", EASY, CHARISMA, SZOCIALIS),
                new SkillDefinitionEntity("Heraldika(Doran)", EASY, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Kultúra(Viharszem szigetek)", EASY, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Lélektan", HARD, WILLPOWER, SZOCIALIS),
                new SkillDefinitionEntity("Művészetek (Rajz)", NORMAL, DEXTERITY, SZOCIALIS),
                new SkillDefinitionEntity("Holt nyelv(Ó-Kyr)", NORMAL, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Nyelvtudás(pyar közös)", HARD, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Politika/Diplomácia", HARD, CHARISMA, SZOCIALIS),
                new SkillDefinitionEntity("Színészet", HARD, CHARISMA, SZOCIALIS),
                new SkillDefinitionEntity("Szexuális kultúra", EASY, CHARISMA, SZOCIALIS),
                new SkillDefinitionEntity("Udvari etikett(kyr)", NORMAL, CHARISMA, SZOCIALIS),
                new SkillDefinitionEntity("Nyelvtudás(kyr)", EASY, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Kultúra(Doran)", EASY, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Nyelvtudás (Dzsad)", EASY, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Nyelvtudás(erv közös)", EASY, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Kultúra(Erioni vegyes)", EASY, INTELLIGENCE, SZOCIALIS),
                new SkillDefinitionEntity("Helyismeret(Tiadlan)", EASY, PERCEPTION, SZOCIALIS),
                new SkillDefinitionEntity("Helyismeret(Erion 3/2/1)", EASY, PERCEPTION, SZOCIALIS),
                new SkillDefinitionEntity("Udvari etikett()", NORMAL, CHARISMA, SZOCIALIS),
                new SkillDefinitionEntity("Vallásismeret(Kyr)", NORMAL, INTELLIGENCE, SZOCIALIS)
        );

        List<SkillDefinitionEntity> mysticalSkills = List.of(
                new SkillDefinitionEntity("Démonológia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Drágakőmágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Magasmágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Nekromancia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Pszi", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Pszi (Kyr)", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Anyagmágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Tapasztalati mágia()", VERY_HARD, INTELLIGENCE, MAGIKUS),
                new SkillDefinitionEntity("Természeti mágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Időmágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Elemi mágia (tűz)", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Lélekmágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Térmágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Metamágia", VERY_HARD, ASTRAL, MAGIKUS),
                new SkillDefinitionEntity("Mágiaismeret", VERY_HARD, INTELLIGENCE, MAGIKUS),
                new SkillDefinitionEntity("Jelmágia", VERY_HARD, ASTRAL, MAGIKUS)
        );

        List<SkillDefinitionEntity> allSkills = Stream.of(
                combatSkills,
                underworldSkills,
                civilSkills,
                scientificSkills,
                socialSkills,
                mysticalSkills
        ).flatMap(Collection::stream).toList();
        return allSkills;
    }

    private static PlayerEntity getPlayer(String name) {
        PlayerEntity player = new PlayerEntity(
                name,
                Race.HUMAN
        );

        player.setAttributes(List.of(
                new AttributeEntity(STRENGTH, 12),
                new AttributeEntity(DEXTERITY, 12),
                new AttributeEntity(SPEED, 12),
                new AttributeEntity(STAMINA, 12),
                new AttributeEntity(HEALTH, 12),
                new AttributeEntity(CHARISMA, 12),
                new AttributeEntity(INTELLIGENCE, 12),
                new AttributeEntity(WILLPOWER, 12),
                new AttributeEntity(ASTRAL, 12),
                new AttributeEntity(PERCEPTION, 12)
        ));

        player.setSkills(List.of(
                new LevelSkillEntity("Gem polishing", player.getAttribute(DEXTERITY), player, Difficulty.NORMAL, 15 ),
                new LevelSkillEntity("Reading/writing", player.getAttribute(INTELLIGENCE), player, Difficulty.NORMAL, 17),
                new LevelSkillEntity("Ekesszolas", player.getAttribute(CHARISMA), player, Difficulty.NORMAL, 10),
                new PercentSkillEntity("Maszas", player.getAttribute(DEXTERITY), player, 5)
        ));

        return player;
    }
}
