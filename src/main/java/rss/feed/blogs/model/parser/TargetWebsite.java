package rss.feed.blogs.model.parser;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "target_website")
public class TargetWebsite {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToOne
    private ParseEntryRule parseEntryRule;
}
