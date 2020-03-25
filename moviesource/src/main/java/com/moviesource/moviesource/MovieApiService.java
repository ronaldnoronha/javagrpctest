package com.moviesource.moviesource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;


public class MovieApiService {

    public JSONArray getMovies() {
        HttpClient httpclient = HttpClients.createDefault();
        JSONArray jsonArray = new JSONArray();
//        String url = "https://www.eventcinemas.com.au/Movies/GetNowShowing";
        String url = "https://api.covid19api.com/summary";
        try
        {
            URI uri = new URI(url);
            HttpGet request = new HttpGet(uri);
            StringEntity reqEntity = new StringEntity("{body}");
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            JSONObject obj1 = new JSONObject(EntityUtils.toString(entity));
//            obj1 = obj1.getJSONObject("Data");
//            jsonArray = obj1.getJSONArray("Movies");
            jsonArray = obj1.getJSONArray("Countries");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return jsonArray;
    }


}
