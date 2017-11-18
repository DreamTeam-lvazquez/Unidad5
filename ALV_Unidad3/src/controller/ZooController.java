package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ZooDAOImpl;
import model.Zoo;

/**
 * Servlet implementation class ZooController
 */
@WebServlet("/ZooController")
public class ZooController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Zoo zoo;
	private List<Zoo> zoos;
	private dao.ZooDAOImpl zooDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZooController() {
        super();
        zoo = new Zoo();
        zoos = new ArrayList<Zoo>();
        zooDAO = new ZooDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save")!= null) {
			
			zoo.setName(request.getParameter("name"));
			zoo.setNumber_animals(request.getParameter("number_animals"));
			zoo.setCity(request.getParameter("city"));
			if(zoo.getId_zoom()==0L) {
				zooDAO.createZoo(zoo);
						}else {
							zooDAO.updateZoo(zoo);
					}
					
			zoos = zooDAO.readAllZoos();
					request.setAttribute("zoos", zoos);
					request.getRequestDispatcher("zoo_list.jsp").forward(request, response);
					
				}else if (request.getParameter("btn_new")!=null) {
					zoo = new Zoo();
					request.getRequestDispatcher("zoo_form.jsp").forward(request, response);
					
				
				}else if(request.getParameter("btn_edit")!=null) {	
					try {
						Long id_zoom = Long.parseLong(request.getParameter("id_zoom"));
						zoo = zooDAO.readZoo(id_zoom);
						
					}catch (Exception e) {
						
						zoo = new Zoo();
					}
					request.setAttribute("zoo", zoo);
					
					request.getRequestDispatcher("zoo_form.jsp").forward(request, response);
					
					
					
				}else if(request.getParameter("btn_delete")!=null) {
				
					
					try {
					Long id_zoom = Long.parseLong(request.getParameter("id_zoom"));
					zooDAO.deleteZoo(id_zoom);
					zoos = zooDAO.readAllZoos();
					
					}catch(Exception e) {
						e.printStackTrace();
						
						
					}
					request.setAttribute("zoos", zoos);
					request.getRequestDispatcher("zoo_list.jsp").forward(request, response);
				}else {
					zoos = zooDAO.readAllZoos();
					request.setAttribute("zoos", zoos);
					request.getRequestDispatcher("zoo_list.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
