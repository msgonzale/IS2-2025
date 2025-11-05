package co.edu.uco.parametersservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.parametersservice.catalog.Parameter;
import co.edu.uco.parametersservice.catalog.ParameterCatalog;

@RestController
@RequestMapping("/parameters/api/v1/parameters")
public class ParameterController {

	
	@GetMapping("/{key}")
	public ResponseEntity<Parameter> getParameter(@PathVariable String key) {
		
		var value = ParameterCatalog.getParameterValue(key);
		
		return new ResponseEntity<> (value,
				(value == null) ? HttpStatus.NOT_FOUND :HttpStatus.OK);
	}

	@PutMapping("/{key}")
	public ResponseEntity<Parameter> modifyParameter(@PathVariable String key, @RequestBody Parameter value){
		value.setKey(key);
		ParameterCatalog.synchronizeParameter(value);
		return new ResponseEntity<> (value, HttpStatus.OK);
	}


}
