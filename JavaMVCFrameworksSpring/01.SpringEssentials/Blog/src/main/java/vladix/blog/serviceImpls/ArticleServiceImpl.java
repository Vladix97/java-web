package vladix.blog.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import vladix.blog.entities.Article;
import vladix.blog.entities.User;
import vladix.blog.models.bindingModels.ArticleCreateModel;
import vladix.blog.models.viewModels.ArticleViewModel;
import vladix.blog.repositories.ArticleRepository;
import vladix.blog.repositories.UserRepository;
import vladix.blog.services.ArticleService;
import vladix.blog.utils.parser.interfaces.ModelParser;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ModelParser modelParser;

    private final ArticleRepository articleRepository;

    private final UserRepository userRepository;

    @Autowired
    public ArticleServiceImpl(ModelParser modelParser, ArticleRepository articleRepository, UserRepository userRepository) {
        this.modelParser = modelParser;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(ArticleCreateModel articleCreateModel) {
        Article article = this.modelParser.convert(articleCreateModel, Article.class);

        UserDetails principal = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User authorByEmail = this.userRepository.findByEmail(principal.getUsername());
        article.setAuthor(authorByEmail);

        this.articleRepository.saveAndFlush(article);
    }

    @Override
    public List<ArticleViewModel> findAll() {
        List<Article> all = this.articleRepository.findAll();
        List<ArticleViewModel> articles = new ArrayList<>();
        for (Article a : all) {
            ArticleViewModel convert = this.modelParser.convert(a, ArticleViewModel.class);
            convert.setSummary(a.getContent());
            articles.add(convert);
        }

        return articles;
    }

    @Override
    public ArticleViewModel findById(Long id) {
        Article one = this.articleRepository.findOne(id);

        if (one == null) return null;

        ArticleViewModel convert = this.modelParser.convert(one, ArticleViewModel.class);
        return convert;
    }

    @Override
    public boolean updateArticle(Long id, ArticleCreateModel articleCreateModel) {

        Article one = this.articleRepository.findOne(id);
        if (one == null) {
            return false;
        }

        one.setTitle(articleCreateModel.getTitle());
        one.setContent(articleCreateModel.getContent());

        this.articleRepository.saveAndFlush(one);

        return true;
    }

    @Override
    public boolean deleteById(Long id) {

        Article one = this.articleRepository.findOne(id);
        if (one == null) {
            return false;
        }

        this.articleRepository.delete(id);
        return true;
    }
}
