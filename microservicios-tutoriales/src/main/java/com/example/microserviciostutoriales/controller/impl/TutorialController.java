package com.example.microserviciostutoriales.controller.impl;

import com.example.microserviciostutoriales.controller.TutorialApi;
import com.example.microserviciostutoriales.model.TutorialVO;
import com.example.microserviciostutoriales.model.dto.TutorialDTO;
import com.example.microserviciostutoriales.repository.TutorialRepository;
import com.example.microserviciostutoriales.service.impl.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorialController implements TutorialApi {

    @Autowired
    private TutorialService tutorialService;

    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public ResponseEntity<List<TutorialDTO>> getAlLTutorials() {
        return ResponseEntity.ok(tutorialService.getAllTutorials());
    }

    @Override
    public ResponseEntity<Optional<TutorialDTO>> getTutorialById(String id) {
        Optional<TutorialVO> dataVO = tutorialRepository.findById(id);
        return new ResponseEntity(dataVO.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TutorialDTO>> findyByPublished() {
        return ResponseEntity.ok(tutorialService.findyByPublished());
    }

    @Override
    public ResponseEntity<List<TutorialDTO>> findByTitleContaining(String titulo) {
        return ResponseEntity.ok(tutorialService.findByTitleContaining(titulo));
    }

    @Override
    public ResponseEntity<TutorialDTO> save(TutorialDTO tutorialDTO) {
        return new ResponseEntity<>(tutorialService.save(tutorialDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TutorialDTO> updateTutorial(String id, TutorialDTO tutorialDTO) {
        return new ResponseEntity<>(tutorialService.updateTutorial(id, tutorialDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity< Boolean > deleteTutorial(String id) {
        return tutorialService.deleteTutorial(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> deleteAllTutorials() {
        return tutorialService.deleteAllTutorials()
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
