package main.models;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LofiMusic extends Music {
    private List<String> loFiPlaylist;
    private int currentSongIndex;
    private Clip clip;
    private final String musicFolderPath = "Playlist Lofi"; // or just "assets/lofi" depending on project root

    public LofiMusic() {
        loFiPlaylist = new ArrayList<>();
        File folder = new File(musicFolderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));

        if (files != null) {
            for (File file : files) {
                loFiPlaylist.add(file.getAbsolutePath());
            }
        }

        if (loFiPlaylist.isEmpty()) {
            System.out.println("⚠️ No .wav files found in " + musicFolderPath);
        }

        currentSongIndex = 0;
    }

    @Override
    public void play() {
        try {
            if (loFiPlaylist.isEmpty())
                return;

            AudioInputStream audioStream = AudioSystem
                    .getAudioInputStream(new File(loFiPlaylist.get(currentSongIndex)));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            isPlaying = true;

            String songName = new File(loFiPlaylist.get(currentSongIndex)).getName().replace(".wav", "");
            System.out.println("🎵 Now Playing: " + songName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
            isPlaying = false;
            System.out.println("⏹ Music Stopped.");
        }
    }

    public void skip() {
        if (isPlaying) {
            stop();
            currentSongIndex = (currentSongIndex + 1) % loFiPlaylist.size();
            play();
        } else {
            System.out.println("❌ Cannot skip, music is not playing.");
        }
    }
}
