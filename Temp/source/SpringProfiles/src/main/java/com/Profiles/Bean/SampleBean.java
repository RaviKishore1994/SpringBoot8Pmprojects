package com.Profiles.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class SampleBean {
	@Autowired
	Environment env;
	public String getBean()
	{
		return env.getProperty("sample.app.name");
	}

}
