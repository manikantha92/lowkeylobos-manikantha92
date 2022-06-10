package com.directtv.lowkeylobos.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.directtv.lowkeylobos.exception.MetadataNotFoundException;
import com.directtv.lowkeylobos.model.Metadata;

@Service
public class MetadataService {

	private RestTemplate restTemplate;
	private static String url = "https://7ir47r3nq5.execute-api.us-east-2.amazonaws.com/metadata";
	private static final String username = "lowkeylobos2022";
	private static final String password = "mani-dronamraju";
	private static HttpHeaders headers = new HttpHeaders();
	@Autowired
	public MetadataService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder
				.basicAuthentication(username, password)
				.build();
	}
	static  {
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	}
	public ResponseEntity<String> addMetadata(Metadata metadata) {
		HttpEntity<Metadata> entity = new HttpEntity<>(metadata,headers);
		return restTemplate.exchange(url, HttpMethod.POST,entity, String.class);
	}
	
	public void updateMetadata(String resourceId, Metadata metadata) {
		HttpEntity<Metadata> entity = new HttpEntity<>(metadata,headers);
		Map<String, String> params = new HashMap<String, String>();
		params.put("resourceId", resourceId);
		restTemplate.put(url, metadata, params);

	}
	
	public ResponseEntity<String> getAllMetadata() {
        HttpEntity <String> entity = new HttpEntity <String> ("parameters", headers);
		return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
	}
	
	public String getMetadataById(String resourceId) throws MetadataNotFoundException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("resourceId", resourceId);
		 if(restTemplate.getForObject(url+"/{resourceId}", String.class, params).isEmpty()) {
			throw new MetadataNotFoundException("The metadata is not available for the resource: "+resourceId);
		 }
		return restTemplate.getForObject(url+"/{resourceId}", String.class, params);
	}
	
	public HttpStatus deleteMetadataById(String resourceId) throws MetadataNotFoundException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("resourceId", resourceId);
		
		try {
			restTemplate.delete(url+"/{resourceId}",  params);
			return HttpStatus.OK;
			} catch (Exception e) {
			throw new MetadataNotFoundException("The given resource id "+resourceId+" does not exist");
			}
	}
}
