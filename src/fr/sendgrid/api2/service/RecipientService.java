package fr.sendgrid.api2.service;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.HttpResponseException;
import org.json.JSONException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import fr.sendgrid.api2.DAO.CsvFile;
import fr.sendgrid.api2.domain.RecipientFromCsvFile;
import fr.sendgrid.api2.domain.RecipientFromSendgrid;
import fr.sendgrid.api2.domain.SendToV3Body;
import fr.sendgrid.api2.domain.TemplateVersionBody;
import fr.sendgrid.api2.domain.bodys.SendToV3Attachments;
import fr.sendgrid.api2.domain.bodys.SendToV3Content;
import fr.sendgrid.api2.domain.bodys.SendToV3Personalizations;
import fr.sendgrid.api2.domain.bodys.SendToV3From;
import fr.sendgrid.api2.domain.bodys.SendToV3PersonalizationSubstitutions;
import fr.sendgrid.api2.domain.bodys.SendToV3PersonalizationTo;


public class RecipientService {
	
	protected CsvFile csvFile;
	protected String apiKey;
	
	public RecipientService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecipientService(String pApiKey, File pFile) throws IOException {
		this.csvFile = new CsvFile(pFile);
		this.apiKey = pApiKey;
	}
	
	public void sendToV3(SendToV3From from, SendToV3Personalizations personalization, /*String subject,*/ /* String template_id*/ SendToV3Content content[]) throws IOException {
		System.out.println("test depuis sendToV3");
			    SendGrid sg = new SendGrid(this.apiKey);
			    Request request = new Request();
			    request.method = Method.POST;
			    request.endpoint = "mail/send";
			    
			    /**************** test **************/
			
//			    request.body = "";
			    GsonBuilder builder = new GsonBuilder();
			    Gson gson = builder.create();
			    SendToV3Body sendToV3Body = new SendToV3Body(from, personalization, /*subject,*/ content);				
				String json = gson.toJson(sendToV3Body);
				System.out.println("voici le json : " + json);
				Response response = null;
				
				try {
					request.body = json;
					response = sg.api(request);
				} catch (HttpResponseException e) {
					e.printStackTrace();
				}
		    
			    /************************************/

			    System.out.println(response.statusCode);
			    System.out.println(response.body);
			    System.out.println(response.headers);

	}
	
