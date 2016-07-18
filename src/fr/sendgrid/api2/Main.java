package fr.sendgrid.api2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import fr.sendgrid.api2.DAO.CsvFileHelperDao;
import fr.sendgrid.api2.DAO.TxtFile;
import fr.sendgrid.api2.domain.RecipientFromCsvFile;
import fr.sendgrid.api2.domain.TemplateBody;
import fr.sendgrid.api2.service.RecipientService;
import fr.sendgrid.api2.service.TemplateService;
import fr.sendgrid.api2.window.FenetreTemplate;

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
				"******************************************************************************   Sending with sendV3  ********************************************************************************************");
		System.out.println(
				"***************************************************************************************************************************************************************************************");
		
		
//		recipientService.sendToV3(from, personalization, subject, template_id);
		
/*		Email from = new Email("amounier@isilis.fr"); 
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
		List<TemplateBody> listTemplate = new ArrayList<TemplateBody>();
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

}