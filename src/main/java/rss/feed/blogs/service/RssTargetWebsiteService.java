package rss.feed.blogs.service;

import lombok.extern.java.Log;
import rss.feed.blogs.model.parser.RssTargetWebsite;
import rss.feed.blogs.repository.RssTargetWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class RssTargetWebsiteService {

    @Autowired
    private RssTargetWebsiteRepository rssTargetWebsiteRepository;

    public List<RssTargetWebsite> findAll() {
        return rssTargetWebsiteRepository.findAll();
    }

}
