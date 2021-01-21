package com.example.microserviciostutoriales.repository;

import com.example.microserviciostutoriales.model.TutorialVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends MongoRepository <TutorialVO, String > {
}
