/**
 * 
 */
package old;

import java.util.List;

/**
 * This is the data interface model, responsible for persisteing the playlists in the applications
 * @author adeptues
 *
 */
public interface Model {
	
	
	
	public boolean storePlayList(PlayList playList);
	
	public List<PlayList> getAllPlayLists();
	
	public void addPlayListAtIndex(int index,PlayList list);
	
	public void save();
	
	/**
	 * Adds an existing playList to the model
	 * @param playlist The playList to be added
	 * @return boolean true if success
	 */
	public boolean addPlaylist(PlayList playlist);
	
	/**
	 * gets a playlist containing songs from the model
	 * @param index the index of the play list to get
	 * @return the playlist to get or null
	 */
	public PlayList getPlayList(int index);
	
	public PlayList[] getAll();
	
	/**
	 * This deletes a playlist from the application entirley
	 * and all the songs and their corresponding locations with
	 * the play list
	 * 
	 * ***WARNING***
	 * This will remove all the songs in the play list from the
	 * application permantly
	 * 
	 * @param index 
	 * The index of the play list to be removed
	 * 
	 * @return boolean 
	 */
	public boolean deletePlayList(int index);
	

}
