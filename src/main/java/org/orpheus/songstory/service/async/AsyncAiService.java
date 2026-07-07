package org.orpheus.songstory.service.async;

import lombok.RequiredArgsConstructor;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.service.classic.AiService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncAiService {

    private final AiService aiService;

    @Async
    public CompletableFuture<String> asyncStoryBuild(GeniusSearchResult request) {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String results = aiService.storyBuild(request);
        return CompletableFuture.completedFuture(results);
    }
}
