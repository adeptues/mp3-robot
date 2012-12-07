/**
 * 
 */
package old;

import java.util.Comparator;

/**
 * @author Tom
 *
 */
public class ArtistComparator implements Comparator<Song> {
	
	/**
	 * returns 0 for equal 1 > and -1 for <
	 */
	//@Override
	public int compare(Song s1, Song s2) {
		// TODO Auto-generated method stub
		int num;
		try{
			num = s1.getArtist().compareToIgnoreCase(s2.getArtist());
		}catch(Exception e){
			System.out.println("Exception!");
			num = 0;
		}
		
		
		return num;
	}

}
