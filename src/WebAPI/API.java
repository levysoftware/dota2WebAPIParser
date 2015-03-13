package WebAPI;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import org.json.simple.parser.ParseException;

import DotaData.AbilityMapping;
import DotaData.HeroMapping;
import DotaData.ItemMapping;
import GameInfo.GameData;
import GameTracker.Config;
import Matches.MatchHistory;
import Parse.JsonParser;
import StoredData.PictureSize;

public class API {
	
	private static JsonParser parser = new JsonParser();
	
	private static int timesWebAPIHit = 0;
	
	/**
	 * 
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static ItemMapping getItemMapping() throws ParseException, IOException {
		return parser.parseItems();
	}
	
	/**
	 * 
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static AbilityMapping getAbilityMapping() throws ParseException, IOException {
		return parser.parseAbilities();
	}
	
	/**
	 * 
	 * @param heroName
	 * @param pictureSize
	 * @return
	 */
	public static String getHeroImage(String heroName, int pictureSize) {
		String suffix;

		if(pictureSize > 0 && pictureSize < PictureSize.SUFFIXES.length) {
			suffix = PictureSize.SUFFIXES[pictureSize];
		} else {
			suffix = PictureSize.SUFFIXES[PictureSize.SMALL];
		}

		String apiCall = "http://cdn.dota2.com/apps/dota2/images/heroes/" + HeroMapping.getHeroNameShort(heroName) + "_" + suffix;
		return apiCall;
	}
	
	/**
	 * 
	 * @param itemName
	 * @return
	 */
	public static String getItemImage(String itemName) {
		String suffix;

		suffix = PictureSize.SUFFIXES[PictureSize.ITEM];

		String apiCall = "http://cdn.dota2.com/apps/dota2/images/items/" + itemName + "_" + suffix;
		return apiCall;
	}
	
	/**
	 * 
	 * Will not localize names (Only returned in English At The Moment)
	 * 
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static HeroMapping getHeroMapping() throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1?key=" + Config.API_KEY;
		return parser.parseHeroes(hitAPI(apiCall));
	}

	/**
	 * 
	 * @param steamUserName
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static String get32BitUName(String steamUserName) throws IOException, ParseException {
		return convert64To32(get64BitUName(steamUserName));
	}
	/**
	 * 
	 * @param steamUserName
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static String get64BitUName(String steamUserName) throws IOException, ParseException {
		String apiCall = "http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=" + 
				Config.API_KEY + "&vanityurl=" + steamUserName.toLowerCase();
		return parser.parseVanityURL(hitAPI(apiCall));
	}
	
	/**
	 * 
	 * @param user32BitID
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesByUser(String user32BitID) throws ParseException, IOException {
		return getMatchesByUser(user32BitID, 25);
	}
	/**
	 * 
	 * @param user32BitID
	 * @param numberOfMatches
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesByUser(String user32BitID, int numberOfMatches) throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1?account_id=" + user32BitID +
				"&matches_requested=" + numberOfMatches + "&key=" + Config.API_KEY;
		return parser.parseMatchHistory(hitAPI(apiCall));
	}
	
	/**
	 * 
	 * @param leagueId
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesByLeagueID(String leagueId) throws ParseException, IOException {
		return getMatchesByLeagueID(leagueId, 25);
	}
	/**
	 * 
	 * @param leagueId
	 * @param numberOfMatches
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesByLeagueID(String leagueId, int numberOfMatches) throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1?league_id=" + leagueId +
				"&matches_requested=" + numberOfMatches + "&key=" + Config.API_KEY;
		return parser.parseMatchHistory(hitAPI(apiCall));
	}
	
	/**
	 * 
	 * @param skillLevel
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesBySkill(int skillLevel) throws ParseException, IOException {
		return getMatchesBySkill(skillLevel, 25);
	}
	/**
	 * 
	 * @param skillLevel
	 * @param numberOfMatches
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesBySkill(int skillLevel, int numberOfMatches) throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1?skill=" + skillLevel +
				"&matches_requested=" + numberOfMatches + "&key=" + Config.API_KEY;
		return parser.parseMatchHistory(hitAPI(apiCall));
	}
	
	/**
	 * 
	 * @param heroId
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesByHeroID(int heroId) throws ParseException, IOException {
		return getMatchesByHeroID(heroId, 25);
	}
	/**
	 * 
	 * @param heroId
	 * @param numberOfMatches
	 * @return MatchHistory
	 * @throws ParseException
	 * @throws IOException
	 */
	public static MatchHistory getMatchesByHeroID(int heroId, int numberOfMatches) throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1?hero_id=" + heroId +
				"&matches_requested=" + numberOfMatches + "&key=" + Config.API_KEY;
		return parser.parseMatchHistory(hitAPI(apiCall));
	}
	
	/**
	 * 
	 * @param matchID
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static GameData getMatchDetails(long matchID) throws ParseException, IOException {
		return getMatchDetails(Long.toString(matchID));
	}
	/**
	 * 
	 * @param matchID
	 * @return GameData
	 * @throws ParseException
	 * @throws IOException
	 */
	public static GameData getMatchDetails(String matchID) throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1?key=" +
				Config.API_KEY + "&match_id=" + matchID;
		return parser.parseMatch(hitAPI(apiCall));
	}
	
	/////////////////////////// Conversions for the user names ///////////////////////////
	/**
	 * 
	 * @param user32Bit
	 * @return
	 */
	public static String convert32To64(String user32Bit) {
		return (new BigInteger(user32Bit)).add(new BigInteger("76561197960265728")).toString();
	}
	/**
	 * 
	 * @param user64Bit
	 * @return
	 */
	public static String convert64To32(String user64Bit) {
		return (new BigInteger(user64Bit)).subtract(new BigInteger("76561197960265728")).toString();
	}
	
	public static int getTimesWebAPIhit() { return timesWebAPIHit; }
	public static void resetWebAPIHitCounter() { timesWebAPIHit = 0; }
	
	// Request the webpage API
	private static String hitAPI(String apiMethod) throws IOException {
		URL url = new URL(apiMethod);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		// int responseCode = con.getResponseCode();
		// IO.log(apiMethod + " returned response code " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String line;
		String ret = "";

		while((line = in.readLine()) != null) {
			ret += line;
		}
		
		timesWebAPIHit++;
		
		return ret;
	}

	public static BufferedImage getPictureFromURL(String urlString) throws IOException {
		BufferedImage image = null;

		URL url = new URL(urlString);
		image = ImageIO.read(url);

		return image;
	}

}
