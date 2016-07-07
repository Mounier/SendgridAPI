package fr.sendgrid.api2;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class TrackingSettings {
	public static void main(String[] args) throws Exception {
		try {
			SendGrid sg = new SendGrid("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");
			Request request = new Request();
			request.method = Method.GET;
			request.endpoint = "tracking_settings";
			Map<String,String> queryParams = new HashMap<String, String>();
			queryParams.put("limit", "1");
	    	queryParams.put("offset", "1");
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
