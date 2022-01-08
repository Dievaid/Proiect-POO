package models;

import java.util.List;

public class AnnualChange {
    private int newSantaBudget;
    private List<Product> newGifts;
    private List<Child> newChildren;
    private List<ChildChange> childrenUpdates;

    public AnnualChange(final int newSantaBudget, final List<Product> newGifts,
                        final List<Child> newChildren, final List<ChildChange> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    public AnnualChange() { }

    /**
     * Getter
     * @return getter
     */
    public int getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * Setter
     * @param newSantaBudget change
     */
    public void setNewSantaBudget(final int newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * Getter
     * @return getter
     */
    public List<Product> getNewGifts() {
        return newGifts;
    }

    /**
     * Setter
     * @param newGifts change
     */
    public void setNewGifts(final List<Product> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * Getter
     * @return getter
     */
    public List<Child> getNewChildren() {
        return newChildren;
    }

    /**
     * Setter
     * @param newChildren change
     */
    public void setNewChildren(final List<Child> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * Getter
     * @return getter
     */
    public List<ChildChange> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * Setter
     * @param childrenUpdates change
     */
    public void setChildrenUpdates(final List<ChildChange> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
