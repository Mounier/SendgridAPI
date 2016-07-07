//package fr.sendgrid.api2.garbage;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import fr.sendgrid.api2.domain.CsvFile;
//import fr.sendgrid.api2.domain.RecipientFromCsvFile;
//
//public class CsvRecipientDao1 implements RecipientDao {
//	private CsvFile csvFile;
//	
//	private CsvRecipientDao1() {
//		super();
//	}
//	
//	public CsvRecipientDao1(File file) throws IOException {
//		this.csvFile = new CsvFile(file);
//	}
//
//	@Override
//	public List<RecipientFromCsvFile> findAllContacts() {
//		final List<RecipientFromCsvFile> contacts = new ArrayList<RecipientFromCsvFile>();
//		final List<Map<String,String>> mappedData = csvFile.getMappedData();
//		
//		for(Map<String,String> map : mappedData) {
//			RecipientFromCsvFile contact = mapToContact(map);
//			contacts.add(contact);
//		}
//		
//		return contacts;
//	}
//
//	private RecipientFromCsvFile mapToContact(Map<String, String> map) {
//		
//		final SimpleRecipient contact = new SimpleRecipient();
//		final String email = map.get("email");
//		final String firstName = map.get("first_name");
//		final String lastName = map.get("last_name");
//		final String region = map.get("geo_region");
//		final String city = map.get("geo_city");
//		final String id = map.get("id");
//		
//		contact.setEmail(email);
//		contact.setFirstName(firstName);
//		contact.setLastName(lastName);
//		contact.setRegion(region);
//		contact.setCity(city);
//		contact.setId(Integer.parseInt(id));
//		
//		return contact;
//	}
//}
