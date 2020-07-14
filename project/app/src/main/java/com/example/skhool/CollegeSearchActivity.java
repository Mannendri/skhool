package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CollegeSearchActivity extends AppCompatActivity {
    EditText collegeNameEditText;
    Button searchCollegeName;
    TextView collegeNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_search);

        collegeNameEditText = findViewById(R.id.collegeNameEditText);
        searchCollegeName = findViewById(R.id.searchCollegeName);
        collegeNameText = findViewById(R.id.nameOfCollege);
    }

    public void fetchData(View view) {
        // Instantiate the RequestQueue.
        final String queriedName = collegeNameEditText.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://raw.githubusercontent.com/Hipo/university-domains-list/master/world_universities_and_domains.json";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
//                        textView.setText("Response is: "+ response.substring(0,500));
                        try{

                            JSONArray responseArray= new JSONArray(response);
                            for(int i=0; i < responseArray.length(); i++){
                                JSONObject currentObject = responseArray.getJSONObject(i);
                                String collegeName = currentObject.getString("name");
                                if(queriedName.equals(collegeName)){
                                    collegeNameText.setText(collegeName);
                                }
                            }

                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}