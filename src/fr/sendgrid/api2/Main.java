package fr.sendgrid.api2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import fr.sendgrid.api2.DAO.CsvFileHelperDao;
import fr.sendgrid.api2.DAO.TxtFile;
import fr.sendgrid.api2.domain.RecipientFromCsvFile;
import fr.sendgrid.api2.domain.Template;
import fr.sendgrid.api2.domain.Webhook;
import fr.sendgrid.api2.service.MailService;
import fr.sendgrid.api2.service.RecipientService;
import fr.sendgrid.api2.service.TemplateService;
import fr.sendgrid.api2.service.WebhookService;
import fr.sendgrid.api2.window.FenetreTemplate;
import com.sendgrid.ASM;
import com.sendgrid.Attachments;
import com.sendgrid.BccSettings;
import com.sendgrid.ClickTrackingSetting;
import com.sendgrid.Client;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.FooterSetting;
import com.sendgrid.GoogleAnalyticsSetting;
import com.sendgrid.Mail;
import com.sendgrid.MailSettings;
import com.sendgrid.Method;
import com.sendgrid.OpenTrackingSetting;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.Setting;
import com.sendgrid.SpamCheckSetting;
import com.sendgrid.SubscriptionTrackingSetting;
import com.sendgrid.TrackingSettings;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Main {

	public static void main(String[] args) throws Exception {
//		FenetreTemplate maFenetre = new FenetreTemplate();
		
//		Récupération du fichier csv
		String apiKey = "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";	//		Clé API qui permet de s'authentifier
		final String FILE_NAME = "C:\\liste_contact.csv";
		System.out.println("Retrieving the csv file...");
		File file = CsvFileHelperDao.getRessource(FILE_NAME);		RecipientService recipientService = new RecipientService(apiKey,file);	//ce sera à partir de cet objet qu'on fera toute les opérations sur les contacts/recipients
	
		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   Recipients   *****************************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");
		
//		On met les contacts dans une liste
		System.out.println("Putting recipients in a list...");
		List<RecipientFromCsvFile> recipientsFromCsvList = new ArrayList<RecipientFromCsvFile>();
		recipientsFromCsvList = recipientService.RetrieveAllRecipientsFromCsvFile();
		System.out.println(recipientsFromCsvList);

		
		
		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   Sending   ********************************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");
		 MailService mailService = new MailService();
		 Map<String, String> params = new HashMap<>();
//		 substitutions.put("%url-perso%", "https://github.com/Mounier");
//		 params.put(MailService.PARAM_SUBJECT, "TEST - NEW WAY TO SEND"); // /!\ SI ON MET LE CARACTERE '°' DANS LE subject ALORS ON OBTIENT UNE EXCEPTION /!\ 
		 params.put(MailService.PARAM_TEMPLATE_ID, "7dac05e4-388e-400e-8e96-3690422670f8");
		 params.put(MailService.PARAM_FROM_NAME, "Service Client");
		 params.put(MailService.PARAM_FROM, "amounier@isilis.fr");
		 params.put(MailService.PARAM_BCC, "dridri_du91@hotmail.fr");
		 params.put(MailService.PARAM_TO_NAME, "amounier de l'esiea");
		 params.put(MailService.PARAM_TO, "amounier@et.esiea.fr");
		 Map<String, String> substitutions = new HashMap<>();

		 File attachmentFile = new File("image.jpg");
		 
//		 mailService.send(params, substitutions, attachmentFile);
		 		
		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   Invalid   ********************************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");

		recipientService.findAllInvalid();

		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   Spam   ***********************************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");
	
		recipientService.findAllSpam();

		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   Bounce   *********************************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");

//		recipientService.findAllBounce();	//Exception in thread "main" org.apache.http.client.HttpResponseException: NOT ACCEPTABLE 
//		Comprend pas.

		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   Block   **********************************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");

		recipientService.FindAllBlock();

		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   Template   *******************************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");

		TemplateService templateService = new TemplateService(apiKey);
		List<Template> listTemplate = new ArrayList<Template>();
		listTemplate = templateService.retrieveAllTemplates();
		System.out.println("\nliste des templates existants : \n" + listTemplate);

//		On charge les fichiers texte
//		File txtFileHtmlContent = new File("C:\\Users\\amounier\\htmlExample.txt");
//		File txtFilePlainContent = new File("C:\\Users\\amounier\\plainContentExample.txt");
//		pour créer une nouvelle version, on peut faire la commande ci dessous. Attention, essayer de recréer une version avec le meme nom par exemple et on obtiendra une BAD REQUEST
//		templateService.createNewTransactionalTemplateVersion("Version d'isilis", txtFileHtmlContent, txtFilePlainContent, 1,"7dac05e4-388e-400e-8e96-3690422670f8","mon sujet");
//		System.out.println("creation d'une nouvelle version d'un template");
		
		System.out.println(
				"\n\n        ***************************************************************************************************************************************************************************************");
		System.out.println(
				"        ******************************************************************************   TrackingSettings   ***********************************************************************************");
		System.out.println(
				"        ***************************************************************************************************************************************************************************************");
//		Webhook webhook = new Webhook();
//		WebhookService webhookService = new WebhookService(apiKey,webhook);
//		
//		webhookService.retrieveWebhookSettings();
//		webhookService.updateWebhookSettingsAllTrue();
//		webhookService.retrieveWebhookSettings();
		
// 	Tous les GET TrackingSettings donnent une exception FORBIDEN EDIT : plus maintenant depuis l'intervention de greg. Mon postman etait apparrement "bugué" du coup impossible de me donner les permissions sur ma clé (à partir de postman car impossible avec l'api java)
		
		System.out.println("tracking click :");
		 try {	
			 SendGrid sg = new SendGrid(apiKey);
			 Request request = new Request();
			 request.method = Method.GET;
			 request.endpoint = "tracking_settings/click";
			 Response response = sg.api(request);
			 System.out.println(response.statusCode);
			 System.out.println(response.body);
			 System.out.println(response.headers);
		 } catch (IOException ex) {
			    throw ex;
		 }
		 
		 System.out.println("tracking open :");
		 try {
			 SendGrid sg = new SendGrid(apiKey);
			 Request request = new Request();
			 request.method = Method.GET;
			 request.endpoint = "tracking_settings/open";
			 Response response = sg.api(request);
			 System.out.println(response.statusCode);
			 System.out.println(response.body);
			 System.out.println(response.headers);
		 } catch (IOException ex) {
			    throw ex;
		 }
	}
}
