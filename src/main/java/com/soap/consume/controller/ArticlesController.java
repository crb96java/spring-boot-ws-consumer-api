package com.soap.consume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soap.consume.bean.Articles;
import com.soap.consume.service.IArticlesService;
import com.soap.ws.consumer.binding.api.AddArticleResponse;
import com.soap.ws.consumer.binding.api.ArticleInfo;
import com.soap.ws.consumer.binding.api.DeleteArticleResponse;
import com.soap.ws.consumer.binding.api.GetAllArticlesResponse;
import com.soap.ws.consumer.binding.api.GetArticleByIdResponse;
import com.soap.ws.consumer.binding.api.UpdateArticleResponse;

@RestController
public class ArticlesController {

	private static Logger log = LoggerFactory.getLogger(ArticlesController.class);

	@Autowired
	private IArticlesService articlesService;

	@PostMapping("/create-article")
	public AddArticleResponse addArticle(@RequestBody Articles articles) {
		log.info("========new articles======= "+articles);
		AddArticleResponse response = articlesService.addArticle(articles);
		log.info("=========== response " + response);
		return response;

	}

	@GetMapping("/get/{article-id}")
	public GetArticleByIdResponse getArticleById(@PathVariable("article-id") long articleId) {
		log.info("=========== input article id to get the response " + articleId);
		GetArticleByIdResponse response = articlesService.getArticleById(articleId);
		log.info("=========== response " + response);
		return response;

	}

	@DeleteMapping("/delete/{article-id}")
	public DeleteArticleResponse deleteArticle(@PathVariable("article-id") long articleId) {
		log.info("=========== input article id to delete the response " + articleId);

		DeleteArticleResponse response = articlesService.deleteArticle(articleId);
		log.info("=========== response " + response);
		return response;
	}

	@PutMapping("/update")
	public UpdateArticleResponse updateArticle(@RequestBody ArticleInfo articleInfo) {
		log.info("=========== input article id to update the response " + articleInfo);

		UpdateArticleResponse response = articlesService.updateArticle(articleInfo);
		log.info("=========== response " + response);
		return response;
	}

	@GetMapping("/get-all-articles")
	public GetAllArticlesResponse getAllArticles() {

		GetAllArticlesResponse response = articlesService.getAllArticles();
		log.info("=========== response " + response);
		return response;
	}
}
