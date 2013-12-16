package com.mvc.portlets;

import javax.persistence.EntityManager;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

public class jpatry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		pdf file = new pdf("http://phy.ntnu.edu.tw/~cchen/ctutor.pdf");
		file.DownloadPdf("emlpoieIA3");
		//SessionMessages.add(actionrequest, "success");
	/*	// TODO Auto-generated method stub

		
		EntityManager entity =DALUtil.getEntityManager();
		java.util.List<Users> list =entity.createQuery("SELECT obj FROM Users obj",Users.class).getResultList();
		
		String name="Wissem Achour";
		String classe = null;
		
		for(Users users : list){
			if(name.toUpperCase().equals(users.getName().toString().toUpperCase()))
				classe=users.getClasse().toString();
			
			}
				
				
		
		
		
			if(classe.toUpperCase().equals("IA3")){
		pdf file = new pdf("http://davidevitelaru.com/tutorials/programming/Lesson%201%20-%20Introduction%20to%20Programming.pdf");
		file.DownloadPdf("emlpoieIA3");
	
			}
			
			if(classe.toUpperCase().equals("IA2")){
				pdf file = new pdf("http://www.cplusplus.com/files/tutorial.pdf");
				file.DownloadPdf("emlpoieIA2");
			
					}
			
			if(classe.toUpperCase().equals("IA1")){
				pdf file = new pdf("http://phy.ntnu.edu.tw/~cchen/ctutor.pdf");
				file.DownloadPdf("emlpoieIA1");
				
					}*/
			
		}
	}


