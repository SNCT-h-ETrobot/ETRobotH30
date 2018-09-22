package driveInstruction;

public class Controller {	//クラス名は再考が必要

	static RacePartDriver RPDriver;
	static GamePartDriver GPDriver;

	private int courseID;

	public Controller(){
		//Rコース
		//courseID = 1;

		//Lコース
		courseID = 2;

		RPDriver = new RacePartDriver(courseID);
		GPDriver = new GamePartDriver(courseID);
	}

	public void drive(){
		RPDriver.driveRacePart();
		//以後ゲー区間
		GPDriver.AI_answer_NumberPart();
		GPDriver.AI_answer_BlockPart();
		GPDriver.AI_answer_StopPart();
	}
}
