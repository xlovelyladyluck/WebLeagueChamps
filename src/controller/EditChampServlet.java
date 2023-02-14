package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListChamp;

/**
 * Servlet implementation class EditChampServlet
 */
@WebServlet("/editChampServlet")
public class EditChampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditChampServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChampListHelper clh = new ChampListHelper();
		String champName = request.getParameter("champName");
		String funRank = request.getParameter("funRank");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListChamp champToUpdate = clh.searchForChampById(tempId);
		champToUpdate.setChampName(champName);
		champToUpdate.setFunRank(funRank);
		
		clh.updateItem(champToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllChampsServlet").forward(request, response);
		
	}

}
