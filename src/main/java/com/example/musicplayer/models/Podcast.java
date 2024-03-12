package com.example.musicplayer.models;

public class Podcast implements Media {
    private String name;

    public Podcast(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.out.println("Playing podcast: " + name);
    }
}
