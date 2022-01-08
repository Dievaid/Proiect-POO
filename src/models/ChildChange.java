package models;

import java.util.List;

public class ChildChange {
    private int id;
    private Double niceScore;
    private List<String> giftsPreferences;

    public ChildChange() { }

    /**
     * Getter
     */
    public int getId() {
        return id;
    }

    /**
     * Setter
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Getter
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * Setter
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * Getter
     */
    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Setter
     */
    public void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
