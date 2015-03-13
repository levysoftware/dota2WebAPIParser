package Demos;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import DotaData.HeroMapping;
import GameTracker.IO;
import StoredData.PictureSize;
import WebAPI.API;

public class DemoHeroData {

	/**
	 * 
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, IOException {
		HeroMapping heroes = API.getHeroMapping();

		// Cycle through all heroes
		for(int i = 0; i <= heroes.getHighestHeroID(); i++) {
			IO.log("Hero ID: " + i + "\tHero Name: " + heroes.getHeroName(i));
		}

		IO.log(API.getHeroImage(heroes.getHeroName(10), PictureSize.LARGE));	
	}

}
