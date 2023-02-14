package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListChamp;

/**
 * Servlet implementation class AddChampServlet
 */
@WebServlet("/addChampServlet")
public class AddChampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChampServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String champName = request.getParameter("champName");
		String funRank = request.getParameter("funRank");
		
		ListChamp lc = new ListChamp(champName, funRank);
		ChampListHelper clh = new ChampListHelper();
		clh.insertChamp(lc);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
