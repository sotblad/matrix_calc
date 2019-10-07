import java.util.Random;
import java.lang.Math;

public class ComplexMatrix {
	
	private Random rand = new Random();
	private String[][] matrixA;
	private String[][] matrix;
	private ComplexMatrix original;
	private double rows;
	private double cols;
	private String Symbol = "+";
	
	private double computeRandom(){
		int randomNum = (int)((rand.nextDouble()-0.5)*rand.nextInt(20)*100);
		return randomNum/100.0;
	}
	
	private String computeRandomSymbol(){
		int randomNum = (int)((rand.nextDouble()-0.5)*rand.nextInt(20)*100);
		if(randomNum>50) {
			Symbol = "+";
		}else {
			Symbol = "-";
		}
		return Symbol;
	}
	
	public ComplexMatrix() {
		
	}
	
	public ComplexMatrix(ComplexMatrix original) {
		this.rows = original.rows;
		this.cols = original.cols;
		matrixA = new String[(int) this.rows][(int) this.cols];
		for(int i=0; i<matrixA.length; i++) {
			for(int k=0; k<cols; k++) {
				matrixA[i][k] = original.matrixA[i][k];
			}
		}
		this.original = original;
		
	}
	
	public ComplexMatrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		matrixA = new String[rows][cols];
		for(int i=0; i<matrixA.length; i++) {
			for(int k=0; k<cols; k++) {
				matrixA[i][k] = computeRandom() + " " + computeRandomSymbol() + " " + Math.abs(computeRandom()) + "i";
			}
		}
	}

	public String toString() {
		System.out.print("[");
		for(int i=0;i<rows;i++) {
			for(int k=0; k<cols; k++) {
				if(i==this.matrixA.length-1 && k==cols-1) {
					System.out.print(this.matrixA[i][k] + ";");
				}else if(k==cols-1) {
					System.out.print(this.matrixA[i][k] + ";\n");
				}else {
					System.out.print(this.matrixA[i][k] +", ");
				}
			}
		}
		System.out.println("]");
		return "";
	}
	
	public String CompAdd(ComplexMatrix matrix) {
		Double img;
		String[][] mA = this.matrixA;
		String Symbol;
		String x = "";

		if(rows != matrix.rows || cols != matrix.cols) {
			return null;
		}
		for(int i=0;i<rows;i++) {
			for(int k=0; k<cols; k++) {
				String removeI2 = mA[i][k].toString().replaceFirst(".$","");
				String parts2[] = removeI2.split(" ");
				String removeI1 = matrix.matrixA[i][k].toString().replaceFirst(".$","");
				String parts1[] = removeI1.split(" ");
				String img1withsymbol = parts1[1] + parts1[2];
				String img2withsymbol = parts2[1] + parts2[2];
				Double real1 = Double.parseDouble(parts1[0]);
				Double real2 = Double.parseDouble(parts2[0]);
				Double real = real1 + real2;
				Double img1 = Double.parseDouble(img1withsymbol);
				Double img2 = Double.parseDouble(img2withsymbol);
				img = img1 + img2;
				if(img > 0) {
					Symbol = "+";
				}else {
					Symbol = "-";
				}
				if(i==this.matrixA.length-1 && k==cols-1) {
					x += String.format("%.5s " + "%s " + "%.5si", real, Symbol, Math.abs(img)) + ";";
				}else if(k==cols-1) {
					x += String.format("%.5s " + "%s " + "%.5si", real, Symbol, Math.abs(img)) +  ";\n";
				}else {
					x += String.format("%.5s " + "%s " + "%.5si", real, Symbol, Math.abs(img)) + ", ";
				}
			}
		}
		for(int i=0;i<rows-1;i++) {
			for(int k=0; k<cols-1; k++) {
					mA[i][k] = mA[i][k];
				}
		}
		return "[" + x + "]";
	}
	
	public String CompSubtract(ComplexMatrix matrix) {
		Double img;
		String[][] mA = this.matrixA;
		String Symbol;
		String x = "";
		if(rows != matrix.rows || cols != matrix.cols) {
			return null;
		}
		for(int i=0;i<rows;i++) {
			for(int k=0; k<cols; k++) {
				String removeI2 = mA[i][k].toString().replaceFirst(".$","");
				String parts2[] = removeI2.split(" ");
				String removeI1 = matrix.matrixA[i][k].toString().replaceFirst(".$","");
				String parts1[] = removeI1.split(" ");
				String img1withsymbol = parts1[1] + parts1[2];
				String img2withsymbol = parts2[1] + parts2[2];
				Double real1 = Double.parseDouble(parts1[0]);
				Double real2 = Double.parseDouble(parts2[0]);
				Double real = real2 - real1;
				Double img1 = Double.parseDouble(img1withsymbol);
				Double img2 = Double.parseDouble(img2withsymbol);
				if(img1<img2) {
					img = img1 - img2;
				}else if(img1 <0 && img2 <0) {
					img = img2 - img1;
				}else {
					img = img1 - img2;
				}
				
				if(img > 0) {
					Symbol = "-";
				}else {
					Symbol = "+";
				}
				if(i==this.matrixA.length-1 && k==cols-1) {
					x += String.format("%.5s " + "%s " + "%.5si", real, Symbol, Math.abs(img)) + ";";
				}else if(k==cols-1) {
					x += String.format("%.5s " + "%s " + "%.5si", real, Symbol, Math.abs(img)) +  ";\n";
				}else {
					x += String.format("%.5s " + "%s " + "%.5si", real, Symbol, Math.abs(img)) + ", ";
				}
			}
		}
		for(int i=0;i<mA.length;i++) {
			for(int k=0; k<cols; k++) {
					mA[i][k] = mA[i][k];
			}
		}
		return "[" + x + "]";
	}

}

