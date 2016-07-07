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

public class RetrieveSettingsOpenTracking {

	public static void main(String[] args) throws Exception {
		/*try {
			SendGrid sg = new SendGrid("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");
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "tracking_settings/open";
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		  } catch (IOException ex) {
		    throw ex;
		  }*/
		
		try {
			SendGrid sg = new SendGrid("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");
		    
			Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "user/account";
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		  } catch (IOException ex) {
		    throw ex;
		  }

	}

}
