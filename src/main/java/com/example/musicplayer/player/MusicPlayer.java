package com.example.musicplayer.player;

import com.example.musicplayer.models.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MusicPlayer {
    private static final Logger logger = LoggerFactory.getLogger(MusicPlayer.class);

    private Media media;
    private int volume;

    public MusicPlayer(Media media) {
        this.media = media;
    }

    public void playMedia(Media media) {
        if (media != null) {
            media.play();
        } else {
            logger.warn("No media provided to play.");
        }
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @PostConstruct
    public void init() {
        logger.info("MusicPlayer is ready to play.");
    }

    @PreDestroy
    public void destroy() {
        logger.info("MusicPlayer is shutting down.");
    }
}
