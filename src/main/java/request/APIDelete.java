package request;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Iterator;

public class APIDelete {

    public static void main(String[] args) throws InterruptedException {
        // Create an HttpClient
        HttpClient client = HttpClients.createDefault();

        for (int i = 201; i < 210; i++) {
			
		
        // Prepare the API request
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + i;
        HttpDelete request = new HttpDelete(apiUrl);

        try {
            // Execute the request
            HttpResponse response = client.execute(request);

            // Get the response status code
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Status code: " + statusCode);
            Thread.sleep(1000);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	 // Release the connection resources
            request.releaseConnection();
        }
        
        }
    }
}