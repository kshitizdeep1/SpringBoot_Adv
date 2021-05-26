package com.olx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Catogery;
import com.olx.dto.StatusList;
import com.olx.service.AdvertiseService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/status")

public class CategoryController {
	
	@Autowired
	AdvertiseService advertiseService;

	@ApiOperation(value = "return all catogery",notes = "list of all advertisiment catogery")
	@GetMapping(value="/advertise/catogery",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Catogery> getAllAdvertisement() {
		return new ResponseEntity<Catogery>(advertiseService.getAllAdvertisement(),HttpStatus.OK);
	}
	@ApiOperation(value = "return all status",notes = "list of all advertisiment status")
	@GetMapping(value="/advertise/status",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<StatusList> getAllStatus() {
		return new ResponseEntity<StatusList>(advertiseService.getAllStatus(),HttpStatus.OK);
	}
}
