package request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class APITestPost {

    public static void main(String[] args) {
        // Create an HttpClient
        HttpClient client = HttpClients.createDefault();

        // Prepare the API request
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/";
        HttpPost request = new HttpPost(apiUrl);

        for (int i = 201; i <= 210; i++) {
			
		
        try {
            // Set the request headers
            request.addHeader("Content-Type", "application/json");

            // Set the request body
            String requestBody1= "{\"id\": \"1\", \"userId\": \"";
            String requestBody = requestBody1 + i + "\", \"title\": \"Test\", \"comments\": \"201\"}";
            StringEntity entity = new StringEntity(requestBody);
            request.setEntity(entity);

            // Execute the request
            HttpResponse response = client.execute(request);

            // Get the response status code
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Status code: " + statusCode);

            // Get the response body
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);
            System.out.println("Response body: " + responseBody);
            
            //Assert
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Release the connection resources
            request.releaseConnection();
        }
        }
    }
}
