import java.lang.Math;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	private double discriminant;
	private boolean realSol;
	private boolean isQua;
	private boolean dupSol;
	private Double sol1;
	private Double sol2;
	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public void getDiscriminant() {
		discriminant = Math.pow(b,2) - 4*a*c;
	}
	public boolean hasRealSolution() {
		getDiscriminant();
		if (discriminant >= 0) {
			realSol = true;
		}
		else {
			realSol = false;
		}
		return realSol;
	}
	public boolean isQuadratic() {
		if (a != 0) {
			isQua = true;
		}
		else {
			isQua = false;
		}
		return isQua;
	}
	public boolean hasDuplicatedSolution() {
		getDiscriminant();
		if (discriminant == 0) {
			dupSol = true;
		}
		else {
			dupSol = false;
		}
		return dupSol;
	}
	public double getSolution1() {
		getDiscriminant();
		boolean realSol1 = hasRealSolution();
		boolean isQua1 = isQuadratic();
		if (realSol1 == true && isQua == true) {
			sol1 = (-b + Math.sqrt(discriminant)) / (2 * a);
		}
		else if (realSol1 == true && isQua == false) {
			sol1 = null;
		}
		else if (realSol1 == false) {
			sol1 = null;
		}
		return sol1;
	}
	public double getSolution2() {
		getDiscriminant();
		boolean realSol2 = hasRealSolution();
		boolean isQua2 = isQuadratic();
		boolean dupSol2 = hasDuplicatedSolution();
		if (realSol2 == true && isQua == true) {
			if (dupSol2 == false) {
				sol2 = (-b - Math.sqrt(discriminant)) / (2 * a);
			}
			else
				sol2 = null;
		}
		else if (realSol2 == true && isQua == false) {
			sol2 = null;
		}
		else if (realSol2 == false) {
			sol2 = null;
		} 
		return sol2;
	}
}