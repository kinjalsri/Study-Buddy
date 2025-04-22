package main.models;

public class YoutubeMusic extends Music {
    private String youtubeLink;

    public YoutubeMusic(String link) {
        this.youtubeLink = link;
    }

    @Override
    public void play() {
        isPlaying = true;
        System.out.println("🎵 Streaming from YouTube: " + youtubeLink);
    }
}