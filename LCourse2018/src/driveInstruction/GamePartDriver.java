package driveInstruction;

import java.util.Timer;
import java.util.TimerTask;

import driveControl.DistanceAngleController;
import driveControl.Linetracer;
import virtualDevices.HSVColorDetector;

public class GamePartDriver {
	private boolean isLinetrace;
	private final float P_GAIN = -250.0F;	//P係数
	private final float I_GAIN = -10.0F;	//I係数
	private final float D_GAIN = -5.0F;	//D係数
	private Linetracer linetracer;
	private HSVColorDetector colorDetect;
	private DistanceAngleController dACtrl;
	public GamePartDriver(int courceID)
	{
		linetracer = new Linetracer();
		colorDetect = new HSVColorDetector();
		dACtrl = new DistanceAngleController();
	}
	public void driveGamePart()
	{
		Timer timerRed = new Timer();
		TimerTask redTask = new TimerTask(){
			public void run(){
				if(isLinetrace)
				{
					linetracer.linetrace(P_GAIN, I_GAIN, D_GAIN, 0.9F, 60,colorDetect.getNormalizedBrightness());
				}
			}
		};
		isLinetrace = true;
		timerRed.scheduleAtFixedRate(redTask, 0, 4);
		while(true)
		{
			
			if(colorDetect.getUnderColorID() == 3)
			{
				break;
			}

			//Delay.msDelay(2);
		}
		isLinetrace = false;
		timerRed.cancel();
		linetracer.linetrace(P_GAIN, I_GAIN, D_GAIN, 0.5F, 0);
		
		dACtrl.goStraightAhead(60.0F, 60.000F);
		dACtrl.turn(-50.0F, false);
		dACtrl.goStraightAhead(80.0F, 60.000F);
		dACtrl.turn(-80.0F, false);
		dACtrl.goStraightAhead(15.0F, 60.000F);
		dACtrl.turn(-40.0F, false);
		dACtrl.goStraightAhead(-30.0F, 60.000F);
		dACtrl.turn(20.0F, false);
		dACtrl.goStraightAhead(-30.0F, 60.000F);
		dACtrl.turn(30.0F, false);
		dACtrl.goStraightAhead(20.0F, 60.000F);
		dACtrl.turn(30.0F, false);
		dACtrl.goStraightAhead(-30.0F, 60.000F);
		dACtrl.turn(-20.0F, false);
		dACtrl.goStraightAhead(-30.0F, 60.000F);
	}

}
