package strategy;

import exec.Database;
import models.Child;

import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Consumer;

public class NiceScoreCitySharing implements SharingStrategy {
    @Override
    public final void share() {
        HashMap<String, Double> niceScoreCityMap = new HashMap<>();
        Consumer<Child> childConsumer = child -> {
            niceScoreCityMap.putIfAbsent(child.getCity(), child.averageForCity());
            var buildNiceCityScore =
                    new Child.Builder().withNiceScoreCity(
                            niceScoreCityMap.get(child.getCity())).build();
            child.setNiceScoreCity(buildNiceCityScore.getNiceScoreCity());
        };

        Database.getInstance().getLoadedInput().getInitialData()
                .getChildren().forEach(childConsumer);

        Database.getInstance().getLoadedInput().getInitialData()
                .getChildren().sort(Comparator.comparing(Child::getNiceScoreCity).reversed()
                        .thenComparing(Child::getCity)
                        .thenComparing(Child::getId));
    }
}
