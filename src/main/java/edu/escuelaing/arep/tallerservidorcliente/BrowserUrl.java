/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.tallerservidorcliente;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Daniel
 */
public class BrowserUrl {
    public static void main(String[] args) throws Exception {
        readUrl("https://www.google.com/");
    }
    
    public static void readUrl(String site){
        try{
            URL siteUrl = new URL(site);
            try{
                URLConnection urlConnection = siteUrl.openConnection();
                Map<String, List<String>> headers = urlConnection.getHeaderFields();
                Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
                for(Map.Entry<String,List<String>> entry: entrySet){
                    String headerName = entry.getKey();
                    if(headerName != null){
                        System.out.println(headerName + ":");
                    }
                    List<String> headerValues = entry.getValue();
                    for(String value: headerValues){
                        System.out.println(value);                       
                    }
                    System.out.println("");
                    System.out.println("----------------------Message-Body--------------");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String inputLine =null;
                    while((inputLine = reader.readLine()) != null){
                        System.out.println(inputLine);
                    }
                }
            }catch(IOException x){
                System.err.println(x);
            }
        }catch(MalformedURLException e){
            e.getStackTrace();
            
        }
        
    }
}
