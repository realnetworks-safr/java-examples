package br.com.realnetworks.safr.longpolling.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import br.com.realnetworks.safr.longpolling.service.IProcessingService;
import br.com.realnetworks.safr.longpolling.service.ProcessingService;
import lombok.extern.slf4j.Slf4j;

@Configuration
@PropertySource(
		value = {"file:${user.home}/safr/longpolling/app.properties" }, 
		encoding = "UTF-8", 
		ignoreResourceNotFound = true
		)
@Slf4j
public class DefaultConfiguration {

	@Value("${safr.userId:userid}")
	private String userId;
	@Value("${safr.password:password}")
	private String password;
	@Value("${safr.directory:main}")
	private String directory;
	@Value("${safr.events.url:https://cv-event.int2.real.com}")
	private String eventUrl;
	
	@Bean()
	public RestTemplate restTemplate() {
		final String AUTHENTICATION_HEADER = "X-RPC-AUTHORIZATION";
		final String AUTHORIZATION_HEADER = "X-RPC-DIRECTORY";
		
		final RestTemplate lRestTemplate = new RestTemplate();
		final String lAuthentication = MessageFormat.format("{0}:{1}", userId, Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8)));
		log.debug(lAuthentication);
		lRestTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(final HttpRequest pRequest, final byte[] pBody,
					final ClientHttpRequestExecution pClientHttpRequestExecution) throws IOException {
				pRequest.getHeaders().set(AUTHENTICATION_HEADER, lAuthentication);
				pRequest.getHeaders().set(AUTHORIZATION_HEADER, directory);
				return pClientHttpRequestExecution.execute(pRequest, pBody);
			}
		});
		return lRestTemplate;
	}

	@Bean(destroyMethod = "shutdown")
	public ExecutorService executorService() {
		return Executors.newWorkStealingPool();
	}
	
	@Bean(destroyMethod = "shutdown")
	public IProcessingService processingService() {
		return new ProcessingService(eventUrl);
	}
}
