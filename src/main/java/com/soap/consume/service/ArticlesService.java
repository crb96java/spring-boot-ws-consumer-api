package com.soap.consume.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.soap.consume.bean.Articles;
import com.soap.ws.consumer.binding.api.AddArticleRequest;
import com.soap.ws.consumer.binding.api.AddArticleResponse;
import com.soap.ws.consumer.binding.api.ArticleInfo;
import com.soap.ws.consumer.binding.api.DeleteArticleRequest;
import com.soap.ws.consumer.binding.api.DeleteArticleResponse;
import com.soap.ws.consumer.binding.api.GetAllArticlesRequest;
import com.soap.ws.consumer.binding.api.GetAllArticlesResponse;
import com.soap.ws.consumer.binding.api.GetArticleByIdRequest;
import com.soap.ws.consumer.binding.api.GetArticleByIdResponse;
import com.soap.ws.consumer.binding.api.UpdateArticleRequest;
import com.soap.ws.consumer.binding.api.UpdateArticleResponse;

@Service
public class ArticlesService implements IArticlesService{
	
	private static Logger log = LoggerFactory.getLogger(ArticlesService.class);

	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate wsTemplate;
	
//	@Value("{spring.ws.consumer.binding.api.articlebyid}")
//	private String url;
	
	//Get the Articles based article id
	public GetArticleByIdResponse getArticleById(long articleId) {
		
		log.info("Article Id "+articleId);
		
		wsTemplate = new WebServiceTemplate(marshaller);
		
		GetArticleByIdRequest request = new GetArticleByIdRequest();
		request.setArticleId(articleId);
		log.info("=====request=========== "+request);
		
		GetArticleByIdResponse response = (GetArticleByIdResponse) wsTemplate.marshalSendAndReceive("http://localhost:8085/soapws/getArticleByIdRequest", request);
		log.info("=====response=========== "+response);
		return response;
	}
	
	public DeleteArticleResponse deleteArticle(long articleId) {
		log.info("Article Id "+articleId);
		DeleteArticleRequest request = new DeleteArticleRequest();
		request.setArticleId(articleId);
		log.info("=====request=========== "+request);
		
		DeleteArticleResponse response = (DeleteArticleResponse) wsTemplate.marshalSendAndReceive("http://localhost:8085/soapws/deleteArticleRequest",request);
		log.info("============Response============"+response);
		return response;
	}
	
	public UpdateArticleResponse updateArticle(ArticleInfo articleInfo) {
		log.info("ArticleInfo Object "+articleInfo);
		UpdateArticleRequest request = new UpdateArticleRequest();
		request.setArticleInfo(articleInfo);
		log.info("=====request=========== "+request);
		
		UpdateArticleResponse response = (UpdateArticleResponse) wsTemplate.marshalSendAndReceive("http://localhost:8085/soapws/updateArticleRequest", request);
		log.info("============Response============"+response);
		return response;
		
	}
	
	public GetAllArticlesResponse getAllArticles() {
		
		GetAllArticlesRequest request = new GetAllArticlesRequest();
		
		GetAllArticlesResponse response = (GetAllArticlesResponse) wsTemplate.marshalSendAndReceive("http://localhost:8085/soapws/getAllArticlesRequest", request);
		log.info("============Response============"+response);
		return response;
		
	}
	
	public AddArticleResponse addArticle(Articles articles) {
		log.info("========new articles======= "+articles);
		AddArticleRequest request = new AddArticleRequest();
		request.setTitle(articles.getTitle());
		request.setCategory(articles.getTitle());
		log.info("=====request=========== "+request);
		
		AddArticleResponse response = (AddArticleResponse) wsTemplate.marshalSendAndReceive("http://localhost:8085/soapws/addArticleRequest", request);
		log.info("============Response============"+response);
		return response;
		
		
	}
}
