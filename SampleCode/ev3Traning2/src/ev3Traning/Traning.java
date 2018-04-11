package ev3Traning;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.TachoMotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Traning {

	static TachoMotorPort MotorR = MotorPort.B.open(TachoMotorPort.class);;//ポートBに右のモーターがつながっている
	static TachoMotorPort MotorL = MotorPort.C.open(TachoMotorPort.class);;//ポートCに左のモーターがつながっている
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S2);
	//使用するセンサーを定義する
	//タッチセンサーはS2ポートにつながっているためこのように定義する
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
	static SensorMode touch;
	static EV3UltrasonicSensor UltraSonicSensor = new EV3UltrasonicSensor(SensorPort.S3);

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		init();
		setTSensor();
		while(CheckTSensor() == false)
		{
			
		}
		while(true)
		{
			//onOffLinetrace(0.5F,50);
			//PIDLinetrace(200.0F,10.0F,1.0F,0.5F,50);
			
			/*
			lcdclear();
			drawLCD(""+MotorR.getTachoCount(),1,1);
			if(MotorR.getTachoCount() < 100)
			{
				PIDLinetrace(50.0F,5.0F,1.0F,0.5F,100);
			}
			else if(MotorR.getTachoCount() < 600)
			{
				PIDLinetrace(100.0F,10.0F,1.0F,0.5F,50);
			}
			else if(MotorR.getTachoCount() < 1000)
			{
				PIDLinetrace(50.0F,10.0F,5.0F,0.5F,100);
			}
			else
			{
				PIDLinetrace(200.0F,10.0F,1.0F,0.5F,50);
			}
			*/
		}
		
	}
	private static float brightness;

	//輝度値基準値。本番環境で調整必要
	private final static float BLACK_BRIGHTNESS = 0.01F;
	private final static float WHITE_BRIGHTNESS = 0.52F;

	//正規化後の最大・最小値
	private final static float BRIGHTNESS_MAX = 1.0F;
	private final static float BRIGHTNESS_MIN = 0.0F;

	public static float getNormalizedBrightness(){
		float normalizedBrightness = (getBrightness()-BLACK_BRIGHTNESS)/(WHITE_BRIGHTNESS-BLACK_BRIGHTNESS);

		return Math.min(Math.max(normalizedBrightness, BRIGHTNESS_MIN),BRIGHTNESS_MAX);
	}

	public static float getBrightness(){
		SensorMode Red = colorSensor.getRedMode();
		float[] sampleBright = new float[Red.sampleSize()];
		float a = 0.8F;//大きくすると遅れるが滑らかになる

		Red.fetchSample(sampleBright, 0);
		//出力値 = a*ひとつ前の出力値 + (1-a)*センサ値
		//ひとつ前の出力値はbrightnessとなっている筈
		brightness = a*brightness + (1-a)*sampleBright[0];
		return brightness;
	}
	
	 public static void onOffLinetrace(float target_brightness,float target_forward){
		float brightness = getNormalizedBrightness();
		float turn = 0.0F;
		if(brightness - target_brightness > 0)
		{
			turn = 50.0F;
		}
		else
		{
			turn = -50.0F;
		}

		controlWheels(turn,target_forward);
		
	}
	
	private static float currentDiff = 0.0F;
	private static float preDiff = 0.0F;
	private static float integral = 0.0F;
	private final static float DELTA_T = 0.004F;
	
	 public static void PIDLinetrace(float kp,float ki,float kd,float target_brightness,float target_forward){
		float brightness = getNormalizedBrightness();

		preDiff = currentDiff;
		currentDiff = brightness - target_brightness;
		integral += ((currentDiff + preDiff) / 2.0F)*DELTA_T;

		float turn = kp * currentDiff;
		turn += ki * integral;
		turn += kd * (currentDiff - preDiff)/DELTA_T;

		controlWheels(turn,target_forward);
		
	}
	 
	 public static void controlWheels(float turn,float forward){
			//計算式は適当
			//turnのMAXを50(-50)の想定のとき
			//外輪と内輪のパワー差が２倍になる感じ
			int powerL;
			int powerR;
			if(turn >= 0){
				powerL = (int)((100-turn)/100 * forward);
			}
			else{
				powerL = (int)forward;
			}
			if(turn <= 0){
				powerR = (int)((100+turn)/100 * forward);
			}
			else{
				powerR = (int)forward;
			}

			controlWheelsDirect(powerL,powerR);
		}
	 public static void controlWheelsDirect(int powerL,int powerR){

			MotorL.controlMotor(powerL, 1);
			MotorR.controlMotor(powerR, 1);
		}
	 
	 
	//LCD上に表示されている文字をすべてクリアします．
		private static void lcdClear(){
			LCD.clear();
		}

		//LCD上に数字を入力させたい場合の関数
		private static void drawInt(int n, int x, int y){
			LCD.drawInt(n, x, y);
		}

		//LCD上に文字列を入力させたい場合の関数
		private static void drawStr(String str, int x, int y){
			LCD.drawString(str, x, y);
		}

		//指定した時間(ミリ秒単位)処理を待機する
		private static void Delay(int msec){
			Delay.msDelay(msec);
		}
		//モーターを初期化する関数
		static void init(){
			MotorR.resetTachoCount();
			for(int i = 0; i < 1500;i++){
				MotorL.controlMotor(0, 1);
				MotorR.controlMotor(0, 1);
			}
			MotorL.resetTachoCount();
		}

