public class Solver {
	double[] usedPositionX = new double[Gold.EvalMax];
	double[] usedPositionY = new double[Gold.EvalMax];

	public static void answer() {
		double value = -1.0;
		double best = Double.MIN_VALUE;
		double[] p = new double[2];
		double[] bestp = new double[2];
		int middle = Gold.EvalMax;

		for(int i=0; i<Gold.EvalMax; i++) {
			if (i <= middle) {
				value = randomRequest();
			} else {
				value = request();
			}

			// System.out.println(i + "," + value);

			if (best < value) {
				best = value;
				bestp[0] = p[0];
				bestp[1] = p[1];
			}
		}
		Gold.submit(bestp);
	}

	private static double randomRequest() {
		// randomで座標の作成
		final double MIN = -1.0e6;
		final double MAX = 1.0e6;
		double[] position = new double[2];
		position[0] = MIN + (MAX-MIN)*Math.random();
		position[1] = MIN + (MAX-MIN)*Math.random();
		
		return getEvaluateFromPostion(position);
	}

	private static double request() {
		double[] position = new double[2];
		final double MIN = -1.0e6;
		final double MAX = 1.0e6;
		position[0] = MIN + (MAX-MIN)*Math.random();
		position[1] = MIN + (MAX-MIN)*Math.random();

		return getEvaluateFromPostion(position);
	}

	private static boolean checkPosition() {
		return false;
	}

	private static double getEvaluateFromPostion(double[] position) {
		// 座標を受け取り、scoreを返す関数
		return Gold.evaluate(position);
	} 
}
