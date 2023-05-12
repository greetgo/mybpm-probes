package kz.mybpm.api.probe_02_create_boi;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ProbeCreateBoi {

  public static final String HOST  = "http://localhost:1313";
  @SuppressWarnings("SpellCheckingInspection")
  public static final String TOKEN = "3a059y6cy08zg5F9LEUCo6gL2vEz8f5$kgV68o0iWZ9GZp2NSqzBMHFIqqu$gyF12NCmBsGAd" +
    "eqAgM6mnWF8Cbwz87aXjktCgaX8zfZ0L2VLIBHhaU5U4V3w0sKUubSSOVnjKJeEz286krEA3CXF4fWsOEU7J8okRf2NFtUHYXbnkfK3w1N" +
    "sveTgKlYrjgzWRiTEEvVXSfCa8quRPfMrLw@@-KpIftqyEtwBvuRsqZ";

  public static void main(String[] args) throws Exception {

    CreateBoiInput input = new CreateBoiInput();
    input.boCode = "MAN";
    input.initialFieldValues.put("SURNAME", "Потапенко");
    input.initialFieldValues.put("NAME", "Алексей");

    ObjectMapper objectMapper = new ObjectMapper();
    String       inputString  = objectMapper.writeValueAsString(input);

    //noinspection UastIncorrectHttpHeaderInspection
    HttpRequest request = HttpRequest.newBuilder()
                                     .uri(URI.create(HOST + "/api/v1/boi/create"))
                                     .POST(HttpRequest.BodyPublishers.ofString(inputString, StandardCharsets.UTF_8))
                                     .header("Content-Type", "application/json")
                                     .header("token", TOKEN)
                                     .build();

    HttpClient           client   = HttpClient.newHttpClient();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    int statusCode = response.statusCode();
    System.out.println("8Qqq012nzU :: statusCode = " + statusCode);

    if (statusCode != 200) {
      throw new RuntimeException("w9b4nUu3im :: No request. Status code = " + statusCode);
    }

    String          bodyString = response.body();
    CreateBoiOutput out        = objectMapper.readValue(bodyString, CreateBoiOutput.class);

    System.out.println("iv12tEUSme :: out = " + out);

  }
}
