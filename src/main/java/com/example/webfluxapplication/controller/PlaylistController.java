package com.example.webfluxapplication.controller;

import com.example.webfluxapplication.Playlist;
import com.example.webfluxapplication.repositories.PlaylistRepository;
import com.example.webfluxapplication.services.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaylistController {

    private static final String PLAYLIST = "/playlist";


    private PlaylistService playlistRepository;

    private final MediaType mediaType = MediaType.APPLICATION_JSON;

    @PostMapping(PLAYLIST + "/new-playlist")
    public Mono<Playlist> save(@RequestBody Playlist playlist){
        return playlistRepository.save(playlist);
    }

    @GetMapping(PLAYLIST)
    public Flux<Playlist> findAll(){
        return playlistRepository.findAll();
    }

    @GetMapping(PLAYLIST + "/{id}")
    public Mono<Playlist> findById(@PathVariable String id){
        return playlistRepository.findById(id);
    }

    @PutMapping(PLAYLIST + "/update/{id}")
    public Publisher<ResponseEntity<Playlist>> updateById(@PathVariable String id, @RequestBody Playlist playlist) {
        return Mono
                .just(playlist)
                .flatMap(p -> this.playlistRepository.update(id, p.getName()))
                .map(p -> ResponseEntity
                        .ok()
                        .contentType(this.mediaType)
                        .build());
    }

    @DeleteMapping(PLAYLIST + "/delete/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return this.playlistRepository.delete(id);
    }
}
