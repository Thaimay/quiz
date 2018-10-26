package com.ssv.template.data.repository;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.ssv.template.data.mapper.AccountMapper;
import com.ssv.template.model.Account;
import com.ssv.template.utils.AppStringUtils;

public class AccountRepository extends Repository<Account, AccountMapper> {

	@Override
	protected AccountMapper mapper(SqlSession session) {
		return session.getMapper(AccountMapper.class);
	}

	@Override
	public String tableName() {
		return AppStringUtils.toTableName(Account.class);
	}

	public Optional<Account> findByEmail(String email) {
		return execute((mapper) -> {
			return Optional.ofNullable(mapper.findByEmail(email));
		});
	}

}
