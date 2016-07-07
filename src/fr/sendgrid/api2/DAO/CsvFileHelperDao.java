package fr.sendgrid.api2.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHelperDao {

	public static List<String> readFile(File file) throws IOException {
		List<String> result = new ArrayList<String>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		for(String line = br.readLine() ; line != null ; line = br.readLine()) {
			result.add(line);
		}
		br.close();
		fr.close();
		return result;
	}

	//// Recherche et récupération d'une ressource sur le disque dur
	// public static String getRessourcePath(String fileName) {
	// final File f = new File (fileName);
	// final String dossierPath = f.getAbsolutePath() + File.separator +
	//// fileName;
	// return dossierPath;
	// }

	public static File getRessource(String fileName) {
		File file = new File(fileName);
		return file;
	}

	public static String cleanKey(String key) {
		String cleanKey = key.toLowerCase();
		return cleanKey;
	}
}
