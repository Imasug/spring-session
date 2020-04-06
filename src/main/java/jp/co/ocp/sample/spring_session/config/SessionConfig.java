package jp.co.ocp.sample.spring_session.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

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

	@Bean
	public LettuceConnectionFactory connectionFactory() {
		System.out.println(hostName);
		System.out.println(port);
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(hostName, port);

		// TODO
		if (!"localhost".equals(hostName)) {
			config.setPassword("pLRI8y0PVuKtT7wX");
		}

		return new LettuceConnectionFactory(config);
	}
}
