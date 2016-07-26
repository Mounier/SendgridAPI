package fr.sendgrid.api2.service;

import com.sendgrid.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class MailService {

    public final static String TEST_TEMPLATE_ID = "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";

    public final static String PARAM_TEMPLATE_ID = "template";
    public final static String PARAM_FROM = "from";
    public final static String PARAM_FROM_NAME = "from-name";
    public final static String PARAM_TO = "to";
    public final static String PARAM_TO_NAME = "to-name";
    public final static String PARAM_BCC = "bcc";
    public final static String PARAM_SUBJECT = "subject";
    private final static String API_KEY = "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";
    private SendGrid sendGrid;

    public MailService() {
        this.sendGrid = new SendGrid(API_KEY);
    }

    public void sendTemplateEmail(String template, File attachment, String emailFrom, String nameFrom, String emailTo, String nameTo, Map<String, String> variables) {
        MailService mailService = new MailService();

        Map<String, String> params = new HashMap<>();
        params.put(MailService.PARAM_TEMPLATE_ID, template);
        params.put(MailService.PARAM_FROM_NAME, nameFrom);
        params.put(MailService.PARAM_FROM, emailFrom);
        params.put(MailService.PARAM_TO_NAME, nameTo);
        params.put(MailService.PARAM_TO, emailTo);

        try {
            mailService.send(params, variables, attachment);
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void send(Map<String, String> params, Map<String, String> substitutions, File attachment) throws IOException {
        // prepare the REST call to SendGrid API
        Request request = new Request();
        request.method = Method.POST;
        request.endpoint = "mail/send";

        // build the JSON structure for the REST call
        Mail mail = this.buildEmail(params, substitutions, attachment);
        request.body = mail.build();

        // do it
        Response response = this.sendGrid.api(request);
        
        System.out.println("sent an email, sengrid status: "+response.statusCode+" "+response.body+" "+response.headers);
    }

    private Mail buildEmail(Map<String, String> params, Map<String, String> substitutions, File attachment) throws IOException {
        Mail result = new Mail();

        // use the designated template
        String templateId = params.get(PARAM_TEMPLATE_ID);
        result.setTemplateId(templateId);

        // build the From:
        String from = params.get(PARAM_FROM);
        Email fromEmail = new Email(from);

        // optional, the displayed From: name
        String fromName = params.get(PARAM_FROM_NAME);
        if (fromName != null) {
            fromEmail.setName(fromName);
        }
        result.setFrom(fromEmail);

        // set up the recipient and its associated variable substitutions
        Personalization personalization = new Personalization();

        // build the To:
        String to = params.get(PARAM_TO);
        Email toEmail = new Email(to);

        // optional, the displayed To: name
        String toName = params.get(PARAM_TO_NAME);
        if (toName != null) {
            toEmail.setName(toName);
        }
        personalization.addTo(toEmail);

        // add a Bcc: if asked
        String bcc = params.get(PARAM_BCC);
        if (bcc != null) {
            personalization.addBcc(new Email(bcc));
        }

        // Subject:
        String subject = params.get(PARAM_SUBJECT);
        result.setSubject(subject);
        personalization.setSubject(subject);

        // set up the variable substitutions
        if ((substitutions != null) && !substitutions.isEmpty()) {
            for (Map.Entry<String, String> currSubEntry : substitutions.entrySet()) {
                personalization.addSubstitution(currSubEntry.getKey(), currSubEntry.getValue());
            }
        }

        Content contentHtml = new Content("text/html", "Test HTML");	//	modifié
        result.addContent(contentHtml);

        // attachments
        if (attachment != null) {
            Attachments attachments = new Attachments();
            attachments.setContent(/* à changer */ Base64Utils.encodeToString(Files.readAllBytes(attachment.toPath())));	//	gerer le base64 encoding ici
            attachments.setType(/* à changer */ TIKA.detect(attachment));	//	TIKA ???
            attachments.setFilename(attachment.getName());
            attachments.setDisposition("attachment");
            attachments.setContentId(attachment.getName());
            result.addAttachments(attachments);
        }

        // add the one and only personalization
        result.addPersonalization(personalization);

        return result;
    }

}