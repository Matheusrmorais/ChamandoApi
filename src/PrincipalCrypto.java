import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalCrypto {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma criptomoeada para ver a cotação: ");
        var criptomoeada = sc.nextLine();
        String criptomoeadafinal = URLEncoder.encode(criptomoeada, StandardCharsets.UTF_8);
        String endereco = "https://api.coingecko.com/api/v3/simple/price?vs_currencies=usd&ids="+ criptomoeadafinal +"&x_cg_demo_api_key=sua_api";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


    }
}
