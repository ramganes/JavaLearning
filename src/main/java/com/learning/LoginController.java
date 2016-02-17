package com.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping("/index")
	public @ResponseBody ModelAndView updateLoginDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.html");
        return mv;		
	}
	
	@RequestMapping(value="/submitDetails", method=RequestMethod.POST)
	public @ResponseBody void submitLoginDetails(@RequestBody String loginDetails) throws Exception {
		System.out.println("LoginController***");
		loginDao.updateLoginDetails(loginDetails);
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
        return mv;*/		
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}
}
