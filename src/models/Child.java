package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private Double niceScoreBonus;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String elf;

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
}
