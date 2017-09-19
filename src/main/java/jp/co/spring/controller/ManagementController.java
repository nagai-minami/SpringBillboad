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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.spring.dto.UserDto;
import jp.co.spring.form.SettingForm;
import jp.co.spring.service.SettingService;

@Controller
public class ManagementController {

	@Autowired
	private SettingService settingService;

	/*
	 * =================
	 * ユーザー管理画面
	 * =================
	 */
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public String setting(Model model) {

		List<UserDto> users = settingService.getAll();

		model.addAttribute("users", users);
		return "management";
	}

	/*
	 * -----------------
	 * ユーザー削除
	 * -----------------
	 */
	@RequestMapping(value = "/management/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(Model model,  @PathVariable int id) {
		settingService.deleteUser(id);
		return "redirect:/management";
	}


	/*
	 * =================
	 * ユーザー編集画面
	 * =================
	 *
	 */

	@RequestMapping(value = "/management/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model,  @PathVariable int id){

		UserDto user = settingService.getUser(id);
		model.addAttribute("user", user);
		SettingForm form = new SettingForm();
		form.setLoginId(user.getLoginId());
		form.setName(user.getName());
		form.setPassword(user.getPassword());
		form.setBranch(user.getBranch());
		form.setPosition(user.getPosition());
		model.addAttribute("settingForm", form);
		return "edit";
	}

	@RequestMapping(value = "/management/edit/{id}", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute SettingForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "/management/edit/{id}";

		} else {
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(form, dto);
			int count = settingService.updateUser(dto);

			Logger.getLogger(SignUpController.class).log(Level.INFO, "挿入件数は" + count + "件です。");

			return "redirect:/management";
		}
	}

}
