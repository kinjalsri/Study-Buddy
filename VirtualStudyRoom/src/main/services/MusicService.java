package main.services;

import main.models.Music;
import main.models.LofiMusic;
import main.models.YoutubeMusic;

public class MusicService {
    private Music currentMusic;

    public void playLoFi() {
        currentMusic = new LofiMusic();
        currentMusic.play();
    }

    public void playYouTube(String link) {
        currentMusic = new YoutubeMusic(link);
        currentMusic.play();
    }

    public void stopMusic() {
        if (currentMusic != null) {
            currentMusic.stop();
        } else {
            System.out.println("❌ No music is playing.");
        }
    }

    public void skipSong() {
        if (currentMusic instanceof LofiMusic) {
            ((LofiMusic) currentMusic).skip();
        } else {
            System.out.println("❌ Cannot skip YouTube music.");
        }
    }
}
