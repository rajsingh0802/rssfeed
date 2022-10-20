package rss.feed.blogs.model.rss;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rss.feed.blogs.model.parser.RssTargetWebsite;

import javax.persistence.*;

@Entity
@Table(name = "rss_feed_entry")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RssFeedEntry {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String url;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "target_website_id")
    private RssTargetWebsite targetWebsite;

}
