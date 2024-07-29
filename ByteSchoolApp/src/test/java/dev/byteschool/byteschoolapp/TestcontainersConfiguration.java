package dev.byteschool.byteschoolapp;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	private PostgreSQLContainer<?> postgresContainer;

	@Bean
	@RestartScope
	@ServiceConnection
	public PostgreSQLContainer<?> postgresContainer() {
		if (postgresContainer == null) {
			postgresContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.3"))
					.withReuse(true);
			postgresContainer.start();
		}
		return postgresContainer;
	}
}
