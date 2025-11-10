package exersize;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FilmFetcher {
    public static String fetchFilm(String filmname) throws Exception {
        String url = String.format("http://www.omdbapi.com/?t=%s&apikey=97a5fe93", filmname);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .join();
    }
}
