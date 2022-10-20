package rss.feed.blogs.model.parser;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parse_entry_rule")
@Data
public class ParseEntryRule {

    @Id
    @GeneratedValue
    private Long id;
    private String newsContainer;
    private String title;
    private String content;
    private String link;
}
