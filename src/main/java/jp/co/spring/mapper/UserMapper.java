package jp.co.spring.mapper;

import java.util.List;

import jp.co.spring.dto.UserDto;
import jp.co.spring.entity.User;

public interface UserMapper {

	//ユーザー登録
	int insertUser(UserDto dto);

	//全ユーザー取得
	List<User> getAll();

	//ユーザー取得
	User getUser(int id);

	//ユーザー認証
	User getLoginUser(String loginId, String password);

	//ユーザー更新
	int updateUser(UserDto dto);

	//ユーザー削除
	int deleteUser(int id);


}

