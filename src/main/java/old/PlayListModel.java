package old;

import java.util.LinkedList;

import javax.rmi.CORBA.Util;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class PlayListModel{
	private LinkedList<PlayList> playLists;
	private ObjectContainer dataBase;
	private boolean DBAccessable;
	//Controller unnamed_Controller_;
	
	public PlayListModel(){
		DBAccessable = false;
		playLists = new LinkedList<PlayList>();
		//openDB();
	}
	
	public boolean closeDB(){
		DBAccessable = false;
		return dataBase.close();
	}
	
	public void openDB(){
		DBAccessable = true;
		dataBase = Db4o.openFile("databaseV3");//TODO change this to something thats not out of date
	}
	
	public boolean storePlayList(PlayList playList){
		//openDB();
		if(playList != null){
			dataBase.store(playList);
			closeDB();
			return true;
		}
		//closeDB();
		return false;
	}
	
	public ObjectSet getAllPlayLists(){
		if(!DBAccessable){
			openDB();
		}else{
			//closeDB()
		}
		


		PlayList proto = new PlayList();
		proto.setName(null);
		ObjectSet result = dataBase.queryByExample(proto);
		//closeDB();
		return result;
	}
	
	public void addPlayListAtIndex(int index,PlayList list){
		
		playLists.remove(index);
		playLists.add(index, list);
	}
	
	public void save(){
		ObjectSet result = getAllPlayLists();
		
		while(result.hasNext()){
			PlayList list = (PlayList) result.next();
			dataBase.delete(list);
		}
		
		
		closeDB();
		for(PlayList x: playLists){
			openDB();
			dataBase.store(x);
			closeDB();
		}
		//closeDB();
	}
	
	/**
	 * Adds an existing playList to the model
	 * @param playlist The playList to be added
	 * @return boolean true if success
	 */
	public boolean addPlaylist(PlayList playlist){
		if(playlist != null){
			boolean check = playLists.add(playlist);
			return check;
		}
		
		return false;
	}
	
	/**
	 * gets a playlist containing songs from the model
	 * @param index the index of the play list to get
	 * @return the playlist to get or null
	 */
	public PlayList getPlayList(int index){
		if((index < playLists.size()) && (index >= 0)){
			return playLists.get(index);
		}
		return null;
	}
	
	public PlayList[] getAll(){
		PlayList[] list = new PlayList[playLists.size()];
		playLists.toArray(list);
		
		return list;
	}
	
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
	public boolean deletePlayList(int index){
		boolean check = false;
		if((index < playLists.size()) && (index >= 0)){
			check = true;
			playLists.remove(index);
			return check;
		}
		
		return check;
	}
	

}