package fr.sendgrid.api2.service;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import fr.sendgrid.api2.domain.CsvFile;
import fr.sendgrid.api2.domain.RecipientFromCsvFile;
import fr.sendgrid.api2.domain.RecipientFromSendgrid;


public class RecipientService {
	
	protected CsvFile csvFile;
	
	public RecipientService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecipientService(File pFile) throws IOException {
		this.csvFile = new CsvFile(pFile);
	}
	
	public List<RecipientFromCsvFile> RetrieveAllRecipientsFromCsvFile() {
		
		final List<RecipientFromCsvFile> recipientsFromCsvFileList = new ArrayList<RecipientFromCsvFile>();
		final List<Map<String,String>> mappedData = csvFile.getMappedData();
		
		for(Map<String,String> map : mappedData) {
			final RecipientFromCsvFile recipientFromCsvFile = mapToContact(map);
			recipientsFromCsvFileList.add(recipientFromCsvFile);
		}
		return recipientsFromCsvFileList;
	}
	
	private RecipientFromCsvFile mapToContact(Map<String, String> map) {
		
		final RecipientFromCsvFile contact = new RecipientFromCsvFile();
		final String email = map.get("email");
		final String firstName = map.get("first_name");
		final String lastName = map.get("last_name");
		final String region = map.get("geo_region");
		final String city = map.get("geo_city");
		final String id = map.get("id");
		
		contact.setEmail(email);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setRegion(region);
		contact.setCity(city);
		contact.setId(Integer.parseInt(id));
		
		return contact;
	}
	
	public List<RecipientFromSendgrid> retrieveAllRecipientsFromSendgrid(String pApiKey) throws JSONException {
		SendGrid sg = new SendGrid(pApiKey);
		Request request = new Request();
		request.method = Method.GET;
		request.endpoint = "contactdb/recipients";
		Response response;
		List<RecipientFromSendgrid> listRecipient = new ArrayList<RecipientFromSendgrid>();
		
		try {

			response = sg.api(request);
//			System.out.println(response.statusCode);
//			System.out.println(response.body);
//			System.out.println(response.headers);

			Gson gson = new Gson();		
			JsonParser parser = new JsonParser();
			JsonObject ObjetRecipients = parser.parse(response.body).getAsJsonObject();
			//	Ci dessus on a parsé le String response.body en objet json (dans la sortie json on peut voir que l'objet json qui "englobe" tout se nomme Recipients)
			//	Ce "Recipients" contient une liste d'éléments. Nous avons définis notre objet Recipient par rapport à ces éléments
			JsonArray recipientJsonArray;
			//	On stock ensuite le contenue (la liste des Recipients) de cet objet dans un JsonArray. 
			recipientJsonArray = ObjetRecipients.getAsJsonArray("recipients");	//	dans le json le nom de l'objet contentant la liste est "Recipients"
			//	Il ne reste plus qu'à parcourir le tableau json et récupérer chaque Recipient
			for (int i = 0; i < recipientJsonArray.size(); i++) {
				RecipientFromSendgrid temp = gson.fromJson(recipientJsonArray.get(i), RecipientFromSendgrid.class);
				//	Une fois le Recipient récupéré du json, on le stock dans notre liste.
				listRecipient.add(temp);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listRecipient;
	}
	
}
