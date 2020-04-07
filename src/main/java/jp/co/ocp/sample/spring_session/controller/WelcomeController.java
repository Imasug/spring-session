package jp.co.ocp.sample.spring_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(types = WelcomeForm.class)
public class WelcomeController {

	@ModelAttribute
	public WelcomeForm init() {
		return new WelcomeForm();
	}

	@GetMapping("/")
	public ModelAndView get(ModelAndView mav) {
		System.out.println("get");
		mav.setViewName("index");
		return mav;
	}

	@PostMapping("/")
	public ModelAndView post(@ModelAttribute WelcomeForm form, ModelAndView mav) {
		System.out.println("post");
		System.out.println(form);
		mav.setViewName("redirect:/");
		return mav;
	}
}
