package com.example.Microservice.Upload.Api.Controller;

import com.example.Microservice.Upload.Api.Model.Imagen;
import com.example.Microservice.Upload.Api.Service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/imagenes")
public class ImageController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping("/status")
    public ResponseEntity<String> verificarServidor(){
        return new ResponseEntity<>("Servido funcionando", HttpStatus.OK);
    }

    @PostMapping("/subir")
    public ResponseEntity<String> subirImagen(@RequestPart("archivo") MultipartFile archivo){
        if (archivo.isEmpty()) {
            return new ResponseEntity<>("Archivo no presente", HttpStatus.BAD_REQUEST);
        }

        try{
            Imagen imagen = imagenService.guardarImagen(archivo);
            return  new ResponseEntity<>("Imagen subida con exito: " + archivo.getOriginalFilename(), HttpStatus.OK);
        }catch (IOException e){
            return new ResponseEntity<>("Error al subir la imagen", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/testUpload")
    public ResponseEntity<String> testUpload(@RequestParam("archivo") MultipartFile archivo) {
        if (archivo.isEmpty()) {
            return new ResponseEntity<>("Archivo no presente", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Archivo recibido: " + archivo.getOriginalFilename(), HttpStatus.OK);
    }
}
