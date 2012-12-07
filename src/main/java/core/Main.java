/**
 * 
 */
package core;

/**
 * @author adeptues
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "/home/adeptues/Music/Tom/Music";
		Model model = new XMLModel();
		Controller controller = new Controller(model);
		//controller.addSongs(path);
		//model.getPlayList(0);

	}

}
