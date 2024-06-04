package com.example.Microservice.Upload.Api.Repository;

import com.example.Microservice.Upload.Api.Model.Imagen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagenRepository extends MongoRepository<Imagen, String> {
}
