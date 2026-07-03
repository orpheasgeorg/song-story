package org.orpheus.songstory.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeniusSearchResult {
    private String title;
    private String artist;
    private String url;
    private String releaseDate;
    private String thumbnailUrl;
}