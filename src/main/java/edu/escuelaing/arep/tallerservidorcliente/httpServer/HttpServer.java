/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.tallerservidorcliente.httpServer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Daniel
 */
public class HttpServer {

 

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(36000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

 

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            try{
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains("GET")) {
                        realizaSolicitud(inputLine, clientSocket);
                    }
                    if (!in.ready()) {
                        break;
                    }
                }
            }catch (FileNotFoundException e){
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" +
                        "<html><head><title>404</title></head><body><h1>Error, pagina no encontrada</h1></body></html>");
            }catch (NullPointerException e){
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" +
                        "<html><head><title>404</title></head><body><h1>Error, pagina no encontrada</h1></body></html>");
            }           
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
        
    }
    
    public static void realizaSolicitud(String inputLine, Socket clientSocket) throws IOException {
        String[] URL = inputLine.split("/");
        String[] archivoSolicitud = URL[1].split(" ");
        String path = "/src/main/resources/" + archivoSolicitud[0];
        FileReader archivo = new FileReader(path);
        archivo.getFile(clientSocket);
    }
}
