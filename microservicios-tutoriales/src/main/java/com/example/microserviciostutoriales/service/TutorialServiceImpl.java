package com.example.microserviciostutoriales.service;

import com.example.microserviciostutoriales.model.TutorialVO;
import com.example.microserviciostutoriales.model.dto.TutorialDTO;
import com.example.microserviciostutoriales.repository.TutorialRepository;
import com.example.microserviciostutoriales.service.converter.TutorialConverterToDTO;
import com.example.microserviciostutoriales.service.converter.TutorialConverterToVO;
import com.example.microserviciostutoriales.service.impl.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private TutorialConverterToDTO tutorialConverterToDTO;

    @Autowired
    private TutorialConverterToVO tutorialConverterToVO;

    @Override
    public List<TutorialDTO> getAllTutorials() {
        return tutorialRepository.findAll()
                .stream()
                .map(tutorialConverterToDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TutorialDTO> findyByPublished(){
        return tutorialRepository.findAll()
                .stream()
                .map(tutorialConverterToDTO::convert)
                .filter(tutorialDTO -> tutorialDTO.getPublicado()==true)
                .collect(Collectors.toList());

    }

    @Override
    public List<TutorialDTO> findByTitleContaining(String titulo) {
        return tutorialRepository.findAll()
                .stream()
                .map(tutorialConverterToDTO::convert)
                .filter(tutorialDTO -> tutorialDTO.getTitulo().contains(titulo))
                .collect(Collectors.toList());
    }

    @Override
    public TutorialDTO save(TutorialDTO tutorial) {
        TutorialVO tutorialVO = tutorialConverterToVO.convert(tutorial);
        return tutorialConverterToDTO.convert(tutorialRepository.insert(tutorialVO));
    }

    @Override
    public TutorialDTO updateTutorial(String id, TutorialDTO tutorialDTO) {
        Optional<TutorialVO> opTutorialVO = tutorialRepository.findById(id);
        TutorialVO tutorialVO = opTutorialVO.get();
        tutorialVO.setTitulo(tutorialDTO.getTitulo());
        tutorialVO.setDescripcion(tutorialDTO.getDescripcion());
        tutorialVO.setPublicado(tutorialDTO.getPublicado());
        return tutorialConverterToDTO.convert(tutorialRepository.save(tutorialVO));
    }

    @Override
    public boolean deleteTutorial(String id) {
        try{
            tutorialRepository.deleteById(id);
            return Boolean.TRUE;
        } catch(Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean deleteAllTutorials() {
        try{
            tutorialRepository.deleteAll();
            return Boolean.TRUE;
        } catch(Exception e) {
            return Boolean.FALSE;
        }
    }
}
