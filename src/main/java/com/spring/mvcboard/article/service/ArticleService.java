package com.spring.mvcboard.article.service;

import java.util.List;

import com.spring.mvcboard.article.domain.ArticleVO;

public interface ArticleService {
	
	// 기본 CRUD 게시판
	void create(ArticleVO articleVO) throws Exception;

	ArticleVO read(Integer articleNo) throws Exception;
	
	void update(ArticleVO articleVO) throws Exception;
	
	void delete(Integer articleNo) throws Exception;
	
	List<ArticleVO> listAll() throws Exception;

}
