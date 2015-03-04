package WebAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.parser.ParseException;

import DotaData.HeroMapping;
import GameInfo.GameData;
import GameTracker.Config;
import Parse.JsonParser;

public class API {
	
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
	 * Will not localize names (Only returned in English ATM)
	 * 
	 */
	public static HeroMapping getHeroMapping() throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1?key=" + Config.API_KEY;
		return JsonParser.parseHeroes(hitAPI(apiCall));
	}
	
	public static String get64BitUName(String steamUserName) throws IOException, ParseException {
		String apiCall = "http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=" + 
				Config.API_KEY + "&vanityurl=" + steamUserName.toLowerCase();
		return JsonParser.parseVanityURL(hitAPI(apiCall));
	}

	public static String getLastMatchID(String user32BitID) throws IOException, ParseException {
		String apiCall = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1?key=" + 
				Config.API_KEY + "&account_id=" + user32BitID + "&matches_requested=1";
		return JsonParser.parseLastMatchID(hitAPI(apiCall));
	}

	public static GameData getMatchDetails(String matchID) throws ParseException, IOException {
		String apiCall = "http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1?key=" +
				Config.API_KEY + "&match_id=" + matchID;
		return JsonParser.parseMatch(hitAPI(apiCall));
	}

	// Conversions for the user names
	public static String convert32To64(String user32Bit) {
		return (new BigInteger(user32Bit)).add(new BigInteger("76561197960265728")).toString();
	}
	public static String convert64To32(String user64Bit) {
		return (new BigInteger(user64Bit)).subtract(new BigInteger("76561197960265728")).toString();
	}

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

		return ret;
	}

}
