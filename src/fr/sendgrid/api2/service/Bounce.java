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

//	BOUNCES Le bounce est un retour d’eMail indiquant que le message
//	qu’on a cherché à faire parvenir à un destinataire ne lui est pas
//	parvenu, pour une raison ou ou autre.

public class Bounce {
	
protected String apiKey;
	
	public Bounce() {
		System.out.println("il faut rentrer la clé api en paramètre.");
	}
	
	public Bounce(String pApiKey) throws Exception {
		apiKey=pApiKey;
	}

	public void findBounce() throws IOException{
		try {
			SendGrid sg = new SendGrid(apiKey);
			Request request = new Request();
			request.method = Method.GET;
			request.endpoint = "suppression/bounces";
			Map<String, String> queryParams = new HashMap<String, String>();
			Calendar now = Calendar.getInstance();
			long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
			long oneMonthAgoInSeconde = (now.getTimeInMillis()/1000l) - 2588339; 	// on soustrait la valeur du temps now par 2588339 qui correspond environ à 1 mois en millisecondes pour nous ramener 1 mois avant
			queryParams.put("start_time", String.valueOf(oneMonthAgoInSeconde));
			queryParams.put("end_time", String.valueOf(nowInSeconde));
			request.queryParams = queryParams;
			Response responseSpam = sg.api(request);
			System.out.println(responseSpam.statusCode);
			System.out.println(responseSpam.body);
			System.out.println(responseSpam.headers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}
