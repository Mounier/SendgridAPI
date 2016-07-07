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

import fr.sendgrid.api2.DAO.CsvFileHelperDao;
import fr.sendgrid.api2.domain.RecipientFromCsvFile;
import fr.sendgrid.api2.domain.RecipientFromSendgrid;
import fr.sendgrid.api2.domain.Template;
import fr.sendgrid.api2.service.Block;
import fr.sendgrid.api2.service.Invalid;
import fr.sendgrid.api2.service.RecipientService;
import fr.sendgrid.api2.service.Spam;
import fr.sendgrid.api2.service.TemplateService;

public class Main {

	public static void main(String[] args) throws Exception {
		
//		Clé API qui permet de s'authentifier
		String apiKey = "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";
		
		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Recipients   *********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");
		
//		Récupération des contacts contenu dans le fichier csv dans une liste
		System.out.println("Retrieving recipients..");
		final String FILE_NAME = "C:\\liste_contact.csv";
		File file = CsvFileHelperDao.getRessource(FILE_NAME);
		List<RecipientFromCsvFile> recipientsFromCsvList = new ArrayList<RecipientFromCsvFile>();
		RecipientService recipientService = new RecipientService(apiKey,file);
		recipientsFromCsvList = recipientService.RetrieveAllRecipientsFromCsvFile();
//		System.out.println(recipientsFromCsvList);
		
/*		
		System.out.println(
				"\n\n***************************************************************************************************************************************************************************************");
		System.out.println(
				"******************************************************************************   Sending   ********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");
		
		
		Email from = new Email("amounier@isilis.fr"); 
		String subject ="NOUVEAU SUJET"; // /!\ SI ON MET LE CARACTERE '°' DANS LE subjec ALORS ON OBTIENT UNE EXCEPTION /!\ 
		Content content = new Content("text/plain", "Ceci est un test");
		recipientService.sendTo(recipientsFromCsvList, from, subject, content);
*/		 		
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

		
	}

}