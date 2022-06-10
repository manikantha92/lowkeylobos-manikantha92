package com.directtv.lowkeylobos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.directtv.lowkeylobos.exception.MetadataNotFoundException;
import com.directtv.lowkeylobos.model.Metadata;
import com.directtv.lowkeylobos.service.MetadataService;

@RestController
@RequestMapping("/metadata")
public class MetadataController {
	
	@Autowired
	private MetadataService metadataService;
	
	@PostMapping(consumes = "application/json")
	public String addMetadata(@RequestBody Metadata metadata) {
		ResponseEntity<String> response = metadataService.addMetadata(metadata);
		 if(response. getStatusCode() == HttpStatus.OK) {
		        return response.getBody();
		    } else {
		        return "Unable to add the requested data the error code returned is "+response.getStatusCodeValue();
		    }
	}
	
	@PutMapping(value = "/{resourceId}",consumes = "application/json",produces = "application/json")
	public String updateMetadata(@PathVariable  String resourceId , @RequestBody Metadata metadata) {
		 metadataService.updateMetadata(resourceId, metadata);
		 return "Metadata for the resource "+resourceId+" has been updated";
	}
	
	@GetMapping(produces = "application/json")
	public String getAll() {
		return metadataService.getAllMetadata().getBody();
	}
	
	@GetMapping(value = "/{resourceId}",produces = "application/json")
	public String getMetadataById(@PathVariable(value = "resourceId") String resourceId) {
		return metadataService.getMetadataById(resourceId);
	}
	
	@DeleteMapping(value = "/{resourceId}",produces = "application/json")
	public HttpStatus deleteMetaDataById(@PathVariable(value = "resourceId") String resourceId) throws MetadataNotFoundException {
		return metadataService.deleteMetadataById(resourceId);
	}
}
