package org.hack.dnd.service;

import org.hack.dnd.model.Character;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterServiceTest {

    private CharacterService characterService;

    @BeforeEach
    void setUp() {
        characterService = new CharacterService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void should_instantiate() {
        assertNotNull(characterService);
    }

    @Test
    void should_return_list() {
        List<Character> expected = new ArrayList<>();
        expected.add(new Character("Viari", 17, 12, 16));
        expected.add(new Character("Binwin", 18, 10, 17));
        List<Character>  actual = characterService.getAllCharacters();
        assertEquals(expected, actual);
    }
}