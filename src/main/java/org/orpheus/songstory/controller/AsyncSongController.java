package org.orpheus.songstory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.orpheus.songstory.service.async.AsyncAiService;
import org.orpheus.songstory.service.async.AsyncGeniusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/v2/songs")
@RequiredArgsConstructor
public class AsyncSongController {

    private final AsyncGeniusService asyncGeniusService;
    private final AsyncAiService asyncAiService;

    @PostMapping("/search")
    public CompletableFuture<List<GeniusSearchResult>> searchSongs(@RequestBody SongRequest request) throws InterruptedException {
        log.info(Thread.currentThread().getName());
        return asyncGeniusService.asyncSearch(request);
    }

    @PostMapping("/story")
    public CompletableFuture<String> storyBuild(@RequestBody GeniusSearchResult request) throws InterruptedException {
        return asyncAiService.asyncStoryBuild(request);
    }


}
