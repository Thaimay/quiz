package com.ssv.template.utils;

import org.apache.commons.lang3.StringUtils;

public class AppStringUtils {

	public static String toSneke(String key) {
		return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(key), "_").toLowerCase();
	}

	public static <T> String toTableName(Class<T> clazz) {
		return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(clazz.getSimpleName()), "_").toLowerCase();
	}

}
