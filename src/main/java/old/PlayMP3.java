package old;

/**
 * Simple MP3 demo using the JLayer library.
 * You will need to provide your own MP3 file to play. 
 * 
 * Documentation for JLayer is here: 
 * http://www.javazoom.net/javalayer/docs/docs1.0/index.html
 * 
 * Based on code by Kevin Wayne, Princeton University.
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class PlayMP3 extends PlaybackListener implements Runnable {
	// test client
	/*
	public static void main(String[] args) {
		String filename = "YOUR MP3 FILE";
		PlayMP3 mp3 = new PlayMP3(filename);
		mp3.play();
	}
	*/

	private String filename;
	//modified to use advanced player
	private AdvancedPlayer player;
	
	private GUIView gui;

	// constructor that takes the name of an MP3 file
	public PlayMP3(String filename, GUIView gui) {
		this.gui = gui;
		this.filename = filename;
	}

	public void closeNotify() {
		if (this.player != null) {
			this.player.stop();
		}
	}
	
	public void close(){
		if (this.player != null) {
			this.player.close();
		}
	}
	
	public void setFilePath(String filePath){
		filename = filePath;
	}
	
	/**
	 * code to run when song has started playing
	 */
	public void playbackStarted(PlaybackEvent evt){
		gui.notifyGUI(true);
		System.out.println(evt.getFrame());
	}
	
	/**
	 * Code to be ran when song is finished playing
	 */
	public void playbackFinished(PlaybackEvent evt){
		
		System.out.println(evt.getFrame());
		gui.notifyGUI(false);
		
	}
	
	/**
	 * false is still playing true if finished
	 * @return
	 */
	/*
	public boolean isPlaying(){
		return player.isComplete();
	}
	
	public int getTime(){
		return player.getPosition();
	}
	*/
	// play the MP3 file to the sound card
	public void play() {
		try {
			FileInputStream fis = new FileInputStream(this.filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			this.player = new AdvancedPlayer(bis);
			player.setPlayBackListener(this);
			this.player.play();
		} catch (Exception e) {
			System.out.println("Problem playing file " + this.filename);
			System.out.println(e);
		}

	}

	//@Override
	public void run() {
		play();
		
	}



}