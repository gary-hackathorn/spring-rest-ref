package org.hack.dnd.controlers;

import org.hack.dnd.model.Character;
import org.hack.dnd.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharacterControler {

    @Autowired
    CharacterService characterService;

    @GetMapping("/character")
    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> characterList = characterService.getAllCharacters();
        return ResponseEntity.ok(characterList);
    }
}
