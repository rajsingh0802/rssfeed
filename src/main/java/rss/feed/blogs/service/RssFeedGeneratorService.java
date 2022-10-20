package rss.feed.blogs.service;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedOutput;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import rss.feed.blogs.model.rss.RssFeedEntry;
import rss.feed.blogs.utils.RssFeedUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log
@Service
public class RssFeedGeneratorService {

    private RssFeedEntryService rssFeedEntryService;

    public RssFeedGeneratorService(RssFeedEntryService feedEntryService) {
        this.rssFeedEntryService = feedEntryService;
    }

    @SneakyThrows
    public String generateRssFeed() {
        List<RssFeedEntry> entries = rssFeedEntryService.findAll();
        return processRssFeed(entries);
    }

    @SneakyThrows
    public String generateRssFeedForWebsite(Long websiteId) {
        List<RssFeedEntry> entries = rssFeedEntryService.findAllByTargetWebsiteId(websiteId);
        return processRssFeed(entries);
    }

    @SneakyThrows
    private String processRssFeed(List<RssFeedEntry> entries) {
        List<SyndEntry> rssEntries = new ArrayList<>();
        SyndFeed feed = RssFeedUtils.getFeed();
        entries.forEach(entry -> rssEntries.add(generateEntry(entry)));
        feed.setEntries(rssEntries);
        return new SyndFeedOutput().outputString(feed);
    }

    private SyndEntry generateEntry(RssFeedEntry entry) {
        SyndEntry rssEntry = new SyndEntryImpl();
        rssEntry.setTitle(entry.getTitle());
        SyndContent content = RssFeedUtils.getFeedEntryContent();
        content.setValue(entry.getContent());
        rssEntry.setLink(entry.getUrl());
        rssEntry.setContents(Collections.singletonList(content));
        rssEntry.setAuthor(entry.getAuthor());
        return rssEntry;
    }

}
