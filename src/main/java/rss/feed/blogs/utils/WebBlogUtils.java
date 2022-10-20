package rss.feed.blogs.utils;

public class WebBlogUtils {

    public static String generateContent(String content, String imageUrl) {
        return imageUrl.isEmpty() ? content : content + generateThumbnailImageTag(imageUrl);
    }

    private static String generateThumbnailImageTag(String imageUrl) {
        return "<a href=\"" + imageUrl + "\">" +
                "<img src=\"" + imageUrl + "\"/>" +
                "</a>";
    }
}
