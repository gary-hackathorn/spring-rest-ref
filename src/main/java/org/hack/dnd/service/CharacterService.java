package org.hack.dnd.service;

import org.hack.dnd.model.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {
    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        characters.add(new Character("Viari", 17, 12, 16));
        characters.add(new Character("Binwin", 18, 10, 17));
        return characters;
    }
}
