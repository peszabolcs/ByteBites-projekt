package hu.university.etelprojekt.etelprojekt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "categories") // Optional: specify the table name in the database
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the categoryId (primary key)
    private Long category_id;

    private String categoryName;
    private String pictureUrl;

    // Default constructor
    public Category() {
    }

    // Constructor with all fields
    public Category(Long categoryId, String categoryName, String pictureUrl) {
        this.category_id = categoryId;
        this.categoryName = categoryName;
        this.pictureUrl = pictureUrl;
    }

    // Getters and Setters
    public Long getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Long categoryId) {
        this.category_id = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + category_id + ", categoryName=" + categoryName + ", pictureUrl=" + pictureUrl
                + "]";
    }
}
