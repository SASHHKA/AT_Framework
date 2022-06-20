package client;


import constants.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TrelloHTTPClient {
    private final String KEY;
    private final String TOKEN;

    public TrelloHTTPClient() {
        this.KEY = Constants.KEY;
        this.TOKEN = Constants.TOKEN;
    }

    public HttpResponse<String> createOrganization(String organizationName, String linkName, String description) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "displayName": "%s",
                    "key": "%s",
                    "token": "%s",
                    "name":"%s",
                    "desc":"%s"
                }""", organizationName, KEY, TOKEN, linkName, description);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/organizations"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> updateOrganization(String id, String organizationName, String linkName, String description) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "id": "%s",
                    "displayName": "%s",
                    "name":"%s",
                    "desc":"%s"
                }""", organizationName, linkName, description);
        System.out.println(requestBody);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/organizations/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getOrganization(String id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/organizations/" + id + "?key=" + KEY + "&token=" + TOKEN))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }



}
