package com.example.musicplayer.config;

import com.example.musicplayer.models.Media;
import com.example.musicplayer.models.Song;
import com.example.musicplayer.models.Podcast;
import com.example.musicplayer.player.MusicPlayer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Value("${media.song.title}")
    private String songTitle;

    @Value("${media.podcast.name}")
    private String podcastName;

    @Bean
    @Primary
    public Media song() {
        return new Song(songTitle);
    }

    @Bean
    public Media podcast() {
        return new Podcast(podcastName);
    }

    @Bean
    public MusicPlayer musicPlayer(Media media) {
        return new MusicPlayer(media);
    }
}
