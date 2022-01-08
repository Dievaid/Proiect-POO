package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private int age;
    private List<String> giftsPreferences;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double niceScore;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double averageScore;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Double> niceScoreHistory;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double assignedBudget;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Product> receivedGifts;

    public Child(final Child child) {
        this.id = child.id;
        this.lastName = child.lastName;
        this.firstName = child.firstName;
        this.age = child.age;
        this.city = child.city;
        this.niceScore = child.niceScore;
        this.giftsPreferences = new ArrayList<>(child.getGiftsPreferences());
        this.averageScore = child.averageScore;
        this.niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
        this.assignedBudget = child.assignedBudget;
        this.receivedGifts = new ArrayList<>(child.getReceivedGifts());
    }

    public Child() { }

    /**
     * @return getter
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
     * @return getter
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return getter
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return getter
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return getter
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * @return getter
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

    /**
     * @return getter
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
     * @return getter
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     * Setter
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return getter
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * Setter
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * @return getter
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * Setter
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * @return getter
     */
    public List<Product> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * Setter
     */
    public void setReceivedGifts(final List<Product> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
