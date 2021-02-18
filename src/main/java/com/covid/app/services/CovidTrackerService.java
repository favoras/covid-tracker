package com.covid.app.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CovidTrackerService {

    private String COVID_DATA_JSON = "https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";

    @PostConstruct
    public void fetchCovidData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(COVID_DATA_JSON))
                .build();
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }

}
