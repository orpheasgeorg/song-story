package org.orpheus.songstory.service.async;

import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncAiService {

    @Async
    public CompletableFuture<String> asyncStoryBuild(GeniusSearchResult request) {
    }
}
