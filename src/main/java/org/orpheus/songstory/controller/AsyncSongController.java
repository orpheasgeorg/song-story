package org.orpheus.songstory.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.orpheus.songstory.service.async.AsyncAiService;
import org.orpheus.songstory.service.async.AsyncGeniusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v2/songs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AsyncSongController {

    private final AsyncGeniusService asyncGeniusService;
    private final AsyncAiService asyncAiService;

    @PostMapping("/search")
    public CompletableFuture<List<GeniusSearchResult>> searchSongs(@RequestBody SongRequest request) {
        return asyncGeniusService.asyncSearch(request);
    }

    @PostMapping("/story")
    public CompletableFuture<String> storyBuild(@RequestBody GeniusSearchResult request) {
        return asyncAiService.asyncStoryBuild(request);
    }


}
