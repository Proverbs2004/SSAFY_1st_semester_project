package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.WishDao;
import com.ssafy.ssafit.model.dto.WishList;

@Service
public class WishServiceImpl implements WishService {

	@Autowired
	private WishDao wishDao;
	
	public void setWishDao(WishDao wishDao) {
		this.wishDao=wishDao;
	}

	@Override
	@Transactional
	public int addWish(WishList wishList) {
		System.out.println("서비스 실행");
		
		System.out.println(wishList.getUserId());
		System.out.println(wishList.getVideoSeq());
		return wishDao.addWish(wishList);

	}

	@Override
	@Transactional
	public List<WishList> selectWish(String userId) {
		List<WishList> result = wishDao.selectWish(userId);
		return result;
	}

	@Override
	@Transactional
	public void deleteWish(int wishSeq) {
		wishDao.deleteWish(wishSeq);
		
	}
	


}
