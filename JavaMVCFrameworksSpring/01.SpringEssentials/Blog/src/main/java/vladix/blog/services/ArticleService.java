package vladix.blog.services;

import vladix.blog.models.bindingModels.ArticleCreateModel;
import vladix.blog.models.viewModels.ArticleViewModel;

import java.util.List;

public interface ArticleService {

    void create(ArticleCreateModel articleCreateModel);

    List<ArticleViewModel> findAll();

    ArticleViewModel findById(Long id);

    boolean updateArticle(Long id, ArticleCreateModel articleCreateModel);

    boolean deleteById(Long id);
}
