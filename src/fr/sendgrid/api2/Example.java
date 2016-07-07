package fr.sendgrid.api2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;
import com.sendgrid.smtpapi.SMTPAPI;

/**************************************************************************************************************************/
/************************************* GOOGLE LIBRARY USING SENDGRID TO SEND MAILS ****************************************/
/**************************************************************************************************************************/

public class Example {
  public static void main(String[] args) throws JSONException, IOException {
   
	  SendGrid mail = new SendGrid("amounier","IsiAM2016$");
	  mail.setTo("dridri_du91@hotmail.fr").setFrom("amounier@isilis.fr").setSubject("Subject goes here").setText("Hello World!").setHtml("<strong>Hello World!</strong>");
	  mail.send();
  }
}