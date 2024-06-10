package com.example.Microservice.Upload.Api;

import com.example.Microservice.Upload.Api.Service.ImagenGrpcService;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

@Configuration
public class GrpcServer {
/*
    private Server server;

    @PostConstruct
    public void start() throws Exception{
        this.server = NettyServerBuilder.forPort(9091)
                .addService(new ImagenGrpcService())
                .build()
                .start();
        System.out.println("Servidor gRPC iniciado, escuchando en " + server.getPort());
    }

    @PreDestroy
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

*/
}
