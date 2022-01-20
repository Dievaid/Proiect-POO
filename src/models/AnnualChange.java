package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnualChange {
    private int newSantaBudget;
    private List<Product> newGifts;
    private List<Child> newChildren;
    private List<ChildChange> childrenUpdates;
    private String strategy;
}
