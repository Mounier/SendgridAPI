package fr.sendgrid.api2.service;
import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import fr.sendgrid.api2.domain.Webhook;

public class WebhookService {
	protected String apiKey;
	protected Webhook Webhook;
	
	public WebhookService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebhookService(String apiKey, Webhook webhook) {
		super();
		this.apiKey = apiKey;
		this.Webhook = webhook;
	}
	
	public void retrieveWebhookSettings () throws IOException {
		System.out.println("Récupération des paramètres de webhook :");
		try {
		    SendGrid sg = new SendGrid(this.apiKey);
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "user/webhooks/event/settings";
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		  } catch (IOException ex) {
		    throw ex;
		  }
	}
	
	
	
}
