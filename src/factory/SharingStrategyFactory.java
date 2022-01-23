package factory;

import common.Constants;
import strategy.IdSharing;
import strategy.NiceScoreCitySharing;
import strategy.NiceScoreSharing;
import strategy.SharingStrategy;

public final class SharingStrategyFactory {
    private SharingStrategyFactory() { }
    /**
     * Does not work for the yellow elf, that's how I wanted it to work
     * @param strategyType used for generating a gift sharing strategy
     * @return strategy generated, just call the share method in order to use the generated strategy
     */
    public static SharingStrategy getSharingStrategy(final String strategyType) {
        switch (strategyType) {
            case Constants.NICE_SCORE -> {
                return new NiceScoreSharing();
            }
            case Constants.NICE_SCORE_CITY -> {
                return new NiceScoreCitySharing();
            }
            default -> {
                return new IdSharing();
            }
        }
    }
}
