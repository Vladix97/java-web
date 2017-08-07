package vladix.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vladix.blog.models.viewModels.ArticleViewModel;
import vladix.blog.services.ArticleService;

import java.util.List;

@Controller
public class HomeController {

    private final ArticleService articleService;

    @Autowired
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<ArticleViewModel> all = this.articleService.findAll();

        model.addAttribute("articles", all);
        model.addAttribute("view", "home/index");

        return "base-layout";
    }
}
