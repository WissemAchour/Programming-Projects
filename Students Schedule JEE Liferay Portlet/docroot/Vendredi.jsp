<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import  = "java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="com.mvc.portlets.Users" %> 
<%@page import="com.mvc.portlets.writeToDB" %> 
<%@page import="com.mvc.portlets.Cell" %> 
<%@page import="com.mvc.portlets.ReadFromDB" %> 
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="javax.persistence.Query"%>


<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();

%>



<%
int nbseance=0;
String[] classes={"EI-1-1","EI-1-2","EI-1-3","IA-1-1","IA-1-2","IA-1-3","MEC-1-1","MEC-1-2","MEC-1-3",
		"EI-2-1","EI-2-2","EI-2-3","IA-2-1","IA-2-2","IA-2-3","MEC-2-1","MEC-2-2","MEC-2-3"};

User user = ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)).getUser();
String name=user.getFullName();
List<String> horaire = new ArrayList<String>();

EntityManager entityManager;
entityManager = Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
EntityManager entity = entityManager;

java.util.List<Users> list =entity.createQuery("SELECT obj FROM Users obj",Users.class).getResultList();
String classe = null;

for(Users users : list){
	if(name.toUpperCase().equals(users.getName().toString().toUpperCase()))
		classe=users.getClasse().toString();
	
	}
//System.out.println(classe);
int nbpage=0;
for(int i=0;i<classes.length;i++){
if(classe.toUpperCase().equals(classes[i].toUpperCase()))	{
	nbpage=i+2;
	break;
}

}

//writeToDB wdb = new writeToDB("C:/Users/Wissem/Desktop/emploie.pdf",nbpage);
//wdb.writeInDB();
List<Cell> cells = new ArrayList<Cell>();
ReadFromDB RD = new ReadFromDB();
cells=RD.getList((nbpage-2)*36);

for(int i=0;i<cells.size();i++){
	if(cells.get(i).getHour().equals("empty")){
		
	}
	else if(horaire.isEmpty()){
		horaire.add(cells.get(i).getHour());
	}
	else if(!cells.get(i).getHour().equals(horaire.get(horaire.size()-1))){
		horaire.add(cells.get(i).getHour());
		
	}
}
nbseance=horaire.size();%>

 <html>
  <head>
    <!--<meta name="viewport" content="user-scalable=no,width=device-width" />-->
 </head>
 <body>
 
 
  
  <script type="text/javascript">
  document.write("<TABLE BORDER=1 CELLPADDING=2 CELLSPACING=2 WIDTH=900>"); 
	document.write("<TR>");
	  document.write("<TR>");

	<%String build="";
	String subclass="";
	String course="";
	String teacher="";
	String room="";%>
	
	  <%for (int i=0; i<horaire.size(); i++) {%>
		  
		     document.write("<TH><%=horaire.get(i)%></TH>");
		    
			  
		 <%}%>
	 document.write("</TR>");

	 
	 document.write("<TR>");

	  <%for (int i=0; i<horaire.size(); i++) {%>
		  
		     <%/*if(cells.get(i*6).getCourse1()==null){
		    	 var1="";
		     }else{
		    	 var1=cells.get(i*6).getCourse1();
		     }
		    	 
		     if(cells.get(i*6).getCourse2()==null){
		    	 var2="";
		     }else{
		    	 var2=cells.get(i*6).getCourse2();
		     }*/
		     
		     build="";
			    subclass=cells.get(i*horaire.size()+4).getSubclass1();
				 course=cells.get(i*horaire.size()+4).getCourse1();
				 teacher=cells.get(i*horaire.size()+4).getTeacher1();
				room=cells.get(i*horaire.size()+4).getRoom1();
				
				if(!subclass.equals("empty")){
					build+="<p>"+subclass+"</p>";
				}
				if(!course.equals("empty")){
					build+="<p>"+course+"</p>";
					
				}
				if(!teacher.equals("empty")){
					build+="<p>"+teacher+"</p>";
				}
				if(!room.equals("empty")){
					build+="<p>"+room+"</p>";
				}
		     
		    	 %>
		     document.write("<TH><%=build%></TH>"); 
		 <%}%>
	 document.write("</TR>");

	document.write(" </TR> ");
	document.write("</TABLE>");
</SCRIPT>
  
 </body>
</html>


<portlet:renderURL var="byday">
    <portlet:param name="mvcPath" value="/byday.jsp" />
</portlet:renderURL> 


<p>
<a href="<%= byday %>"> Back</a>
</p>