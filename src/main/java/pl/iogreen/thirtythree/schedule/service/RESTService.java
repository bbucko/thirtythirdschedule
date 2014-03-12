package pl.iogreen.thirtythree.schedule.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RESTService extends IntentService {

    private static final String TAG = RESTService.class.getSimpleName();

    public RESTService() {
        super("RESTService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final RequestQueue queue = Volley.newRequestQueue(this);
        final JsonArrayRequest jsonSpeakerRequest = new JsonArrayRequest("http://2014.33degree.org/speaker/list.json", createSpeakerHandler(), createErrorHandler());
        final JsonArrayRequest jsonTalkRequest = new JsonArrayRequest("http://2014.33degree.org/talk/list.json", createTalkHandler(), createErrorHandler());

        queue.add(jsonSpeakerRequest);
        queue.add(jsonTalkRequest);
    }

    private Response.Listener<JSONArray> createTalkHandler() {
        return new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.i(TAG, "Response OK: " + response.toString());

                try {
                    for (int i = 0; i < response.length(); i++) {
                        final JSONObject jsonObject = response.getJSONObject(i);
                        final String id = jsonObject.getString("id");
                        final String description = jsonObject.getString("description");
                        final Long speakerId = jsonObject.isNull("speaker") ? null : jsonObject.getJSONObject("speaker").getLong("id");
                        final Long speaker2Id = jsonObject.isNull("speaker2") ? null : jsonObject.getJSONObject("speaker2").getLong("id");

                        Log.i(TAG, id + " " + description + " " + speakerId + " " + speaker2Id);
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Response Parsing ERROR: " + e.getMessage(), e);
                }
            }
        };
    }

    private Response.Listener<JSONArray> createSpeakerHandler() {
        return new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.i(TAG, "Response OK: " + response.toString());

                try {
                    for (int i = 0; i < response.length(); i++) {
                        final JSONObject jsonObject = response.getJSONObject(i);
                        final String id = jsonObject.getString("id");
                        final String bio = jsonObject.getString("bio");
                        final String firstName = jsonObject.getString("firstName");
                        final String lastName = jsonObject.getString("lastName");

                        Log.i(TAG, id + " " + firstName + " " + lastName + " " + bio);
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Response Parsing ERROR: " + e.getMessage(), e);
                }
            }
        };
    }

    private Response.ErrorListener createErrorHandler() {
        return new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Response ERROR: " + error.getMessage(), error);
            }
        };
    }
}
