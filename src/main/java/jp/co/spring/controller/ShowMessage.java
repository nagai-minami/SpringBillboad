package jp.co.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowMessage {

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showMessage(Model model) {
		model.addAttribute("message", "hello world!!");
		return "showMessage";
	}

}
