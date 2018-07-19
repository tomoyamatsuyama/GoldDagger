import java.util.*;

public class Solver {
	static double[] usedPositionX = new double[Gold.EvalMax];
	static double[] usedPositionY = new double[Gold.EvalMax];
	static double value = -1.0;
	static double best = Double.MIN_VALUE;
	static double[] bestp = new double[2];
	static ArrayList<ArrayList<Double>> positions = new ArrayList<>();
	static double[] saveBestPosition = new double[2];
	static int count;
 
	public static void answer() {
		double[] p = new double[2];
		int middle = Gold.EvalMax * 7 / 10;

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
		double[] position = nearPositionFromBest();

		value = getEvaluateFromPostion(position);
		if (best < value) {
			best = value;
			bestp[0] = position[0];
			bestp[1] = position[1];
		}
	}

	private static double[] nearPositionFromBest() {
		// bestPositionから近傍を測る。
		// そのbestPositionが何回同じ調べる
		double addtionalPosition = 0.828;
		double[] position = new double[2];
		position[0] = bestp[0] + (addtionalPosition * sameCountPosition());
		position[1] = bestp[1] + (addtionalPosition * sameCountPosition());

		return position;
	}

	private static int sameCountPosition() {
		// ここでbestPositionが何回目か確認する。
		if ((bestp[0] == saveBestPosition[0]) && (bestp[1] == saveBestPosition[1])) {
			count ++;
			return count;
		} else {
			return 0;
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
