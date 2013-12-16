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
<%@page import="com.itextpdf.text.pdf.PdfReader" %>  
<%@page import="com.mvc.portlets.PDFCreator" %>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="javax.persistence.Query"%>
<%@page import= "javax.portlet.ActionRequest"%>

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>


<% 
PdfReader reader = new PdfReader("C:/Users/Wissem/Desktop/emploie.pdf");
writeToDB db = new writeToDB("C:/Users/Wissem/Desktop/emploie.pdf", reader.getNumberOfPages()-9);
db.writeInDB();
%>


<h3>Data Base Updated!</h3> 
<portlet:renderURL var="viewGreetingURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL> 


<p>
<a href="<%= viewGreetingURL %>"> Back</a>
</p>