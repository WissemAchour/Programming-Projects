package com.mvc.portlets;


 
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.commons.io.*;
 
public class pdf extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  
	String link;
	
		public pdf(String link){
			
			this.link=link;
		}
		 
		
		 String dirName = System.getProperty("user.home");
		
		 public void DownloadPdf(String FileName){
			 
		 
			
		 try {
			 
			 if(SearchFile( FileName +".pdf")){
				 System.out.println("File found");
			OpenPdf(System.getProperty("user.home")+"\\"+FileName +".pdf");
			 }
			 else{
			System.out.println("downloading...");
			 saveFileFromUrl( dirName + "\\"+FileName +".pdf",link);
			 System.out.println("downloading complete!");
			 OpenPdf(System.getProperty("user.home")+"\\"+FileName +".pdf");
			 }
			 
			 
		  
		 } catch (MalformedURLException e) {
		 e.printStackTrace();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 
		}

		 
		
public static void saveFileFromUrl(String fileName, String fileUrl) throws MalformedURLException, IOException {

	     BufferedInputStream in = null;
		 FileOutputStream fout = null;
		 
		 try {
			 
			   URL url = new URL(fileUrl);
			   URLConnection conn = url.openConnection();
			 
			   conn.setDoOutput(true);
			   conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20100101 Firefox/21.0");
			   conn.setRequestProperty("Accept", "text/plain");
			  
			   
			   
		 in = new BufferedInputStream(conn.getInputStream());
		 fout = new FileOutputStream(fileName);
		 
		 byte data[] = new byte[1024];
		 int count;
		
		 while ((count = in.read(data, 0, 1024)) != -1) {
			 
		 fout.write(data, 0, count);
		 }
		 
		 }finally {
			
		 if (in != null)
		 in.close();
		 if (fout != null)
		 fout.close();
		 }
		
		 }
		 
		
		 public static void saveFileFromUrlWithCommonsIO(String fileName,String fileUrl) throws MalformedURLException, IOException {
			 
		 FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
		 
		 }
		 
		 public static void OpenPdf(String path){
			 
			 File file = new File(path);
			    if (file.toString().endsWith(".pdf"))
					try {
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
			        Desktop desktop = Desktop.getDesktop();
			        try {
						desktop.open(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			 
		 }
		 
		 public static boolean SearchFile(String FileName){
			 
			 List<String> textFiles = new ArrayList<String>();
			  File dir = new File(System.getProperty("user.home"));
			  for (File file : dir.listFiles()) {
			    if (file.getName().toUpperCase().equals(FileName.toUpperCase())) {
			      return true;
			    }
			  }
			  return false;
		 
	
	
    }
		 
		 public static void main(String[] args) {
				
				
				
				pdf file = new pdf("http://www.eniso.rnu.tn/files/bourses_alternance.pdf");
				file.DownloadPdf("try");
		 }
}
