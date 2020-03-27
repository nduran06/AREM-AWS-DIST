package edu.escuelaing.arem.spark;


import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import spark.Request;
import spark.Response;

public class SparkApp {
	
    public static void main( String[] args ){
    	port(getPort());
        get("square", (req, res)->getSquarePage());
        get("squareResult", (req, res)->getSquareResultPage(req, res));
    }
    
    private static String getSquareResultPage(Request req, Response res) {
    	
        String inputValue = req.queryParams("number");
        URL url=null;
        BufferedReader reader=null;
        String readInput=null;
        Integer numberSquare=0;

		try {

			url=new URL("https://53fxx0gpsi.execute-api.us-east-1.amazonaws.com/beta?value=" + inputValue); 
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((readInput=reader.readLine())!=null) {
				numberSquare=Integer.parseInt(readInput);
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
    	String page= 
    	"<!DOCTYPE html>"
        + "<html>"
        + "<body>"
        + "<h1>Square</h1>"
        + "<br/>"
        + "Result: "+ numberSquare
        + "</body>"
        + "</html>";
    	return page;
	}
    
    private static String getSquarePage() {
    	String page= 
    	"<!DOCTYPE html>"
        + "<html>"
        + "<body>"
        + "<h1>Square of a Number</h1>"
        + "<form action=\"/squareResult\">"
        + "  Instert a number<br>"
        + "  <input type=\"text\" name=\"number\"> <br/><br/>"
        + "  <input type=\"submit\" value=\"Calculate\">"
        + "</form>"
        + "</body>"
        + "</html>";
    	return page;
	}
    
   


	static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 14789;
    }
}
