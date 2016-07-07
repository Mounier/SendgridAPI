package fr.sendgrid.api2.service;
import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Block {
	protected String apiKey;
	
	public Block() {
		System.out.println("il faut rentrer la clé api en paramètre.");
	}
	
	public Block(String pKeyApi) {
		apiKey=pKeyApi;
	}
	
	public void findBlock() throws IOException {
		try {
			SendGrid sg = new SendGrid(apiKey);
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "suppression/blocks";
		    Map<String,String> queryParams = new HashMap<String, String>();
		    Calendar now = Calendar.getInstance();
			long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
			long beforeOneMonthInSeconde = (now.getTimeInMillis()/1000l) - 2588339;		// on soustrait la valeur du temps now par 2588339 qui correspond environ à 1 mois en millisecondes pour nous ramener 1 mois avant
			queryParams.put("start_time", String.valueOf(beforeOneMonthInSeconde));
			queryParams.put("end_time", String.valueOf(nowInSeconde));
//		    queryParams.put("offset", "0");		// 0 pour le début de la liste
//		    queryParams.put("limit", "300");	// 300 pour indiquer l'indice de la position ou on veut s'arreter
		    request.queryParams = queryParams;
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		  } catch (IOException ex) {
		    throw ex;
		  }
	}

}
