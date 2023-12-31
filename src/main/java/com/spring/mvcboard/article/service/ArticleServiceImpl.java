package com.spring.mvcboard.article.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.persistence.ArticleDAO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.SearchCriteria;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private final ArticleDAO articleDAO;

    @Inject
    public ArticleServiceImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public void create(ArticleVO articleVO) throws Exception {
        articleDAO.create(articleVO);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public ArticleVO read(Integer articleNo) throws Exception {
    	articleDAO.updateViewCnt(articleNo);
        return articleDAO.read(articleNo);
    }

    @Override
    public void update(ArticleVO articleVO) throws Exception {
        articleDAO.update(articleVO);
    }

    @Override
    public void delete(Integer articleNo) throws Exception {
        articleDAO.delete(articleNo);
    }

    @Override
    public List<ArticleVO> listAll() throws Exception {
        return articleDAO.listAll();
    }
    
    // 게시판 페이징 관련
    @Override
    public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
        return articleDAO.listCriteria(criteria);
    }
    
    @Override
    public int countArticles(Criteria criteria) throws Exception {
        return articleDAO.countArticles(criteria);
    }

    // 게시판 검색기능 관련
    @Override
    public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception {
        return articleDAO.listSearch(searchCriteria);
    }

    @Override
    public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception {
        return articleDAO.countSearchedArticles(searchCriteria);
    }
}
