package jp.co.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.BeanUtils;
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
public class SignUpController {

	@Autowired
	private SettingService settingService;

	/*
	 * =================
	 * ユーザー登録画面
	 * =================
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String setting(Model model) {

		List<UserDto> users = settingService.getAll();

		SettingForm form = new SettingForm();
		model.addAttribute("settingForm", form);
		model.addAttribute("users", users);
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String getFormInfo(@Valid @ModelAttribute SettingForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "signup";

		} else {
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(form, dto);
			int count = settingService.insertUser(dto);

			Logger.getLogger(SignUpController.class).log(Level.INFO, "挿入件数は" + count + "件です。");

			return "redirect:./";
		}
	}
}
