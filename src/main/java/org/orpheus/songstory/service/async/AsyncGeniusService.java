package org.orpheus.songstory.service.async;

import lombok.RequiredArgsConstructor;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.orpheus.songstory.service.classic.GeniusService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncGeniusService {

    private final GeniusService geniusService;

    @Async
    public CompletableFuture<List<GeniusSearchResult>> asyncSearch(SongRequest request) throws InterruptedException {

        List<GeniusSearchResult> results = geniusService.search(request);
        return CompletableFuture.completedFuture(results);

    }
}
