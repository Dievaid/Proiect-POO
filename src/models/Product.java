package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productName;
    private Double price;
    private String category;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int quantity;
}
