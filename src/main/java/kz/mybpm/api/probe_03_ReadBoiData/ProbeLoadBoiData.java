package kz.mybpm.api.probe_03_ReadBoiData;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ProbeLoadBoiData {

  public static final String HOST  = "http://localhost:1313";
  @SuppressWarnings("SpellCheckingInspection")
  public static final String TOKEN = "3a059y6cy08zg5F9LEUCo6gL2vEz8f5$kgV68o0iWZ9GZp2NSqzBMHFIqqu$gyF12NCmBsGAdeqAgM6mnWF8Cbwz87" +
    "aXjktCgaX8zfZ0L2VLIBHhaU5U4V3w0sKUubSSOVnjKJeEz286krEA3CXF4fWsOEU7J8okRf2NFtUHYXbnkfK3w1NsveTgKlYrjgzWRiTEEvVXSfCa8quRPfMrLw@@-" +
    "KpIftqyEtwBvuRsqZ";

  public static void main(String[] args) throws Exception {
    LoadBoiInput input = new LoadBoiInput();
    input.boCode = "MAN";
    //noinspection SpellCheckingInspection
    input.boiId  = "5ldxtvMXIDf7qmY@";

    ObjectMapper objectMapper = new ObjectMapper();
    String       inputString  = objectMapper.writeValueAsString(input);

    //noinspection UastIncorrectHttpHeaderInspection
    HttpRequest request = HttpRequest.newBuilder()
                                     .uri(URI.create(HOST + "/api/v1/boi/load"))
                                     .POST(HttpRequest.BodyPublishers.ofString(inputString, StandardCharsets.UTF_8))
                                     .header("Content-Type", "application/json")
                                     .header("token", TOKEN)
                                     .build();

    HttpClient           client   = HttpClient.newHttpClient();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    int statusCode = response.statusCode();
    System.out.println("45TC1V4KTv :: statusCode = " + statusCode);

    if (statusCode != 200) {
      throw new RuntimeException("JRe483EoSK :: No request. Status code = " + statusCode);
    }

    String     bodyString = response.body();
    LoadBoiOut out        = objectMapper.readValue(bodyString, LoadBoiOut.class);

    System.out.println("93MJ0DUhUf :: out = " + out);
  }
}
