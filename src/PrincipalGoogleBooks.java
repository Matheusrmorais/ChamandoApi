import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalGoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome de um livro Google Books: ");
        var livro = sc.nextLine();
        String livrofinal = URLEncoder.encode(livro, StandardCharsets.UTF_8);
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + livrofinal + "&key=AIzaSyCXrdNf9gAsWceOHRrNIBZ1YBA2mL30v4c";

        //https://www.googleapis.com/books/v1/volumes?q=harry%20potter&key=AIzaSyCXrdNf9gAsWceOHRrNIBZ1YBA2mL30v4c
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());





    }
}
