/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.tallerservidorcliente;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Daniel
 */
public class URLScanner {
    
    public static void main(String[] args) throws MalformedURLException{
        scanUrl("https://arcane-earth-96304.herokuapp.com/juego");
    }
    public static void scanUrl(String site) throws MalformedURLException{
        try {
            URL siteUrl = new URL(site);
            System.out.println("Protocol:" + siteUrl.getProtocol());
            System.out.println("Host:" + siteUrl.getHost());
            System.out.println("Port:" + siteUrl.getPort());
            System.out.println("Path:" + siteUrl.getPath());
            System.out.println("File:" + siteUrl.getFile());
            System.out.println("Query:" + siteUrl.getQuery());
            System.out.println("Ref: " + siteUrl.getRef());
            System.out.println("Authority: " + siteUrl.getAuthority());                             
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
    }
    
}
