package report;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.ZooDAOImpl;

import model.Zoo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class ZooReport
 */
@WebServlet("/ZooReport")
public class ZooReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ZooDAOImpl dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
   
    public ZooReport() {
        super();
       
        	dao = new ZooDAOImpl() {
			
			@Override
			public void updateZoo(Zoo zoo) {
				// TODO Auto-generated method stub
				
				
				
			}
			
			@Override
			public Zoo readZoo(Long id_zoom) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Zoo> readAllZoos() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteZoo(Long id_zoom) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createZoo(Zoo zoo) {
				// TODO Auto-generated method stub
				
			}
		};
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "F:\\Lecteur\\ALV_Unidad3\\src\\report\\zooReport1.jrxml";
		try {
			
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			Map<String, Object> data = new HashMap<String, Object>();
			 data.put("image_mia1", this.getServletContext().getRealPath("/")+"/image/image_mia1.png");
			 data.put("image_zoo", this.getServletContext().getRealPath("/")+"/image/image_zoo.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnetion());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
				
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
