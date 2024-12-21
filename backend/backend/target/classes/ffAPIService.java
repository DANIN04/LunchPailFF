package com.lunchpailff;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ffAPIService {

    private static final String API_KEY = System.getProperty("api.key");
    private static final String BASE_URL = "https://api.fantasydata.com";

    public static String fetchDraftRankings() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(BASE_URL + "/v3/nfl/projections/json/PlayerSeasonProjectionStats")
                .addHeader("Ocp-Apim-Subscription-Key", API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("API call failed");
            }
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching data: " + e.getMessage();
        }
    }
}
