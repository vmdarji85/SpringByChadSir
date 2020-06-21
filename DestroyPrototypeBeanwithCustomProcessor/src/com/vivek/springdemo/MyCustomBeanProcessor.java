package com.vivek.springdemo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyCustomBeanProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {
	private BeanFactory beanFactory;

	private final List<Object> prototypeBeans = new LinkedList<>();

	@Override
	public void destroy() throws Exception {
		// loop through the prototype bean and call destroy mathod for each bean
		System.out.println("\ninside Destroy menthod");
		synchronized (prototypeBeans) {
			for (Object bean : prototypeBeans) {
				if (bean instanceof DisposableBean) {
					DisposableBean disposableBean = (DisposableBean) bean;

					try {
						System.out.println(disposableBean.toString());
						disposableBean.destroy();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			prototypeBeans.clear();
		}

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

		this.beanFactory = beanFactory;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\ninside post postProcessAfterInitialization");
		if (beanFactory.isPrototype(beanName)) {
			synchronized (prototypeBeans) {
				prototypeBeans.add(bean);
				System.out.println(bean.toString());
			}
		}
		return bean;
	}

}
