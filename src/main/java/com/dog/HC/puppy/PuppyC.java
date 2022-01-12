package com.dog.HC.puppy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PuppyC {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String puppy(HttpServletRequest req) {
		
		req.setAttribute("loginPage", "main/loginPage.jsp");
		return "";
	}
}
