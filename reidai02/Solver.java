public class Solver {

	public static void answer() {

		final double MIN = -1.0e6;
		final double MAX = 1.0e6;

		double value = -1.0;
		double best = Double.MIN_VALUE;
		double[] p = new double[2];
		double[] bestp = new double[2];

		for(int i=0; i<Gold.EvalMax; i++){
			p[0] = MIN + (MAX-MIN)*Math.random();
			p[1] = MIN + (MAX-MIN)*Math.random();
			value = Gold.evaluate(p);
//			System.out.println(i + "," + value);
			if(best < value){
				best = value;
				bestp[0] = p[0];
				bestp[1] = p[1];
			}
		}
		Gold.submit(bestp);
	}

}
