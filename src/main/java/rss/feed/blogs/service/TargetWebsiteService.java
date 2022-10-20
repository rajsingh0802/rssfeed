package rss.feed.blogs.service;

import lombok.extern.java.Log;
import rss.feed.blogs.model.parser.TargetWebsite;
import rss.feed.blogs.repository.TargetWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class TargetWebsiteService {

    @Autowired
    private TargetWebsiteRepository targetWebsiteRepository;

    public List<TargetWebsite> findAll() {
        return targetWebsiteRepository.findAll();
    }

}
