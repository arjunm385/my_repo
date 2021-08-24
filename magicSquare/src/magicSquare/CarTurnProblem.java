package magicSquare;

public class CarTurnProblem {

	public static void main(String[] args) {
//		String s = "right,left,right,left,right,back,left,right,straight";
		String s="right,right,right,right,right,right,right,right,right,right";
		String sa[] = s.split(",");
		int angle = 0;

		// initially car is facing towards North

		for (int i = 0; i < sa.length; i++) {

			if (sa[i].matches("right"))
				angle += 90;

			else if (sa[i].matches("left"))
				angle -= 90;

			else if (sa[i].matches("back"))
				angle -= 180;

			else if (sa[i].matches("straight"))
				angle += 0;

			if (angle == 360 || angle == -360)
				angle = 0;

			if (angle > 360)
				angle = angle - 360;

			if (angle < -360)
				angle = angle + 360;

		}

		System.out.println(angle);

		if (angle == 0 || angle == 360 || angle == -360)
			System.out.println("North");

		else if (angle == 90 || angle == -270)
			System.out.println("East");

		else if (angle == -90 || angle == 270)
			System.out.println("West");

		else
			System.out.println("South");

	}

}
