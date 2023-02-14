package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListChamp;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToChamp");
		String path = "/viewAllChampsServlet";
		
		if(act.equals("delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListChamp itemToDelete = clh.searchForChampById(tempId);
				clh.deleteItem(itemToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an champ");
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListChamp champToEdit = clh.searchForChampById(tempId);
				request.setAttribute("champToEdit", champToEdit);
				path = "/edit-champ.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a champ");
			}
		}else if(act.equals("add")) {
			
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
