package com.example.microserviciostutoriales.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TutorialDTO {

    private String ID;
    private String titulo;
    private String descripcion;
    private Boolean publicado;

}
