package com.soap.consume.service;

import com.soap.consume.bean.Articles;
import com.soap.ws.consumer.binding.api.AddArticleResponse;
import com.soap.ws.consumer.binding.api.ArticleInfo;
import com.soap.ws.consumer.binding.api.DeleteArticleResponse;
import com.soap.ws.consumer.binding.api.GetAllArticlesResponse;
import com.soap.ws.consumer.binding.api.GetArticleByIdResponse;
import com.soap.ws.consumer.binding.api.UpdateArticleResponse;

public interface IArticlesService {

	public GetArticleByIdResponse getArticleById(long articleId);

	public DeleteArticleResponse deleteArticle(long articleId);

	public UpdateArticleResponse updateArticle(ArticleInfo articleInfo);

	public GetAllArticlesResponse getAllArticles();

	public AddArticleResponse addArticle(Articles articles);

}
