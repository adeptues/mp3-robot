/**
 * 
 */
package core;

import java.util.LinkedList;

/**
 * @author adeptues
 *
 */
public class Playlist {
	private String name;
	private LinkedList<Song> playList;
	
	public Playlist(LinkedList<Song> playList){
		name = "New PlayList";
		this.playList = playList;
	}
	
	public Playlist(){
		name = "New PlayList";
		playList = new LinkedList<Song>();
	}
	/*
	public PlayList(String name){
		this.name = name;
		playList = new LinkedList<Song>();
	}
	*/
	public void setName(String name){
		this.name = name;
	}
	
	public int numberOfSongs(){
		return playList.size();
	}
	

	
	
	public boolean addSong(Song song){
		boolean check = playList.add(song);
		return check;
	}
	
	public Song getSong(int index){
		if((index < playList.size()) && (index >= 0)){
			return playList.get(index);
		}
		return null;
	}
	
	public LinkedList<Song> songList(){
		return playList;
	}
	
	public void setSongs(LinkedList<Song> songs){
		playList = songs;
	}
	
	public Song [] getSongs(){
		Song [] songs = new Song[playList.size()];
		playList.toArray(songs);
		return songs;
	}
	
	public boolean removeSong(int index){
		if((index < playList.size()) && (index >= 0)){
			playList.remove(index);
			return true;
		}
		return false;
	}
	
	public String toString(){
		return name;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Playlist){
			Playlist list = (Playlist) obj;
			if(list.toString().equalsIgnoreCase(name)){
				Song songA [] = list.getSongs();
				Object songB [] = playList.toArray();
				if(songA.length == songB.length){
					for(int i = 0; i < songA.length;i++){
						Song song = (Song) songB[i];
						boolean check = songA[i].equals(song);
						if(!check){
							return false;
						}
					}
					return true;
				}
				return false;
				
			}
			return false;
					
		}
		return false;
	}

}
