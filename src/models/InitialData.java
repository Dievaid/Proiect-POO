package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InitialData {
    private List<Child> children;
    private List<Product> santaGiftsList;
}
