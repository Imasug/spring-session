package jp.co.ocp.sample.spring_session.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.util.StringUtils;

/**
 * @see <a href="https://docs.spring.io/spring-data/data-redis/docs/2.2.5.RELEASE/reference/html/#reference">Spring Data Redis</a>
 * @author suguru.imanaga
 *
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

	@Value("${REDIS_SERVICE_HOST:localhost}")
	private String hostName;

	@Value("${REDIS_SERVICE_PORT:6379}")
	private int port;

	@Value("${database-password:}")
	private String password;

	@Bean
	public LettuceConnectionFactory connectionFactory() {

		System.out.println(String.format("hostName: %s, port: %s, password: %s", hostName, port, password));

		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(hostName, port);

		if (!StringUtils.isEmpty(password)) {
			config.setPassword(password);
		}

		return new LettuceConnectionFactory(config);
	}
}
