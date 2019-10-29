package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Article;

import java.util.List;

@Controller()
@RequestMapping("/articles")
public class HomePageController {

    private final ArticleService articleService;

    @Autowired
    public HomePageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/recent")
    public String lastFiveArticles(Model model) {
        List<Article> recentArticles = articleService.lastFiveArticles();
        model.addAttribute("articles", recentArticles);

        List<String> categories = articleService.findAllCategories();
        model.addAttribute("categories", categories);

        return "recent";
    }

    @GetMapping("/category/{category}")
    public String articlesInCat(Model model,
                                @PathVariable String category) {
        List<Article> articles = articleService.articlesByCategory(category);
        model.addAttribute("articles", articles);

        return "category";
    }
}
