package com.example.microserviciostutoriales.controller;

import com.example.microserviciostutoriales.controller.constant.EndPointUris;
import com.example.microserviciostutoriales.model.TutorialVO;
import com.example.microserviciostutoriales.model.dto.TutorialDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(EndPointUris.API + EndPointUris.V1 + EndPointUris.TUTORIALS)
public interface TutorialApi {

    @GetMapping
    ResponseEntity<List <TutorialDTO>> getAlLTutorials();

    @GetMapping(EndPointUris.ID)
    ResponseEntity<Optional<TutorialDTO>> getTutorialById(@PathVariable final String id);

    @GetMapping(EndPointUris.PUBLICADO)
    ResponseEntity<List<TutorialDTO>> findyByPublished();

    @GetMapping(EndPointUris.TITULO)
    ResponseEntity<List<TutorialDTO>> findByTitleContaining(@PathVariable final String titulo);

    @PostMapping
    ResponseEntity<TutorialDTO> save(@RequestBody final TutorialDTO tutorialDTO);

    @PutMapping(EndPointUris.ID)
    ResponseEntity<TutorialDTO> updateTutorial(@PathVariable final String id, @RequestBody final TutorialDTO tutorialTDTO);

    @DeleteMapping(EndPointUris.ID)
    ResponseEntity<Boolean> deleteTutorial(@PathVariable final String id);

    @DeleteMapping
    ResponseEntity<Boolean> deleteAllTutorials();
}
