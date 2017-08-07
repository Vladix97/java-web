package vladix.blog.models.bindingModels;

import javax.validation.constraints.NotNull;

public class ArticleCreateModel {

    private String title;

    private String content;

    public ArticleCreateModel() { }

    public ArticleCreateModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
