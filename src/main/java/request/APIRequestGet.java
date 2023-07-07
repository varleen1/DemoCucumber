package request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.junit.Assert;

import java.io.IOException;

public class APIRequestGet {

    public static void main(String[] args) {
        // Create an HttpClient
        HttpClient client = HttpClients.createDefault();

        // Prepare the API request
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/13";
        HttpGet request = new HttpGet(apiUrl);

        try {
            // Execute the request
            HttpResponse response = client.execute(request);

            // Get the response status code
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Status code: " + statusCode);
            Assert.assertEquals(statusCode, 200);
            
           // Assert

            // Get the response body
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            System.out.println("Response body: " + responseBody);
            
            Assert.assertTrue(responseBody.contains("et doloremque nulla"));
            
            // Assert

            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Release the connection resources
            request.releaseConnection();
        }
    }
}
