package com.example.microserviciostutoriales.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document( collection = "Tutorial")
public class TutorialVO {

    @Id
    private String ID;
    private String titulo;
    private String descripcion;
    private Boolean publicado;
}