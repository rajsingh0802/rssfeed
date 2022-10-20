package rss.feed.blogs.repository;

import rss.feed.blogs.model.parser.RssParseEntryRule;
import org.springframework.data.repository.CrudRepository;

public interface RssParseEntryRuleRepository extends CrudRepository<RssParseEntryRule, Long> {
}
