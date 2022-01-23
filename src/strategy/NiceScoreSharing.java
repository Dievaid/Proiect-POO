package strategy;

import exec.Database;
import models.Child;

import java.util.Comparator;

public class NiceScoreSharing implements SharingStrategy {
    @Override
    public final void share() {
        Database.getInstance()
                .getLoadedInput()
                .getInitialData()
                .getChildren()
                .sort(Comparator.comparing(Child::getAverageScore)
                        .reversed().thenComparing(Child::getId));
    }
}
