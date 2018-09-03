import lejos.hardware.lcd.LCD;
import virtualDevices.ArmController;
import Hardware.Hardware;


public class ColorChecker {
	static ArmController arm;

	public static void main(String[] args) {
		float[] sampleRGB = new float[Hardware.colorSensor.getRGBMode().sampleSize()];

		arm = new ArmController();
		arm.controlArmNormalAngel();

		while(true){
			Hardware.colorSensor.getRGBMode().fetchSample(sampleRGB, 0);

			float r = sampleRGB[0];
			float g = sampleRGB[1];
			float b = sampleRGB[2];

			float max = Math.max(r, Math.max(g, b));
			float min = Math.min(r, Math.min(g, b));

			float h = max - min;
			if(h > 0.0F){
				if(max == r){
					h = (g-b)/h;
					if(h < 0.0F){
						h += 6.0F;
					}
				}
				else if(max == g){
					h = 2.0F + (b-r)/h;
				}
				else{
					h = 4.0F + (r-g)/h;
				}
			}
			h /= 6.0F;

			float s = (max -min);
			if(max != 0.0F){
				s /= max;
			}

			float v = max;			float[] sampleTouch = new float[Hardware.touch.sampleSize()];
			Hardware.touchMode.fetchSample(sampleTouch, 0);
			if(sampleTouch[0] != 0){
				LCD.drawString("h:"+h, 0, 0);
				LCD.drawString("s:"+s, 0, 1);
				LCD.drawString("v:"+v, 0, 2);
			}
		}
	}


}
