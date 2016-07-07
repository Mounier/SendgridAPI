package fr.sendgrid.api2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**************************************************************************************************************************/
/************************************* FONCTIONNE AVEC LA REQUETE SPAM (V2) **************************************************/
/**************************************************************************************************************************/

public class TestSpam {

	public static void main(String[] args) throws IOException {
		Map<String,String> queryParams = new HashMap<String, String>();
		Calendar now = Calendar.getInstance();
		long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
		long beforeOneMonthInSeconde = (now.getTimeInMillis()/1000l) - 2588339;		// on soustrait la valeur du temps now par 2588339 qui correspond environ à 1 mois en millisecondes pour nous ramener 1 mois avant
		queryParams.put("start_time", String.valueOf(beforeOneMonthInSeconde));
		queryParams.put("end_time", String.valueOf(nowInSeconde));
			
		String ur="	https://api.sendgrid.com/api/spamreports.get.json?api_user=amounier&api_key=IsiAM2016$&date=1";	//ton URL
		URL url = new URL(ur);
		URLConnection  conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//		writer.write(post);
		writer.flush();
//		recuperation du code html
		String reponse=null,ligne = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((ligne = reader.readLine()) != null) {
		        reponse+= ligne.trim()+"\n";
		}
		System.out.print(reponse);

	}

}