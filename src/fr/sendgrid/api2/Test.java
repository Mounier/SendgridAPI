package fr.sendgrid.api2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;



/**************************************************************************************************************************/
/************************************* FONCTIONNE AVEC LA REQUETE BOUNCE (V2) *********************************************/
/**************************************************************************************************************************/

public class Test {

	public static void main(String[] args) throws IOException {
		try {
		    SendGrid sg = new SendGrid("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");
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "contactdb/recipients";
		    Map<String,String> queryParams = new HashMap<String, String>();
//		    queryParams.put("page", "1");
//		    queryParams.put("page_size", "1");
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
