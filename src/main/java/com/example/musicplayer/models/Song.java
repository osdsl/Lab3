package com.example.musicplayer.models;

public class Song implements Media {
    private String title;

    public Song(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public void play() {
        System.out.println("Playing song: " + title);
    }
}
