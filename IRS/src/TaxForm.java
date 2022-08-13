/**
 * 
 * a.	$50,000	Married		__________5619
	b.	$25,000	Single		__________2809.5
	c.	$300,000	Married		__________60579
	d.	$170,000	Single		__________28089.5
	e.	$30,000	Married		__________3409.5
	f.	$500,000	Single		__________150689.5
	g.	$170,000	Married		__________
	h.	$45,000	Single		__________
	i.	$130,000	Married		__________
	j.	$120,000	Single		__________

 * 
 * 
 * 
 * @author Eduard Mirzoyan
 * @version 10/29/2018
 *
 */
public class TaxForm {

	int status;
	double income;
	
	/**
	 * Creates a tax form object setting status to 1 (single) and income to 0
	 */
	public TaxForm() {
		status = 1;
		income = 0;
	}
	
	/**
	 * Creates a tax form object
	 * @param status the martial status of tax form owner
	 * @param income the total income of tax form owner
	 */
	public TaxForm(int status, double income) {
		this.status = status;
		this.income = income;
	}
	
	/**
	 * Calculates federal tax based on martial status and income
	 * @Pre income cannot be less than zero
	 * @return federal tax calculated based on income and martial status
	 */
	public double calcFedTax() {
		if(status == 1) {
			if(income <= 9525) {
				return (0.1)*(income);
			}
			else if(income <= 38700){
				return 952.5 + (0.12)*(income - 9525);
			}
			else if(income <= 82500) {
				return 4453.5 + (0.22)*(income - 38700);
			}
			else if(income <= 157500) {
				return (14089.5 + (0.24)*(income - 82500));
			}
			else if(income <= 200000) {
				return 32089.5 + (0.32)*(income - 157500);
			}
			else if(income <=500000) {
				return 45689.5 + (0.35)*(income - 200000);
			}
			else {
				return 150689.5 + (0.37)*(income - 500000);
			}
		}
		if(status == 2) {
			if(income <= 19050) {
				return (0.1)*(income);
			}
			else if(income <= 77400){
				return 1905 + (0.12)*(income - 19050);
			}
			else if(income <= 165000) {
				return 8907 + (0.22)*(income - 77400);
			}
			else if(income <= 315000) {
				return 28179 + (0.24)*(income - 165000);
			}
			else if(income <= 400000) {
				return 64179 + (0.32)*(income - 315000);
			}
			else if(income <=600000) {
				return 91379 + (0.35)*(income - 400000);
			}
			else {
				return 161.379 + (0.37)*(income - 600000);
			}
		}
		else {
			return 0;
		}
	}
}
