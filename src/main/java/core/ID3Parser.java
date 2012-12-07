/**
 * 
 */
package core;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.cmc.music.common.ID3ReadException;
import org.cmc.music.metadata.MusicMetadata;
import org.cmc.music.metadata.MusicMetadataSet;
import org.cmc.music.myid3.MyID3;

/**
 * parses ID3 metadata tags from mp3 files using myid3
 * @author adeptues
 *
 */
public class ID3Parser {
	
	/**
	 * returns a playlist containing the songs and metadata of a directory
	 * @return
	 * @throws IOException 
	 * @throws ID3ReadException 
	 */
	public static Playlist parseID3Tags(List<File> files) throws ID3ReadException, IOException{
		//album art not implemented
		Playlist playlist = new Playlist();
		playlist.setName("Music");
		for(int i = 0; i < files.size(); i++){
			Song song = new Song();
			MusicMetadataSet srcInfo = new MyID3().read(files.get(i));
			MusicMetadata metaData = (MusicMetadata) srcInfo.getSimplified();
			
			try{
				song.setArtist(metaData.getArtist());
			}catch(NullPointerException npe){
				song.setArtist("Unknown");
			}
			
			
			try{
				song.setTitle(metaData.getSongTitle());
			}catch(NullPointerException npe){
				song.setTitle("Unknown");
			}
			
			try{
				song.setAlbum(metaData.getAlbum());
			}catch(NullPointerException npe){
				song.setAlbum("unknown");
			}
			
			
			
			try{
				song.setGenre(metaData.getGenreName());
			}catch(NullPointerException npe){
				song.setGenre("Unknown");
			}
			
			
			try{
				song.setLength(metaData.getDurationSeconds().intValue());
			}catch(NullPointerException npe){
				song.setLength(0);
			}
			
			song.setPath(files.get(i).getAbsolutePath());
			
			playlist.addSong(song);
		}
		return playlist;
	}

}
