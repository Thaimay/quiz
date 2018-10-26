package com.ssv.template.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

public interface Mapper<T> {

	@Select("select * from ${tableName} where ${primaryKeyName} = ${id}")
	T findById(@Param("tableName") String tableName, @Param("primaryKeyName") String primaryKeyName,
			@Param("id") int id);

	@Select("select * from ${tableName}")
	List<T> findAll(@Param("tableName") String tableName);

	@Select("select count(1) from ${tableName}")
	int countAll(@Param("tableName") String tableName);

	@Select("SETVAL ('${tableName}_${primaryKeyName}_seq', '1', false)")
	Long resetSerial(@Param("tableName") String tableName, @Param("primaryKeyName") String primaryKeyName);

	@Select("select * from ${tableName}")
	Cursor<T> getHead(@Param("tableName") String tableName);

	@Delete("delete * from ${tableName}")
	void deleteAll(@Param("tableName") String tableName);
}
