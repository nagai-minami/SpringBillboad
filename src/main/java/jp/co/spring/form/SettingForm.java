package jp.co.spring.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class SettingForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "{validation.error.notNull}")
	@NotEmpty(message = "{validation.error.notEmpty}")
	@Size(min = 6, max = 20, message = "{validation.error.size}")
	//@Repeat
	private String loginId;


	@NotNull(message = "{validation.error.notNull}")
	@NotEmpty(message = "{validation.error.notEmpty}")
	@Size(min = 2, max = 20, message = "{validation.error.size}")
	private String name;

	@NotNull(message = "{validation.error.notNull}")
	@NotEmpty(message = "{validation.error.notEmpty}")
	@Size(min = 6, max = 20, message = "{validation.error.size}")
	private String password;

	private String branch;

	private String position;


	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
