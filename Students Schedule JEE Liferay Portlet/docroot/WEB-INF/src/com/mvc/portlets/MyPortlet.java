package com.mvc.portlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;




import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MyPortlet extends MVCPortlet{

	/**
	 * @param args
	 */
	public void processAction(ActionRequest actionrequest, ActionResponse actionresponse) throws IOException , PortletException{
		
		PortletPreferences prefs = actionrequest.getPreferences();
		String button = actionrequest.getParameter("all");
		//EntityManager entity =DALUtil.getEntityManager();
		//java.util.List<Users> list =entity.createQuery("SELECT obj FROM Users obj",Users.class).getResultList();
		//User user = ((ThemeDisplay) actionrequest.getAttribute(WebKeys.THEME_DISPLAY)).getUser();
		//String name=user.getFullName();
		/*String classe = null;
		
		for(Users users : list){
			if(name.toUpperCase().equals(users.getName().toString().toUpperCase()))
				classe=users.getClasse().toString();
			
			}*/
		
		
		if(button!=null){
				System.out.println("hello i'm here");
		}
		
		//if(button_pdf!=null){
		/*	
			if(classe.toUpperCase().equals("IA3")){
				
				pdf file = new pdf("http://davidevitelaru.com/tutorials/programming/Lesson%201%20-%20Introduction%20to%20Programming.pdf");
				file.DownloadPdf("emlpoieIA3");
		SessionMessages.add(actionrequest, "success");
			}
			
			else if(classe.toUpperCase().equals("IA2")){
				pdf file = new pdf("http://www.cplusplus.com/files/tutorial.pdf");
				file.DownloadPdf("emlpoieIA2");
				SessionMessages.add(actionrequest, "success");
					}
			
			else if(classe.toUpperCase().equals("IA1")){
				pdf file = new pdf("http://phy.ntnu.edu.tw/~cchen/ctutor.pdf");
				file.DownloadPdf("emlpoieIA1");
				SessionMessages.add(actionrequest, "success");
					}
			
			else ;*/
		/*	String INPUTFILE = "C:\\Users\\Wissem\\Desktop\\Promo_IA1.pdf"; //Specifying the file location. 
			String out2 = "C:\\Users\\Wissem\\Desktop\\try.txt";
			 PdfReader reader = new PdfReader(INPUTFILE);
			 PdfReaderContentParser parser = new PdfReaderContentParser(reader); 
			 PrintWriter out = new PrintWriter(new FileOutputStream(out2)); 
			 TextExtractionStrategy strategy;
			 for (int i = 1; i <= 3; i++) { strategy = parser.processContent(i, new SimpleTextExtractionStrategy()); out.println(strategy.getResultantText()); } 
			 out.flush(); out.close(); reader.close();*/
			
		//}
			
		super.processAction(actionrequest, actionresponse);
	
	
	  }

	  }
	
