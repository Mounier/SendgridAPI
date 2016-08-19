package fr.sendgrid.api2.domain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class TrackingSettings {
	
}


//System.out.println("Récupération des stats :");
//try {
//	    SendGrid sg = new SendGrid(apiKey);
//	    Request request = new Request();
//	    request.method = Method.GET;
//	    request.endpoint = "stats";
//	    Map<String,String> queryParams = new HashMap<String, String>();
//	    queryParams.put("aggregated_by", "day");
//	    queryParams.put("start_date", "2016-07-01");
//	    queryParams.put("end_date", "2016-08-05");
//	    request.queryParams = queryParams;
//	    Response response = sg.api(request);
//	    System.out.println(response.statusCode);
//	    System.out.println(response.body);
//	    System.out.println(response.headers);
//} catch (IOException ex) {
//	    throw ex;
//		}