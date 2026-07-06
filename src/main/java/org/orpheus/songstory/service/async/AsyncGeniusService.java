package org.orpheus.songstory.service.async;

import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.orpheus.songstory.service.classic.GeniusService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncGeniusService {

    private GeniusService geniusService;

    @Async
    public CompletableFuture<List<GeniusSearchResult>> asyncSearch(SongRequest request) {

        List<GeniusSearchResult> results = geniusService.search(request);
        return CompletableFuture.completedFuture(results);

    }
}
