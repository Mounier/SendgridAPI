//package fr.sendgrid.api2.DAO;
//
//import java.awt.List;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import fr.sendgrid.api2.domain.CsvFileHelper;
//
//public class CsvFileService implements CsvFile{
//	List<String>lines=new List();
//	
//	public CsvFileService() {
//		super();
//	}
//	
//	public void init() throws IOException{
//		lines = CsvFileHelper.readFile(file);
//		data = new ArrayList<String[] >(lines.size());
//		String separator = new Character(SEPARATOR).toString();
//		boolean first=true;
//		
//		for(String line : lines) {
////			suppression des espaces de fin de la ligne
//			line = line.trim();
//			
////			On saute les lignes vides
//			if(line.length()==0)
//				continue;
//			
////			On saute les lignes de commentaire
//			if(line.startsWith("#"))
//				continue;
//			
//			String[] oneData = line.split(separator);
//			
//			if (first) {
//				titles = oneData;
//				first=false;
//			}
//			else
//				data.add(oneData);
//			
//		}
//		
//		mapData();
//	}
//}
