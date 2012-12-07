package old;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang.RandomStringUtils;

/**
 * This class represents a song or MP3 file and all the textual information
 * associated with the song or mp3 file, as well as the location of the file
 * on the disk so it can be played.
 * 
 * the song class is a subclass of album.
 * @author Tom
 *
 */
public class Song extends Album {
	/**
	 * Represents the Song name or title of the MP3
	 */
	private String songName;
	
	/**
	 * The name of the artist that performed the song
	 */
	private String artist;
	
	/**
	 * the location of the song or MP3 on disk
	 */
	private File fileLocation;
	
	/**
	 * The length of time the song plays for 
	 */
	private Number songLength;
	
	/**
	 * The genre of music the song belongs to
	 */
	private String genre;
	
	/**
	 * The year the song was recorded or the track created in
	 */
	private Number year;
	
	private String uuid;
	
	/**
	 * default constructor creates a song object with known values 
	 * which relate to nothing and for all intensive purposes empty
	 */
	public Song(){
		super("unknown");
		songName = "unknown";
		artist = "unknown";
		fileLocation = new File("defaultFile.txt");
		songLength = 0.0;
		genre = "unknown";
		year = 0;
		uuid = Controller.generateUniqueId();
		
	}
	
	

	/**
	 * @param songName
	 * @param artist
	 * @param fileLocation
	 * @param songLength
	 * @param genre
	 * @param year
	 */
	public Song(String songName, String artist, File fileLocation,
			Number songLength, String genre, Number year,String album,String uuid) {
		super(album);
		this.songName = songName;
		this.artist = artist;
		this.fileLocation = fileLocation;
		this.songLength = songLength;
		this.genre = genre;
		this.year = year;
		this.uuid = uuid;
	}



	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongName() {
		return this.songName;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return this.artist;
	}

	public void setFileLocation(File fileLocation) {
		this.fileLocation = fileLocation;
	}

	public File getFileLocation() {
		return this.fileLocation;
	}

	public void setSongLength(double songLength) {
		this.songLength = songLength;
	}

	public Number getSongLength() {
		return this.songLength;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Number getYear() {
		return this.year;
	}



	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}



	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Track Title: " + songName + ", Artist: " + artist
				+" Album: "+getAlbum()+ ", Length: "
				+ songLength + ", Genre: " + genre + ", Year: " + year;
	}

	
	public boolean equals(Object obj){
		if(obj instanceof Song){
			Song song = (Song) obj;
			if((song.getSongName().equalsIgnoreCase(songName)) && 
					(song.getArtist().equalsIgnoreCase(artist)) && 
					(song.getAlbum().equalsIgnoreCase(getAlbum())) &&
					(song.getGenre().equalsIgnoreCase(genre)) &&
					//(song.getSongLength().intValue() == songLength.intValue()) &&
					(song.getYear().intValue() == year.intValue()) &&
					(song.getFileLocation().equals(fileLocation)) &&
					(song.getAlbumArt().getPath().equalsIgnoreCase(this.getAlbumArt().getPath()))){
				return true;
			}
			return false;
		}
		return false;
	}

	
}