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

import fr.eilco.EJB.EJBProduitRemote;
import fr.eilco.model.Produit;
import fr.eilco.EJB.EJBProduitRemote;
import fr.eilco.model.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/Produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Produit bean = new Produit();
 		HttpSession session = request.getSession(true);
 		Produit p= new Produit();
 		List<Produit> listP= new ArrayList<Produit>();
 		//Connexion JNDI (annuaire pour localiser l'EJB)
 		try{
 		final Hashtable jndiProperties = new Hashtable();
 		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
 		final Context context = new InitialContext(jndiProperties);
 		final String appName = "CatalogueEAR";
 		final String moduleName = "HelloEJBProject";
 		//final String distinctName = ""; //localier ejb sur jboss 7.2
 		//sur jboss eap n'est plus nécessaire de spécifier distinct name
 		final String beanName = "EJBProduit";
 		final String viewClassName = EJBProduitRemote.class.getName();
 		//HelloEJBRemote remote = (HelloEJBRemote)
 		// context.lookup("ejb:"+appName+"/"+moduleName+"/"+
 		//"/"+distinctName+"/"+beanName+"!"+viewClassName);
 		EJBProduitRemote remote = (EJBProduitRemote)
 		context.lookup("ejb:"+appName+"/"+moduleName+"/"+
 		beanName+"!"+viewClassName);
 		
 		p = remote.getProduit(1);
 		listP= remote.getAllProduit();
 		}catch (Exception e) {
 		e.printStackTrace();
 		}
 		//bean.
		session.setAttribute("Produit", p);
		session.setAttribute("listeProduit", "test");
		response.sendRedirect("Produit.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
