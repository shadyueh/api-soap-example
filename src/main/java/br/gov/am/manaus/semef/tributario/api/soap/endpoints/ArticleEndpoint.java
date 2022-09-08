package br.gov.am.manaus.semef.tributario.api.soap.endpoints;

import br.gov.am.manaus.semef.tributario.api.soap.configs.WebServiceConfig;
import br.gov.am.manaus.semef.tributario.api.soap.entities.ArticleModel;
import br.gov.am.manaus.semef.tributario.api.soap.services.IArticleService;
import br.gov.am.manaus.semef.tributario.ws.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ArticleEndpoint {

    @Autowired
    private IArticleService articleService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "getArticleByIdRequest")
    @ResponsePayload
    public GetArticleByIdResponse getArticle(@RequestPayload GetArticleByIdRequest request) {
        GetArticleByIdResponse response = new GetArticleByIdResponse();
        ArticleInfo articleInfo = new ArticleInfo();
        BeanUtils.copyProperties(articleService.getArticleById(request.getArticleId()), articleInfo);
        response.setArticleInfo(articleInfo);
        return response;
    }
    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "getAllArticlesRequest")
    @ResponsePayload
    public GetAllArticlesResponse getAllArticles() {
        GetAllArticlesResponse response = new GetAllArticlesResponse();
        List<ArticleInfo> articleInfoList = new ArrayList<>();
        List<ArticleModel> articleList = articleService.getAllArticles();
        for (int i = 0; i < articleList.size(); i++) {
            ArticleInfo ob = new ArticleInfo();
            BeanUtils.copyProperties(articleList.get(i), ob);
            articleInfoList.add(ob);
        }
        response.getArticleInfo().addAll(articleInfoList);
        return response;
    }
    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "addArticleRequest")
    @ResponsePayload
    public AddArticleResponse addArticle(@RequestPayload AddArticleRequest request) {
        AddArticleResponse response = new AddArticleResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        ArticleModel article = new ArticleModel();
        article.setTitle(request.getTitle());
        article.setCategory(request.getCategory());
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Content Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            ArticleInfo articleInfo = new ArticleInfo();
            BeanUtils.copyProperties(article, articleInfo);
            response.setArticleInfo(articleInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "updateArticleRequest")
    @ResponsePayload
    public UpdateArticleResponse updateArticle(@RequestPayload UpdateArticleRequest request) {
        ArticleModel article = new ArticleModel();
        BeanUtils.copyProperties(request.getArticleInfo(), article);
        articleService.updateArticle(article);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateArticleResponse response = new UpdateArticleResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "deleteArticleRequest")
    @ResponsePayload
    public DeleteArticleResponse deleteArticle(@RequestPayload DeleteArticleRequest request) {
        ArticleModel article = articleService.getArticleById(request.getArticleId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (article == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Content Not Available");
        } else {
            articleService.deleteArticle(article);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }
        DeleteArticleResponse response = new DeleteArticleResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

}
