public class Solver {
	static double[] usedPositionX = new double[Gold.EvalMax];
	static double[] usedPositionY = new double[Gold.EvalMax];
	static double value = -1.0;
	static double best = Double.MIN_VALUE;
	static double[] bestp = new double[2];

	public static void answer() {
		double[] p = new double[2];
		int middle = Gold.EvalMax;

		for(int i=0; i<Gold.EvalMax; i++) {
			if (i <= middle) {
				randomRequest();
			} else {
				request();
			}
			// System.out.println(i + "," + value);
		}
		Gold.submit(bestp);
	}

	private static void randomRequest() {
		// randomで座標の作成
		final double MIN = -1.0e6;
		final double MAX = 1.0e6;
		double[] position = new double[2];
		position[0] = MIN + (MAX-MIN)*Math.random();
		position[1] = MIN + (MAX-MIN)*Math.random();
		
		value = getEvaluateFromPostion(position);
		if (best < value) {
			best = value;
			bestp[0] = position[0];
			bestp[1] = position[1];
		}
	}

	private static void request() {
		double[] position = new double[2];
		final double MIN = -1.0e6;
		final double MAX = 1.0e6;
		position[0] = MIN + (MAX-MIN)*Math.random();
		position[1] = MIN + (MAX-MIN)*Math.random();

		value = getEvaluateFromPostion(position);
		if (best < value) {
			best = value;
			bestp[0] = position[0];
			bestp[1] = position[1];
		}
	}

	private static boolean checkPosition() {
		return false;
	}

	private static double getEvaluateFromPostion(double[] position) {
		// 座標を受け取り、scoreを返す関数
		return Gold.evaluate(position);
	} 
}
