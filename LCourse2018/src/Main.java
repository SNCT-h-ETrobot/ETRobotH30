import UserInterface.Starter;


public class Main {

	static boolean isLinetrace;
	public static void main(String[] args) {
		Starter starter = new Starter();
		starter.calibrate();
		starter.touchStart();
		/*DistanceAngleController con = new DistanceAngleController();
		while(true)
		{
			con.goStraightAhead(5, 50);
			Delay.msDelay(1000);
		}*/
	}

}
