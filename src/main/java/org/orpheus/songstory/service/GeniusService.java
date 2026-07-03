package org.orpheus.songstory.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.orpheus.songstory.DTO.SongRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeniusService {

    private final RestTemplate restTemplate;

    @Value("${genius.api.key}")
    private String apiKey;

    public List<GeniusSearchResult> search(SongRequest q){

       // String query = buildSearchUrl(q);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

       // System.out.println(query);

        ResponseEntity<JsonNode> response = restTemplate.exchange(
                "https://api.genius.com/search?q=" + q.getTitle(),
                HttpMethod.GET,
                entity,
                JsonNode.class
        );

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders().getContentType());
        System.out.println(response.getBody());

        JsonNode hits = response.getBody().path("response").path("hits");


        List<GeniusSearchResult> results = new ArrayList<>();

        for (JsonNode hit : hits) {
            JsonNode result = hit.path("result");
            results.add(new GeniusSearchResult(
                    result.path("title").textValue(),
                    result.path("artist_names").textValue(),
                    result.path("url").textValue(),
                    result.path("release_date_for_display").textValue(),
                    result.path("song_art_image_thumbnail_url").textValue()
            ));
        }
        return results;
    }

  /*  private String buildSearchUrl(SongRequest q){
        String query = Stream.of(q.getTitle(), q.getArtist(), q.getAlbum())
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining(" "));

        if (query.isEmpty()) {
            throw new IllegalArgumentException("At least one search criterion is required");
        }

        return query.replace(" ", "%20");
    } */

}
