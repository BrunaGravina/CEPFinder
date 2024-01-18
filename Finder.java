import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Finder {

    public Address findAddress(String cep){
        URI address = URI.create("https://viacep.com.br/ws/" + cep + "/json");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException("Não consegui obter endereço a partir deste CEP.");
        }
        return new Gson().fromJson(response.body(), Address.class);
    }
}
