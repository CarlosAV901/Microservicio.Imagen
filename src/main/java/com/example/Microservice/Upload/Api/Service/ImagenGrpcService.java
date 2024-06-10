package com.example.Microservice.Upload.Api.Service;


import com.example.Microservice.Upload.Api.Model.Imagen;
import com.example.Microservice.Upload.Api.Repository.ImagenRepository;
import com.example.grpc.server.imagen.ImagenRequest;
import com.example.grpc.server.imagen.ImagenResponse;
import com.example.grpc.server.imagen.ImagenServiceGrpcGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@GrpcService
public class ImagenGrpcService extends ImagenServiceGrpcGrpc.ImagenServiceGrpcImplBase {

    @Autowired
    private ImagenRepository imagenRepository;

    @Override
    public void subirImagen(ImagenRequest request, StreamObserver<ImagenResponse> responseObserver){
        try {
            Imagen imagen = new Imagen();
            imagen.setDatos(request.getData().toByteArray());
            imagen.setAutorGuid(request.getGuid());

            imagenRepository.save(imagen);

            ImagenResponse response = ImagenResponse.newBuilder()
                    .setMensaje("Imagen insertada correctamente")
                    .setAutorGuid(imagen.getAutorGuid())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch (Exception e){
            String errorMessage = "Error al insertar la imagen: " + e.getMessage();
            responseObserver.onError(Status.INTERNAL.withDescription(errorMessage).asException());
        }
    }

}
