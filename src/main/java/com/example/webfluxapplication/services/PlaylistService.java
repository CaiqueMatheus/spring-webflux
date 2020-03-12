package com.example.webfluxapplication.services;

import com.example.webfluxapplication.Playlist;
import com.example.webfluxapplication.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Mono<Playlist> update(String id, String name) {
        return this.playlistRepository
                .findById(id)
                .map(playlist -> new Playlist(playlist.getId(), name))
                .flatMap(this.playlistRepository::save);
    }

    public Mono<Void> delete(String id) {
        return playlistRepository.deleteById(id);
    }
}
