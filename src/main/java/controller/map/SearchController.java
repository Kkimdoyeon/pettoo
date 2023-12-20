package controller.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;

public class SearchController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
		String area1 =(String) request.getParameter("area1");
		String area2= (String) request.getParameter("area2");
		// Controller에서의 코드 예시
		String checkbox1Value = request.getParameter("checkbox1");
		String checkbox2Value = request.getParameter("checkbox2");
		String checkedBox = "";
		if (checkbox1Value != null) {
			checkedBox = "카페";
		}

		if (checkbox2Value != null) {
			if(checkedBox == "카페") checkedBox="";
			else
				checkedBox = "식당";
		}
		
		String result = area1+" "+area2+" 애견동반 "+checkedBox;
		request.setAttribute("result", result);
		
		return "/map/search.jsp";
	}
	

}
