package jp.co.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.spring.dto.UserDto;
import jp.co.spring.form.SettingForm;
import jp.co.spring.service.SettingService;

@Controller
public class LoginController {

	@Autowired
	private SettingService settingService;

	/*
	 * =================
	 * ログイン画面
	 * =================
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(@Valid @ModelAttribute SettingForm form, BindingResult result, Model model) {

		String loginId = form.getLoginId();
		String password = form.getPassword();
		UserDto user = settingService.getLoginUser(loginId, password);

		if(user == null){
			model.addAttribute("message", "ログインに失敗しました");
			return "login";
		} else{

		return "redirect:./";

		}
	}
}
