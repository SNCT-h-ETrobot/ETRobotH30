package driveInstruction;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Information.SectionInfo;
import driveControl.DetectGray;
import driveControl.Linetracer;
import lejos.hardware.lcd.LCD;
import virtualDevices.ArmController;
import virtualDevices.DistanceMeasure;

public class RacePartDriver {

	private DistanceMeasure disMeasure = new DistanceMeasure();
	private ArmController armCtrl;
	private Linetracer tracer;

	//private Communicator com;

	private ArrayList<SectionInfo> sectionList;
	private int currentSectionID;
	private DetectGray detectGray = new DetectGray();



	//private WheelController whcon = new WheelController();



	public RacePartDriver(int courseID){
		//区間情報はリストで管理する
		sectionList = new ArrayList<SectionInfo>();

		//コースIDによってLとRどちらを走行するか決定する
		if(courseID == 1){	//Rコース  左側走行　これで22.46秒
			sectionList.add(new SectionInfo(0,275.0F,-30.0F,-20.0F,-5.0F,0.5F,100.0F));//GATE1前まで
			//sectionList.add(new SectionInfo(1,500.0F,-70.0F,-15.0F,-5.0F,0.5F,100.0F));
			//sectionList.add(new SectionInfo(2,700.0F,-100.0F,-20.0F,-5.0F,0.5F,100.0F));
			//sectionList.add(new SectionInfo(3,750.0F,-85.0F,-15.0F,-5.0F,0.5F,100.0F));//ラストの直線前まで
			//sectionList.add(new SectionInfo(4,1100.0F,-40.0F,-5.0F,-5.0F,0.5F,100.0F));//ゴールまで




		}
		else if(courseID == 2){	//Lコース 左側走行 これで安定
			//sectionList.add(new SectionInfo(0,260.0F,-150.0F,-100.0F,-10.0F,0.5F,100.0F));
			sectionList.add(new SectionInfo(0,240.0F,-25.0F,-10.0F,-5.0F,0.5F,100.0F));//最初のカーブ前まで
			sectionList.add(new SectionInfo(1,400.0F,-50.0F,-5.0F,-5.0F,0.5F,100.0F));//カーブGATE1まで
			sectionList.add(new SectionInfo(2,560.0F,-25.0F,-10.0F,-5.0F,0.5F,100.0F));//二つ目のカーブ前まで
			sectionList.add(new SectionInfo(3,650.0F,-70.0F,-10.0F,-5.0F,0.5F,100.0F));
			sectionList.add(new SectionInfo(4,720.0F,-40.0F,-10.0F,-5.0F,0.5F,100.0F));
			sectionList.add(new SectionInfo(5,810.0F,-60.0F,-5.0F,-5.0F,0.5F,100.0F));
			sectionList.add(new SectionInfo(6,1030.0F,-40.0F,-10.0F,-5.0F,0.5F,100.0F));
			//sectionList.add(new SectionInfo(3,700.0F,-100.0F,-50.0F,-5.0F,0.5F,100.0F));
			//sectionList.add(new SectionInfo(1,10000.0F,-45.0F,-20.0F,-5.0F,0.5F,0.0F));//GATE1まで
			//sectionList.add(new SectionInfo(0,200.0F,-150.0F,-25.0F,-5.0F,0.5F,100.0F));
			//sectionList.add(new SectionInfo(1,800.0F,-45.0F,-20.0F,-5.0F,0.5F,100.0F));
			//sectionList.add(new SectionInfo(0,1000.0F,-40.0F,-10.0F,-5.0F,0.5F,100.0F));
			//sectionList.add(new SectionInfo(0,9999.0F,-40.0F,-10.0F,-5.0F,0.5F,100.0F));
		}

		armCtrl = new ArmController();
		tracer = new Linetracer();

	}

	public void driveRacePart(){
		//com = new Communicator();
		//LCD.drawString("Connect Ready", 0, 0);
		//com.establishConnection();

		Timer timer = new Timer();

		TimerTask timerTask = new TimerTask(){

			public void run(){
				presumeCurrentSection();
				if(currentSectionID != -1){
					tracer.linetraceFast(sectionList.get(currentSectionID).getKp(),
							sectionList.get(currentSectionID).getKi(),
							sectionList.get(currentSectionID).getKd(),
							sectionList.get(currentSectionID).getTargetBrightness(),
							sectionList.get(currentSectionID).getTargetForward());
				}

			}
		};

		timer.scheduleAtFixedRate(timerTask, 0, 4);

		//com.readCode();
		LCD.drawString("dist:"+disMeasure.getDistance(), 0, 0);
		armCtrl.controlArmNormalAngel();

		while(currentSectionID != -1)
		{

		}
		timer.cancel();
		tracer.linetraceFast(0.0F,
				0.0F,
				0.0F,
				0.0F,
				0.0F);
		//detectGray.run();
	}


	private void presumeCurrentSection(){
		float distance = disMeasure.getDistance();

		for(int i = 0; i < sectionList.size();i++){
			//区間の距離と走行した距離を比較
			if(sectionList.get(i).getDistance() > distance){
				currentSectionID = sectionList.get(i).getSectionID();
				break;
			}
			if(i + 1 == sectionList.size()){
				//もし区間情報リストの終端まで比較しても
				//走行済の距離のほうが大きい場合例外として-1
				currentSectionID = -1;
			}
		}

	}
}
