package com.olx.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.olx.dto.Advertise;

public class MasterDataServiceImpl implements MasterDataService {

	@Override
	public Advertise createAdvertise(Advertise advertise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authVerify(String authToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Advertise updateAdvertise(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> readAllAdvertise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertise readAdvertiseOfUser(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertise deletAdvertiseOfuser(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> searchAdvertiseByFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> searchAdvertiseByText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpStatus readAdvertiseByPostId(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
