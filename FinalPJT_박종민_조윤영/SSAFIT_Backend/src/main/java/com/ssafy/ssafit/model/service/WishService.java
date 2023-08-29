package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.WishList;

public interface WishService {
	
	public int addWish(WishList wishList);
	
	public List<WishList> selectWish(String userId);
	
	public void deleteWish(int wishSeq);
}