/*
		//モーターを動かす関数
		//右と左の速度を引数として受けとって、モーターを動かす
		static void setMotor(int Right, int Left){

			MotorR.setSpeed(Right);
			if(Right>0)MotorR.forward();
			else if(Right<0)MotorR.backward();
			else MotorR.stop();

			MotorL.setSpeed(Left);
			if(Left>0)MotorL.forward();
			else if(Left<0)MotorL.backward();
			else MotorL.stop();
		}
*/
		//指定した秒数だけ待機する関数
		static void Delaysec(double d){
			Delay.msDelay((int)(d*1000));
		}
		//LCDに表示されている文章をすべてクリアします．
		private static void  lcdclear(){
			LCD.refresh();
			LCD.clear();
		}

		//RGB値を取得します．配列のパスの順にRed,Green,Blueの値が格納されています．
		private static void getRGB(float[] RGB){
			SensorMode  color = colorSensor.getMode(2);
			color.fetchSample(RGB, 0);
		}

		//自動的にRGB値を取得しそれが何色なのか判定します．
		//色の種類はIDで表現され，IDを整数型で返します．
		//例：黒の場合のIDは7，赤なら0
		private static int getColorID(){
			float[] value = new float[1];
			SensorMode  color = colorSensor.getMode(0);
			color.fetchSample(value, 0);
			return (int)value[0];
		}

		//得られたRGB値とcolorIDをLCD上に表示します．
		private static void drawResult(float[] RGB,int colorID){
			LCD.drawString("R:"+RGB[0], 0, 0);
			LCD.drawString("G:"+RGB[1], 0, 1);
			LCD.drawString("B:"+RGB[2], 0, 2);
			switch(colorID){
			case 0:		LCD.drawString("Color:Red", 0, 4);
						break;
			case 1:		LCD.drawString("Color:Green", 0, 4);
						break;
			case 2:		LCD.drawString("Color:Blue", 0, 4);
						break;
			case 3: 	LCD.drawString("Color:Yellow", 0, 4);
						break;
			case 6: 	LCD.drawString("Color:White", 0, 4);
						break;
			case 7: 	LCD.drawString("Color:Black", 0, 4);
						break;
			default :	LCD.drawString("Color:Unkown", 0, 4);
						break;
			}

		}
		//タッチセンサの初期設定を行います．タッチセンサを使うときはこれをまず宣言してください．
		public static void setTSensor(){
			touch = touchSensor.getMode(0);
		}

		//タッチセンサが押されているかどうかを判定します．押されていたらtrueを，押されていなかったらfalseを返します．
		public static boolean CheckTSensor(){
			float value[] = new float[touch.sampleSize()];

			touch.fetchSample(value, 0);

			if(value[0]==1){
				return true;
			}else{
				return false;
			}
		}


		//LCDに好きな文章を表示できます．
		//第1の引数はメッセージの文字列，第2の引数はメッセージの1文字目のx座標，第3の引数はy座標です．
		private static void drawLCD(String message,int x,int y){
			LCD.drawString(message, x, y);
		}


		//超音波センサから物体までの距離を測定し，値を得ます．
		private static float getUltraSonicDistance(){
			float Distance[] = new float[UltraSonicSensor.sampleSize()];
			UltraSonicSensor.getDistanceMode();
			UltraSonicSensor.fetchSample(Distance, 0);
			return (float) (Distance[0]*100.0);
		}

		//float型の値を表示できます．
		private static void drawString(float cm,int x,int y){
			LCD.drawString(String.format("%.1f"+"cm", cm), x, y);
		}

}
