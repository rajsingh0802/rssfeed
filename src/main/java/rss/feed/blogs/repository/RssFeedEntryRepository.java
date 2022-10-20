package rss.feed.blogs.repository;

import rss.feed.blogs.model.rss.RssFeedEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RssFeedEntryRepository extends CrudRepository<RssFeedEntry, Long> {
    List<RssFeedEntry> findAllByTargetWebsiteId(Long targetWebsiteId);
    List<RssFeedEntry> findAll();
}
