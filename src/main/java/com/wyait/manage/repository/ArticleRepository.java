package com.wyait.manage.repository;


import com.wyait.manage.entity.Article;
import com.wyait.manage.entity.WeiboDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author fz
 * @Date 2018/6/7 10:51
 * 
 */
public interface ArticleRepository extends JpaRepository<Article, String> {

    Page<Article> findByType(String type, Pageable pageable);
}
