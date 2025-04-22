package main.models;

import java.util.List;
import java.util.Arrays;

public class LofiMusic extends Music {
    private List<String> loFiPlaylist;
    private int currentSongIndex;

    public LofiMusic() {
        this.loFiPlaylist = Arrays.asList(
                "Aeris - Crystal Waltz",
                "Aeris - Moving Mountains",
                "Aylex - Eternal Love",
                "Epic Spectrum - Fallen",
                "Pufino - Enlivening");
        this.currentSongIndex = 0;
    }

    @Override
    public void play() {
        isPlaying = true;
        System.out.println("🎵 Now Playing: " + loFiPlaylist.get(currentSongIndex));
    }

    public void skip() {
        if (isPlaying) {
            currentSongIndex = (currentSongIndex + 1) % loFiPlaylist.size();
            System.out.println("⏭ Skipping... Now Playing: " + loFiPlaylist.get(currentSongIndex));
        } else {
            System.out.println("❌ Cannot skip, music is not playing.");
        }
    }
}
