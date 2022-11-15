package com.fcdcdwc.lemon.back;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author liyandi
 * @program: lemon
 * @description: 预加载数据实现类
 * @date 2022-06-29 16:46:22
 */
@Component
public class PreloadRunnerImpl implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(PreloadRunnerImpl.class);

	@Override
	public void run(String... args) throws Exception {
	}

}
