package rss.feed.blogs.repository;

import rss.feed.blogs.model.parser.ParseEntryRule;
import org.springframework.data.repository.CrudRepository;

public interface ParseEntryRuleRepository extends CrudRepository<ParseEntryRule, Long> {
}
