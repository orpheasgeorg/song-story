package org.orpheus.songstory.service.async;

import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncGeniusService {

    @Async
    public CompletableFuture<List<GeniusSearchResult>> asyncSearch(SongRequest request) {
    }
}
