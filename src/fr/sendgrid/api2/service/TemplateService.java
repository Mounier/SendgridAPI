package fr.sendgrid.api2.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.HttpResponseException;
import org.json.JSONException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import fr.sendgrid.api2.DAO.TxtFile;
import fr.sendgrid.api2.domain.TemplateBody;
import fr.sendgrid.api2.domain.TemplateVersionBody;

public class TemplateService {

	protected TemplateBody template = new TemplateBody();
	protected String apiKey;

	public TemplateService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TemplateService(String pApiKey) {
		super();
		this.apiKey = pApiKey;
	}

	public TemplateService(String pApiKey, TemplateBody pTemplate) {
		super();
		this.template = pTemplate;
		this.apiKey = pApiKey;
	}

	public void createNewTransactionalTemplateVersion(String versionName, File htmlContent, File plainContent,
			int active, String templateId, String subject) throws IOException {
		System.out.println("coucou");
		try {

			SendGrid sg = new SendGrid(this.apiKey);
			Request request = new Request();
			request.method = Method.POST;
			request.endpoint = "templates/"+templateId+"/versions";
			/**************** test **************/

			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.disableHtmlEscaping().create();
			String htmlString = FileUtils.readFileToString(htmlContent, "US-ASCII");
			System.out.println("htmlString : \n\t" + htmlString);
			// htmlString = StringEscapeUtils.escapeHtml4(htmlString);
			// System.out.println("htmlString escaped : \n\t"+htmlString);

			String contentString = FileUtils.readFileToString(plainContent, "UTF-8");
			System.out.println("contentString : " + contentString);

			TemplateVersionBody templateBody = new TemplateVersionBody(versionName, htmlString, contentString, active, templateId,
					subject);

			String json = gson.toJson(templateBody);

			System.out.println("voici le json : " + json);
			Response response = null;
			try {
				request.body = json;
				response = sg.api(request);
			} catch (HttpResponseException e) {
				e.printStackTrace();
			}

			System.out.println(response.statusCode);
			System.out.println(response.body);
			System.out.println(response.headers);
		} catch (IOException ex) {
			throw ex;
		}
	}

	public List<TemplateBody> retrieveAllTemplates() throws JSONException {

		SendGrid sg = new SendGrid(this.apiKey);
		Request request = new Request();
		request.method = Method.GET;
		request.endpoint = "templates";

		Response response;
		List<TemplateBody> listTemplate = new ArrayList<TemplateBody>();

		try {
			
			response = sg.api(request);
			System.out.println(response.statusCode);
			System.out.println(response.body);
			System.out.println(response.headers);

			Gson gson = new Gson();
			JsonParser parser = new JsonParser();

			JsonObject ObjetTemplates = parser.parse(response.body).getAsJsonObject();

			// Ci dessus on a parsé le String response.body en objet json (dans
			// la sortie json on peut voir que l'objet json qui "englobe" tout
			// se nomme templates)
			// Ce "templates" contient une liste d'éléments. Nous avons définis
			// notre objet Template par rapport à ces éléments
			JsonArray templateJsonArray;
			// On stock ensuite le contenue (la liste des templates) de cet
			// objet dans un JsonArray.

			templateJsonArray = ObjetTemplates.getAsJsonArray("templates"); // dans le json le nom de l'objet contentant la liste est "templates"

			// Il ne reste plus qu'à parcourir le tableau json et récupérer
			// chaque template
			for (int i = 0; i < templateJsonArray.size(); i++) {
				TemplateBody temp = gson.fromJson(templateJsonArray.get(i), TemplateBody.class);
				// Une fois le template récupéré du json, on le stock dans notre
				// liste.
				listTemplate.add(temp);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTemplate;
	}

	public void createTemplate() throws IOException {
		SendGrid sg = new SendGrid(this.apiKey);
		Request request = new Request();
		request.method = Method.POST;
		request.endpoint = "templates";

		TemplateBody templateRequest = new TemplateBody();
		templateRequest.setName(this.template.getName());

		Gson gson = new GsonBuilder().create();
		String templateAsJson = gson.toJson(templateRequest);

		request.body = templateAsJson;
		try {
			Response response = sg.api(request);
			System.out.println(response.statusCode);
			System.out.println(response.body);
			System.out.println(response.headers);
		} catch (Exception ex) {
			throw ex;
		}

	}

}
