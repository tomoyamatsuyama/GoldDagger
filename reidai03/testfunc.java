public class testfunc {
	
	public static double define (double[] p) {
		double max = 100.0;
		double[] pbest = {100.0, 100.0};
		double f = max - 1.0e-9*( Math.pow(p[0]-pbest[0],2) + Math.pow(p[1]-pbest[1],2) );
		return ( f );
	}

}
