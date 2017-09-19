package jp.co.spring.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.spring.dto.UserDto;
import jp.co.spring.entity.User;
import jp.co.spring.mapper.UserMapper;


@Service
public class SettingService {

	@Autowired
	private UserMapper userMapper;

    /*=================
	全ユーザー取得
	=================*/

    public List<UserDto> getAll(){

		//mapperから取得した結果をListに詰める
		List<User> userList = userMapper.getAll();

		List<UserDto> resultList = convertToDto(userList);
		return resultList;
	}

    private List<UserDto> convertToDto(List<User> userList){

		List<UserDto> resultList = new LinkedList<UserDto>();
		for(User entity : userList){
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}

    /*=================
	 ユーザー取得(id)
	=================*/

    public UserDto getUser(Integer id){
		UserDto dto = new UserDto();
		User entity = userMapper.getUser(id);
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}

    /*=================
	 ユーザー認証(loginId,pass)
	=================*/

   public UserDto getLoginUser(String loginId, String password){
		UserDto dto = new UserDto();
		User entity = userMapper.getLoginUser(loginId,password);
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}

	/*=================
	ユーザー登録
	=================*/

    public int insertUser(UserDto dto) {

    	int count = userMapper.insertUser(dto);
		return count;
    }

    /*=================
	 ユーザー更新(id)
	=================*/

    public int updateUser(UserDto dto){

    	int count = userMapper.updateUser(dto);
		return count;
    }

    /*=================
  	 ユーザー更新(id)
  	=================*/

    public int deleteUser(Integer id){
      	int count = userMapper.deleteUser(id);
  		return count;
      }

}
