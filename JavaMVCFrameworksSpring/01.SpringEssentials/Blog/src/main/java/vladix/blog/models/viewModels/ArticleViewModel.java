package vladix.blog.models.viewModels;

public class ArticleViewModel {

    private Long id;

    private String title;

    private String content;

    private String summary;

    private String authorFullName;

    public ArticleViewModel() { }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        int length = summary.length() / 4;
        this.summary = summary.substring(0, length);
    }

    public String getAuthorFullName() {
        return this.authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}
