package com.ssv.template.common;

import java.io.InputStream;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CommonSessionFactory {

	protected static Logger logger = LoggerFactory.getLogger(CommonSessionFactory.class);

	protected SqlSessionFactory sqlSessionFactory = null;

	public SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}

	protected CommonSessionFactory() {
		init();
	}

	protected void init() {
		try {
			String myBatisConfigPath = getMyBatisConfigPath();
			if (myBatisConfigPath == null) {
				throw new IllegalStateException("Not find MyBatis config path : " + getMybatisEnviroment());
			}
			String mode = getRunningMode();
			logger.info("$$$ Running mode is " + mode);
			InputStream inputStream = Resources.getResourceAsStream(myBatisConfigPath);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, mode);
			if (sqlSessionFactory == null) {
				throw new IllegalStateException("Not find mybatis session config. environment is " + getRunningMode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}
	}

	protected String getMyBatisConfigPath() {
		PropertiesConfiguration config = readConfig();
		String environment = getMybatisEnviroment();

		if (StringUtils.isNotEmpty(environment)) {
			logger.info("$$$ Running mybatis enviroment is " + environment);
			return config.getString("mybatis." + environment + ".config");
		} else {
			logger.info("$$$ Running mybatis enviroment is default.");
			return config.getString("mybatis.config");
		}
	}

	protected String getRunningMode() {
		return System.getProperty("mode");
	}

	protected String getMybatisEnviroment() {
		return System.getProperty("mybatis");
	}

	protected PropertiesConfiguration readConfig() {
		try {
			return new PropertiesConfiguration("application.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}
	}
}
