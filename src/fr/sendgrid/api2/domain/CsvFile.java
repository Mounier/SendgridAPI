package fr.sendgrid.api2.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvFile {
	public final static char SEPARATOR = ';';
	protected File file;
	protected List<String> lines;
	protected List<String[]> data;
	protected String[] titles;
	protected List<Map<String, String>> mappedData;
	
	public CsvFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CsvFile(File file) throws IOException {
		this.file = file;
		init();
	}
	
	private void init() throws IOException {
		lines = CsvFileHelper.readFile(file);
		data = new ArrayList<String[] >(lines.size());
		String separator = new Character(SEPARATOR).toString();
		boolean first=true;
		
		for(String line : lines) {
//			suppression des espaces de fin de la ligne
			line = line.trim();
			
//			On saute les lignes vides
			if(line.length()==0)
				continue;
			
//			On saute les lignes de commentaire
			if(line.startsWith("#"))
				continue;
			
			String[] oneData = line.split(separator);
			
			if (first) {
				titles = oneData;
				first=false;
			}
			else
				data.add(oneData);
			
		}
		
		mapData();
	}
	
	private void mapData() {
        mappedData = new ArrayList<Map<String, String>>(data.size());

        final int titlesLength = titles.length;

        for (String[] oneData : data) {
            final Map<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < titlesLength; i++) {
                final String key = CsvFileHelper.cleanKey(titles[i]);
                final String value = oneData[i];
                map.put(key, value);
            }

            mappedData.add(map);
        }
    }
	
	public CsvFile(File file, List<String[]> data, String[] title, List<Map<String, String>> getMappeddata) {
		super();
		this.file = file;
		this.data = data;
		this.titles = title;
		this.mappedData = getMappeddata;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public List<String[]> getData() {
		return data;
	}
	public void setData(List<String[]> data) {
		this.data = data;
	}
	public String[] getTitle() {
		return titles;
	}
	public void setTitle(String[] title) {
		this.titles = title;
	}
	public List<Map<String, String>> getMappedData() {
		return mappedData;
	}
	public void setGetMappeddata(List<Map<String, String>> getMappeddata) {
		this.mappedData = getMappeddata;
	}
	@Override
	public String toString() {
		return "CsvFile [file=" + file + ", data=" + data + ", title=" + Arrays.toString(titles) + ", getMappeddata="
				+ mappedData + "]";
	}
	
	
}
