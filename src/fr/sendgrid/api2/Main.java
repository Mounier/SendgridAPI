package fr.sendgrid.api2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import fr.sendgrid.api2.domain.RecipientFromCsvFile;
import fr.sendgrid.api2.domain.RecipientFromSendgrid;
import fr.sendgrid.api2.domain.Template;
import fr.sendgrid.api2.service.Block;
import fr.sendgrid.api2.service.CsvFileHelper;
import fr.sendgrid.api2.service.Invalid;
import fr.sendgrid.api2.service.RecipientService;
import fr.sendgrid.api2.service.Spam;
import fr.sendgrid.api2.service.TemplateService;

public class Main {

	static void sendTo(String pApiKey, List<RecipientFromSendgrid> pRecipientList, Email pFrom, String pSubject, Content pContent)
			throws IOException {

		SendGrid sg = new SendGrid(pApiKey);
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

	public static void main(String[] args) throws Exception {

//		Récupération des contacts contenu dans le fichier csv dans une liste
		final String FILE_NAME = "C:\\liste_contact.csv";
		File file = CsvFileHelper.getRessource(FILE_NAME);
		List<RecipientFromCsvFile> recipientFromCsvList = new ArrayList<RecipientFromCsvFile>();
		RecipientService recipientService = new RecipientService(file);
		recipientFromCsvList = recipientService.RetrieveAllRecipientsFromCsvFile();
		System.out.println(recipientFromCsvList);

		String apiKey = "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";
		/*
		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Invalid   ********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

		Invalid testInvalid = new Invalid(apiKey);
		testInvalid.findInvalid();

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Spam   ***********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

		Spam testSpam = new Spam(apiKey);
		testSpam.findSpam();

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Bounce   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

		// Bounce testBounce = new Bounce(apiKey);
		// testBounce.findBounce();

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Block   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

		Block testBlock = new Block(apiKey);
		testBlock.findBlock();

		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Template   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");

		// pour créer un template :
		// String nomTemplate = "test template 2";
		// Template template = new Template(nomTemplate);
		// templateService.createTemplate(apiKey, template); 

		TemplateService templateService = new TemplateService();
		List<Template> listTemplate = new ArrayList<Template>();

		listTemplate = templateService.retrieveAllTemplates(apiKey);
		System.out.println("liste des templates existants : \n" + listTemplate);

*/
		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Recipients   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");
		
/*		List<RecipientFromSendgrid> recipientList = new ArrayList<RecipientFromSendgrid>();
		RecipientService recipientServiceFromSendgrid = new RecipientService();
		recipientList = recipientService.retrieveAllRecipientsFromSendgrid(apiKey);
		System.out.println("liste des recipients : \n" + recipientList); */
		
/*		  Email from = new Email("amounier@isilis.fr"); 
		  String subject ="NOUVEAU SUJET"; // /!\ SI ON MET LE CARACTERE '°' DANS LE subjec ALORS ON OBTIENT UNE EXCEPTION /!\ 
		  Content content = new Content("text/plain", "Ceci est un test"); 
		  sendTo(apiKey, recipientList2,from, subject, content);
*/		 
	}

}

/*
 * adrien-mounier@hotmail.fr : YWRyaWVuLW1vdW5pZXJAaG90bWFpbC5mcg==
 * amounier@et.esiea.fr : YW1vdW5pZXJAZXQuZXNpZWEuZnI= dridri_du91@hotmail.fr :
 * ZHJpZHJpX2R1OTFAaG90bWFpbC5mcg==
 */