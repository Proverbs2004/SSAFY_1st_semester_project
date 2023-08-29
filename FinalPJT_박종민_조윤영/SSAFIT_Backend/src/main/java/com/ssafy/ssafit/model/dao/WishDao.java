package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.WishList;

public interface WishDao {
	
	public int addWish(WishList wishList);
	
	public List<WishList> selectWish(String userId);
	
	public void deleteWish(int wishSeq);
	
}
