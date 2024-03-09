package org.kmt.lld.design.patterns.behavorial.state;

import org.kmt.lld.design.patterns.behavorial.state.states.ReadyState;
import org.kmt.lld.design.patterns.behavorial.state.states.State;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {

    private State state;
    private boolean playing = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public MediaPlayer(){
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 0; i < 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void changeState(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if(currentTrack == playlist.size() - 1){
            currentTrack = 0;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if(currentTrack == -1){
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}