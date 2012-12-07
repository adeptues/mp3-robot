package old;

import javax.swing.JOptionPane;


/**
 * This class provides static methods that enable data entry in a variety of
 * formats. For example the <i>getInt</i> method displays a dialog box that 
 * prompts the user to type in an integer. The user will not be able to close
 * the dialog until a valid integer is entered. The entered integer is returned
 * to the calling program. Similar methods are available for other data types.
 * 
 * @author Gordon Branson (from work done by Kevan Buckley)
 * @version 1.0, January 2009 
 */

public class GraphicalInputPrompt {

	/**
	 *  This class need not (cannot!) be constructed. All its functionality is
	 *  provided through static methods.
	 */

	private GraphicalInputPrompt() {
	}

	/**
	 * Displays the specified dialog and waits for user to type in an integer
	 * and press the <b>OK</b> button. If the text typed cannot be converted to an 
	 * integer or if the user presses the cancel button, the dialog is 
	 * redisplayed and the user must enter text again.
	 * 
	 * @param prompt Text to be displayed in the dialog..
	 * @return The integer the user typed.
	 */

	public static int getInt(String prompt) {
		while(true) {
			try {
				String readLine = JOptionPane.showInputDialog(prompt);
				return Integer.parseInt(readLine);
			} catch(Exception e) {      
			}
		}
	}

	/**
	 * Displays the specified dialog and waits for user to type in a double
	 * and press the <b>OK</b> button. If the text typed cannot be converted to a 
	 * double or if the user presses the cancel button, the dialog is 
	 * redisplayed and the user must enter text again.
	 * 
	 * @param prompt Text to be displayed in the dialog.
	 * @return The double the user typed.
	 */

	public static double getDouble(String prompt) {
		while(true) {
			try {
				String readLine = JOptionPane.showInputDialog(prompt);
				return Double.parseDouble(readLine);
			} catch(Exception e) {      
			}
		}
	}

	/**
	 * Displays the specified dialog and waits for user to select
	 * <b>Yes</b> (for <i>true</i>) or <b>No</b> (for <i>false</i>)
	 * 
	 * @param prompt Text to be displayed in the dialog.
	 * @return The Boolean the user typed.
	 */

	public static boolean getBoolean(String prompt) {
		int option = JOptionPane.showConfirmDialog(null, prompt, "Select option", JOptionPane.YES_NO_OPTION);
				return (option == JOptionPane.YES_OPTION);
	}

	/**
	 * Displays the specified dialog and waits for user to type in some text and
	 * press a button.
	 * 
	 * @param prompt Text to be displayed in the dialog..
	 * @return If the user pressed <b>OK</b> it returns the text the user typed. 
	 * If the user presses <b>Cancel</b> <i>null</i> is returned.
	 */

	public static String getString(String prompt) {
			String readLine = JOptionPane.showInputDialog(prompt);
			return readLine;
	}
	/**
	 * Displays a simple message dialog and waits for the 
	 * user to press the <b>OK</b> button.
	 */
	public static void pause() {
		JOptionPane.showMessageDialog(null, "Press OK to continue.");

	}

}


