<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="javax.portlet.PortletPreferences" %>

<portlet:defineObjects />

<liferay-ui:success key="success" message="greeting saved succesfully!"/>



<portlet:renderURL var="editGreetingURL">
<portlet:param name="mvcPath" value="/edit.jsp"/>

</portlet:renderURL>

<portlet:renderURL var="byday">
<portlet:param name="mvcPath" value="/byday.jsp"/>

</portlet:renderURL>

<portlet:renderURL var="genPDF">
<portlet:param name="mvcPath" value="/pdf.jsp"/>

</portlet:renderURL>


<portlet:renderURL var="update">
<portlet:param name="mvcPath" value="/update.jsp"/>

</portlet:renderURL>

<h3>Schedule For Students</h3>
<p>
<p><a href="<%=editGreetingURL %>"> <input type="button"  value="Viewer For all week"> </a></p>
<p><a href="<%=byday %>"> <input type="button"   		  value="Viewer by day         "> </a></p>
<p><a href="<%=genPDF %>"> <input type="button"   		  value="Download PDF        "> </a></p>
<p><a href="<%=update %>"> <input type="button"   		  value="Update Data Base   "> </a></p>
<p>Wissem Achour</p>
<p>Année Universitaire 2013/2014</p>

</p>


