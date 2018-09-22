package Information;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteDriver {

	private static List<Integer> routeList = new ArrayList<Integer>();// ルート計算の結果
	private final float DEGRESS_MULT = 0;// 角度を距離に直すときの倍率
	private static final float[] COST_MULT = {1.0f,1.0f,1.0f,1.0f};//コストに補正をかける，小さいほど動かす対象に選ばれやすい、赤、緑、青、黄の順
	
	//パワーブロックのID、初期位置コードから読み取る
	private int powerBlockID = BlockArrangeInfo.getPowerID();

	public void driveRoute(){
		//右と左のルートとそれぞれのルートのコスト
		List<Integer> tempList = new ArrayList<Integer>();
		List<Integer> lowCostTempList = new ArrayList<Integer>();
		float routeCost = 0,lowCostRouteCost = 0;

		//初期のパワーブロックの配置で一番加点が見込めるのは8通り→8回繰り返して一番移動コストが小さいものを採用する
		for (int i = 0; i < 8; i++) {
			int blockCarryTarget[];// ブロックを置く目標位置  赤、緑、青、黄の順
			if(powerBlockID == 1)
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{0, 39, 37, 4};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{0, 39, 37, 78};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{0, 39, 82, 4};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{0, 39, 82, 78};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{41, 39, 37, 4};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{41, 39, 37, 78};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{41, 39, 82, 4};
				}
				else
				{
					blockCarryTarget = new int[]{41, 39, 82, 78};
				}
			}
			else if(powerBlockID == 2)
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{41, 39, 8, 4};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{41, 39, 8, 43};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{41, 39, 82, 4};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{41, 39, 82, 43};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{41, 86, 8, 4};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{41, 86, 8, 43};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{41, 86, 82, 4};
				}
				else
				{
					blockCarryTarget = new int[]{41, 86, 82, 43};
				}
			}
			else if(powerBlockID == 3)
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{74, 39, 37, 78};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{74, 39, 82, 78};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{74, 115, 37, 78};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{74, 115, 82, 78};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{119, 39, 37, 78};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{119, 39, 82, 78};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{119, 115, 37, 78};
				}
				else
				{
					blockCarryTarget = new int[]{119, 115, 82, 78};
				}
			}
			else if(powerBlockID == 4)
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{41, 39, 82, 78};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{41, 39, 82, 123};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{41, 86, 82, 78};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{41, 86, 82, 123};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{119, 39, 82, 78};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{119, 39, 82, 123};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{119, 86, 82, 78};
				}
				else
				{
					blockCarryTarget = new int[]{119, 86, 82, 123};
				}
			}
			else if(powerBlockID == 5)
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{41, 39, 8, 4};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{41, 39, 8, 78};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{41, 39, 37, 4};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{41, 39, 37, 78};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{74, 39, 8, 4};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{74, 39, 8, 78};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{74, 39, 37, 4};
				}
				else
				{
					blockCarryTarget = new int[]{74, 39, 37, 78};
				}
			}
			else if(powerBlockID == 6)
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{41, 12, 8, 43};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{41, 12, 8, 78};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{41, 12, 82, 43};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{41, 12, 82, 78};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{41, 39, 8, 43};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{41, 39, 8, 78};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{41, 39, 82, 43};
				}
				else
				{
					blockCarryTarget = new int[]{41, 39, 82, 78};
				}
			}
			else if(powerBlockID == 7)
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{41, 39, 82, 78};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{41, 39, 111, 78};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{41, 115, 82, 78};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{41, 115, 111, 78};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{74, 39, 82, 78};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{74, 39, 111, 78};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{74, 115, 82, 78};
				}
				else
				{
					blockCarryTarget = new int[]{74, 115, 111, 78};
				}
			}
			else
			{
				if(i == 0)
				{
					blockCarryTarget = new int[]{41, 86, 82, 43};
				}
				else if(i == 1)
				{
					blockCarryTarget = new int[]{41, 86, 82, 78};
				}
				else if(i == 2)
				{
					blockCarryTarget = new int[]{41, 115, 82, 43};
				}
				else if(i == 3)
				{
					blockCarryTarget = new int[]{41, 115, 82, 78};
				}
				else if(i == 4)
				{
					blockCarryTarget = new int[]{119, 86, 82, 43};
				}
				else if(i == 5)
				{
					blockCarryTarget = new int[]{119, 86, 82, 78};
				}
				else if(i == 6)
				{
					blockCarryTarget = new int[]{119, 115, 82, 43};
				}
				else
				{
					blockCarryTarget = new int[]{119, 115, 82, 78};
				}
			}
			int robotPlace = 74; // 走行体の位置 初期値は走行区間から続く赤のブロック置き場
			//一回ごとにリストとコストをリセット
			tempList.clear();
			routeCost = 0;

			int[] blockPlace = BlockArrangeInfo.getBlockPlaceIDList();// ブロックの置いてある位置
			

			
			boolean canNotCarryAll = true;
			for (int j = 0; j < 4; j++) {
				// 移動先が開いているブロックの色を調べる
				boolean[] canCarry = new boolean[5];
				canNotCarryAll = true;
				for (int k = 0; k < 4; k++) {
					// それぞれのブロックに対して、ブロックの移動先にいずれかのブロックが置いてあるなら運べない
					canCarry[k] = true;
					for (int k2 = 0; k2 < 4; k2++) {
						if(blockCarryTarget[k] == blockPlace[k2]){
							canCarry[k] = false;
							break;
						}
					}
					if(canCarry[k] == true)canNotCarryAll = false;
				}

				// 動かせないときの処理
				if(canNotCarryAll){
					//その回を飛ばす
					break;
				}

				// 経路探索して最小コストを探索
				float lowestCost = Float.MAX_VALUE;
				List<Integer> lowestRoute = null;
				int lowestColor = 0;
				for (int k = 0; k < 5; k++) {
					if(!canCarry[k])continue;
					//System.out.println(robotPlace + "->" + blockPlace[k]);
					//同一地点をターゲットとすることがないように
					if(robotPlace != blockPlace[k]){
						List<Integer> tempRoute = aStar(robotPlace, blockPlace[k],blockPlace, false);
						float tempCost = calcCost(tempRoute) * COST_MULT[k];
						if(lowestCost > tempCost){
							lowestCost = tempCost;
							lowestRoute = tempRoute;
							lowestColor = k;
						}
					}
				}
				// エラー落ち回避用
				if(lowestRoute == null){
					lowestRoute = new ArrayList<Integer>();
					lowestRoute.add(robotPlace);
				}
				tempList.addAll(lowestRoute);
				routeCost += lowestCost;

				// ブロックから目標位置まで
				//同一地点をターゲットとすることがないように
				if(blockPlace[lowestColor] != blockCarryTarget[lowestColor]){
					List<Integer> tempRoute = aStar(blockPlace[lowestColor], blockCarryTarget[lowestColor],blockPlace, true);
					float tempCost = calcCost(tempRoute);
					tempList.addAll(tempRoute);
					routeCost += tempCost;
				}

				// 走行体とブロックの位置を更新
				robotPlace = blockPlace[lowestColor] = blockCarryTarget[lowestColor];
			}

			if(canNotCarryAll){
				//その回を飛ばす
				continue;
			}
			
			// 脱出地点に向かう
			List<Integer> tempRoute = aStar(robotPlace, 63, blockPlace, true);
			float tempCost = calcCost(tempRoute);
			tempList.addAll(tempRoute);
			routeCost += tempCost;


			// 最初に計算したルートとコストを保存
			if(i==0){
				lowCostTempList = new ArrayList<Integer>(tempList);
				lowCostRouteCost = routeCost;
			}
			else
			{
				// どちらがコスト低いか比較する
				// 低い方を変数に保存する ・ あとでgetRouteで参照する
				if(routeCost < lowCostRouteCost){
					lowCostTempList = new ArrayList<Integer>(tempList);
					lowCostRouteCost = routeCost;
				}
			}

		}

		
			routeList = new ArrayList<Integer>(lowCostTempList);
		
	}

	private List<Integer> aStar(int startID, int targetID, int[] blockPlace ,boolean isCarry){
		List<Integer> route = new ArrayList<Integer>();
		List<Integer> openList = new ArrayList<Integer>();
		List<Integer> closeList = new ArrayList<Integer>();

		//System.out.println(startID+"to"+targetID);
		//コスト
		double[] f = new double[124];
		for(int i = 0;i<124;i++){
			f[i] = 0.0F;
		}

		//子のIDがKey
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();

		int selectID;

		openList.add(startID);
		Vertex target = new Vertex(0,0,0);
		target = (Vertex)BlockArrangeInfo.getPointObject(targetID);
		float[] coordinateTarget = new float[2];
		coordinateTarget = target.getCoordinates();
		while(true){
			//解なし
			if(openList.isEmpty()){
				//System.out.println("Routing Fault");
				break;
			}

			//最小コストを選択
			selectID = openList.get(0);
			openList.remove(0);

			//ゴールなら終了
			if(selectID == targetID){
				break;
			}
			else{
				closeList.add(selectID);
			}

			//選択した箇所と隣接してるやつのコストに応じて処理
			List<Vertex> tempVertexList = new ArrayList<Vertex>(BlockArrangeInfo.getConnectionVertex(selectID));

			//目的ではないブロックで埋まってる場合除外
			int k = 0;
			while(tempVertexList.size() > k){
				for(int j = 0;j < 4;j++){
					if(tempVertexList.get(k).getPointID() == targetID){
						//目的地の場合何もしない
					}
					else if(tempVertexList.get(k).getPointID() == blockPlace[j]){
						//そうではないときは選択肢から外す
						tempVertexList.remove(k);
						k = 0;
						break;
					}
					if(j == 3){
						k++;
					}
				}
			}

			//親までのrouteのList
			List<Integer> tempRoute = new ArrayList<Integer>();
			tempRoute.add(0, selectID);
			while(true){
				if(tempRoute.get(0) == startID){
					break;
				}
				tempRoute.add(0,BlockArrangeInfo.getConnectionPath(tempRoute.get(0), map.get(tempRoute.get(0))).getPointID());
				tempRoute.add(0, map.get(tempRoute.get(1)));
			}

			//親の概算コスト
			Vertex parent = (Vertex) BlockArrangeInfo.getPointObject(tempRoute.get(tempRoute.size()-1));
			float[] coordinatesPar = parent.getCoordinates();
			double hn = Math.sqrt(Math.pow(coordinatesPar[0]-coordinateTarget[0],2.0F)+Math.pow(coordinatesPar[1]-coordinateTarget[1],2.0F));

			for(int i = 0;i<tempVertexList.size();i++){
				float[] coordinates = tempVertexList.get(i).getCoordinates();
				
				double fdmult;
				if(BlockArrangeInfo.getConnectionPath(selectID,tempVertexList.get(i).getPointID()).isLine())
					fdmult = 1.0;
				else
					fdmult = 10.0;
				
				//f'=g+cost+h
				//半ば簡易的。calcCostとは結果が違う
				double fd = (f[selectID] - hn)
						+BlockArrangeInfo.getConnectionPath(selectID,tempVertexList.get(i).getPointID()).getDistance() * fdmult
						+Math.sqrt(Math.pow(coordinates[0]-coordinateTarget[0],2.0F)+Math.pow(coordinates[1]-coordinateTarget[1],2.0F));

				//オープンされている
				if(openList.contains(tempVertexList.get(i).getPointID())){
					if(fd<f[tempVertexList.get(i).getPointID()]){
						f[tempVertexList.get(i).getPointID()] = fd;
						map.put(tempVertexList.get(i).getPointID(), selectID);
					}
				}
				//クローズされている
				else if(closeList.contains(tempVertexList.get(i).getPointID())){
					if(fd<f[tempVertexList.get(i).getPointID()]){
						f[tempVertexList.get(i).getPointID()] = fd;
						closeList.remove(tempVertexList.get(i).getPointID());
						openList.add(tempVertexList.get(i).getPointID());
						map.put(tempVertexList.get(i).getPointID(), selectID);
					}
				}
				//どちらでもない場合
				else{
					f[tempVertexList.get(i).getPointID()] = fd;
					openList.add(tempVertexList.get(i).getPointID());
					map.put(tempVertexList.get(i).getPointID(), selectID);
				}
			}

			//openListはindexが先頭に行くほどコストが低い
			//バブルなので遅かったら変える
			for(int i = 0; i < openList.size()-1; i++){
				for(int j = openList.size()-1; j > i ; j--){
					//コスト比較
					if(f[openList.get(j)] <f[openList.get(j-1)]){
						int temp = openList.get(j);
						openList.set(j, openList.get(j-1));
						openList.set(j-1, temp);
					}
				}
			}
		}

		//System.out.println("routing");
		//route生成
		route.add(0,targetID);
		do{
			//System.out.println(route.get(0));
			route.add(0,BlockArrangeInfo.getConnectionPath(route.get(0),map.get(route.get(0))).getPointID());
			//System.out.println(route.get(0));
			route.add(0,map.get(route.get(1)));
		}while(route.get(0)!=startID);
		//System.out.println(route.get(0));

		return route;
	}

	// ルートのリストを渡すとコストが返ってくるメソッド
	private float calcCost(List<Integer> route){
		float cost = 0;
		int[] array = new int[route.size()];
		List<Path> tempPathList;
		float preAngle = 0.0F;
		float nextAngle = 0.0F;
		//頂点、エッジ、頂点、エッジ……と並ぶと想定
		for(int i = 0; i<route.size();i++){
			//何度もアクセスすると遅いので一度Listから出す
			//メモリ足りなくなるなら辞め
			array[i] = route.get(i);
		}

		for(int i = 0; i<route.size()-2;i=i+2){
			tempPathList = new ArrayList<Path>(BlockArrangeInfo.getConnectionPath(array[i]));
			for(int j = 0;j<tempPathList.size();j++){
				if(tempPathList.get(j).getPointID() == array[i+1]){
					if(array[i] < array[i+2]){
						nextAngle = tempPathList.get(j).getAngle();
					}
					else{
						nextAngle = tempPathList.get(j).getAngle() * -1;
					}

					if(tempPathList.get(j).getAngle() > 180){
						cost += tempPathList.get(j).getDistance()
								+Math.abs(preAngle - (nextAngle-180))*DEGRESS_MULT;
					}
					else{
						cost += tempPathList.get(j).getDistance()
								+Math.abs(preAngle - nextAngle)*DEGRESS_MULT;
					}

					preAngle = nextAngle;
				}
			}

		}

		return cost;
	}

	// 算出したルートのgetter
	public List<Integer> getRoute(){
		return routeList;
	}

}
