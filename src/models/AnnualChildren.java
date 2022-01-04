package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AnnualChildren {
    @JsonProperty("children")
    private List<Child> children;

    public AnnualChildren(final List<Child> children) {
        this.children = new ArrayList<>();
        for (var child : children) {
            this.children.add(new Child(child));
        }
    }
}
