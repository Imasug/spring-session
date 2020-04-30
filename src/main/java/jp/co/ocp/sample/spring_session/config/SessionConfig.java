package jp.co.ocp.sample.spring_session.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @see <a href="https://docs.spring.io/spring-data/data-redis/docs/2.2.5.RELEASE/reference/html/#reference">Spring Data Redis</a>
 * @author suguru.imanaga
 *
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Environment env;

	@Bean
	public LettuceConnectionFactory connectionFactory() {

		String redisBaseEnvName = env.getProperty("REDIS_APPLICATION_NAME", "").toUpperCase().replace("-", "_");
		String redisHostEnvName = String.format("%s_SERVICE_HOST", redisBaseEnvName);
		String redisPortEnvName = String.format("%s_SERVICE_PORT", redisBaseEnvName);

		String redisHost = env.getProperty(redisHostEnvName, "localhost");
		Integer redisPort = env.getProperty(redisPortEnvName, Integer.class, 6379);
		String redisPassword = env.getProperty("REDIS_PASSWORD", "");

		log.debug("redisHost: {}, redisPort: {}, redisPassword: {}", redisHost, redisPort, redisPassword);

		LettuceConnectionFactory factory = new LettuceConnectionFactory();
		factory.setHostName(redisHost);
		factory.setPort(redisPort);
		factory.setPassword(redisPassword);

		return factory;
	}
}
