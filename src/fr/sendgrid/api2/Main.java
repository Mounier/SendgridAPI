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

//		On charge le contenu du fichier txt(le code html) dans un string
//		String htmlContent=null;
//		String plainContent=null;
		File txtFileHtmlContent = new File("C:\\Users\\amounier\\htmlExample.txt");
		File txtFilePlainContent = new File("C:\\Users\\amounier\\plainContentExample.txt");
//		htmlContent = txtFile.loadFile();
//		plainContent = txtFile2.loadFile();
//		System.out.println(htmlContent);

//		pour créer une nouvelle version, on peut faire la commande ci dessous. Attention, essayer de recréer une version avec le meme nom par exemple et on obtiendra une BAD REQUEST
//		templateService.createNewTransactionalTemplateVersion("maVersion", txtFileHtmlContent, txtFilePlainContent, 1,"7dc5b076-7d1f-4c02-b389-444119841a1f","mon sujet");

	}

	private static Mail buildMail() throws IOException {
		Mail mail = new Mail();

//		On définit l'expediteur
		Email fromEmail = new Email();
	    fromEmail.setName("L'expediteur");
	    fromEmail.setEmail("amounier@isilis.fr");
	    mail.setFrom(fromEmail);
	    
//	    L'objet du mail
	    mail.setSubject("Hello World from the SendGrid Java Library");
	    
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
	    attachments.setContent("TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdC4gQ3JhcyBwdW12");
	    attachments.setType("application/pdf");
	    attachments.setFilename("balance_001.pdf");
	    attachments.setDisposition("attachment");
	    attachments.setContentId("Balance Sheet");
	    mail.addAttachments(attachments);
*/	    
	    Attachments attachments2 = new Attachments();
	    attachments2.setContent("BwdW");
	    attachments2.setType("image/png");
	    attachments2.setFilename("C:\\Users\\amounier\\image.jpg");		
//	    attachments2.setDisposition("inline");
//	    attachments2.setContentId("Banner");
	    mail.addAttachments(attachments2);
	    
	    
//	    Definition du template à utiliser
//	    mail.setTemplateId("7dac05e4-388e-400e-8e96-3690422670f8");
	    
	    
		return mail;
	}

}