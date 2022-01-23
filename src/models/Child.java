package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import exec.Database;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double niceScoreBonus;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String elf;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double assignedBudget;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Product> receivedGifts;

    @JsonIgnore
    private Double niceScoreCity;

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
        this.niceScoreBonus = child.niceScoreBonus;
        this.elf = child.elf;
        this.niceScoreCity = child.niceScoreCity;
    }

    private Child(final Builder builder) {
        setId(builder.id);
        setLastName(builder.lastName);
        setFirstName(builder.firstName);
        setCity(builder.city);
        setAge(builder.age);
        setGiftsPreferences(builder.giftsPreferences);
        setNiceScore(builder.niceScore);
        setAverageScore(builder.averageScore);
        setNiceScoreHistory(builder.niceScoreHistory);
        setNiceScoreBonus(builder.niceScoreBonus);
        setElf(builder.elf);
        setAssignedBudget(builder.assignedBudget);
        setReceivedGifts(builder.receivedGifts);
        setNiceScoreCity(builder.niceScoreCity);
    }

    /**
     * @return Average score of a city
     */
    public final Double averageForCity() {
        Double avgCity = 0d;
        var children = new ArrayList<>(Database.getInstance()
                .getLoadedInput()
                .getInitialData()
                .getChildren());
        children.sort(Comparator.comparing(Child::getId));
        children.removeIf(c -> !c.getCity().equals(this.getCity()));
        for (var child : children) {
            avgCity += child.getAverageScore();
        }
        return avgCity / children.size();
    }

    /**
     * {@code Child} builder static inner class.
     */
    public static final class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private String city;
        private int age;
        private List<String> giftsPreferences;
        private Double niceScore;
        private Double averageScore;
        private List<Double> niceScoreHistory;
        private Double niceScoreBonus;
        private String elf;
        private Double assignedBudget;
        private List<Product> receivedGifts;
        private Double niceScoreCity;

        public Builder() {
        }

        /**
         * Sets the {@code id} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code id} to set
         * @return a reference to this Builder
         */
        public Builder withId(final int val) {
            id = val;
            return this;
        }

        /**
         * Sets the {@code lastName} and returns a reference
         * to this Builder enabling method chaining.
         * @param val the {@code lastName} to set
         * @return a reference to this Builder
         */
        public Builder withLastName(final String val) {
            lastName = val;
            return this;
        }

        /**
         * Sets the {@code firstName} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code firstName} to set
         * @return a reference to this Builder
         */
        public Builder withFirstName(final String val) {
            firstName = val;
            return this;
        }

        /**
         * Sets the {@code city} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code city} to set
         * @return a reference to this Builder
         */
        public Builder withCity(final String val) {
            city = val;
            return this;
        }

        /**
         * Sets the {@code age} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code age} to set
         * @return a reference to this Builder
         */
        public Builder withAge(final int val) {
            age = val;
            return this;
        }

        /**
         * Sets the {@code giftsPreferences} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code giftsPreferences} to set
         * @return a reference to this Builder
         */
        public Builder withGiftsPreferences(final List<String> val) {
            giftsPreferences = val;
            return this;
        }

        /**
         * Sets the {@code niceScore} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code niceScore} to set
         * @return a reference to this Builder
         */
        public Builder withNiceScore(final Double val) {
            niceScore = val;
            return this;
        }

        /**
         * Sets the {@code averageScore} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code averageScore} to set
         * @return a reference to this Builder
         */
        public Builder withAverageScore(final Double val) {
            averageScore = val;
            return this;
        }

        /**
         * Sets the {@code niceScoreHistory} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code niceScoreHistory} to set
         * @return a reference to this Builder
         */
        public Builder withNiceScoreHistory(final List<Double> val) {
            niceScoreHistory = val;
            return this;
        }

        /**
         * Sets the {@code niceScoreBonus} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code niceScoreBonus} to set
         * @return a reference to this Builder
         */
        public Builder withNiceScoreBonus(final Double val) {
            niceScoreBonus = val;
            return this;
        }

        /**
         * Sets the {@code elf} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code elf} to set
         * @return a reference to this Builder
         */
        public Builder withElf(final String val) {
            elf = val;
            return this;
        }

        /**
         * Sets the {@code assignedBudget} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code assignedBudget} to set
         * @return a reference to this Builder
         */
        public Builder withAssignedBudget(final Double val) {
            assignedBudget = val;
            return this;
        }

        /**
         * Sets the {@code receivedGifts} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code receivedGifts} to set
         * @return a reference to this Builder
         */
        public Builder withReceivedGifts(final List<Product> val) {
            receivedGifts = val;
            return this;
        }

        /**
         * Sets the {@code niceScoreCity} and returns a reference
         * to this Builder enabling method chaining.
         *
         * @param val the {@code niceScoreCity} to set
         * @return a reference to this Builder
         */
        public Builder withNiceScoreCity(final Double val) {
            niceScoreCity = val;
            return this;
        }

        /**
         * Returns a {@code Child} built from the parameters previously set.
         *
         * @return a {@code Child} built with parameters of this {@code Child.Builder}
         */
        public Child build() {
            return new Child(this);
        }
    }
}
