package old;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;

import javazoom.jl.player.advanced.PlaybackListener;



import org.apache.commons.lang.RandomStringUtils;
import org.cmc.music.common.ID3ReadException;
import org.cmc.music.metadata.ImageData;
import org.cmc.music.metadata.MusicMetadata;
import org.cmc.music.metadata.MusicMetadataSet;
import org.cmc.music.myid3.MyID3;

import com.db4o.ObjectSet;


public class Controller  {
	private PlayListModel model;
	
	private GUIView gui;
	private Thread thread;
	private PlayMP3 mp3Player;
	
	private PlayList playList;// the playlist to be manipulated
	private Song song;
	private Recorder recorder;



	
	public Controller(){
		playList = new PlayList();
		model = new PlayListModel();
		gui = new GUIView(this);
		gui.setVisible(true);
		//place call to gui
		//initailiseData();
		
		
		
		//and db40 storage instance
		//and any other setup operation
	}
	
	public static void main(String[] args){
		Controller contr = new Controller();
		contr.initailiseData();
		
	}
	
	/*
	public void loadData(){
		
	}
	*/
	public boolean addFile(File[] file,int index){
		Song song;
		MusicMetadataSet srcInfo;
		String artist, album, songTitle, genre;
		Number duration;
		Number year;
		try {
			for(int i = 0; i < file.length; i++){
				srcInfo = new MyID3().read(file[i]);
				MusicMetadata metaData = (MusicMetadata) srcInfo.getSimplified();
				artist = metaData.getArtist();
				album = metaData.getAlbum();
				songTitle = metaData.getSongTitle();
				duration  = metaData.getDurationSeconds();
				genre = metaData.getGenreName();
				year = metaData.getYear();//TODO fix song declaration
				File albumFile;
				if((artist != null) || (songTitle != null) || (album != null)){
					Vector<ImageData> pics = metaData.getPictures();
					
					if(!pics.isEmpty()){
						ImageData pic = pics.get(0);
						// convert to useful format
						Toolkit toolKit = Toolkit.getDefaultToolkit();//technically not needed but may be useful
						Image image = toolKit.createImage(pic.imageData, 0, pic.imageData.length);
						
						ByteArrayInputStream bis = new ByteArrayInputStream(pic.imageData);
						BufferedImage bimage = ImageIO.read(bis);//cheating
						String location = "albumArt/"+album+".jpg";
						albumFile = new File(location);
						
						ImageIO.write(bimage, "jpg", albumFile);
						//resize image
						
						//Image resized = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
						
						
						song = new Song(songTitle,artist,file[i],duration,genre,year,album,Controller.generateUniqueId());
						song.setAlbumArt(albumFile);
						this.song = song;
						addSongToPlayList(index);
					}else{
						//get image from site
						song = new Song(songTitle,artist,file[i],duration,genre,year,album,Controller.generateUniqueId());
						/*
						try {
							List<Artist> artists = Artist.findByName(song.getArtist());
						} catch (ServerUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/
						this.song = song;
						
						addSongToPlayList(index);
					}
					
					
					//check if album art already exists
					//if not then fetch art 
				}else{
					System.out.print(songTitle+" by "+artist);
					System.out.println("song not added, Bad song");
				}
				
				
			}
			return true;
			
			
			//System.out.println(song);
			/*
			System.out.println("Artist : "+artist+" Album: "+album+" song Title: "+songTitle+" Length: "+duration+
					" Genre: "+genre+" year: "+year);
					*/
		} catch (ID3ReadException e) {
			System.out.println("Error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static String generateUniqueId() {
	    return RandomStringUtils.randomAlphanumeric(10);
	}
	
	public void startRecord(String fileName){
		try {
			recorder = new Recorder(fileName);
			Thread thread = new Thread(recorder);
			thread.start();
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void stopRecord(boolean trigger){
		recorder.setTrigger(trigger);
	}
	
	public Object[] getAllplayListsFromDB(){//TODO make private maybe
		ObjectSet result = model.getAllPlayLists();
		return  result.toArray();
	}
	
	public void playSong(Song song) throws URISyntaxException{
		
		String filePath = song.getFileLocation().getPath();
		mp3Player = new PlayMP3(filePath, gui);
		thread = new Thread(mp3Player);
		thread.start();
		
		
		/*
		int a = mp3Player.getTime();
		System.out.println(a);
		*/
		
		/*
		boolean shuffle = gui.getShuffle();
		if(shuffle){
			
		}
		*/
		
		
		
		
		//mp3Player = new PlayMP3(filePath);
		
		//mp3Player.play();
		
		System.out.println(filePath);
	}
	/*
	public void pauseSong() throws InterruptedException{
		
		if(thread.isAlive()){
			thread.sleep(2000);
		}
	}
	*/
	
	public void stopPlaying(){
		mp3Player.closeNotify();
		thread.stop();
		
	}
	
	public void closeMP3(){
		mp3Player.close();
	}
	
	public PlayList[] getAllPlayLists(){
		return model.getAll();
	}
	
	private void initailiseData(){

		
		Object [] result = getAllplayListsFromDB();
		
		if(result == null){
			/*
			Song song1 = new Song("Test","test",null,null,"test",2005,"magic");
			Song song2 = new Song("Test","test",null,null,"test",2005,"magic");
			PlayList standard = new PlayList();
			standard.addSong(song1);
			standard.addSong(song2);
			model.addPlaylist(standard);
			*/
		}else{
			for(int i = 0; i < result.length; i++){
				model.addPlaylist((PlayList) result[i]);
			}
		}
		
		
	}
	
	
	public boolean addSongToPlayList(int index){
		
		
		//check = this.playList.addSong(song);
		
		PlayList list = model.getPlayList(index);
		list.addSong(song);
		//boolean check = model.deletePlayList(index);
		model.addPlayListAtIndex(index,list);
		boolean check = true;//FIXME BAD DONT DO THIS
		if(check){
			
			return check;
		}else{
			check = false;
			return check;
		}
		
	}
	
	public void addPlayListAtIndex(int index, PlayList list){
		model.addPlayListAtIndex(index, list);
	}
	
	public boolean newPlayList(){
		PlayList playlist = new PlayList();
		
		boolean check = model.addPlaylist(playlist);
		if(check){
			return check;
		}
		return check;
	}
	
	public void sortArtist(int index){
		ArtistComparator comp = new ArtistComparator();
		PlayList playlist = model.getPlayList(index);
		LinkedList<Song> songs = playlist.songList();
		Collections.sort(songs, comp);
		playlist.setSongs(songs);
		//model.deletePlayList(index);
		model.addPlayListAtIndex(index, playlist);
	}
	
	public void deletePlayList(int index){
		model.deletePlayList(index);
	}
	
	public void saveData(){
		model.save();
		model.closeDB();
	}
	
	
	/*
	public void newPlaylist(){
		PlayList plasd;
		
	}
	*/
	


}