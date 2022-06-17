package com.projetmipih.clientweb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.projetmipih.clientweb.model.Declaration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DeclarationProxy {
	
	public Iterable<Declaration> getDeclarations(){
		String baseApiUrl = "http://localhost:9000";
		String getDeclarationsUrl = baseApiUrl + "/declarations";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Declaration>> response = restTemplate.exchange(getDeclarationsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Declaration>>() {});
		
		return response.getBody();
	}
	
	public Declaration createEmployee(Declaration e) {
		String baseApiUrl = "http://localhost:9000";
	    String createDeclarationUrl = baseApiUrl + "/createDeclaration";

	    RestTemplate restTemplate = new RestTemplate();
	    HttpEntity<Declaration> request = new HttpEntity<Declaration>(e);
	    ResponseEntity<Declaration> response = restTemplate.exchange(
	        createDeclarationUrl,
	        HttpMethod.POST,
	        request,
	        Declaration.class);


	    return response.getBody();
	}
	
    public Declaration getDeclaration(int id) {
    	String baseApiUrl = "http://localhost:9000";
		String getDeclarationUrl = baseApiUrl + "/declaration/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Declaration> response = restTemplate.exchange(
				getDeclarationUrl, 
				HttpMethod.GET, 
				null,
				Declaration.class
			);
		
		return response.getBody();
	}
    
    public void deleteDeclaration(int id) {
    	String baseApiUrl = "http://localhost:9000";
		String deleteDeclarationUrl = baseApiUrl + "/declarationdelete/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteDeclarationUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
	}
    

}
