package exec;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.AnnualChildren;
import input.loader.Input;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public final class Database {
    @JsonIgnore
    private static Database instance = new Database();

    @JsonProperty("annualChildren")
    private List<AnnualChildren> annualChildren = new ArrayList<>();

    @JsonIgnore
    private Input loadedInput = new Input();

    private Database() { }

    /**
     * Method used for getting the current instance of the singleton
     * @return Current instance of the database
     */
    public static Database getInstance() {
        if (instance == null) {
            return new Database();
        }
        return instance;
    }

    /**
     * Method used for simulating each year
     * @param data -> parsed JSON data from a specific test file
     */
    public void fetchData(final Input data) {
        this.loadedInput = data;
        data.simulateFirstYear();
        data.simulateAnnualChanges();
    }

    /**
     * Method used for deleting the current state of the singleton
     * Deleting the current state of the singleton, prepares the simulation for another round
     * Used for avoiding data parsed from previous inputs
     */
    public static void clear() {
        instance = new Database();
    }
}
