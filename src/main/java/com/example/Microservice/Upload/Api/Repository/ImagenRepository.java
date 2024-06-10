package com.example.Microservice.Upload.Api.Repository;

import com.example.Microservice.Upload.Api.Model.Imagen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends MongoRepository<Imagen, String> {
}
