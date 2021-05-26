package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertise;
import com.olx.service.MasterDataService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/operations")
public class AdvertiseOperationController {

	@Autowired
	MasterDataService masterDataService;

	@ApiOperation(value = "create advertisement", notes = "Use to create new advertisment")
	@PostMapping(value = "/advertise", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Advertise> createAdvertise(@RequestBody Advertise advertise,
			@RequestHeader("Auth_token") String authToken) {
		if (masterDataService.authVerify(authToken)) {
			return new ResponseEntity<Advertise>(masterDataService.createAdvertise(advertise), HttpStatus.OK);
		}
		return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Update Advertisement", notes = "Update the existing advertisement by Id")
	@PutMapping(value = "advertise/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Advertise> updateAdvertise(@RequestHeader("Auth_token") String authToken,
			@PathVariable("id") int id) {

		if (masterDataService.authVerify(authToken)) {
			return new ResponseEntity<Advertise>(masterDataService.updateAdvertise(id), HttpStatus.OK);
		}
		return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Get All Advertise", notes = "read all listed advertisement")
	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Advertise>> readAllAdvertise(@RequestHeader("Auth_token") String authToken) {

		if(masterDataService.authVerify(authToken)) {
			return new ResponseEntity <List<Advertise>>(masterDataService.readAllAdvertise(),HttpStatus.OK);
		}
		return new ResponseEntity<List<Advertise>>(HttpStatus.BAD_REQUEST);
		
	}

	@ApiOperation(value = "Advertisement associate to user", notes = "all advertisement user have ever created")
	@GetMapping(value = "/user/advertise/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Advertise> readAdvertiseOfUser(@RequestHeader("Auth_token") String authToken, @PathVariable("postId") int postId) {

		if(masterDataService.authVerify(authToken)) {
			return new ResponseEntity<Advertise>(masterDataService.readAdvertiseOfUser(postId),HttpStatus.OK);
		}
		return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Delete advertisement", notes = "delete advertisement associated to user")
	@DeleteMapping(value = "/user/advertise/{postId}")
	public ResponseEntity<Advertise> deletAdvertiseOfuser(@RequestHeader("Auth_token") String authToken,@PathVariable("postId") int postId) {
		
		if(masterDataService.authVerify(authToken)) {
			return new ResponseEntity<Advertise>(masterDataService.deletAdvertiseOfuser(postId),HttpStatus.OK);
		}
		return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Search Advertisement by filter", notes = "Search all Advertisement by selecting filters ")
	@GetMapping(value = "/advertise/search/filter/criteria", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Advertise>> searchAdvertiseByFilter() {
		
		return new ResponseEntity<List<Advertise>>(masterDataService.searchAdvertiseByFilter(),HttpStatus.OK);   
	}

	@ApiOperation(value = "Search Advertisement by test", notes = "search Advertisement by the help of text")
	@GetMapping(value = "/advertise/search", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Advertise>> searchAdvertiseByText() {

		return new ResponseEntity<List<Advertise>>(masterDataService.searchAdvertiseByText(),HttpStatus.OK);
	}

	@ApiOperation(value = "get advertisement by post id", notes = "return advertisiment by post id")
	@GetMapping(value = "/advertise/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Advertise> readAdvertiseByPostId(@PathVariable("postId") int postId,@RequestHeader("Auth_token") String authToken) {

		if(masterDataService.authVerify(authToken)) {
			return new ResponseEntity<Advertise>(masterDataService.readAdvertiseByPostId(postId));
		}
		return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST);
	}
}
