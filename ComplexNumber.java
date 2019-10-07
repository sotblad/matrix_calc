import java.lang.Math;

public class ComplexNumber {

	private double real;
	private double img;
	private ComplexNumber num;
	private String Symbol;
	private String complex;
	
	public Double getReal(){
		return real;
	}

	public Double getImg(){
		return img;
	}

	public void setReal(Double newreal){
		this.real = newreal;
	}

	public void setImg(Double newimg){
		this.img = newimg;
	}

	public ComplexNumber(double real, double img) {
		if(img>0) {
			complex = real + " + " + Math.floor(img * 100) / 100 + "i";
		}else {
			complex = real + " - " + Math.floor(Math.abs(img) * 100) / 100 + "i";
		}
		this.real = real;
		this.img = img;
	}
	
	public ComplexNumber addComp(ComplexNumber num) {
		this.num = num;
		String removeI = num.toString().replaceFirst(".$","");
		String parts[] = removeI.split(" ");
		real = real+Double.parseDouble(parts[0]);
		img = img+Double.parseDouble(parts[1]+parts[2]);
		num = new ComplexNumber(real,img);
		return num;
	}
	
	public ComplexNumber subtractComp(ComplexNumber num) {
		this.num = num;
		String removeI = num.toString().replaceFirst(".$","");
		String parts[] = removeI.split(" ");
		this.real = real-Double.parseDouble(parts[0]);
		this.img = img-Double.parseDouble(parts[1]+parts[2]);
		num = new ComplexNumber(this.real,this.img);
		return num;
	}
	
	public ComplexNumber multiplyComp(ComplexNumber num) {
		this.num = num;
		String removeI = num.toString().replaceFirst(".$","");
		String parts[] = removeI.split(" ");
		this.real = (real*Double.parseDouble(parts[0])) - (img*Double.parseDouble(parts[1] + parts[2]));
		this.img = (real*Double.parseDouble(parts[1] + parts[2])) + (Double.parseDouble(parts[0])*img);
		num = new ComplexNumber(this.real,this.img);
		return num;
	}
	
	public String toString() {
		if(img>0) {
			return Math.floor(real * 100) / 100 + " + " + Math.floor(img * 100) / 100  + "i";
		}else {
			return Math.floor(real * 100) / 100  + " - " + Math.floor(Math.abs(img) * 100) / 100 + "i";
		}
	}
	
	public boolean equals(ComplexNumber num) {
		if(complex.contentEquals(num.toString())) {
			return true;
		}else {
			return false;
		}
	}

}

