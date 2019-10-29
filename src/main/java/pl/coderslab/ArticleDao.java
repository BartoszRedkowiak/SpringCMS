package pl.coderslab;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public Article findOne(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void delete(Long id) {
        Article article = findOne(id);
        if (article != null) {
            entityManager.remove(article);
        }
    }

    public List<Article> lastFiveArticles() {
        Query query = entityManager.createQuery("select a from Article a order by a.created desc");
        query.setMaxResults(5);
        return query.getResultList();
    }

    public List<String> findAllCategories() {
        Query query = entityManager.createQuery("select distinct c.name from Category c ");
        return query.getResultList();
    }

    public List<Article> articlesByCategory(String category) {
        Query query = entityManager.createQuery("select a from Article a join Category c on a.id = c.article.id where c.name = :category");
        query.setParameter("category", category);
        return query.getResultList();
    }


}
