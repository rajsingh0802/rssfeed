package rss.feed.blogs.repository;

import rss.feed.blogs.model.rss.FeedEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedEntryRepository extends CrudRepository<FeedEntry, Long> {
    List<FeedEntry> findAllByTargetWebsiteId(Long targetWebsiteId);
    List<FeedEntry> findAll();
}
