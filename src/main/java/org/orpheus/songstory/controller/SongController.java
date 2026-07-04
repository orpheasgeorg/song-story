package org.orpheus.songstory.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.orpheus.songstory.service.AiService;
import org.orpheus.songstory.service.GeniusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void storyBuild(@RequestBody GeniusSearchResult request) {
        System.out.println(request.toString());
         aiService.storyBuild(request);
    }

}