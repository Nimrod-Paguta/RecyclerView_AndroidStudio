package ocier.paguta.recycler;

import java.util.List;

public class AminoAcidModel {
    String aminoAcidName;
    String aminoAcidAbbreviation;
    String aminoAcidAbbreviationSmall;

    String description;

    String id;
    String title;

    String price;
    String discountPercentage;

    String rating;
    String stock;
    String brand;
    String category;

    String thumbnail;

    List<String> images;

    public AminoAcidModel(String id, String title, String description,
                          String price, String discountPercentage, String rating,
                          String stock, String brand, String category, String thumbnail,
                          List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
        this.images = images;
    }

    public String getAminoAcidName() {
        return aminoAcidName;
    }

    public String getAminoAcidAbbreviation() {
        return aminoAcidAbbreviation;
    }

    public String getAminoAcidAbbreviationSmall() {
        return aminoAcidAbbreviationSmall;
    }


    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public String getRating() {
        return rating;
    }

    public String getStock() {
        return stock;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getThumbnail() {
        return thumbnail;
    }


    public List<String> getImages() {
        return images;
    }
}
