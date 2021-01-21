package com.example.microserviciostutoriales.service.impl;
import com.example.microserviciostutoriales.model.dto.TutorialDTO;
import java.util.List;


public interface TutorialService {

    List<TutorialDTO> getAllTutorials();
    List<TutorialDTO> findyByPublished();
    List<TutorialDTO> findByTitleContaining(final String titulo);
    TutorialDTO save(final TutorialDTO tutorial);
    TutorialDTO updateTutorial(String id, final TutorialDTO tutorial);
    boolean deleteTutorial(final String id);
    boolean deleteAllTutorials();
}
