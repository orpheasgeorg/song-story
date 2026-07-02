package org.orpheus.songstory.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SongStoryResponse {
    private String title;
    private String artist;
    private String lyrics;
    private String story;
}
