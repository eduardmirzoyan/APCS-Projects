import java.text.DecimalFormat;

public class Statistics {

	private int[] data;
	private int realLength;
	
	public Statistics() {
		data = new int[1000];
		realLength = 0;
	}
	
	public Statistics(int rl) {
		data = new int[1000];
		realLength = rl;
	}
	
	public double average() {
		double average = 0;
		for(int i = 0; i < realLength; i++) {
			average += data[i];
		}
		return round(average /= realLength);
	}
	
//	public double standardDiviation() {
//		double SD = 0;
//		for(int i = 0; i < realLength; i++) {
//			SD += Math.pow(Math.abs(average() - data[i]), 2);
//		}
//		
//		return round(SD = Math.sqrt(SD / (realLength - 1)));
//	}
	
	public int mode() {
	    int mode = data[0];
	    int max = 0;
	    for (int i = 0; i < realLength; i++) {
	        int value = data[i];
	        int count = 1;
	        for (int j = 0; j < realLength; j++) {
	            if (data[j] == value) 
	            	count++;
	            if (count > max) {
	                mode = value;
	                max = count;
	            }
	        }
	    }
	    return mode;
	}

	public double round(double d) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(d));
	}
	
	public void insert(int val, int i) {
		for(int count = realLength; count > i; count--) {
			data[count] = data[count - 1];
		}
		data[i] = val;
		realLength++;
	}
	
	public void delete(int i) {
		for(int count = i; count < realLength; count++) {
			data[count] = data[count + 1];
		}
		realLength--;
	}
	
	public int compact(int value) {
		int max = 0;
		for (int i = 0; i < realLength;) {
			if(data[i] == value) {
				delete(i);
			}
			else {
				max++;
				i++;
			}
		 }

		return max;
	}
	
	public void printData() {
		for(int count = 0; count < realLength; count++) {
			System.out.print(data[count] + ", ");
		}
		System.out.println();
	}
	
	public int[] getData() {
		return data;
	}
	
	public int getRealLength() {
		return realLength;
	}
	
	public void setRealLength(int rl) {
		realLength = rl;
	}
	
	public static void main(String[] args) {
		ArrayReader reader = new ArrayReader("Data/numbers2.txt");
		Statistics stats = new Statistics();
		stats.setRealLength(reader.fillArray(stats.getData()));
		stats.printData();
		System.out.println("There are " + stats.compact(0) + " real data values.");
		stats.printData();
		System.out.println(stats.average());
		//System.out.println(stats.standardDiviation());
		System.out.println(stats.mode());
	}
}
