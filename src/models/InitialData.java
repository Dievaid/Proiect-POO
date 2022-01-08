package models;

import java.util.List;

public class InitialData {
    private List<Child> children;
    private List<Product> santaGiftsList;

    public InitialData() { }

    /**
     * Getter
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * Setter
     */
    public void setChildren(final List<Child> children) {
        this.children = children;
    }

    /**
     * Getter
     */
    public List<Product> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * Setter
     */
    public void setSantaGiftsList(final List<Product> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
