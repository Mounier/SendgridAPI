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

//	INVALID EMAILS recipients who had malformed email addresses or whose mail provider reported the address as invalid

public class Invalid {
	protected String apiKey;

	public Invalid() {
		System.out.println("il faut rentrer la clé api en paramètre.");
	}

	public Invalid(String pApiKey) {
		apiKey = pApiKey;
	}

	public void findInvalid() throws IOException {
		try {
			SendGrid sg = new SendGrid(apiKey);
			Request request = new Request();
			request.method = Method.GET;
			request.endpoint = "suppression/invalid_emails";
			Map<String, String> queryParams = new HashMap<String, String>();
			Calendar now = Calendar.getInstance();
			long nowInSeconde = now.getTimeInMillis() / 1000l;
			/*
			 * on divise par mille car time.getTIme() est en seconde or on veut
			 * des milli secondes
			 */
			long beforeOneMonthInSeconde = (now.getTimeInMillis() / 1000l) - 2588339;
			/*
			 * on soustrait la valeur du temps now par 2588339 qui correspond
			 * environ à 1 mois en millisecondes pour nous ramener 1 mois avant
			 */
			queryParams.put("start_time", String.valueOf(beforeOneMonthInSeconde));
			// queryParams.put("limit", "300"); // 300 pour indiquer l'indice de
			// la position ou on veut s'arreter
			queryParams.put("end_time", String.valueOf(nowInSeconde));
			// queryParams.put("offset", "0"); // 0 pour le début de la liste
			request.queryParams = queryParams;
			Response responseInvalid = sg.api(request);
			System.out.println(responseInvalid.statusCode);
			System.out.println(responseInvalid.body);
			System.out.println(responseInvalid.headers);
		} catch (IOException ex) {
			throw ex;
		}
	}

}
