package main.services;

import main.models.Music;
import main.models.LofiMusic;
// import main.models.YoutubeMusic; // Temporarily not used

public class MusicService {
    private Music currentMusic;

    public void playLoFi() {
        currentMusic = new LofiMusic();
        currentMusic.play();
    }

    /*
     * // Commented out YouTube logic for now
     * public void playYouTube(String link) {
     * currentMusic = new YoutubeMusic(link);
     * currentMusic.play();
     * }
     */

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

    // Added helper method for play/pause toggle
    public boolean isCurrentlyPlaying() {
        return currentMusic != null && currentMusic.isPlaying;
    }

    // Optional: Rewind function
    public void rewind() {
        if (currentMusic != null) {
            stopMusic();
            playLoFi(); // Restart the Lo-Fi track
            System.out.println("🔁 Rewound and restarted music.");
        }
    }
}
