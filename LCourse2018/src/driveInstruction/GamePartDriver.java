package driveInstruction;

import java.util.Timer;
import java.util.TimerTask;

import driveControl.DistanceAngleController;
import driveControl.Linetracer;
import lejos.hardware.lcd.LCD;
import virtualDevices.ArmController;
import virtualDevices.HSVColorDetector;

public class GamePartDriver {
	
	private int AI_digitalNumber = 0;
	private int AI_analogNumber = 0;
	private ArmController arm;
	private int arm_up_angle = 150; 
	private DistanceAngleController dACtrl;
	private final float P_GAIN = 250.0F;	//P係数
	private final float I_GAIN = 10.0F;	//I係数
	private final float D_GAIN = 5.0F;	//D係数
	private boolean isgoStraightAhead;
	private Linetracer linetracer;
	
//	private final float TARGET_BRIGHTNESS = 0.5F;//要調整もっと高いかも
	private HSVColorDetector colorDetect = new HSVColorDetector();
	
	public GamePartDriver(int courseID)
	{
		arm = new ArmController();
		dACtrl = new DistanceAngleController();
		linetracer = new Linetracer();
	}
	
	public void AI_answer_NumberPart()
	{
		arm.controlArmNormalAngel();
		AI_digitalNumber = 7;
		AI_analogNumber = 7;
		LCD.drawString("success", 0, 0);
	}
	
	public void AI_answer_BlockPart()
	{
		if(AI_digitalNumber == 7)
		{
			//黒色検知
/*
			Timer timerBlack = new Timer();
			TimerTask BlackTask = new TimerTask(){
				public void run(){
					if(isgoStraightAhead)
					{
						dACtrl.goStraightAhead(10.0F, 100.000F);
						if(colorDetect.getUnderColorID() == 0)
						{
							dACtrl.goStraightAhead(0, 0);
						}
						//linetracer.linetrace(P_GAIN, I_GAIN, D_GAIN, TARGET_BRIGHTNESS, 50,colorDetect.getNormalizedBrightness());
					}
				}
			};
			isgoStraightAhead = true;
			timerBlack.scheduleAtFixedRate(BlackTask, 0, 4);
			while(true)
			{
				
				if(colorDetect.getUnderColorID() == 0)
				{
					break;
				}

				//Delay.msDelay(2);
			}
			isgoStraightAhead = false;
			timerBlack.cancel();*/
//			linetracer.linetrace(P_GAIN, I_GAIN, D_GAIN, TARGET_BRIGHTNESS, 0);
//			dACtrl.goStraightAhead(100.0F, 60.000F);
			//ブロック移動
			/*
			dACtrl.TurningControl((float)(2.0F * Math.PI * 12.6F * 65.0F / 360F), 80, false);//一番最初に赤マスのブロックを持っているところ
			dACtrl.goStraightAhead(-10, 80);
			dACtrl.TurningControl((float)(-2.0F * Math.PI * 12.6F * 65.0F / 360F), 80, false);
			dACtrl.goStraightAhead(-10, 80);
			dACtrl.TurningControl((float)(-2.0F * Math.PI * 12.6F * 65.0F / 360F), 80, false);
			dACtrl.goStraightAhead(20, 80);
			*/
//			dACtrl.TurningControl((float)(2.0F * Math.PI * 12.6F * 105.0F / 360F), 80, false);

			dACtrl.goStraightAhead(0, 0);
			dACtrl.goStraightAhead(70, 80);
			dACtrl.TurningControl((float)(-2.0F * Math.PI * 12.6F * 90.0F / 360F), 80, false);
			dACtrl.goStraightAhead(45, 80);
			//黒色検知
			Timer timerBlack = new Timer();
			TimerTask BlackTask = new TimerTask(){
				public void run(){
					if(isgoStraightAhead)
					{
						dACtrl.goStraightAhead(10.0F, 50.000F);
						if(colorDetect.getUnderColorID() == 0)
						{
							dACtrl.goStraightAhead(0, 0);
						}
						//linetracer.linetrace(P_GAIN, I_GAIN, D_GAIN, TARGET_BRIGHTNESS, 50,colorDetect.getNormalizedBrightness());
					}
				}
			};
			isgoStraightAhead = true;
			timerBlack.scheduleAtFixedRate(BlackTask, 0, 4);
			while(true)
			{
				
				if(colorDetect.getUnderColorID() == 0)
				{
					break;
				}

				//Delay.msDelay(2);
			}
			isgoStraightAhead = false;
			timerBlack.cancel();
			LCD.drawString("success", 5, 5);
			dACtrl.goStraightAhead(0, 0);
			dACtrl.TurningControl((float)(2.0F * Math.PI * 12.6F * 105.0F / 360F), 80, false);
			linetracer.linetrace(-30, -10, -5, 0.03F, 50,colorDetect.getNormalizedBrightness());

			//dACtrl.TurningControl(-(float)(2.0F * Math.PI * 12.6F * 40.0F / 360F), 80, false);//一番最初に赤マスのブロックを持っているところ
			
			//dACtrl.goStraightAhead(50, 80);
			//arm.controlArm(arm_up_angle);
//			arm.controlArmHoldAngel(); //アームを挙げる動作
			//Delay.msDelay(2);
			//arm.controlArmNormalAngel();
			//arm.controlArmDetectAngel();
			//arm.controlArmPutAngel();
			//dACtrl.TurningControl(/*targetDistance, speed, right*/50, 50, false);
		}
	}
	
	public void AI_answer_StopPart()
	{
		
	}

}
