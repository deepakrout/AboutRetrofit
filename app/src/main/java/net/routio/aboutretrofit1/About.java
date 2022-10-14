package net.routio.aboutretrofit1;

public class About {
    private String mainHeader;
    private String mainParagraph;
    private AboutContent[] contents;

    public String getMainHeader() {
        return mainHeader;
    }

    public String getMainParagraph() {
        return mainParagraph;
    }

    public AboutContent[] getContents() {
        return contents;
    }
}

class AboutContent {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
