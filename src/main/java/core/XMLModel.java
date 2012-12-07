/**
 * 
 */
package core;

import java.util.LinkedList;
import java.util.List;

/**
 * @author adeptues
 *
 */
public class XMLModel implements Model{
	
	private LinkedList<Playlist> playlists;
	
	public XMLModel(){
		playlists = new LinkedList<Playlist>();
	}

	public boolean storePlayList(Playlist playList) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Playlist> getAllPlayLists() {
		
		return playlists;
	}

	public void addPlayListAtIndex(int index, Playlist list) {
		// TODO Auto-generated method stub
		
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

	public boolean addPlaylist(Playlist playlist) {
		if(playlist != null){
			this.playlists.add(playlist);
			return true;
		}
		
		return false;
	}

	public Playlist getPlayList(int index) {
		if(index >= 0 && index <= playlists.size()){
			return playlists.get(index);
		}
		return null;
	}

	public Playlist[] getAll() {
		
		return (Playlist[]) playlists.toArray();
	}

	public boolean deletePlayList(int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
