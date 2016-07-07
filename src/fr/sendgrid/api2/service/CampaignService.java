package fr.sendgrid.api2.service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import fr.sendgrid.api2.domain.Campaign;

public class CampaignService {
	/*
	String keyApi;
	
	public Campaign() {
		System.out.println("Il faut rentrer la clé API en paramètre.");
	}
	
	public Campaign(String pKeyApi) {
		keyApi=pKeyApi;
	}
	*/
	
	public static void main(String[] args) throws IOException {	
//		avoir les info sur le groupe 907
		try {
			SendGrid sg = new SendGrid("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");
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "asm/groups";
		    Map<String,String> queryParams = new HashMap<String, String>();
		    queryParams.put("id", "907");
		    request.queryParams = queryParams;
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		  } catch (IOException ex) {
		    throw ex;
		  }
		
//		create campaign
		try {
			SendGrid sg = new SendGrid("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");
		    Request request = new Request();
		    request.method = Method.POST;
		    request.endpoint = "campaigns";
		    
		    Campaign campaignRequest = new Campaign();
		    campaignRequest.setHtmlContent("<html><head><title></title></head><body><p>Check out our spring line!</p></body></html>");
		    //TODO add sender id
		    campaignRequest.setSenderId("");
		    campaignRequest.setSubject("My subject");
		    campaignRequest.setPlainContent("some plain content!");
		    campaignRequest.setTitle("A Nice title");
		    
		    Gson gson = new GsonBuilder().create();
		    String campaignAsJson = gson.toJson(campaignRequest);
		    
		    System.out.println( campaignAsJson );
		    
//		    request.body ="{\"custom_unsubscribe_url\":\"\",\"html_content\":\"<html><head><title></title></head><body><p>Check out our spring line!</p></body></html>\",\"list_ids\":\"\",\"sender_id\":YW1vdW5pZXJAZXQuZXNpZWEuZnI=,\"subject\":\"New Products for Spring!\",\"plain_content\":\"Check out our spring line!\",\"suppression_group_id\":,\"title\":\"March Newsletter\",\"segment_ids\":[],\"categories\":[],\"ip_pool\":\"marketing\"}";
		    
		    request.body = campaignAsJson;
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		  } catch (Exception ex) {
		    throw ex;
		  }
		
		
	}

}
