package org.orpheus.songstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class  SongStoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongStoryApplication.class, args);
    }

}
