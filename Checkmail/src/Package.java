
public class Package {

	private double dim1, dim2, dim3;
	private double weight;
	
	public Package() {
		dim1 = 0;
		dim2 = 0;
		dim3 = 0;
		weight = 0;
	}
	
	public Package(double d1, double d2, double d3, double w) {
		dim1 = d1;
		dim2 = d2;
		dim3 = d3;
		weight = w;
	}
	
	public String checkPackage() {
		double L;
		boolean large;
		if(dim1 > dim2) {
			if(dim1 > dim3) {
				L = dim1;
			}
			else {
				L = dim2;
			}
		}
		else {
			if(dim2 > dim3) {
				L = dim2;
			}
			else {
				L = dim3;
			}
		}
		
		if(L + 2 * (dim1 + dim2 + dim3) - 2 * L > 100) {
			large = true;
		}
		else {
			large = false;
		}
		
		if(weight > 70) {
			if(large) {
				return "This package is too large and too heavy";
			}
			else {
				return "This package is too heavy";
			}
		}
		else {
			if(large) {
				return "This package is too large";
			}
			else {
				return "This package is acceptable";
			}
		}
	}
}
