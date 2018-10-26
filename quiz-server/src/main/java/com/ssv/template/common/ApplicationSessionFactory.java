package com.ssv.template.common;

public class ApplicationSessionFactory extends CommonSessionFactory {

	private static final ApplicationSessionFactory INSTANCE = new ApplicationSessionFactory();

	public static ApplicationSessionFactory getInstance() {
		return INSTANCE;
	}

	private ApplicationSessionFactory() {
		super();
	}

}
