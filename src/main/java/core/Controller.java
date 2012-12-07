/**
 * 
 */
package core;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.cmc.music.common.ID3ReadException;

import views.ViewList;

/**
 * @author adeptues
 *
 */
public class Controller {
	private Model model;
	private ViewList view;
	
	
	public Controller(Model model){
		this.model = model;
		this.view = new ViewList(model,this);
		view.setVisible(true);
	}
	
	/**
	 * adds bunch of songs to the application model in a default playlist called music. The path variable si the
	 * directory or folder of the songs.
	 * @param path
	 */
	public void addSongs(String path){
		File file = new File(path);
		if(file.isDirectory()){
			Collection<File> files = FileUtils.listFiles(
					  file, 
					  new RegexFileFilter(".+\\.mp3"), 
					  DirectoryFileFilter.DIRECTORY
					);
			try {
				Playlist playlist = ID3Parser.parseID3Tags((List<File>)files);
				model.addPlaylist(playlist);
			} catch (ID3ReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("file not directory");
		}
		
	}
	

}
