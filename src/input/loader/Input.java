package input.loader;

import common.Constants;
import models.AnnualChange;
import models.AnnualChildren;
import models.InitialData;
import models.Product;
import exec.Database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Input {
    private int numberOfYears;
    private int santaBudget;
    private InitialData initialData;
    private List<AnnualChange> annualChanges;

    /**
     * Method used in the Database singleton, to fetch all the necessary data
     * Simulates only the first year -> year number 0
     */
    public void simulateFirstYear() {
        for (var child : initialData.getChildren()) {
            child.setNiceScoreHistory(new ArrayList<>());
            child.getNiceScoreHistory().add(child.getNiceScore());
            child.setAverageScore(child.getNiceScore());
        }
        simulate();
        initialData.getChildren().removeIf(child -> child.getAge() > Constants.TEEN);
        var annualChildren = Database.getInstance().getAnnualChildren();
        var annualChildrenEntry = new AnnualChildren(new ArrayList<>(initialData.getChildren()));
        annualChildren.add(annualChildrenEntry);
    }

    /**
     * Common sequence for simulating either the first year, or the rest of the years
     */
    private void simulate() {
        calculateAverageForEveryChild();
        Double budgetUnit = calculateBudgetUnit();

        initialData.getChildren().forEach(child -> child.setReceivedGifts(new ArrayList<>()));

        ArrayList<Product> gifts = new ArrayList<>(initialData.getSantaGiftsList());
        gifts.sort(Comparator.comparing(Product::getPrice));

        HashMap<String, ArrayList<Product>> giftCategoryMap = new HashMap<>();
        for (var gift : gifts) {
            giftCategoryMap.putIfAbsent(gift.getCategory(), new ArrayList<>());
            giftCategoryMap.get(gift.getCategory()).add(gift);
        }

        for (var child : initialData.getChildren()) {
            child.setAssignedBudget(budgetUnit * child.getAverageScore());
            var budget = child.getAssignedBudget();
                for (var giftPref : child.getGiftsPreferences()) {
                    if (giftCategoryMap.get(giftPref) != null) {
                        var giftsByCategory = giftCategoryMap.get(giftPref);
                        for (var gift : giftsByCategory) {
                            if (budget >= gift.getPrice()) {
                                budget -= gift.getPrice();
                                child.getReceivedGifts().add(gift);
                                break;
                            }
                        }
                    }
                }
        }
    }

    /**
     * Method for calculating the budget unit
     * Used for finding the assigned budget for each child
     * @return budget unit value
     */
    private Double calculateBudgetUnit() {
        Double budgetUnit = (double) santaBudget;
        Double sum = 0.0;

        for (var child : initialData.getChildren()) {
            sum += child.getAverageScore();
        }

        return budgetUnit / sum;
    }

    /**
     * Method used for calculating the average score for all children
     */
    public void calculateAverageForEveryChild() {
        for (var child : initialData.getChildren()) {
            Double avg = 0.0;
            if (child.getAge() < Constants.BABY) {
                avg = Constants.MAX_SCORE;
            } else if (child.getAge() < Constants.KID) {
                for (var scoreEntry : child.getNiceScoreHistory()) {
                    avg += scoreEntry;
                }
                avg /= child.getNiceScoreHistory().size();
            } else if (child.getAge() <= Constants.TEEN) {
                int i = 1;
                for (var scoreEntry : child.getNiceScoreHistory()) {
                    avg += scoreEntry * (i++);
                }
                int sum = 0;
                for (i = 1; i <= child.getNiceScoreHistory().size(); i++) {
                    sum += i;
                }
                avg /= sum;
            }
            child.setAverageScore(avg);
        }
    }

    /**
     * Method used in the Database singleton, to fetch all the necessary data
     * Simulates all the other years, exception being made for the first year
     */
    public void simulateAnnualChanges() {
        for (int i = 1; i <= numberOfYears; i++) {

            this.initialData.getChildren().
                    forEach(child -> child.setAge(child.getAge() + 1));
            this.initialData.getChildren().
                    removeIf(child -> child.getAge() > Constants.TEEN);

            if (annualChanges != null) {
                if (annualChanges.get(i - 1) != null) {
                    this.santaBudget = annualChanges.get(i - 1).getNewSantaBudget();
                    this.initialData.getSantaGiftsList()
                            .addAll(annualChanges.get(i - 1).getNewGifts());

                    for (var childUpdate : annualChanges.get(i - 1).getChildrenUpdates()) {
                        for (var child : this.initialData.getChildren()) {
                            if (childUpdate.getId() == child.getId()) {
                                if (childUpdate.getNiceScore() != null) {
                                    child.setNiceScore(childUpdate.getNiceScore());
                                    child.getNiceScoreHistory().add(child.getNiceScore());
                                }
                                LinkedHashSet<String> giftPrefs = new
                                        LinkedHashSet<>(childUpdate.getGiftsPreferences());
                                giftPrefs.addAll(child.getGiftsPreferences());
                                child.setGiftsPreferences(new ArrayList<>(giftPrefs));
                                calculateAverageForEveryChild();
                            }
                        }
                    }
                    int startIndex = initialData.getChildren().size();
                    this.initialData.getChildren()
                            .addAll(annualChanges.get(i - 1).getNewChildren());
                    for (int j = startIndex; j < initialData.getChildren().size(); j++) {
                        initialData.getChildren().get(j)
                                .setNiceScoreHistory(new ArrayList<>());
                        initialData.getChildren().get(j)
                                .getNiceScoreHistory()
                                .add(initialData.getChildren().get(j).getNiceScore());
                        initialData.getChildren().get(j)
                                .setAverageScore(initialData.getChildren().get(j).getNiceScore());
                    }
                }
            }
            simulate();
            initialData.getChildren().removeIf(child -> child.getAge() > Constants.TEEN);
            var annualChildren = Database.getInstance().getAnnualChildren();
            var annualChildrenEntry = new
                    AnnualChildren(new ArrayList<>(initialData.getChildren()));
            annualChildren.add(annualChildrenEntry);
        }
    }
}
