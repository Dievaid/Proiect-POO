package strategy;

import common.Constants;
import exec.Database;
import models.Child;
import models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Consumer;

public class YellowElfSharing implements SharingStrategy {
    /**
     * Method used for sharing gifts for the children who are assigned the Yellow Elf
     */
    @Override
    public final void share() {
        var gifts = Database.getInstance().getLoadedInput()
                .getInitialData().getSantaGiftsList();

        var children = new ArrayList<>(Database.getInstance().getLoadedInput()
                .getInitialData().getChildren());
        ArrayList<Product> giftsCopy = new ArrayList<>(gifts);
        giftsCopy.sort(Comparator.comparing(Product::getPrice));

        HashMap<String, ArrayList<Product>> giftCategoryMap = new HashMap<>();
        for (var gift : giftsCopy) {
            giftCategoryMap.putIfAbsent(gift.getCategory(), new ArrayList<>());
            giftCategoryMap.get(gift.getCategory()).add(gift);
        }

    Consumer<Child> childConsumer =
        child -> {
          if (child.getElf().equals(Constants.YELLOW) && child.getReceivedGifts().isEmpty()) {
            var giftPref = child.getGiftsPreferences().get(0);
            if (giftCategoryMap.containsKey(giftPref)) {
                if (giftCategoryMap.get(giftPref).get(0).getQuantity() > 0) {
                    var x = giftCategoryMap.get(giftPref).get(0);
                    x.setQuantity(x.getQuantity() - 1);
                    child.getReceivedGifts().add(x);
                }
            }
          }
        };
        children.forEach(childConsumer);
    }
}
