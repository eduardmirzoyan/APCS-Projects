import javax.swing.JOptionPane;

public class CheckMail {

	public static void main(String[] args) {
		Package mail = new Package(5,70,5,70);
		
		//String in = JOptionPane.showInputDialog("");
		JOptionPane.showMessageDialog(null, mail.checkPackage());
	}
}
