package rss.feed.blogs.service;

import lombok.extern.java.Log;
import rss.feed.blogs.model.rss.FeedEntry;
import rss.feed.blogs.repository.FeedEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class FeedEntryService {

    @Autowired
    private FeedEntryRepository feedEntryRepository;

    public FeedEntry save(FeedEntry feedEntry) {
        return feedEntryRepository.save(feedEntry);
    }

    public List<FeedEntry> findAll() {
        return feedEntryRepository.findAll();
    }

    public List<FeedEntry> findAllByTargetWebsiteId(Long targetWebsiteId) {
        return feedEntryRepository.findAllByTargetWebsiteId(targetWebsiteId);
    }

    public void deleteAll() {
        feedEntryRepository.deleteAll();
    }
}
