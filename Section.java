package structures;

import java.io.Serializable;

public class Section implements Serializable {
    private String title;
    private String content;

    public Section(String title) {
        this.title = title;
    }
    public Section(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void addContent(String addition){
        this.setContent(this.getContent() + " " + addition);
    }
}
