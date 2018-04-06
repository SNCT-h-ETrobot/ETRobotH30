package ev3Traning;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Traning {

	static RegulatedMotor MotorR = Motor.B;//ポートBに右のモーターがつながっている
	static RegulatedMotor MotorL = Motor.C;//ポートCに左のモーターがつながっている
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S2);
	//使用するセンサーを定義する
	//タッチセンサーはS2ポートにつながっているためこのように定義する
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
	static SensorMode touch;
	static EV3UltrasonicSensor UltraSonicSensor = new EV3UltrasonicSensor(SensorPort.S3);

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		init();
		
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
			MotorR.rotateTo(0);
			MotorL.resetTachoCount();
			MotorL.rotateTo(0);
		}


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
