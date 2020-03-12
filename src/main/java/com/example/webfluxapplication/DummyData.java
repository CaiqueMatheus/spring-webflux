package com.example.webfluxapplication;

//import com.example.webfluxapplication.repositories.PlaylistRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//
//import java.util.UUID;
//
//@Component
//public class DummyData implements CommandLineRunner {
//
//    private final PlaylistRepository playlistRepository;
//
//    public DummyData(PlaylistRepository playlistRepository) {
//        this.playlistRepository = playlistRepository;
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        playlistRepository.deleteAll()
//                .thenMany(
//                        Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud",
//                                "Java 8", "Github", "Spring Security", "Web Service Restfull", "Bean no Spring Framework")
//                        .map(name -> new com.example.webfluxapplication.Playlist(UUID.randomUUID().toString(), name))
//                        .flatMap(playlistRepository::save))
//                .subscribe(System.out::println);
//    }
//}
