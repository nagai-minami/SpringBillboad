package jp.co.spring.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.spring.dto.UserDto;
import jp.co.spring.service.SettingService;
import jp.co.spring.validator.annotaion.Repeat;

public class RepeatValidator implements ConstraintValidator<Repeat, String> {

	@Autowired
	private SettingService settingService;

	public void initialize(Repeat repeat) {
	}

	public boolean isValid(String input, ConstraintValidatorContext con) {

		List<UserDto> users = settingService.getAll();
		List<String> loginId = new ArrayList<String>();

		for (int i = 0; i <= users.size(); i++) {
			loginId.add(((UserDto) users).getLoginId());
		}

		for (int i = 0; i <= loginId.size(); i++) {

			if (loginId.contains(input)) {
				return false;
			}
		}
		return true;
	}
}
