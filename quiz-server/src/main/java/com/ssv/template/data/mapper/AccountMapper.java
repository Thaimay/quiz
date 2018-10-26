package com.ssv.template.data.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssv.template.model.Account;

public interface AccountMapper extends Mapper<Account> {

	@Select("select * from account where email = '${email}'")
	Account findByEmail(@Param("email") String email);

}
