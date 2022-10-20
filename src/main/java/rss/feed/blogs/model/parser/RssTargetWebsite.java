package rss.feed.blogs.model.parser;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "rss_target_website")
public class RssTargetWebsite {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToOne
    private RssParseEntryRule parseEntryRule;
}
