package com.EndoxinGames.engine.localization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.EndoxinGames.engine.exceptions.LocalizationNotPresentException;
import com.EndoxinGames.engine.exceptions.LocalizionNotInitializedException;

public class Localization {
	public static String language;
	public static HashMap<String, String> languages = new HashMap<String, String>();
	public static HashMap<String, String[]> localization = new HashMap<String, String[]>();

	public static void init(String language) throws FileNotFoundException {
		try {
			languages = populateRoster();
		} catch (FileNotFoundException e) {

		}
		System.out.println("Language set to " + language);
		Localization.language = language;
		if (languages.containsKey(language)) {
			File file = new File("assets/localizations/" + languages.get(language) + ".lang");
			if (!file.canRead()) {
				System.out.println("File not found");
				return;
			}
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(file));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					String[] data = line.split(" ");
					String[] data2 = { data[1], data[2], data[3] };
					localization.put(data[0], data2);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static HashMap<String, String> populateRoster()
			throws FileNotFoundException {
		File file = new File("assets/localizations/languages.txt");
		HashMap<String, String> roster = new HashMap<String, String>();
		if (!file.canRead()) {
			System.out.println("File not found");
			throw new FileNotFoundException();
		} else {
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(file));
			String line;
			Integer i = 1;
			try {
				while ((line = br.readLine()) != null) {
					String[] data = line.split(":");
					roster.put(data[0], data[1]);
					i++;
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return roster;
	}

	public static String localize(String stringToLocalize, int capitalization)
			throws LocalizionNotInitializedException,
			LocalizationNotPresentException {
		if (language != null) {
			String localizedString = localization.get(stringToLocalize)[capitalization];
			return localizedString;
		}
		throw new LocalizionNotInitializedException();
	}
}
