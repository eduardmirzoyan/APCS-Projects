import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;;

public class Main {

	public static void main(String[] args) {
		while (true) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "java");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {

				// System.out.println("You chose to open this file: " +
				// chooser.getSelectedFile().getName());

				try {
					ArrayList<String> fileData = FileIO.readFile(chooser.getSelectedFile().getAbsolutePath());
					
					FileIO.writeFile("Outputs\\test.txt", fileData);	
					
//					for (String s : fileData) {
//						System.out.println(s);
//					}
					
					System.out.println("Complete");
					return;
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Something unexpected occured, try again");
				}

				// Increase user friendliness - reprompt on exception
				// Squeeze lab goal: switch spaces to numbers
				// Write out the data to a file
			}
			if (returnVal == JFileChooser.CANCEL_OPTION) {
				return;
			}
			if (returnVal == JFileChooser.ERROR_OPTION) {
				return;
			}
		}
	}
}
