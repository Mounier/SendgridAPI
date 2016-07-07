package fr.sendgrid.api2.service;
import java.io.IOException;
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

//	SPAM REPORTS recipients who marked your email as spam

public class Spam {
	
protected String apiKey;
	
	public Spam() {
		System.out.println("il faut rentrer la clé api en paramètre.");
	}
	
	public Spam(String pApiKey) throws Exception {
		apiKey=pApiKey;
	}
	
	public void findSpam() throws IOException {
		 try {
			 SendGrid sg = new SendGrid(apiKey);
			 Request request = new Request();
			 request.method = Method.GET;
			 request.endpoint = "suppression/spam_reports";
			 Map<String,String> queryParams = new HashMap<String, String>();
			 Calendar now = Calendar.getInstance();
			 long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
			 long oneMonthAgoInSeconde = (now.getTimeInMillis()/1000l) - 2588339;		// on soustrait la valeur du temps now par 2588339 qui correspond environ à 1 mois en millisecondes pour nous ramener 1 mois avant
			 queryParams.put("start_time", String.valueOf(oneMonthAgoInSeconde));
			 //queryParams.put("limit", "300"); // 300 pour indiquer l'indice de la position ou on veut s'arreter
			 queryParams.put("end_time", String.valueOf(nowInSeconde));
			 //queryParams.put("offset", "0");	// 0 pour le début de la liste
			 request.queryParams = queryParams;
			 Response responseSpam = sg.api(request);
			 System.out.println(responseSpam.statusCode);
			 System.out.println(responseSpam.body);
			 System.out.println(responseSpam.headers);
		 } catch (IOException ex) {
			 throw ex;
		 }
	}
}
