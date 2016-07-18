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
import fr.sendgrid.api2.domain.TemplateVersionBody;
import fr.sendgrid.api2.domain.bodys.SendToV3Attachments;
import fr.sendgrid.api2.domain.bodys.SendToV3Content;
import fr.sendgrid.api2.domain.bodys.SendToV3Personalizations;
import fr.sendgrid.api2.domain.bodys.SendToV3From;


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
	
	public void sendToV3(SendToV3From from, SendToV3Personalizations personalization, String subject, String template_id /*SendToV3Content content[]*/) throws IOException {
		  try {
			    SendGrid sg = new SendGrid(this.apiKey);
			    Request request = new Request();
			    request.method = Method.POST;
			    request.endpoint = "mail/send";
			    
			    /**************** test **************/
/*			
			    request.body = "";
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
*/			    
			    /************************************/
			    
//			    request.body = "{\"custom_args\":{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\",\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},\"from\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},\"attachments\":[{\"name\":\"file1\",\"filename\":\"file1.jpg\",\"content\":\"[BASE64 encoded content block here]\",\"disposition\":\"inline\",\"content_id\":\"ii_139db99fdb5c3704\",\"type\":\"jpg\"}],\"personalizations\":[{\"to\":[{\"email\":\"john.doe@example.com\",\"name\":\"John Doe\"}],\"cc\":[{\"email\":\"jane.doe@example.com\",\"name\":\"Jane Doe\"}],\"bcc\":[{\"email\":\"sam.doe@example.com\",\"name\":\"Sam Doe\"}],\"custom_args\":{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\",\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},\"headers\":{\"X-Accept-Language\":\"en\",\"X-Mailer\":\"MyApp\"},\"send_at\":1409348513,\"substitutions\":{\"type\":\"object\",\"id\":\"substitutions\"},\"subject\":\"Hello, World!\"}],\"subject\":\"Hello, World!\",\"ip_pool_name\":\"[YOUR POOL NAME GOES HERE]\",\"content\":[{\"type\":\"text/html\",\"value\":\"<html><p>Hello, world!</p><img src=[CID GOES HERE]></img></html>\"}],\"headers\":{},\"asm\":{\"groups_to_display\":[1,2,3],\"group_id\":1},\"batch_id\":\"[YOUR BATCH ID GOES HERE]\",\"tracking_settings\":{\"subscription_tracking\":{\"text\":\"If you would like to unsubscribe and stop receiveing these emails <% click here %>.\",\"enable\":true,\"html\":\"If you would like to unsubscribe and stop receiving these emails <% clickhere %>.\",\"substitution_tag\":\"<%click here%>\"},\"open_tracking\":{\"enable\":true,\"substitution_tag\":\"%opentrack\"},\"click_tracking\":{\"enable\":true,\"enable_text\":true},\"ganalytics\":{\"utm_campaign\":\"[NAME OF YOUR REFERRER SOURCE]\",\"enable\":true,\"utm_name\":\"[NAME OF YOUR CAMPAIGN]\",\"utm_term\":\"[IDENTIFY PAID KEYWORDS HERE]\",\"utm_content\":\"[USE THIS SPACE TO DIFFERENTIATE YOUR EMAIL FROM ADS]\",\"utm_medium\":\"[NAME OF YOUR MARKETING MEDIUM e.g. email]\"}},\"mail_settings\":{\"footer\":{\"text\":\"Thanks,/n The SendGrid Team\",\"enable\":true,\"html\":\"<p>Thanks</br>The SendGrid Team</p>\"},\"spam_check\":{\"threshold\":3,\"post_to_url\":\"http://example.com/compliance\",\"enable\":true},\"bypass_list_management\":{\"enable\":true},\"sandbox_mode\":{\"enable\":false},\"bcc\":{\"enable\":true,\"email\":\"ben.doe@example.com\"}},\"reply_to\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},\"sections\":{\"section\":{\":sectionName2\":\"section 2 text\",\":sectionName1\":\"section 1 text\"}},\"template_id\":\"[YOUR TEMPLATE ID GOES HERE]\",\"categories\":[\"category1\",\"category2\"],\"send_at\":1409348513}";
//			    request.body = "{\"
			    Response response = sg.api(request);
			    System.out.println(response.statusCode);
			    System.out.println(response.body);
			    System.out.println(response.headers);
			  } catch (IOException ex) {
			    throw ex;
			  }
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
	
	public void FindAllBlock() throws IOException {
		try {
			SendGrid sg = new SendGrid(this.apiKey);
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "suppression/blocks";
		    Map<String,String> queryParams = new HashMap<String, String>();
		    Calendar now = Calendar.getInstance();
			long nowInSeconde = now.getTimeInMillis()/1000l;	// on divise par mille car time.getTIme() est en seconde or on veut des milli secondes
			long beforeOneMonthInSeconde = (now.getTimeInMillis()/1000l) - 2588339;		// on soustrait la valeur du temps now par 2588339 qui correspond environ à 1 mois en millisecondes pour nous ramener 1 mois avant
			queryParams.put("start_time", String.valueOf(beforeOneMonthInSeconde));
			queryParams.put("end_time", String.valueOf(nowInSeconde));
//		    queryParams.put("offset", "0");		// 0 pour le début de la liste
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
			long oneMonthAgoInSeconde = (now.getTimeInMillis()/1000l) - 2588339; 	// on soustrait la valeur du temps now par 2588339 qui correspond environ à 1 mois en millisecondes pour nous ramener 1 mois avant
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
			 * environ à 1 mois en millisecondes pour nous ramener 1 mois avant
			 */
			queryParams.put("start_time", String.valueOf(beforeOneMonthInSeconde));
			// queryParams.put("limit", "300"); // 300 pour indiquer l'indice de la position ou on veut s'arreter
			queryParams.put("end_time", String.valueOf(nowInSeconde));
			// queryParams.put("offset", "0"); // 0 pour le début de la liste
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
			 long oneMonthAgoInSeconde = (now.getTimeInMillis()/1000l) - 2588339;		// on soustrait la valeur du temps now par 2588339 qui correspond environ à 1 mois en millisecondes pour nous ramener 1 mois avant
			 queryParams.put("start_time", String.valueOf(oneMonthAgoInSeconde));
			 //queryParams.put("limit", "300"); // 300 pour indiquer l'indice de la position ou on veut s'arreter
			 queryParams.put("end_time", String.valueOf(nowInSeconde));
			 //queryParams.put("offset", "0");	// 0 pour le début de la liste
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
