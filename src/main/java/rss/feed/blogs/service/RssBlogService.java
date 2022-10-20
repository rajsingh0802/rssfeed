package rss.feed.blogs.service;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import rss.feed.blogs.model.parser.RssParseEntryRule;
import rss.feed.blogs.model.parser.RssTargetWebsite;
import rss.feed.blogs.model.rss.RssFeedEntry;
import rss.feed.blogs.utils.WebBlogUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class RssBlogService {

    private RssFeedEntryService rssFeedEntryService;
    private RssTargetWebsiteService rssTargetWebsiteService;

    public RssBlogService(RssFeedEntryService feedEntryService, RssTargetWebsiteService targetWebsiteService) {
        this.rssFeedEntryService = feedEntryService;
        this.rssTargetWebsiteService = targetWebsiteService;
    }

    @SneakyThrows
    public void scrapAndSave() {
        List<RssTargetWebsite> websites = rssTargetWebsiteService.findAll();
        entriesCleanup();
        processWebsitesScrapping(websites);
        log.info("Total: " + websites.size() + " websites scrapped.");
    }

    @SneakyThrows
    private void processWebsitesScrapping(List<RssTargetWebsite> websites) {
        for (RssTargetWebsite website : websites) {
            Document doc = Jsoup.connect(website.getUrl()).get();
            String websiteTitle = doc.title();
            Elements elements = doc.select(website.getParseEntryRule().getNewsContainer());
            elements.forEach(element -> saveEntry(element, website, websiteTitle));
            log.info("Scrapped website: " + websiteTitle + ". " + elements.size() + " entries added to feed.");
        }
    }

    private void entriesCleanup() {
        rssFeedEntryService.deleteAll();
    }

    private RssFeedEntry saveEntry(Element element, RssTargetWebsite website, String websiteTitle) {
        RssParseEntryRule rule = website.getParseEntryRule();
        String imageUrl = element.select("img").first().absUrl("src");
        return rssFeedEntryService.save(
                RssFeedEntry.builder()
                        .author(websiteTitle)
                        .title(element.select(rule.getTitle()).text())
                        .content(
                                WebBlogUtils.generateContent(
                                        element.select(rule.getContent()).text(),
                                        imageUrl
                                )
                        )
                        .url(element.select(rule.getLink()).attr("abs:href"))
                        .imageUrl(imageUrl)
                        .targetWebsite(website)
                        .build());
    }

}
