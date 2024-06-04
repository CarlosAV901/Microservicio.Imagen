package com.example.Microservice.Upload.Api.Service;

import com.example.Microservice.Upload.Api.Model.Imagen;
import com.example.Microservice.Upload.Api.Repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imageRepository;

    public Imagen guardarImagen(MultipartFile archivo) throws IOException {
        Imagen imagen = new Imagen();
        imagen.setNombre(archivo.getOriginalFilename());
        imagen.setDatos(archivo.getBytes());
        return imageRepository.save(imagen);
    }
}
