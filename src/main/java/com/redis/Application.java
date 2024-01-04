package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Redis+caching, active_mq, rabbit_mq
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
//		ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
//				.setPersistenceEnabled(false)
//				.setJournalDirectory("target/data/journal")
//				.setSecurityEnabled(false)
//				.addAcceptorConfiguration("invm","vm://0"));
//		server.start();
		SpringApplication.run(Application.class, args);

	}

}
