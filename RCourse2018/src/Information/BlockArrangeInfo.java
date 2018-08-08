package Information;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BlockArrangeInfo {
	static private final int PLACE_A = 65536; //16*16*16*16
	static private final int PLACE_B = 4096; //16*16*16
	static private final int PLACE_C = 256; //16*16
	static private final int PLACE_D = 16;
	static private int[] blockPlaceIDList = new int[4];
	static private int powerID = 0;
	static private Map<Integer,Map<Vertex,Path>> connectionList = new HashMap<Integer,Map<Vertex,Path>>();
	static private List<Object> pointList = new ArrayList<Object>();
	static private List<BlockPlace> blockPlaceList = new ArrayList<BlockPlace>();

	static public BlockPlace b000 = new BlockPlace(0,0.000F,0.000F,1);
	static public BlockPlace b004 = new BlockPlace(4,45.000F,0.000F,4);
	static public BlockPlace b008 = new BlockPlace(8,90.000F,0.000F,3);
	static public BlockPlace b012 = new BlockPlace(12,135.000F,0.000F,2);
	static public BlockPlace b037 = new BlockPlace(37,0.000F,40.000F,3);
	static public BlockPlace b039 = new BlockPlace(39,45.000F,40.000F,2);
	static public BlockPlace b041 = new BlockPlace(41,90.000F,40.000F,1);
	static public BlockPlace b043 = new BlockPlace(43,135.000F,40.000F,4);
	static public BlockPlace b074 = new BlockPlace(74,0.000F,80.000F,1);
	static public BlockPlace b078 = new BlockPlace(78,45.000F,80.000F,4);
	static public BlockPlace b082 = new BlockPlace(82,90.000F,80.000F,3);
	static public BlockPlace b086 = new BlockPlace(86,135.000F,80.000F,2);
	static public BlockPlace b111 = new BlockPlace(111,0.000F,120.000F,3);
	static public BlockPlace b115 = new BlockPlace(115,45.000F,120.000F,2);
	static public BlockPlace b119 = new BlockPlace(119,90.000F,120.000F,1);
	static public BlockPlace b123 = new BlockPlace(123,135.000F,120.000F,4);

	static public VirtualVertex v002 = new VirtualVertex(2,22.500F,0.000F,true);
	static public VirtualVertex v006 = new VirtualVertex(6,67.500F,0.000F,true);
	static public VirtualVertex v010 = new VirtualVertex(10,112.500F,0.000F,true);
	static public VirtualVertex v023 = new VirtualVertex(23,0.000F,20.000F,true);
	static public VirtualVertex v024 = new VirtualVertex(24,45.000F,20.000F,true);
	static public VirtualVertex v025 = new VirtualVertex(25,90.000F,20.000F,true);
	static public VirtualVertex v026 = new VirtualVertex(26,135.000F,20.000F,true);
	static public VirtualVertex v038 = new VirtualVertex(38,22.500F,40.000F,true);
	static public VirtualVertex v040 = new VirtualVertex(40,67.500F,40.000F,true);
	static public VirtualVertex v042 = new VirtualVertex(42,112.500F,40.000F,true);
	static public VirtualVertex v060 = new VirtualVertex(60,0.000F,60.000F,true);
	static public VirtualVertex v061 = new VirtualVertex(61,45.000F,60.000F,true);
	static public VirtualVertex v062 = new VirtualVertex(62,90.000F,60.000F,true);
	static public VirtualVertex v063 = new VirtualVertex(63,135.000F,60.000F,true);
	static public VirtualVertex v076 = new VirtualVertex(76,22.500F,80.000F,true);
	static public VirtualVertex v080 = new VirtualVertex(80,67.500F,80.000F,true);
	static public VirtualVertex v084 = new VirtualVertex(84,112.500F,80.000F,true);
	static public VirtualVertex v097 = new VirtualVertex(97,0.000F,100.000F,true);
	static public VirtualVertex v098 = new VirtualVertex(98,45.000F,100.000F,true);
	static public VirtualVertex v099 = new VirtualVertex(99,90.000F,100.000F,true);
	static public VirtualVertex v100 = new VirtualVertex(100,135.000F,100.000F,true);
	static public VirtualVertex v113 = new VirtualVertex(113,22.500F,120.000F,true);
	static public VirtualVertex v117 = new VirtualVertex(117,67.500F,120.000F,true);
	static public VirtualVertex v121 = new VirtualVertex(121,112.500F,120.000F,true);


	static public Path p001 = new Path(1,22.500F,0.000F,true);
	static public Path p003 = new Path(3,22.500F,0.000F,true);
	static public Path p005 = new Path(5,22.500F,0.000F,true);
	static public Path p007 = new Path(7,22.500F,0.000F,true);
	static public Path p009 = new Path(9,22.500F,0.000F,true);
	static public Path p011 = new Path(11,22.500F,0.000F,true);
	static public Path p013 = new Path(13,20.000F,90.000F,true);
	static public Path p014 = new Path(14,30.104F,138.367F,false);
	static public Path p015 = new Path(15,30.104F,41.633F,false);
	static public Path p016 = new Path(16,20.000F,90.000F,true);
	static public Path p017 = new Path(17,30.104F,138.367F,false);
	static public Path p018 = new Path(18,30.104F,41.633F,false);
	static public Path p019 = new Path(19,20.000F,90.000F,true);
	static public Path p020 = new Path(20,30.104F,138.367F,false);
	static public Path p021 = new Path(21,30.104F,41.633F,false);
	static public Path p022 = new Path(22,20.000F,90.000F,true);
	static public Path p027 = new Path(27,20.000F,90.000F,true);
	static public Path p028 = new Path(28,30.104F,41.633F,false);
	static public Path p029 = new Path(29,30.104F,138.367F,false);
	static public Path p030 = new Path(30,20.000F,90.000F,true);
	static public Path p031 = new Path(31,30.104F,41.633F,false);
	static public Path p032 = new Path(32,30.104F,138.367F,false);
	static public Path p033 = new Path(33,20.000F,90.000F,true);
	static public Path p034 = new Path(34,30.104F,41.633F,false);
	static public Path p035 = new Path(35,30.104F,138.367F,false);
	static public Path p036 = new Path(36,20.000F,90.000F,true);
	static public Path p044 = new Path(44,22.500F,0.000F,true);
	static public Path p045 = new Path(45,22.500F,0.000F,true);
	static public Path p046 = new Path(46,22.500F,0.000F,true);
	static public Path p047 = new Path(47,22.500F,0.000F,true);
	static public Path p048 = new Path(48,22.500F,0.000F,true);
	static public Path p049 = new Path(49,22.500F,0.000F,true);
	static public Path p050 = new Path(50,20.000F,90.000F,true);
	static public Path p051 = new Path(51,30.104F,138.367F,false);
	static public Path p052 = new Path(52,30.104F,41.633F,false);
	static public Path p053 = new Path(53,20.000F,90.000F,true);
	static public Path p054 = new Path(54,30.104F,138.367F,false);
	static public Path p055 = new Path(55,30.104F,41.633F,false);
	static public Path p056 = new Path(56,20.000F,90.000F,true);
	static public Path p057 = new Path(57,30.104F,138.367F,false);
	static public Path p058 = new Path(58,30.104F,41.633F,false);
	static public Path p059 = new Path(59,20.000F,90.000F,true);
	static public Path p064 = new Path(64,20.000F,90.000F,true);
	static public Path p065 = new Path(65,30.104F,41.633F,false);
	static public Path p066 = new Path(66,30.104F,138.367F,false);
	static public Path p067 = new Path(67,20.000F,90.000F,true);
	static public Path p068 = new Path(68,30.104F,41.633F,false);
	static public Path p069 = new Path(69,30.104F,138.367F,false);
	static public Path p070 = new Path(70,20.000F,90.000F,true);
	static public Path p071 = new Path(71,30.104F,41.633F,false);
	static public Path p072 = new Path(72,30.104F,138.367F,false);
	static public Path p073 = new Path(73,20.000F,90.000F,true);
	static public Path p075 = new Path(75,22.500F,0.000F,true);
	static public Path p077 = new Path(77,22.500F,0.000F,true);
	static public Path p079 = new Path(79,22.500F,0.000F,true);
	static public Path p081 = new Path(81,22.500F,0.000F,true);
	static public Path p083 = new Path(83,22.500F,0.000F,true);
	static public Path p085 = new Path(85,22.500F,0.000F,true);
	static public Path p087 = new Path(87,20.000F,90.000F,true);
	static public Path p088 = new Path(88,30.104F,138.367F,false);
	static public Path p089 = new Path(89,30.104F,41.633F,false);
	static public Path p090 = new Path(90,20.000F,90.000F,true);
	static public Path p091 = new Path(91,30.104F,138.367F,false);
	static public Path p092 = new Path(92,30.104F,41.633F,false);
	static public Path p093 = new Path(93,20.000F,90.000F,true);
	static public Path p094 = new Path(94,30.104F,138.367F,false);
	static public Path p095 = new Path(95,30.104F,41.633F,false);
	static public Path p096 = new Path(96,20.000F,90.000F,true);
	static public Path p101 = new Path(101,20.000F,90.000F,true);
	static public Path p102 = new Path(102,30.104F,41.633F,false);
	static public Path p103 = new Path(103,30.104F,138.367F,false);
	static public Path p104 = new Path(104,20.000F,90.000F,true);
	static public Path p105 = new Path(105,30.104F,41.633F,false);
	static public Path p106 = new Path(106,30.104F,138.367F,false);
	static public Path p107 = new Path(107,20.000F,90.000F,true);
	static public Path p108 = new Path(108,30.104F,41.633F,false);
	static public Path p109 = new Path(109,30.104F,138.367F,false);
	static public Path p110 = new Path(110,20.000F,90.000F,true);
	static public Path p112 = new Path(112,22.500F,0.000F,true);
	static public Path p114 = new Path(114,22.500F,0.000F,true);
	static public Path p116 = new Path(116,22.500F,0.000F,true);
	static public Path p118 = new Path(118,22.500F,0.000F,true);
	static public Path p120 = new Path(120,22.500F,0.000F,true);
	static public Path p122 = new Path(122,22.500F,0.000F,true);
	

	public static void makeConnection(){
		connectionList.put(b000.getPointID(),new HashMap<Vertex,Path>());
		connectionList.get(b000.getPointID()).put(v002, p001);
		connectionList.get(b000.getPointID()).put(v023, p013);
		connectionList.put(v002.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v002.getPointID()).put(b000, p001);
		connectionList.get(v002.getPointID()).put(b004, p003);
		connectionList.get(v002.getPointID()).put(v023, p014);
		connectionList.get(v002.getPointID()).put(v024, p015);
		connectionList.put(b004.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b004.getPointID()).put(v002, p003);
		connectionList.get(b004.getPointID()).put(v006, p005);
		connectionList.get(b004.getPointID()).put(v024, p016);
		connectionList.put(v006.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v006.getPointID()).put(b004, p005);
		connectionList.get(v006.getPointID()).put(b008, p007);
		connectionList.get(v006.getPointID()).put(v024, p017);
		connectionList.get(v006.getPointID()).put(v025, p018);
		connectionList.put(b008.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b008.getPointID()).put(v006, p007);
		connectionList.get(b008.getPointID()).put(v010, p009);
		connectionList.get(b008.getPointID()).put(v025, p019);
		connectionList.put(v010.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v010.getPointID()).put(b008, p009);
		connectionList.get(v010.getPointID()).put(b012, p011);
		connectionList.get(v010.getPointID()).put(v025, p020);
		connectionList.get(v010.getPointID()).put(v026, p021);		
		connectionList.put(b012.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b012.getPointID()).put(v010, p011);
		connectionList.get(b012.getPointID()).put(v026, p022);
		connectionList.put(v023.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v023.getPointID()).put(b000, p013);
		connectionList.get(v023.getPointID()).put(v002, p014);
		connectionList.get(v023.getPointID()).put(v038, p028);
		connectionList.get(v023.getPointID()).put(b037, p027);
		connectionList.put(v024.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v024.getPointID()).put(v002, p015);
		connectionList.get(v024.getPointID()).put(b004, p016);
		connectionList.get(v024.getPointID()).put(v006, p017);
		connectionList.get(v024.getPointID()).put(v038, p029);
		connectionList.get(v024.getPointID()).put(b039, p030);
		connectionList.get(v024.getPointID()).put(v040, p031);
		connectionList.put(v025.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v025.getPointID()).put(v006, p018);
		connectionList.get(v025.getPointID()).put(b008, p019);
		connectionList.get(v025.getPointID()).put(v010, p020);
		connectionList.get(v025.getPointID()).put(v040, p032);
		connectionList.get(v025.getPointID()).put(b041, p033);
		connectionList.get(v025.getPointID()).put(v042, p034);
		connectionList.put(v026.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v026.getPointID()).put(b012, p022);
		connectionList.get(v026.getPointID()).put(v010, p021);
		connectionList.get(v026.getPointID()).put(v042, p035);
		connectionList.get(v026.getPointID()).put(b043, p036);
		connectionList.put(b037.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b037.getPointID()).put(v023, p027);
		connectionList.get(b037.getPointID()).put(v038, p044);
		connectionList.get(b037.getPointID()).put(v060, p050);
		connectionList.put(v038.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v038.getPointID()).put(v023, p028);
		connectionList.get(v038.getPointID()).put(v024, p029);
		connectionList.get(v038.getPointID()).put(b037, p044);
		connectionList.get(v038.getPointID()).put(b039, p045);
		connectionList.get(v038.getPointID()).put(v060, p051);
		connectionList.get(v038.getPointID()).put(v061, p052);
		connectionList.put(b039.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b039.getPointID()).put(v024, p030);
		connectionList.get(b039.getPointID()).put(v038, p045);
		connectionList.get(b039.getPointID()).put(v040, p046);
		connectionList.get(b039.getPointID()).put(v061, p053);
		connectionList.put(v040.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v040.getPointID()).put(v024, p031);
		connectionList.get(v040.getPointID()).put(v025, p032);
		connectionList.get(v040.getPointID()).put(b039, p046);
		connectionList.get(v040.getPointID()).put(b041, p047);
		connectionList.get(v040.getPointID()).put(v061, p054);
		connectionList.get(v040.getPointID()).put(v062, p055);
		connectionList.put(b041.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b041.getPointID()).put(v025, p033);
		connectionList.get(b041.getPointID()).put(v040, p047);
		connectionList.get(b041.getPointID()).put(v042, p048);
		connectionList.get(b041.getPointID()).put(v062, p056);
		connectionList.put(v042.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v042.getPointID()).put(v025, p034);
		connectionList.get(v042.getPointID()).put(v026, p035);
		connectionList.get(v042.getPointID()).put(b041, p048);
		connectionList.get(v042.getPointID()).put(b043, p049);
		connectionList.get(v042.getPointID()).put(v062, p057);
		connectionList.get(v042.getPointID()).put(v063, p058);
		connectionList.put(b043.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b043.getPointID()).put(v026, p036);
		connectionList.get(b043.getPointID()).put(v042, p049);
		connectionList.get(b043.getPointID()).put(v063, p059);
		connectionList.put(v060.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v060.getPointID()).put(b037, p050);
		connectionList.get(v060.getPointID()).put(v038, p051);
		connectionList.get(v060.getPointID()).put(b074, p064);
		connectionList.get(v060.getPointID()).put(v076, p065);
		connectionList.put(v061.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v061.getPointID()).put(v038, p052);
		connectionList.get(v061.getPointID()).put(b039, p053);
		connectionList.get(v061.getPointID()).put(v040, p054);
		connectionList.get(v061.getPointID()).put(v076, p066);
		connectionList.get(v061.getPointID()).put(b078, p067);
		connectionList.get(v061.getPointID()).put(v080, p068);
		connectionList.put(v062.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v062.getPointID()).put(v040, p055);
		connectionList.get(v062.getPointID()).put(b041, p056);
		connectionList.get(v062.getPointID()).put(v042, p057);
		connectionList.get(v062.getPointID()).put(v080, p069);
		connectionList.get(v062.getPointID()).put(b082, p070);
		connectionList.get(v062.getPointID()).put(v084, p071);
		connectionList.put(v063.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v063.getPointID()).put(b043, p059);
		connectionList.get(v063.getPointID()).put(v042, p058);
		connectionList.get(v063.getPointID()).put(v084, p072);
		connectionList.get(v063.getPointID()).put(b086, p073);
		connectionList.put(b074.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b074.getPointID()).put(v060, p064);
		connectionList.get(b074.getPointID()).put(v076, p075);
		connectionList.get(b074.getPointID()).put(v097, p087);
		connectionList.put(v076.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v076.getPointID()).put(v060, p065);
		connectionList.get(v076.getPointID()).put(v061, p066);
		connectionList.get(v076.getPointID()).put(b074, p075);
		connectionList.get(v076.getPointID()).put(b078, p077);
		connectionList.get(v076.getPointID()).put(v097, p088);
		connectionList.get(v076.getPointID()).put(v098, p089);
		connectionList.put(b078.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b078.getPointID()).put(v061, p067);
		connectionList.get(b078.getPointID()).put(v076, p077);
		connectionList.get(b078.getPointID()).put(v080, p079);
		connectionList.get(b078.getPointID()).put(v098, p090);
		connectionList.put(v080.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v080.getPointID()).put(v061, p068);
		connectionList.get(v080.getPointID()).put(v062, p069);
		connectionList.get(v080.getPointID()).put(b078, p079);
		connectionList.get(v080.getPointID()).put(b082, p081);
		connectionList.get(v080.getPointID()).put(v098, p091);
		connectionList.get(v080.getPointID()).put(v099, p092);
		connectionList.put(b082.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b082.getPointID()).put(v062, p070);
		connectionList.get(b082.getPointID()).put(v080, p081);
		connectionList.get(b082.getPointID()).put(v084, p083);
		connectionList.get(b082.getPointID()).put(v099, p093);
		connectionList.put(v084.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v084.getPointID()).put(v062, p071);
		connectionList.get(v084.getPointID()).put(v063, p072);
		connectionList.get(v084.getPointID()).put(b082, p083);
		connectionList.get(v084.getPointID()).put(b086, p085);
		connectionList.get(v084.getPointID()).put(v099, p094);
		connectionList.get(v084.getPointID()).put(v100, p095);
		connectionList.put(b086.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b086.getPointID()).put(v063, p073);
		connectionList.get(b086.getPointID()).put(v084, p085);
		connectionList.get(b086.getPointID()).put(v100, p096);
		connectionList.put(v097.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v097.getPointID()).put(b074, p087);
		connectionList.get(v097.getPointID()).put(v076, p088);
		connectionList.get(v097.getPointID()).put(b111, p101);
		connectionList.get(v097.getPointID()).put(v113, p102);
		connectionList.put(v098.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v098.getPointID()).put(v076, p089);
		connectionList.get(v098.getPointID()).put(b078, p090);
		connectionList.get(v098.getPointID()).put(v080, p091);
		connectionList.get(v098.getPointID()).put(v113, p103);
		connectionList.get(v098.getPointID()).put(b115, p104);
		connectionList.get(v098.getPointID()).put(v117, p105);
		connectionList.put(v099.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v099.getPointID()).put(v080, p092);
		connectionList.get(v099.getPointID()).put(b082, p093);
		connectionList.get(v099.getPointID()).put(v084, p094);
		connectionList.get(v099.getPointID()).put(v117, p106);
		connectionList.get(v099.getPointID()).put(b119, p107);
		connectionList.get(v099.getPointID()).put(v121, p108);
		connectionList.put(v100.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v100.getPointID()).put(v084, p095);
		connectionList.get(v100.getPointID()).put(b086, p096);
		connectionList.get(v100.getPointID()).put(v121, p109);
		connectionList.get(v100.getPointID()).put(b123, p110);
		connectionList.put(b111.getPointID(),new HashMap<Vertex,Path>());
		connectionList.get(b111.getPointID()).put(v097, p101);
		connectionList.get(b111.getPointID()).put(v113, p112);
		connectionList.put(v113.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v113.getPointID()).put(v097, p102);
		connectionList.get(v113.getPointID()).put(v098, p103);
		connectionList.get(v113.getPointID()).put(b111, p112);
		connectionList.get(v113.getPointID()).put(b115, p114);
		connectionList.put(b115.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b115.getPointID()).put(v098, p104);
		connectionList.get(b115.getPointID()).put(v113, p114);
		connectionList.get(b115.getPointID()).put(v117, p116);
		connectionList.put(v117.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v117.getPointID()).put(v098, p105);
		connectionList.get(v117.getPointID()).put(v099, p106);
		connectionList.get(v117.getPointID()).put(b115, p116);
		connectionList.get(v117.getPointID()).put(b119, p118);
		connectionList.put(b119.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b119.getPointID()).put(v099, p107);
		connectionList.get(b119.getPointID()).put(v117, p118);
		connectionList.get(b119.getPointID()).put(v121, p120);
		connectionList.put(v121.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(v121.getPointID()).put(v099, p108);
		connectionList.get(v121.getPointID()).put(v100, p109);
		connectionList.get(v121.getPointID()).put(b119, p120);
		connectionList.get(v121.getPointID()).put(b123, p122);		
		connectionList.put(b123.getPointID(), new HashMap<Vertex,Path>());
		connectionList.get(b123.getPointID()).put(v100, p110);
		connectionList.get(b123.getPointID()).put(v121, p122);


		pointList.add(b000);
		pointList.add(p001);
		pointList.add(v002);
		pointList.add(p003);
		pointList.add(b004);
		pointList.add(p005);
		pointList.add(v006);
		pointList.add(p007);
		pointList.add(b008);
		pointList.add(p009);
		pointList.add(v010);
		pointList.add(p011);
		pointList.add(b012);
		pointList.add(p013);
		pointList.add(p014);
		pointList.add(p015);
		pointList.add(p016);
		pointList.add(p017);
		pointList.add(p018);
		pointList.add(p019);
		pointList.add(p020);
		pointList.add(p021);
		pointList.add(p022);
		pointList.add(v023);
		pointList.add(v024);
		pointList.add(v025);
		pointList.add(v026);
		pointList.add(p027);
		pointList.add(p028);
		pointList.add(p029);
		pointList.add(p030);
		pointList.add(p031);
		pointList.add(p032);
		pointList.add(p033);
		pointList.add(p034);
		pointList.add(p035);
		pointList.add(p036);
		pointList.add(b037);
		pointList.add(v038);
		pointList.add(b039);
		pointList.add(v040);
		pointList.add(b041);
		pointList.add(v042);
		pointList.add(b043);
		pointList.add(p044);
		pointList.add(p045);
		pointList.add(p046);
		pointList.add(p047);
		pointList.add(p048);
		pointList.add(p049);
		pointList.add(p050);
		pointList.add(p051);
		pointList.add(p052);
		pointList.add(p053);
		pointList.add(p054);
		pointList.add(p055);
		pointList.add(p056);
		pointList.add(p057);
		pointList.add(p058);
		pointList.add(p059);
		pointList.add(v060);
		pointList.add(v061);
		pointList.add(v062);
		pointList.add(v063);
		pointList.add(p064);
		pointList.add(p065);
		pointList.add(p066);
		pointList.add(p067);
		pointList.add(p068);
		pointList.add(p069);
		pointList.add(p070);
		pointList.add(p071);
		pointList.add(p072);
		pointList.add(p073);
		pointList.add(b074);
		pointList.add(p075);
		pointList.add(v076);
		pointList.add(p077);
		pointList.add(b078);
		pointList.add(p079);
		pointList.add(v080);
		pointList.add(p081);
		pointList.add(b082);
		pointList.add(p083);
		pointList.add(v084);
		pointList.add(p085);
		pointList.add(b086);
		pointList.add(p087);
		pointList.add(p088);
		pointList.add(p089);
		pointList.add(p090);
		pointList.add(p091);
		pointList.add(p092);
		pointList.add(p093);
		pointList.add(p094);
		pointList.add(p095);
		pointList.add(p096);
		pointList.add(v097);
		pointList.add(v098);
		pointList.add(v099);
		pointList.add(v100);
		pointList.add(p101);
		pointList.add(p102);
		pointList.add(p103);
		pointList.add(p104);
		pointList.add(p105);
		pointList.add(p106);
		pointList.add(p107);
		pointList.add(p108);
		pointList.add(p109);
		pointList.add(p110);
		pointList.add(b111);
		pointList.add(p112);
		pointList.add(v113);
		pointList.add(p114);
		pointList.add(b115);
		pointList.add(p116);
		pointList.add(v117);
		pointList.add(p118);
		pointList.add(b119);
		pointList.add(p120);
		pointList.add(v121);
		pointList.add(p122);
		pointList.add(b123);

		
		blockPlaceList.add(b000);
		blockPlaceList.add(b004);
		blockPlaceList.add(b008);
		blockPlaceList.add(b012);
		blockPlaceList.add(b037);
		blockPlaceList.add(b039);
		blockPlaceList.add(b041);
		blockPlaceList.add(b043);
		blockPlaceList.add(b074);
		blockPlaceList.add(b078);
		blockPlaceList.add(b082);
		blockPlaceList.add(b086);
		blockPlaceList.add(b111);
		blockPlaceList.add(b115);
		blockPlaceList.add(b119);
		blockPlaceList.add(b123);
	}

	public static void setBlockPlace(int code){
		int n = code;
		int i = 1;
		//位置番号が小さい順に赤、緑、黄、青としておく、画像から取得できるようにする
		int [] colorPlace = {0,1,3,2};


		i = (int)(n/PLACE_A);
		n = n - (i*PLACE_A);
		switch(i+1){
			case 1:
				blockPlaceIDList[colorPlace[0]] = 0;
				break;
			case 2:
				blockPlaceIDList[colorPlace[0]] = 4;
				break;
			case 3:
				blockPlaceIDList[colorPlace[0]] = 8;
				break;
			case 4:
				blockPlaceIDList[colorPlace[0]] = 12;
				break;
			case 5:
				blockPlaceIDList[colorPlace[0]] = 37;
				break;
			case 6:
				blockPlaceIDList[colorPlace[0]] = 39;
				break;
			case 7:
				blockPlaceIDList[colorPlace[0]] = 41;
				break;
			case 8:
				blockPlaceIDList[colorPlace[0]] = 43;
				break;
			case 9:
				blockPlaceIDList[colorPlace[0]] = 74;
				break;
			case 10:
				blockPlaceIDList[colorPlace[0]] = 78;
				break;
			case 11:
				blockPlaceIDList[colorPlace[0]] = 82;
				break;
			case 12:
				blockPlaceIDList[colorPlace[0]] = 86;
				break;
			case 13:
				blockPlaceIDList[colorPlace[0]] = 111;
				break;
			case 14:
				blockPlaceIDList[colorPlace[0]] = 115;
				break;
			case 15:
				blockPlaceIDList[colorPlace[0]] = 119;
				break;
			case 16:
				blockPlaceIDList[colorPlace[0]] = 123;
				break;
		}

		i = (int)(n/PLACE_B);
		n = n - (i*PLACE_B);
		switch(i+1){
		case 1:
			blockPlaceIDList[colorPlace[1]] = 0;
			break;
		case 2:
			blockPlaceIDList[colorPlace[1]] = 4;
			break;
		case 3:
			blockPlaceIDList[colorPlace[1]] = 8;
			break;
		case 4:
			blockPlaceIDList[colorPlace[1]] = 12;
			break;
		case 5:
			blockPlaceIDList[colorPlace[1]] = 37;
			break;
		case 6:
			blockPlaceIDList[colorPlace[1]] = 39;
			break;
		case 7:
			blockPlaceIDList[colorPlace[1]] = 41;
			break;
		case 8:
			blockPlaceIDList[colorPlace[1]] = 43;
			break;
		case 9:
			blockPlaceIDList[colorPlace[1]] = 74;
			break;
		case 10:
			blockPlaceIDList[colorPlace[1]] = 78;
			break;
		case 11:
			blockPlaceIDList[colorPlace[1]] = 82;
			break;
		case 12:
			blockPlaceIDList[colorPlace[1]] = 86;
			break;
		case 13:
			blockPlaceIDList[colorPlace[1]] = 111;
			break;
		case 14:
			blockPlaceIDList[colorPlace[1]] = 115;
			break;
		case 15:
			blockPlaceIDList[colorPlace[1]] = 119;
			break;
		case 16:
			blockPlaceIDList[colorPlace[1]] = 123;
			break;
		}

		i = (int)(n/PLACE_C);
		n = n - (i*PLACE_C);
		switch(i+1){
		case 1:
			blockPlaceIDList[colorPlace[2]] = 0;
			break;
		case 2:
			blockPlaceIDList[colorPlace[2]] = 4;
			break;
		case 3:
			blockPlaceIDList[colorPlace[2]] = 8;
			break;
		case 4:
			blockPlaceIDList[colorPlace[2]] = 12;
			break;
		case 5:
			blockPlaceIDList[colorPlace[2]] = 37;
			break;
		case 6:
			blockPlaceIDList[colorPlace[2]] = 39;
			break;
		case 7:
			blockPlaceIDList[colorPlace[2]] = 41;
			break;
		case 8:
			blockPlaceIDList[colorPlace[2]] = 43;
			break;
		case 9:
			blockPlaceIDList[colorPlace[2]] = 74;
			break;
		case 10:
			blockPlaceIDList[colorPlace[2]] = 78;
			break;
		case 11:
			blockPlaceIDList[colorPlace[2]] = 82;
			break;
		case 12:
			blockPlaceIDList[colorPlace[2]] = 86;
			break;
		case 13:
			blockPlaceIDList[colorPlace[2]] = 111;
			break;
		case 14:
			blockPlaceIDList[colorPlace[2]] = 115;
			break;
		case 15:
			blockPlaceIDList[colorPlace[2]] = 119;
			break;
		case 16:
			blockPlaceIDList[colorPlace[2]] = 123;
			break;
		}

		i = (int)(n/PLACE_D);
		n = n - (i*PLACE_D);
		switch(i+1){
		case 1:
			blockPlaceIDList[colorPlace[3]] = 0;
			break;
		case 2:
			blockPlaceIDList[colorPlace[3]] = 4;
			break;
		case 3:
			blockPlaceIDList[colorPlace[3]] = 8;
			break;
		case 4:
			blockPlaceIDList[colorPlace[3]] = 12;
			break;
		case 5:
			blockPlaceIDList[colorPlace[3]] = 37;
			break;
		case 6:
			blockPlaceIDList[colorPlace[3]] = 39;
			break;
		case 7:
			blockPlaceIDList[colorPlace[3]] = 41;
			break;
		case 8:
			blockPlaceIDList[colorPlace[3]] = 43;
			break;
		case 9:
			blockPlaceIDList[colorPlace[3]] = 74;
			break;
		case 10:
			blockPlaceIDList[colorPlace[3]] = 78;
			break;
		case 11:
			blockPlaceIDList[colorPlace[3]] = 82;
			break;
		case 12:
			blockPlaceIDList[colorPlace[3]] = 86;
			break;
		case 13:
			blockPlaceIDList[colorPlace[3]] = 111;
			break;
		case 14:
			blockPlaceIDList[colorPlace[3]] = 115;
			break;
		case 15:
			blockPlaceIDList[colorPlace[3]] = 119;
			break;
		case 16:
			blockPlaceIDList[colorPlace[3]] = 123;
			break;
		}
		powerID = n;
	}

	public static List<Vertex> getConnectionVertex(int pointID){
		List<Vertex> list = new ArrayList<Vertex>();
		if(connectionList.containsKey(pointID)){
			Iterator<Vertex> iterV = connectionList.get(pointID).keySet().iterator();
			while(iterV.hasNext()){
				list.add(iterV.next());
			}
		}
		else{
		}
		return list;
	}

	public static List<Path> getConnectionPath(int pointID){
		List<Path> list = new ArrayList<Path>();
		if(connectionList.containsKey(pointID)){
			Iterator<Path> iterP = connectionList.get(pointID).values().iterator();
			while(iterP.hasNext()){
				list.add(iterP.next());
			}
		}
		else{
		}
		return list;
	}

	public static Path getConnectionPath(int pointID1,int pointID2){
		if((connectionList.containsKey(pointID1) &&(connectionList.get(pointID1).containsKey((Vertex)getPointObject(pointID2))))){
			return connectionList.get(pointID1).get((Vertex)getPointObject(pointID2));
		}
		else{
			return null;
		}
	}

	public static Object getPointObject(int pointID){
		return pointList.get(pointID);
	}

	public static int[] getBlockPlaceIDList() {
		int[] list = (int[])blockPlaceIDList.clone();
		return list;
	}

	public static void setBlockPlaceIDList(int redID,int greenID,int blueID,int yellowID) {
		BlockArrangeInfo.blockPlaceIDList[0] = redID;
		BlockArrangeInfo.blockPlaceIDList[1] = greenID;
		BlockArrangeInfo.blockPlaceIDList[2] = blueID;
		BlockArrangeInfo.blockPlaceIDList[3] = yellowID;
	}

	public static Map<Integer, Map<Vertex, Path>> getConnectionList() {
		return connectionList;
	}
	
	public static List<BlockPlace> getBlockPlaceList()
	{
		return blockPlaceList;
	}
	//setConnectionListはバグの元になりそうなので作らない
	
	public static int getPowerID()
	{
		return powerID;
	}
}