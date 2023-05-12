package kz.mybpm.api.probe_01_auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ProbeAuth {

  public static final String HOST = "http://localhost:1313";

  public static void main(String[] args) throws Exception {

    AuthInput input = new AuthInput();
    input.email    = "asd@vin.com";
    input.timezone = "GMT+0600";
    //noinspection SpellCheckingInspection
    input.password = "111qweasdzxC!";

    ObjectMapper objectMapper = new ObjectMapper();
    String       inputString  = objectMapper.writeValueAsString(input);

    HttpRequest request = HttpRequest.newBuilder()
                                     .uri(URI.create(HOST + "/api/v1/json/auth/get-access-by-password"))
                                     .POST(HttpRequest.BodyPublishers.ofString(inputString, StandardCharsets.UTF_8))
                                     .header("Content-Type", "application/json")
                                     .build();

    HttpClient           client   = HttpClient.newHttpClient();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    int statusCode = response.statusCode();
    System.out.println("UzjUq9cLMG :: statusCode = " + statusCode);

    if (statusCode != 200) {
      throw new RuntimeException("uu88XQN0U7 :: No request. Status code = " + statusCode);
    }

    String     bodyString = response.body();
    AuthOutput authOutput = objectMapper.readValue(bodyString, AuthOutput.class);

    System.out.println("Ajl1EYaxTD :: token = " + authOutput.token);

  }
}
