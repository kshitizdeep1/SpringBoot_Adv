package com.olx.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.olx.dto.Advertise;

@Service
public interface MasterDataService {

	Advertise createAdvertise(Advertise advertise);

	boolean authVerify(String authToken);

	Advertise updateAdvertise(int id);

	List<Advertise> readAllAdvertise();

	Advertise readAdvertiseOfUser(int postId);

	Advertise deletAdvertiseOfuser(int postId);

	List<Advertise> searchAdvertiseByFilter();

	List<Advertise> searchAdvertiseByText();

	HttpStatus readAdvertiseByPostId(int postId);

}
