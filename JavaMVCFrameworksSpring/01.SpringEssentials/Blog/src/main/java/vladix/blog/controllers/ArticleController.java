package vladix.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vladix.blog.models.bindingModels.ArticleCreateModel;
import vladix.blog.models.viewModels.ArticleViewModel;
import vladix.blog.services.ArticleService;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {

        this.articleService = articleService;
    }

    @GetMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String getCreateArticle(Model model) {

        model.addAttribute("view", "article/create");

        return "base-layout";
    }

    @PostMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String postCreateArticle(ArticleCreateModel articleCreateModel) {

        this.articleService.create(articleCreateModel);

        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String getDetails(Model model, @PathVariable Long id) {

        ArticleViewModel article = this.articleService.findById(id);
        if (article == null) {
            return "redirect:/";
        }

        model.addAttribute("article", article);
        model.addAttribute("view", "article/details");

        return "base-layout";
    }

    @GetMapping("/article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String getEdit(Model model, @PathVariable Long id) {

        ArticleViewModel byId = this.articleService.findById(id);
        if (byId == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "article/edit");
        model.addAttribute("article", byId);

        return "base-layout";
    }

    @PostMapping("/article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String postEdit(@PathVariable Long id, ArticleCreateModel articleCreateModel) {

        this.articleService.updateArticle(id, articleCreateModel);

        return "redirect:/";
    }

    @GetMapping("/article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteArticle(@PathVariable Long id) {

        System.out.println("HERE");

        this.articleService.deleteById(id);

        return "redirect:/";
    }
}
