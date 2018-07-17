import java.util.*;

public class Solver {
	static double[] usedPositionX = new double[Gold.EvalMax];
	static double[] usedPositionY = new double[Gold.EvalMax];
	static double value = -1.0;
	static double best = Double.MIN_VALUE;
	static double[] bestp = new double[2];
	static ArrayList<ArrayList<Double>> positions = new ArrayList<>();
 
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
		printPositions();
		Gold.submit(bestp);
	}

	private static void printPositions() {
		for (ArrayList<Double> position: positions) {
			System.out.printf("x: %f, y: %f", position.get(0), position.get(1));
		}
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

	private static void addPosition(double[] position) {
		ArrayList<Double> posi = new ArrayList<>();
		posi.add(position[0]);
		posi.add(position[1]);
		positions.add(posi);
	}

	private static boolean checkPosition() {
		return false;
	}

	private static double getEvaluateFromPostion(double[] position) {
		// 座標を受け取り、scoreを返す関数
		addPosition(position);
		return Gold.evaluate(position);
	} 
}
