import java.text.NumberFormat;
import javax.swing.JOptionPane;

/*
 * a. 4
 * b. 4
 * c. 4
 * d. ?
 */

public class IRS {

	public static void main(String[] args) {
		String[] options = new String[]  {"Single", "Married"};
		NumberFormat f = NumberFormat.getCurrencyInstance();
		int status = JOptionPane.showOptionDialog(null, "What is your martial status?", "IRS Tax Calculator",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
		int income = Integer.parseInt(JOptionPane.showInputDialog("What is your income?"));
		TaxForm tax = new TaxForm(status + 1 ,income);
		System.out.println(tax.calcFedTax());
		JOptionPane.showMessageDialog(null,"Your ferderal income tax is: " + f.format(tax.calcFedTax()));
	}
}
