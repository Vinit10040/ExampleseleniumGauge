package Config;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;
	private final String propertyFilePath= "env//default//user.properties";

	
	public ConfigReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("APP_URL");
		if(url != null) return url;
		else throw new RuntimeException("Application url not specified in the Configuration.properties file.");
	}
	
	public String getUsername(){
		String username = properties.getProperty("USERNAME");
		if(username!= null) return username;
		else throw new RuntimeException("username not specified in the user.properties file.");		
	}
	
	public String getPassword(){
		String password = properties.getProperty("PASSWORD");
		if(password!= null) return password;
		else throw new RuntimeException("password not specified in the user.properties file.");		
	}
	public String getJobname() {
		String jobname = properties.getProperty("JOBNAME");
		if(jobname!= null) return jobname;
		else throw new RuntimeException("jobname  not specified in the user.properties file.");		

		
	}
	


}