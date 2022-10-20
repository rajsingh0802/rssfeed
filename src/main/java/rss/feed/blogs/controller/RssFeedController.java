package rss.feed.blogs.controller;

import rss.feed.blogs.service.RssFeedGeneratorService;
import rss.feed.blogs.service.RssBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RssFeedController {

    @Autowired
    private RssFeedGeneratorService rssFeedGeneratorService;
    @Autowired
    private RssBlogService rssBlogService;

    @GetMapping("/rssblog")
    @ResponseBody
    public String scrap() {

        rssBlogService.scrapAndSave();
        return "Blog saved successfully!!";
    }

    @GetMapping("/generaterssfeed")
    @ResponseBody
    public String generateRssFeed() {
        return rssFeedGeneratorService.generateRssFeed();
    }

    @GetMapping("/generaterssfeed/{id}")
    @ResponseBody
    public String generateRssFeed(@PathVariable("id") Long websiteId) {
        return rssFeedGeneratorService.generateRssFeedForWebsite(websiteId);
    }
}
