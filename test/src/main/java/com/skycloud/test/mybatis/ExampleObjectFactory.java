package com.skycloud.test.mybatis;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class ExampleObjectFactory extends DefaultObjectFactory {

	/** serialVersionUID [long] */
	private static final long serialVersionUID = 6883586229044000087L;

	@Override
	public <T> T create(Class<T> type) {
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}

	@Override
	protected Class<?> resolveInterface(Class<?> type) {
		return super.resolveInterface(type);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		return super.isCollection(type);
	}

}