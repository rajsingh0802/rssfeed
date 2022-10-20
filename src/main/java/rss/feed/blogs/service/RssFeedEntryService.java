package rss.feed.blogs.service;

import lombok.extern.java.Log;
import rss.feed.blogs.model.rss.RssFeedEntry;
import rss.feed.blogs.repository.RssFeedEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class RssFeedEntryService {

    @Autowired
    private RssFeedEntryRepository rssFeedEntryRepository;

    public RssFeedEntry save(RssFeedEntry feedEntry) {
        return rssFeedEntryRepository.save(feedEntry);
    }

    public List<RssFeedEntry> findAll() {
        return rssFeedEntryRepository.findAll();
    }

    public List<RssFeedEntry> findAllByTargetWebsiteId(Long targetWebsiteId) {
        return rssFeedEntryRepository.findAllByTargetWebsiteId(targetWebsiteId);
    }

    public void deleteAll() {
        rssFeedEntryRepository.deleteAll();
    }
}
