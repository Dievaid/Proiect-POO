package strategy;

import exec.Database;
import models.Child;

import java.util.Comparator;

public class IdSharing implements SharingStrategy {
    @Override
    public final void share() {
        Database.getInstance()
                .getLoadedInput()
                .getInitialData()
                .getChildren()
                .sort(Comparator.comparing(Child::getId));
    }
}
