package fr.sendgrid.api2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import fr.sendgrid.api2.DAO.CsvFileHelperDao;
import fr.sendgrid.api2.DAO.TxtFile;
import fr.sendgrid.api2.domain.RecipientFromCsvFile;
import fr.sendgrid.api2.domain.Template;
import fr.sendgrid.api2.service.RecipientService;
import fr.sendgrid.api2.service.TemplateService;
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
		File file = CsvFileHelperDao.getRessource(FILE_NAME);
		RecipientService recipientService = new RecipientService(apiKey,file);	//ce sera à partir de cet objet qu'on fera toute les opérations sur les contacts/recipients
	
		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Recipients   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");
		
//		On met les contacts dans une liste
		System.out.println("Putting recipients in a list...");
		List<RecipientFromCsvFile> recipientsFromCsvList = new ArrayList<RecipientFromCsvFile>();
		recipientsFromCsvList = recipientService.RetrieveAllRecipientsFromCsvFile();
		System.out.println(recipientsFromCsvList);

		
		
		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Sending   ********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");
		SendGrid sg = new SendGrid(apiKey);
		sg.addRequestHeader("X-Mock","true");
		Request request = new Request();
		Mail mail = buildMail();
		
		try {
		      request.method = Method.POST;
		      request.endpoint = "mail/send";
		      request.body = mail.build();
		      Response response = sg.api(request);
		      System.out.println(response.statusCode);
		      System.out.println(response.body);
		      System.out.println(response.headers);
		    } catch (IOException ex) {
		      throw ex;
		    }

		
//		String subject ="NOUVEAU SUJET"; // /!\ SI ON MET LE CARACTERE '°' DANS LE subjec ALORS ON OBTIENT UNE EXCEPTION /!\ 
//		Content content = new Content("text/plain", "Ceci est un test");
//		recipientService.sendTo(recipientsFromCsvList, from, subject, content);
		 		
		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Invalid   ********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

		recipientService.findAllInvalid();

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Spam   ***********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");
	
		recipientService.findAllSpam();

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Bounce   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

//		recipientService.findAllBounce();	//exception

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Block   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

		recipientService.FindAllBlock();

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Template   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

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
	}

	private static Mail buildMail() throws IOException {
		Mail mail = new Mail();

//		On définit l'expediteur
		Email fromEmail = new Email();
	    fromEmail.setName("L'expediteur");
	    fromEmail.setEmail("amounier@isilis.fr");
	    mail.setFrom(fromEmail);
	    
//	    L'objet du mail
	    mail.setSubject("Hello World from the SendGrid Java Library"); // /!\ SI ON MET LE CARACTERE '°' DANS L'OBJET ALORS ON OBTIENT UNE EXCEPTION /!\ 
	    
//	    Definition du/des contacts à qui envoyer le mail / Les adresses mail en copie etc
	    Personalization personalization = new Personalization();
	    Email to = new Email();
	    to.setName("le receveur No.1");
	    to.setEmail("amounier@et.esiea.fr");
	    personalization.addTo(to);
	    to.setName("le receveur No.2");
	    to.setEmail("adrien-mounier@hotmail.fr");
	    personalization.addTo(to);
	    personalization.setSubject("Hello World from the Personalized SendGrid Java Library");
	    personalization.addHeader("X-Test", "test");
	    personalization.addHeader("X-Mock", "true");
	    mail.addPersonalization(personalization);
	    
//	    Definition du contenu du mail
	    Content content = new Content();
	    content.setType("text/html");
	    content.setValue("<html><body>some text here</body></html>");
	    mail.addContent(content);

	    
//	    Definition de la piece jointe
/*	    Attachments attachments = new Attachments();
//	    se rendre sur ce site -> https://lehollandaisvolant.net/tout/tools/base64i/ afin d'encoder notre fichier en base 64 (Une partie du début du texte encodé obtenu est à supprimer)
	    attachments.setContent("TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdC4gQ3JhcyBwdW12");
	    attachments.setType("application/pdf");
	    attachments.setFilename("balance_001.pdf");
	    attachments.setDisposition("attachment");
	    attachments.setContentId("Balance Sheet");
	    mail.addAttachments(attachments);
*/	    
	    Attachments attachments2 = new Attachments();
//	    se rendre sur ce site -> https://lehollandaisvolant.net/tout/tools/base64i/ afin d'encoder notre fichier en base 64 (attention : dans cet exemple j'ai supprimé le début du texte "data:image/jpeg;base64,")
	    attachments2.setContent("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");
	    attachments2.setType("jpg");
	    attachments2.setFilename("image.jpg");		
//	    attachments2.setDisposition("inline");
//	    attachments2.setContentId("Banner");
	    mail.addAttachments(attachments2);
	    
	    
//	    Definition du template à utiliser
	    mail.setTemplateId("7dac05e4-388e-400e-8e96-3690422670f8");
	    
	    
		return mail;
	}

}