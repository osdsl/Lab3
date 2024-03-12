package com.example.musicplayer;

import com.example.musicplayer.models.Media;
import com.example.musicplayer.models.Song;
import com.example.musicplayer.models.Podcast;
import com.example.musicplayer.player.MusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicplayerApplication {

    @Value("${player.default.volume}")
    private int defaultVolume;

    public static void main(String[] args) {
        SpringApplication.run(MusicplayerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext ctx) {
        return args -> {
            System.out.println("Демонстрация работы музыкального плеера:");

            // Получаем бины song и podcast из контекста
            Song song = ctx.getBean(Song.class);
            Podcast podcast = ctx.getBean(Podcast.class);

            // Выводим информацию о медиа
            System.out.println("Загруженная песня: " + song.getTitle());
            System.out.println("Загруженный подкаст: " + podcast.getName());

            // Получаем и конфигурируем MusicPlayer
            MusicPlayer musicPlayer = ctx.getBean(MusicPlayer.class);
            musicPlayer.setVolume(defaultVolume);

            // Воспроизводим медиа
            System.out.println("Воспроизведение песни:");
            musicPlayer.playMedia(song);

            System.out.println("Воспроизведение подкаста:");
            musicPlayer.playMedia(podcast);
        };
    }
}
