package com.codepath.sinkari.hottrailers.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sinkari on 2/12/18.
 */

public class Movie {

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    String posterPath;
    String originalTitle;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> res = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            try {
                res.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
