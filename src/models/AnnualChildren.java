package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class AnnualChildren {
    @JsonProperty("children")
    private List<Child> children;

    public AnnualChildren() { }

    public AnnualChildren(final List<Child> children) {
        this.children = new ArrayList<>();
        for (var child : children) {
            this.children.add(new Child(child));
        }
    }

    /**
     * Getter
     * @return children list
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * Setter
     * @param children change
     */
    public void setChildren(final List<Child> children) {
        this.children = children;
    }
}
