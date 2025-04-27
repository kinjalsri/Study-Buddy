package main.models;

public class Music {
    public boolean isPlaying;

    public void play() {
        isPlaying = true;
        System.out.println("🎵 Playing music...");
    }

    public void stop() {
        isPlaying = false;
        System.out.println("⏹ Music Stopped.");
    }
}