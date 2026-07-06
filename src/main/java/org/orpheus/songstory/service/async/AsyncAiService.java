package org.orpheus.songstory.service.async;

import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.service.classic.AiService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncAiService {

    private AiService aiService;

    @Async
    public CompletableFuture<String> asyncStoryBuild(GeniusSearchResult request) {

        String results = aiService.storyBuild(request);
        return CompletableFuture.completedFuture(results);
    }
}
