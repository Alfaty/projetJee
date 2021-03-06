package fr.info.sdweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eilco.EJB.EJBCategorieRemote;
import fr.eilco.model.Categorie;
import fr.eilco.EJB.EJBCategorieRemote;
import fr.eilco.model.Categorie;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/categorie")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Categorie bean = new Categorie();
 		HttpSession session = request.getSession(true);
 		Categorie c= new Categorie();
 		List<Categorie> listC= new ArrayList<Categorie>();
 		//Connexion JNDI (annuaire pour localiser l'EJB)
 		try{
 		final Hashtable jndiProperties = new Hashtable();
 		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
 		final Context context = new InitialContext(jndiProperties);
 		final String appName = "CatalogueEAR";
 		final String moduleName = "HelloEJBProject";
 		//final String distinctName = ""; //localier ejb sur jboss 7.2
 		//sur jboss eap n'est plus nécessaire de spécifier distinct name
 		final String beanName = "EJBCategorie";
 		final String viewClassName = EJBCategorieRemote.class.getName();
 		//HelloEJBRemote remote = (HelloEJBRemote)
 		// context.lookup("ejb:"+appName+"/"+moduleName+"/"+
 		//"/"+distinctName+"/"+beanName+"!"+viewClassName);
 		EJBCategorieRemote remote = (EJBCategorieRemote)
 		context.lookup("ejb:"+appName+"/"+moduleName+"/"+
 		beanName+"!"+viewClassName);
 		
 		c = remote.getCategorie(1);
 		listC= remote.getAllCategorie();
 		}catch (Exception e) {
 		e.printStackTrace();
 		}
 		//bean.
		session.setAttribute("categorie", c);
		session.setAttribute("listeCategorie", listC);
		response.sendRedirect("Categorie.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
