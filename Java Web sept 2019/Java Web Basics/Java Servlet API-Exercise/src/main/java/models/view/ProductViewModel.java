package models.view;

public class ProductViewModel {

        private String description;

    public ProductViewModel() {
    }

    public ProductViewModel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
