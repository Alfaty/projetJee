<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebCatalog | <%= request.getParameter("title") %></title>
<link type="text/css" rel="stylesheet"  href="css/WebCatalog.css" />
</head>
<body>

<div id="entete">
	WebCatalog
</div>
<div id="main">
 <div id="menu">
  Menu
  <ul>
		<li><a href="index.jsp">Accueil</a></li>
		<li><a href="categorie">Catégories</a></li>
		<li><a href="produit">Produits</a></li>
		<li><a href="Panier.jsp">Votre panier</a></li>
	</ul>
 </div>

 <div id="contenu">
 <% String content = request.getParameter("content"); %>
 <jsp:include page="<%= content %>">
 <jsp:param name="" value=""/>
 </jsp:include>
 </div>
</div>

<div id="footer">
 WebCatalog @2017 Félix Bouteraa
 </div>
</body>
</html>