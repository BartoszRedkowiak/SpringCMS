package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Article;

import javax.persistence.Query;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void save(Article article) {
        articleDao.save(article);
    }

    public void update(Article article) {
        articleDao.update(article);
    }

    public Article findOne(Long id) {
        return articleDao.findOne(id);
    }

    public void delete(Long id) {
        articleDao.delete(id);
    }

    public List<Article> lastFiveArticles() {
        return articleDao.lastFiveArticles();
    }

    public List<String> findAllCategories() {
        return articleDao.findAllCategories();
    }

    public List<Article> articlesByCategory(String category) {
        return articleDao.articlesByCategory(category);
    }


}
