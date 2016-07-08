package fr.sendgrid.api2.DAO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

public class TxtFile {
	
	private File file;
	
	public TxtFile() {
		super();
	}
	
	public TxtFile(String fileName) {
		this.file= new File(fileName);
	}
	
	public String loadFile () {
		
		StringWriter out = new StringWriter();
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(this.file));
			int b;
			while ((b=in.read()) != -1)
	        out.write(b);
			out.flush();
			out.close();
			in.close();

		}
	    catch (IOException ie)
	    {
	         ie.printStackTrace(); 
	    }
		
		return out.toString();
	}
}
