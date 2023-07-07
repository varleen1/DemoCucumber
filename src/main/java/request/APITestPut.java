package request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class APITestPut {

    public static void main(String[] args) {
        // Create an HttpClient
        HttpClient client = HttpClients.createDefault();

        // Prepare the API request
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/1";
        HttpPut request = new HttpPut(apiUrl);

        try {
            // Set the request headers
            request.addHeader("Content-Type", "application/json");

            // Set the request body
            String requestBody = "{\"id\": \"1\", \"userId\": \"201\", \"title\": \"Test 123\", \"comments\": \"202\"}";
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Release the connection resources
            request.releaseConnection();
        }
    }
}
