package org.orpheus.songstory.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.orpheus.songstory.service.async.AsyncAiService;
import org.orpheus.songstory.service.async.AsyncGeniusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v2/songs")
@RequiredArgsConstructor
public class AsyncSongController {

    private AsyncGeniusService asyncGeniusService;
    private AsyncAiService asyncAiService;

    public CompletableFuture<List<GeniusSearchResult>> searchSongs(@RequestBody SongRequest request) {
        return asyncGeniusService.asyncSearch(request);
    }

    @PostMapping("/story")
    public CompletableFuture<String> storyBuild(@RequestBody GeniusSearchResult request) {
        return asyncAiService.asyncStoryBuild(request);
    }


}
