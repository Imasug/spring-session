package jp.co.ocp.sample.spring_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public ModelAndView get(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
}
