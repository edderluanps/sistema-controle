package com.eluanps.sistemacontrole.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizacaoConfig {

	public MessageSource messgeSource() {
		ReloadableResourceBundleMessageSource messagesource = new ReloadableResourceBundleMessageSource();
		messagesource.setBasename("classpath:messages");
		messagesource.setDefaultEncoding("ISO-8859-1");
		messagesource.setDefaultLocale(Locale.getDefault());
		return messagesource;
	}
	
	public LocalValidatorFactoryBean validatorFactoryBean() {
		LocalValidatorFactoryBean lvfbean = new LocalValidatorFactoryBean();
		lvfbean.setValidationMessageSource(messgeSource());
		return lvfbean;
	}
	
}
