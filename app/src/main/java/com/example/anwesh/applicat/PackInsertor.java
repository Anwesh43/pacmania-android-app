package com.example.anwesh.applicat;

/**
 * Created by Anwesh on 07-05-2015.
 */
import android.os.*;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.util.*;
import org.json.*;
import com.google.gson.*;
public class PackInsertor extends AsyncTask<Pacman,Integer,String> {
    public void onPreExecute() {

    }
    public String doInBackground(Pacman...params){
        String msg="";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://192.168.1.2:8000/insertMe");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
            Gson gson = new Gson();
            nameValuePairs.add(new BasicNameValuePair("pacman",gson.toJson(params[0])));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs);
            httpPost.setEntity(entity);
            String response = httpClient.execute(httpPost,responseHandler);
            msg = response;
        }
        catch(Exception exception) {
            msg="error";
        }
        return msg;
    }
    public void onPostExecute(String result) {

    }
}
