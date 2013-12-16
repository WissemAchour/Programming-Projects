<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="javax.portlet.PortletPreferences" %>

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();

%>

<html>
<head>
</head>
<body>

</body>
</html>


<h3>Viewer by day</h3>
<portlet:renderURL var="viewGreetingURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL> 

<portlet:renderURL var="Lundi">
    <portlet:param name="mvcPath" value="/Lundi.jsp" />
</portlet:renderURL> 

<portlet:renderURL var="Mardi">
    <portlet:param name="mvcPath" value="/Mardi.jsp" />
</portlet:renderURL> 

<portlet:renderURL var="Mercredi">
    <portlet:param name="mvcPath" value="/Mercredi.jsp" />
</portlet:renderURL>
 
<portlet:renderURL var="Jeudi">
    <portlet:param name="mvcPath" value="/Jeudi.jsp" />
</portlet:renderURL> 

<portlet:renderURL var="Vendredi">
    <portlet:param name="mvcPath" value="/Vendredi.jsp" />
</portlet:renderURL> 

<portlet:renderURL var="Samedi">
    <portlet:param name="mvcPath" value="/Samedi.jsp" />
</portlet:renderURL> 

<p>
<a href="<%= Lundi %>"> Lundi</a>
</p>
<p>
<a href="<%= Mardi %>"> Mardi</a>
</p>
<p>
<a href="<%= Mercredi%>"> Mercredi</a>
</p>
<p>
<a href="<%= Jeudi%>"> Jeudi</a>
</p>
<p>
<a href="<%= Vendredi%>"> Vendredi</a>
</p>
<p>
<a href="<%= Samedi %>"> Samedi</a>
</p>



<p>
<a href="<%= viewGreetingURL %>"> Back</a>
</p>