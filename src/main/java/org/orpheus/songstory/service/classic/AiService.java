package org.orpheus.songstory.service.classic;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.orpheus.songstory.DTO.GeniusSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiService {

    private final RestTemplate restTemplate;

    @Value("${grok.api.key}")
    private String apiKey;

    public String storyBuild(GeniusSearchResult request) throws InterruptedException {

        String prompt = "Tell me the story behind the song '"
                + request.getTitle() + "' by "
                + request.getArtist()
                + ", released in " + request.getReleaseDate() + "."
                + " Include information about the inspiration, the recording process, and any interesting facts."
                + "Keep the response concise, maximum 3-4 paragraphs.";;


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();

        body.put("model", "llama-3.3-70b-versatile");

        Map<String, String> message = new HashMap<>();

        message.put("role", "user");
        message.put("content", prompt);

        List<Map<String, String>> messages = List.of(message);

        body.put("messages", messages);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<JsonNode> response = restTemplate.exchange(
                "https://api.groq.com/openai/v1/chat/completions",
                HttpMethod.POST,
                entity,
                JsonNode.class
        );

        String answer = response.getBody()
                .path("choices")
                .get(0)
                .path("message")
                .path("content")
                .asText();

        Thread.sleep(1000L);
        log.info(Thread.currentThread().getName());

        return answer;
    }
}
