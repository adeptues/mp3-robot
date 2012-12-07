/**
 * 
 */
package core;

/**
 * This class represents a song which can be played
 * @author adeptues
 *
 */
public class Song {
	private String artist;
	private String title;
	private String genre;
	private String album;
	private String albumArtPath;
	private int length;
	private String path;
	//private int year;
	/**
	 * @param artist
	 * @param title
	 * @param genre
	 * @param album
	 * @param albumArtPath
	 * @param length
	 * @param path
	 */
	public Song(String artist, String title, String genre, String album,
			String albumArtPath, int length, String path) {
		this.artist = artist;
		this.title = title;
		this.genre = genre;
		this.album = album;
		this.albumArtPath = albumArtPath;
		this.length = length;
		this.path = path;
	}
	/**
	 * 
	 */
	public Song() {

		this.artist = "Unknown";
		this.title = "Unknown";
		this.genre = "Unknown";
		this.album = "Unknown";
		this.albumArtPath = null;
		this.length = 0;
		this.path = null;
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}
	/**
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	/**
	 * @return the albumArtPath
	 */
	public String getAlbumArtPath() {
		return albumArtPath;
	}
	/**
	 * @param albumArtPath the albumArtPath to set
	 */
	public void setAlbumArtPath(String albumArtPath) {
		this.albumArtPath = albumArtPath;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Song [artist=" + artist + ", title=" + title + ", genre="
				+ genre + ", album=" + album + ", albumArtPath=" + albumArtPath
				+ ", length=" + length + ", path=" + path + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result
				+ ((albumArtPath == null) ? 0 : albumArtPath.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + length;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (albumArtPath == null) {
			if (other.albumArtPath != null)
				return false;
		} else if (!albumArtPath.equals(other.albumArtPath))
			return false;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (length != other.length)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
