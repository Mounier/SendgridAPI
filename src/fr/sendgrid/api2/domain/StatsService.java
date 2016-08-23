package fr.sendgrid.api2.domain;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.HttpResponseException;
import org.json.JSONException;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StatsService {
	
	private GlobalStatsElement globalStatsElement = new GlobalStatsElement();
	private String apiKey;
	
	public GlobalStatsElement getGlobalStatsElement() {
		return globalStatsElement;
	}
	public void setGlobalStatsElement(GlobalStatsElement globalStatsElement) {
		this.globalStatsElement = globalStatsElement;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	@Override
	public String toString() {
		return "StatsService [globalStatsElement=" + globalStatsElement + ", apiKey=" + apiKey + "]";
	}
	
	public StatsService(GlobalStatsElement globalStatsElement, String apiKey) {
		super();
		this.globalStatsElement = globalStatsElement;
		this.apiKey = apiKey;
	}
	
	public StatsService(String apiKey) {
		super();
		this.apiKey = apiKey;
	}
	
	public StatsService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GlobalStatsElement[] retrieveAllStats() throws Exception {
		
		GlobalStatsElement[] stats = null;
		
		try {
			SendGrid sg = new SendGrid(this.apiKey);
		    Request request = new Request();
		    request.method = Method.GET;
		    request.endpoint = "stats";
		    Map<String,String> queryParams = new HashMap<String, String>();
		    queryParams.put("aggregated_by", "day");
		    queryParams.put("start_date", "2016-07-01");
		    queryParams.put("end_date", "2016-08-05");
		    request.queryParams = queryParams;
		    Response response = sg.api(request);
		    System.out.println(response.statusCode);
		    System.out.println(response.body);
		    System.out.println(response.headers);
		    
		    
		    Gson gson = new Gson();
		    JsonParser parser = new JsonParser();
		    JsonObject objetGlobalStatsElement = parser.parse(response.body).getAsJsonObject();
		    JsonArray globalStatsElementJsonArray;
		    globalStatsElementJsonArray = objetGlobalStatsElement.getAsJsonArray("");
		    for (int i = 0; i < globalStatsElementJsonArray.size(); i++) {
				GlobalStatsElement temp = gson.fromJson(globalStatsElementJsonArray.get(i), GlobalStatsElement.class);
				stats[i]=temp;
			}
		} catch (IOException ex) {
		    throw ex;
		}
		return stats;
	}
}
