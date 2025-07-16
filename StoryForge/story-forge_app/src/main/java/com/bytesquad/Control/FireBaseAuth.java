package com.bytesquad.Control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FireBaseAuth {

        public boolean LoginWithEmailAndPassword(String email,String password){

        try{
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDRCG5_-hdVpUHAHsqvSt5dZX6ySes9fNw");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoOutput(true);
            String payload = String.format("{\"email\":\"%s\", \"password\":\"%s\", \"returnSecureToken\":true}", email,password);
            OutputStream ops = null;
            ops = httpURLConnection.getOutputStream();
            ops.write(payload.getBytes());

            int responseCode = httpURLConnection.getResponseCode();

            if(responseCode == 200){
                return true;
            }else{
                try(BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()))){
                    String line;
                    while((line=br.readLine()) != null){
                        System.out.println(line);
                    }
                }
                return false;
            }


        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    

        public boolean signUpWithEmailAndPassword(String email,String password){

        try{
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyAAX-JBvYoV1wwAOdRWUf7FT1hEgCs7mpc");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoOutput(true);
            String payload = String.format("{\"email\":\"%s\", \"password\":\"%s\", \"returnSecureToken\":true}", email,password);
            OutputStream ops = null;
            ops = httpURLConnection.getOutputStream();
            ops.write(payload.getBytes());

            int responseCode = httpURLConnection.getResponseCode();

            if(responseCode == 200){
                return true;
            }else{
                try(BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()))){
                    String line;
                    while((line=br.readLine()) != null){
                        System.out.println(line);
                    }
                }
                return false;
            }


        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }

}
