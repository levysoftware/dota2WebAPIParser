package GameTracker;

import java.io.IOException;
import java.util.Iterator;

import org.json.simple.parser.ParseException;

import GameInfo.Ability;
import GameInfo.GameData;
import GameInfo.PlayerData;
import Parse.JsonParser;
import WebAPI.API;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		//String uname64bit = API.get64BitUName("TheLevite");
		//String matchId = API.getLastMatchID(API.convert64To32(uname64bit));
		GameData data = API.getMatchDetails("1280737746");
		//String matchData = "{	\"result\": {		\"players\": [			{				\"account_id\": 125613406,				\"player_slot\": 0,				\"hero_id\": 81,				\"item_0\": 108,				\"item_1\": 63,				\"item_2\": 156,				\"item_3\": 151,				\"item_4\": 116,				\"item_5\": 114,				\"kills\": 8,				\"deaths\": 6,				\"assists\": 17,				\"leaver_status\": 0,				\"gold\": 3769,				\"last_hits\": 302,				\"denies\": 2,				\"gold_per_min\": 606,				\"xp_per_min\": 660,				\"gold_spent\": 25675,				\"hero_damage\": 11419,				\"tower_damage\": 9525,				\"hero_healing\": 0,				\"level\": 25,				\"ability_upgrades\": [					{						\"ability\": 5396,						\"time\": 558,						\"level\": 1					},					{						\"ability\": 5115,						\"time\": 597,						\"level\": 2					},					{						\"ability\": 5395,						\"time\": 689,						\"level\": 3					},					{						\"ability\": 5395,						\"time\": 782,						\"level\": 4					},					{						\"ability\": 5396,						\"time\": 932,						\"level\": 5					},					{						\"ability\": 5109,						\"time\": 1149,						\"level\": 6					},					{						\"ability\": 5395,						\"time\": 1398,						\"level\": 7					},					{						\"ability\": 5395,						\"time\": 1430,						\"level\": 8					},					{						\"ability\": 5115,						\"time\": 1538,						\"level\": 9					},					{						\"ability\": 5396,						\"time\": 1656,						\"level\": 10					},					{						\"ability\": 5109,						\"time\": 1711,						\"level\": 11					},					{						\"ability\": 5115,						\"time\": 1875,						\"level\": 12					},					{						\"ability\": 5396,						\"time\": 1966,						\"level\": 13					},					{						\"ability\": 5115,						\"time\": 2087,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2100,						\"level\": 15					},					{						\"ability\": 5109,						\"time\": 2229,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2331,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 2400,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 2670,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 2754,						\"level\": 20					},					{						\"ability\": 5002,						\"time\": 2782,						\"level\": 21					},					{						\"ability\": 5002,						\"time\": 2961,						\"level\": 22					},					{						\"ability\": 5002,						\"time\": 3023,						\"level\": 23					},					{						\"ability\": 5002,						\"time\": 3152,						\"level\": 24					},					{						\"ability\": 5002,						\"time\": 3175,						\"level\": 25					}				]							},			{				\"account_id\": 88520219,				\"player_slot\": 1,				\"hero_id\": 63,				\"item_0\": 41,				\"item_1\": 178,				\"item_2\": 48,				\"item_3\": 123,				\"item_4\": 168,				\"item_5\": 0,				\"kills\": 4,				\"deaths\": 11,				\"assists\": 9,				\"leaver_status\": 0,				\"gold\": 1621,				\"last_hits\": 150,				\"denies\": 2,				\"gold_per_min\": 361,				\"xp_per_min\": 444,				\"gold_spent\": 15525,				\"hero_damage\": 9031,				\"tower_damage\": 525,				\"hero_healing\": 0,				\"level\": 20,				\"ability_upgrades\": [					{						\"ability\": 5150,						\"time\": 518,						\"level\": 1					},					{						\"ability\": 5163,						\"time\": 563,						\"level\": 2					},					{						\"ability\": 5150,						\"time\": 661,						\"level\": 3					},					{						\"ability\": 5163,						\"time\": 724,						\"level\": 4					},					{						\"ability\": 5150,						\"time\": 794,						\"level\": 5					},					{						\"ability\": 5040,						\"time\": 940,						\"level\": 6					},					{						\"ability\": 5040,						\"time\": 1038,						\"level\": 7					},					{						\"ability\": 5150,						\"time\": 1116,						\"level\": 8					},					{						\"ability\": 5153,						\"time\": 1261,						\"level\": 9					},					{						\"ability\": 5040,						\"time\": 1468,						\"level\": 10					},					{						\"ability\": 5040,						\"time\": 1711,						\"level\": 11					},					{						\"ability\": 5163,						\"time\": 1964,						\"level\": 12					},					{						\"ability\": 5163,						\"time\": 2094,						\"level\": 13					},					{						\"ability\": 5153,						\"time\": 2240,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2436,						\"level\": 15					},					{						\"ability\": 5002,						\"time\": 2606,						\"level\": 16					},					{						\"ability\": 5153,						\"time\": 2981,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 3169,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 3261,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 3507,						\"level\": 20					}				]							},			{				\"account_id\": 4294967295,				\"player_slot\": 2,				\"hero_id\": 19,				\"item_0\": 112,				\"item_1\": 125,				\"item_2\": 8,				\"item_3\": 63,				\"item_4\": 81,				\"item_5\": 0,				\"kills\": 7,				\"deaths\": 16,				\"assists\": 13,				\"leaver_status\": 0,				\"gold\": 723,				\"last_hits\": 112,				\"denies\": 0,				\"gold_per_min\": 377,				\"xp_per_min\": 475,				\"gold_spent\": 15100,				\"hero_damage\": 9819,				\"tower_damage\": 980,				\"hero_healing\": 78,				\"level\": 21,				\"ability_upgrades\": [					{						\"ability\": 5017,						\"time\": 437,						\"level\": 1					},					{						\"ability\": 5397,						\"time\": 607,						\"level\": 2					},					{						\"ability\": 5397,						\"time\": 689,						\"level\": 3					},					{						\"ability\": 5506,						\"time\": 791,						\"level\": 4					},					{						\"ability\": 5397,						\"time\": 865,						\"level\": 5					},					{						\"ability\": 5117,						\"time\": 1004,						\"level\": 6					},					{						\"ability\": 5397,						\"time\": 1190,						\"level\": 7					},					{						\"ability\": 5017,						\"time\": 1268,						\"level\": 8					},					{						\"ability\": 5017,						\"time\": 1515,						\"level\": 9					},					{						\"ability\": 5017,						\"time\": 1549,						\"level\": 10					},					{						\"ability\": 5117,						\"time\": 1968,						\"level\": 11					},					{						\"ability\": 5506,						\"time\": 2269,						\"level\": 12					},					{						\"ability\": 5506,						\"time\": 2376,						\"level\": 13					},					{						\"ability\": 5506,						\"time\": 2587,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2588,						\"level\": 15					},					{						\"ability\": 5117,						\"time\": 2754,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2858,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 3004,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 3406,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 3485,						\"level\": 20					}				]							},			{				\"account_id\": 95584364,				\"player_slot\": 3,				\"hero_id\": 56,				\"item_0\": 98,				\"item_1\": 156,				\"item_2\": 63,				\"item_3\": 141,				\"item_4\": 160,				\"item_5\": 212,				\"kills\": 19,				\"deaths\": 6,				\"assists\": 20,				\"leaver_status\": 0,				\"gold\": 1957,				\"last_hits\": 193,				\"denies\": 2,				\"gold_per_min\": 580,				\"xp_per_min\": 648,				\"gold_spent\": 25285,				\"hero_damage\": 22216,				\"tower_damage\": 4395,				\"hero_healing\": 325,				\"level\": 25,				\"ability_upgrades\": [					{						\"ability\": 5106,						\"time\": 512,						\"level\": 1					},					{						\"ability\": 5015,						\"time\": 605,						\"level\": 2					},					{						\"ability\": 5261,						\"time\": 674,						\"level\": 3					},					{						\"ability\": 5106,						\"time\": 830,						\"level\": 4					},					{						\"ability\": 5106,						\"time\": 980,						\"level\": 5					},					{						\"ability\": 5262,						\"time\": 1039,						\"level\": 6					},					{						\"ability\": 5106,						\"time\": 1165,						\"level\": 7					},					{						\"ability\": 5261,						\"time\": 1191,						\"level\": 8					},					{						\"ability\": 5261,						\"time\": 1250,						\"level\": 9					},					{						\"ability\": 5261,						\"time\": 1428,						\"level\": 10					},					{						\"ability\": 5262,						\"time\": 1511,						\"level\": 11					},					{						\"ability\": 5015,						\"time\": 1662,						\"level\": 12					},					{						\"ability\": 5015,						\"time\": 1699,						\"level\": 13					},					{						\"ability\": 5002,						\"time\": 1807,						\"level\": 14					},					{						\"ability\": 5015,						\"time\": 1908,						\"level\": 15					},					{						\"ability\": 5262,						\"time\": 2039,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2103,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 2343,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 2405,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 2616,						\"level\": 20					},					{						\"ability\": 5002,						\"time\": 2754,						\"level\": 21					},					{						\"ability\": 5002,						\"time\": 2769,						\"level\": 22					},					{						\"ability\": 5002,						\"time\": 2878,						\"level\": 23					},					{						\"ability\": 5002,						\"time\": 2914,						\"level\": 24					},					{						\"ability\": 5002,						\"time\": 2980,						\"level\": 25					}				]							},			{				\"account_id\": 4294967295,				\"player_slot\": 4,				\"hero_id\": 37,				\"item_0\": 98,				\"item_1\": 180,				\"item_2\": 108,				\"item_3\": 141,				\"item_4\": 61,				\"item_5\": 60,				\"kills\": 16,				\"deaths\": 8,				\"assists\": 17,				\"leaver_status\": 0,				\"gold\": 2139,				\"last_hits\": 108,				\"denies\": 2,				\"gold_per_min\": 438,				\"xp_per_min\": 651,				\"gold_spent\": 19800,				\"hero_damage\": 25068,				\"tower_damage\": 720,				\"hero_healing\": 0,				\"level\": 25,				\"ability_upgrades\": [					{						\"ability\": 5504,						\"time\": 433,						\"level\": 1					},					{						\"ability\": 5290,						\"time\": 593,						\"level\": 2					},					{						\"ability\": 5041,						\"time\": 684,						\"level\": 3					},					{						\"ability\": 5504,						\"time\": 750,						\"level\": 4					},					{						\"ability\": 5041,						\"time\": 859,						\"level\": 5					},					{						\"ability\": 5043,						\"time\": 953,						\"level\": 6					},					{						\"ability\": 5290,						\"time\": 1025,						\"level\": 7					},					{						\"ability\": 5041,						\"time\": 1076,						\"level\": 8					},					{						\"ability\": 5041,						\"time\": 1202,						\"level\": 9					},					{						\"ability\": 5290,						\"time\": 1429,						\"level\": 10					},					{						\"ability\": 5290,						\"time\": 1509,						\"level\": 11					},					{						\"ability\": 5043,						\"time\": 1730,						\"level\": 12					},					{						\"ability\": 5504,						\"time\": 1730,						\"level\": 13					},					{						\"ability\": 5504,						\"time\": 1809,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 1898,						\"level\": 15					},					{						\"ability\": 5043,						\"time\": 1969,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2036,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 2317,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 2614,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 2741,						\"level\": 20					},					{						\"ability\": 5002,						\"time\": 2827,						\"level\": 21					},					{						\"ability\": 5002,						\"time\": 3181,						\"level\": 22					},					{						\"ability\": 5002,						\"time\": 3183,						\"level\": 23					},					{						\"ability\": 5002,						\"time\": 3351,						\"level\": 24					},					{						\"ability\": 5002,						\"time\": 3485,						\"level\": 25					}				]							},			{				\"account_id\": 4294967295,				\"player_slot\": 128,				\"hero_id\": 85,				\"item_0\": 50,				\"item_1\": 147,				\"item_2\": 0,				\"item_3\": 81,				\"item_4\": 145,				\"item_5\": 0,				\"kills\": 14,				\"deaths\": 15,				\"assists\": 9,				\"leaver_status\": 0,				\"gold\": 1637,				\"last_hits\": 127,				\"denies\": 7,				\"gold_per_min\": 431,				\"xp_per_min\": 655,				\"gold_spent\": 15260,				\"hero_damage\": 16690,				\"tower_damage\": 587,				\"hero_healing\": 580,				\"level\": 25,				\"ability_upgrades\": [					{						\"ability\": 5442,						\"time\": 443,						\"level\": 1					},					{						\"ability\": 5042,						\"time\": 609,						\"level\": 2					},					{						\"ability\": 5427,						\"time\": 701,						\"level\": 3					},					{						\"ability\": 5042,						\"time\": 805,						\"level\": 4					},					{						\"ability\": 5427,						\"time\": 923,						\"level\": 5					},					{						\"ability\": 5429,						\"time\": 1079,						\"level\": 6					},					{						\"ability\": 5442,						\"time\": 1139,						\"level\": 7					},					{						\"ability\": 5442,						\"time\": 1241,						\"level\": 8					},					{						\"ability\": 5042,						\"time\": 1350,						\"level\": 9					},					{						\"ability\": 5042,						\"time\": 1441,						\"level\": 10					},					{						\"ability\": 5429,						\"time\": 1637,						\"level\": 11					},					{						\"ability\": 5442,						\"time\": 1886,						\"level\": 12					},					{						\"ability\": 5427,						\"time\": 1893,						\"level\": 13					},					{						\"ability\": 5427,						\"time\": 1963,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2087,						\"level\": 15					},					{						\"ability\": 5429,						\"time\": 2267,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2482,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 2531,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 2618,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 2712,						\"level\": 20					},					{						\"ability\": 5002,						\"time\": 2864,						\"level\": 21					},					{						\"ability\": 5002,						\"time\": 2864,						\"level\": 22					},					{						\"ability\": 5002,						\"time\": 2902,						\"level\": 23					},					{						\"ability\": 5002,						\"time\": 3121,						\"level\": 24					},					{						\"ability\": 5002,						\"time\": 3273,						\"level\": 25					}				]							},			{				\"account_id\": 60827879,				\"player_slot\": 129,				\"hero_id\": 28,				\"item_0\": 152,				\"item_1\": 55,				\"item_2\": 63,				\"item_3\": 1,				\"item_4\": 41,				\"item_5\": 164,				\"kills\": 9,				\"deaths\": 9,				\"assists\": 11,				\"leaver_status\": 0,				\"gold\": 781,				\"last_hits\": 92,				\"denies\": 0,				\"gold_per_min\": 352,				\"xp_per_min\": 488,				\"gold_spent\": 14860,				\"hero_damage\": 15300,				\"tower_damage\": 1155,				\"hero_healing\": 0,				\"level\": 21,				\"ability_upgrades\": [					{						\"ability\": 5260,						\"time\": 436,						\"level\": 1					},					{						\"ability\": 5107,						\"time\": 571,						\"level\": 2					},					{						\"ability\": 5260,						\"time\": 593,						\"level\": 3					},					{						\"ability\": 5016,						\"time\": 631,						\"level\": 4					},					{						\"ability\": 5260,						\"time\": 736,						\"level\": 5					},					{						\"ability\": 5018,						\"time\": 847,						\"level\": 6					},					{						\"ability\": 5016,						\"time\": 897,						\"level\": 7					},					{						\"ability\": 5016,						\"time\": 1007,						\"level\": 8					},					{						\"ability\": 5016,						\"time\": 1143,						\"level\": 9					},					{						\"ability\": 5107,						\"time\": 1303,						\"level\": 10					},					{						\"ability\": 5107,						\"time\": 1385,						\"level\": 11					},					{						\"ability\": 5018,						\"time\": 1614,						\"level\": 12					},					{						\"ability\": 5107,						\"time\": 1888,						\"level\": 13					},					{						\"ability\": 5260,						\"time\": 2134,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2258,						\"level\": 15					},					{						\"ability\": 5018,						\"time\": 2503,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2532,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 2706,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 2751,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 3115,						\"level\": 20					},					{						\"ability\": 5002,						\"time\": 3272,						\"level\": 21					}				]							},			{				\"account_id\": 155088917,				\"player_slot\": 130,				\"hero_id\": 25,				\"item_0\": 108,				\"item_1\": 29,				\"item_2\": 69,				\"item_3\": 43,				\"item_4\": 24,				\"item_5\": 40,				\"kills\": 4,				\"deaths\": 15,				\"assists\": 17,				\"leaver_status\": 0,				\"gold\": 427,				\"last_hits\": 73,				\"denies\": 1,				\"gold_per_min\": 277,				\"xp_per_min\": 341,				\"gold_spent\": 10550,				\"hero_damage\": 9615,				\"tower_damage\": 720,				\"hero_healing\": 0,				\"level\": 18,				\"ability_upgrades\": [					{						\"ability\": 5426,						\"time\": 443,						\"level\": 1					},					{						\"ability\": 5291,						\"time\": 616,						\"level\": 2					},					{						\"ability\": 5426,						\"time\": 701,						\"level\": 3					},					{						\"ability\": 5444,						\"time\": 803,						\"level\": 4					},					{						\"ability\": 5291,						\"time\": 933,						\"level\": 5					},					{						\"ability\": 5165,						\"time\": 1023,						\"level\": 6					},					{						\"ability\": 5291,						\"time\": 1191,						\"level\": 7					},					{						\"ability\": 5444,						\"time\": 1390,						\"level\": 8					},					{						\"ability\": 5291,						\"time\": 1585,						\"level\": 9					},					{						\"ability\": 5444,						\"time\": 1886,						\"level\": 10					},					{						\"ability\": 5165,						\"time\": 2010,						\"level\": 11					},					{						\"ability\": 5444,						\"time\": 2488,						\"level\": 12					},					{						\"ability\": 5426,						\"time\": 2510,						\"level\": 13					},					{						\"ability\": 5426,						\"time\": 2588,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2592,						\"level\": 15					},					{						\"ability\": 5165,						\"time\": 2876,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 3305,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 3458,						\"level\": 18					}				]							},			{				\"account_id\": 85908570,				\"player_slot\": 131,				\"hero_id\": 4,				\"item_0\": 63,				\"item_1\": 116,				\"item_2\": 127,				\"item_3\": 26,				\"item_4\": 154,				\"item_5\": 0,				\"kills\": 12,				\"deaths\": 10,				\"assists\": 10,				\"leaver_status\": 0,				\"gold\": 1126,				\"last_hits\": 91,				\"denies\": 0,				\"gold_per_min\": 360,				\"xp_per_min\": 507,				\"gold_spent\": 14335,				\"hero_damage\": 9398,				\"tower_damage\": 1531,				\"hero_healing\": 0,				\"level\": 22,				\"ability_upgrades\": [					{						\"ability\": 5505,						\"time\": 436,						\"level\": 1					},					{						\"ability\": 5116,						\"time\": 641,						\"level\": 2					},					{						\"ability\": 5116,						\"time\": 707,						\"level\": 3					},					{						\"ability\": 5505,						\"time\": 803,						\"level\": 4					},					{						\"ability\": 5259,						\"time\": 938,						\"level\": 5					},					{						\"ability\": 5398,						\"time\": 1008,						\"level\": 6					},					{						\"ability\": 5116,						\"time\": 1041,						\"level\": 7					},					{						\"ability\": 5116,						\"time\": 1237,						\"level\": 8					},					{						\"ability\": 5505,						\"time\": 1295,						\"level\": 9					},					{						\"ability\": 5505,						\"time\": 1366,						\"level\": 10					},					{						\"ability\": 5398,						\"time\": 1632,						\"level\": 11					},					{						\"ability\": 5259,						\"time\": 1894,						\"level\": 12					},					{						\"ability\": 5259,						\"time\": 1956,						\"level\": 13					},					{						\"ability\": 5259,						\"time\": 2124,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2125,						\"level\": 15					},					{						\"ability\": 5398,						\"time\": 2252,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2518,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 2519,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 2929,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 3276,						\"level\": 20					},					{						\"ability\": 5002,						\"time\": 3276,						\"level\": 21					},					{						\"ability\": 5002,						\"time\": 3455,						\"level\": 22					}				]							},			{				\"account_id\": 4294967295,				\"player_slot\": 132,				\"hero_id\": 77,				\"item_0\": 194,				\"item_1\": 55,				\"item_2\": 63,				\"item_3\": 81,				\"item_4\": 135,				\"item_5\": 0,				\"kills\": 6,				\"deaths\": 8,				\"assists\": 10,				\"leaver_status\": 0,				\"gold\": 269,				\"last_hits\": 196,				\"denies\": 2,				\"gold_per_min\": 406,				\"xp_per_min\": 528,				\"gold_spent\": 18260,				\"hero_damage\": 14023,				\"tower_damage\": 1219,				\"hero_healing\": 859,				\"level\": 22,				\"ability_upgrades\": [					{						\"ability\": 5151,						\"time\": 434,						\"level\": 1					},					{						\"ability\": 5108,						\"time\": 611,						\"level\": 2					},					{						\"ability\": 5428,						\"time\": 699,						\"level\": 3					},					{						\"ability\": 5151,						\"time\": 806,						\"level\": 4					},					{						\"ability\": 5151,						\"time\": 985,						\"level\": 5					},					{						\"ability\": 5447,						\"time\": 1034,						\"level\": 6					},					{						\"ability\": 5151,						\"time\": 1088,						\"level\": 7					},					{						\"ability\": 5108,						\"time\": 1180,						\"level\": 8					},					{						\"ability\": 5108,						\"time\": 1397,						\"level\": 9					},					{						\"ability\": 5108,						\"time\": 1548,						\"level\": 10					},					{						\"ability\": 5447,						\"time\": 1594,						\"level\": 11					},					{						\"ability\": 5428,						\"time\": 1848,						\"level\": 12					},					{						\"ability\": 5428,						\"time\": 1920,						\"level\": 13					},					{						\"ability\": 5428,						\"time\": 2147,						\"level\": 14					},					{						\"ability\": 5002,						\"time\": 2272,						\"level\": 15					},					{						\"ability\": 5447,						\"time\": 2465,						\"level\": 16					},					{						\"ability\": 5002,						\"time\": 2521,						\"level\": 17					},					{						\"ability\": 5002,						\"time\": 2782,						\"level\": 18					},					{						\"ability\": 5002,						\"time\": 2804,						\"level\": 19					},					{						\"ability\": 5002,						\"time\": 3130,						\"level\": 20					},					{						\"ability\": 5002,						\"time\": 3299,						\"level\": 21					},					{						\"ability\": 5002,						\"time\": 3390,						\"level\": 22					}				]							}		]		,		\"radiant_win\": true,		\"duration\": 2998,		\"start_time\": 1424553173,		\"match_id\": 1261825070,		\"match_seq_num\": 1131429106,		\"tower_status_radiant\": 1798,		\"tower_status_dire\": 0,		\"barracks_status_radiant\": 51,		\"barracks_status_dire\": 0,		\"cluster\": 124,		\"first_blood_time\": 62,		\"lobby_type\": 0,		\"human_players\": 10,		\"leagueid\": 0,		\"positive_votes\": 0,		\"negative_votes\": 0,		\"game_mode\": 18	}}";
		//GameData data = JsonParser.parseMatch(matchData);

		// Game Data
		IO.log("Lobby ID: " + data.getMatchID());
		IO.log("Lobby Type: " + data.getLobbyType());
		IO.log("Game Mode: " + data.getGameMode());
		IO.log("Number Of Human Players: " + data.getNumHumanPlayers());
		IO.log("Number of Positive Votes: " + data.getPosVotes());
		IO.log("Number of Negative Votes: " + data.getNegVotes());
		IO.log("Dire Barracks Status: " + data.getDireBarracksStatus());
		IO.log("Dire Tower Status: " + data.getDireTowerStatus());
		IO.log("Radiant Barracks Status: " + data.getRadiantBarracksStatus());
		IO.log("Radiant Tower Status: " + data.getRadiantTowerStatus());
		IO.log("First Blood Time: " + data.getFirstBloodTime());
		IO.log("Did Radiant Win?: " + data.isRadiantWinner());
		IO.log("Match Length: " + data.getMatchDurationStr());
		
		// Player Data
		while(data.hasNextPlayer()) {
			PlayerData p = data.getNextPlayer();
			IO.log("\n");
			IO.log("Account ID: " + p.getAccountID());
			IO.log("Kills: " + p.getKills());
			IO.log("Deaths: " + p.getDeaths());
			IO.log("Assists: " + p.getAssists());
			IO.log("Last Hits: " + p.getLastHits());
			IO.log("Denies: " + p.getDenies());
			IO.log("Gold: " + p.getGold());
			IO.log("Gold Spent: " + p.getGoldSpent());
			IO.log("GPM: " + p.getGPM());
			IO.log("XPM: " + p.getXPM());
			IO.log("Hero Damage: " + p.getHeroDamage());
			IO.log("Hero Healing: " + p.getHeroHealing());
			IO.log("Tower Damage: " + p.getTowerDamage());
			IO.log("Hero Level: " + p.getLevel());
			IO.log("Player Slot: " + p.getPlayerSlot());
			for(long item : p.getItems()) {
				IO.log("Item ID: " + item);
			}
			for(Ability ability : p.getAbilities()) {
				//IO.log("Ability: " + ability.getAbilityID() + " " + ability.getPlayerLevel());
			}
		}
	}

}
