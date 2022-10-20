package rss.feed.blogs.repository;

import rss.feed.blogs.model.parser.RssTargetWebsite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RssTargetWebsiteRepository extends CrudRepository<RssTargetWebsite, Long> {
    List<RssTargetWebsite> findAll();
}
