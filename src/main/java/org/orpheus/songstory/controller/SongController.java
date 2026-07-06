package org.orpheus.songstory.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.orpheus.songstory.service.AiService;
import org.orpheus.songstory.service.GeniusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* v2-async */

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final GeniusService geniusService;
    private final AiService aiService;

    @PostMapping("/search")
    public List<GeniusSearchResult> searchSongs(@RequestBody SongRequest request) {
        return geniusService.search(request);
    }

    @PostMapping("/story")
    public String storyBuild(@RequestBody GeniusSearchResult request) {
        return aiService.storyBuild(request);
    }

}