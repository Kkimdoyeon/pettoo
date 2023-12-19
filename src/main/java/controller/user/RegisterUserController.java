package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.CommunityDto;
import model.UserDto;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("RegisterForm Request");

    		List<CommunityDto> commList = UserManager.getInstance().findCommunityList();	// 커뮤니티 리스트 검색
			request.setAttribute("commList", commList);	
		
			return "/user/joinForm.jsp";   // 검색한 커뮤니티 리스트를 registerForm으로 전송     	
	    }	

    	// POST request (회원정보가 parameter로 전송됨)
       	UserDto user = new UserDto(
			request.getParameter("userId"),
			request.getParameter("userPw"),
			request.getParameter("userName"),
			request.getParameter("address"),
			request.getParameter("gender"),
			request.getParameter("email"),
			request.getParameter("phoneNumber"),
			request.getParameter("userBirth"),
			request.getParameter("petId"),
			Integer.parseInt(request.getParameter("comm_numm")));
		
        log.debug("Create User : {}", user);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
	        return "redirect:/user/login";	// 성공 시 로그인 화면으로 redirect
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/user/joinFrom.jsp";
		}
    }
}

