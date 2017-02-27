package com.oaktreeair.ffprogram.util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.oaktreeair.ffprogram.TempFileAware;

@Component
public class TempFileBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof TempFileAware) {
			TempFileAware fa = (TempFileAware) bean;
			try {
				File tempFile = File.createTempFile("data", null, 
								new File(System.getProperty("user.dir")));
				System.out.println("postProcessBeforeInitialization injecting File " 
						   + tempFile.getName() + " into bean: " 
						   + bean.getClass());
				fa.setTempFile(tempFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

}