	public void sendTo(List<RecipientFromCsvFile> pRecipientList, Email pFrom, String pSubject, Content pContent)
			throws IOException {

		SendGrid sg = new SendGrid(this.apiKey);
		Request request = new Request();
		request.method = Method.POST;
		request.endpoint = "mail/send";
		Email from = pFrom;
		String subject = pSubject;
		Content content = pContent;
		Email[] to = new Email[pRecipientList.size()];

		try {
			for (int i = 0; i < pRecipientList.size(); i++) {
				to[i] = new Email(pRecipientList.get(i).getEmail());
				Mail mail = new Mail(from, subject, to[i], content);
				request.body = mail.build();
				Response responseMailSent = sg.api(request);
				System.out.println(responseMailSent.statusCode);
				System.out.println(responseMailSent.body);
				System.out.println(responseMailSent.headers);
				System.out.println("Mail sent to " + pRecipientList.get(i));
			}
		} catch (IOException ex) {
			throw ex;
		}

	}

	
	public List<RecipientFromCsvFile> RetrieveAllRecipientsFromCsvFile() {
		
		final List<RecipientFromCsvFile> recipientsFromCsvFileList = new ArrayList<RecipientFromCsvFile>();
		final List<Map<String,String>> mappedData = this.csvFile.getMappedData();
		
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
	
	public List<RecipientFromSendgrid> retrieveAllRecipientsFromSendgrid() throws JSONException {
		
		SendGrid sg = new SendGrid(this.apiKey);
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
			//	Ci dessus on a pars� le String response.body en objet json (dans la sortie json on peut voir que l'objet json qui "englobe" tout se nomme Recipients)
			//	Ce "Recipients" contient une liste d'�l�ments. Nous avons d�finis notre objet Recipient par rapport � ces �l�ments
			JsonArray recipientJsonArray;
			//	On stock ensuite le contenue (la liste des Recipients) de cet objet dans un JsonArray. 
			recipientJsonArray = ObjetRecipients.getAsJsonArray("recipients");	//	dans le json le nom de l'objet contentant la liste est "Recipients"
			//	Il ne reste plus qu'� parcourir le tableau json et r�cup�rer chaque Recipient
			for (int i = 0; i < recipientJsonArray.size(); i++) {
				RecipientFromSendgrid temp = gson.fromJson(recipientJsonArray.get(i), RecipientFromSendgrid.class);
				//	Une fois le Recipient r�cup�r� du json, on le stock dans notre liste.
				listRecipient.add(temp);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listRecipient;
	}
	
	public void FindAllBlock() throws IOException {
		try {
			SendGrid sg = new SendGrid(this.apiKey);
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "suppression/blocks";
		    Map<String,String> queryParams = new HashMap<String, String>();
		    Calendar now = Calendar.getInstance();
			long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
			long beforeOneMonthInSeconde = (now.getTimeInMillis()/1000l) - 2588339;		// on soustrait la valeur du temps now par 2588339 qui correspond environ � 1 mois en millisecondes pour nous ramener 1 mois avant
			queryParams.put("start_time", String.valueOf(beforeOneMonthInSeconde));
			queryParams.put("end_time", String.valueOf(nowInSeconde));
//		    queryParams.put("offset", "0");		// 0 pour le d�but de la liste
//		    queryParams.put("limit", "300");	// 300 pour indiquer l'indice de la position ou on veut s'arreter
		    request.queryParams = queryParams;
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		  } catch (IOException ex) {
		    throw ex;
		  }
	}
	
	public void findAllBounce() throws IOException {
		try {
			SendGrid sg = new SendGrid(this.apiKey);
			Request request = new Request();
			request.method = Method.GET;
			request.endpoint = "suppression/bounces";
			Map<String, String> queryParams = new HashMap<String, String>();
			Calendar now = Calendar.getInstance();
			long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
			long oneMonthAgoInSeconde = (now.getTimeInMillis()/1000l) - 2588339; 	// on soustrait la valeur du temps now par 2588339 qui correspond environ � 1 mois en millisecondes pour nous ramener 1 mois avant
			queryParams.put("start_time", String.valueOf(oneMonthAgoInSeconde));
			queryParams.put("end_time", String.valueOf(nowInSeconde));
			request.queryParams = queryParams;
			Response responseSpam = sg.api(request);
			System.out.println(responseSpam.statusCode);
			System.out.println(responseSpam.body);
			System.out.println(responseSpam.headers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	public void findAllInvalid() throws IOException {
		try {
			SendGrid sg = new SendGrid(this.apiKey);
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
			 * environ � 1 mois en millisecondes pour nous ramener 1 mois avant
			 */
			queryParams.put("start_time", String.valueOf(beforeOneMonthInSeconde));
			// queryParams.put("limit", "300"); // 300 pour indiquer l'indice de la position ou on veut s'arreter
			queryParams.put("end_time", String.valueOf(nowInSeconde));
			// queryParams.put("offset", "0"); // 0 pour le d�but de la liste
			request.queryParams = queryParams;
			Response responseInvalid = sg.api(request);
			System.out.println(responseInvalid.statusCode);
			System.out.println(responseInvalid.body);
			System.out.println(responseInvalid.headers);
		} catch (IOException ex) {
			throw ex;
		}
	}
	
	public void findAllSpam() throws IOException {
		 try {
			 SendGrid sg = new SendGrid(this.apiKey);
			 Request request = new Request();
			 request.method = Method.GET;
			 request.endpoint = "suppression/spam_reports";
			 Map<String,String> queryParams = new HashMap<String, String>();
			 Calendar now = Calendar.getInstance();
			 long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
			 long oneMonthAgoInSeconde = (now.getTimeInMillis()/1000l) - 2588339;		// on soustrait la valeur du temps now par 2588339 qui correspond environ � 1 mois en millisecondes pour nous ramener 1 mois avant
			 queryParams.put("start_time", String.valueOf(oneMonthAgoInSeconde));
			 //queryParams.put("limit", "300"); // 300 pour indiquer l'indice de la position ou on veut s'arreter
			 queryParams.put("end_time", String.valueOf(nowInSeconde));
			 //queryParams.put("offset", "0");	// 0 pour le d�but de la liste
			 request.queryParams = queryParams;
			 Response responseSpam = sg.api(request);
			 System.out.println(responseSpam.statusCode);
			 System.out.println(responseSpam.body);
			 System.out.println(responseSpam.headers);
		 } catch (IOException ex) {
			 throw ex;
		 }
	}
	
}
