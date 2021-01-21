package com.example.microserviciostutoriales.service.converter;

import com.example.microserviciostutoriales.model.TutorialVO;
import com.example.microserviciostutoriales.model.dto.TutorialDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TutorialConverterToVO implements Converter < TutorialDTO, TutorialVO > {

    @Override
    public TutorialVO convert(TutorialDTO tutorialDTO) {
        return TutorialVO.builder()
                .titulo(tutorialDTO.getTitulo())
                .descripcion(tutorialDTO.getDescripcion())
                .publicado(tutorialDTO.getPublicado())
                .ID(tutorialDTO.getID())
                .build();
    }
}
