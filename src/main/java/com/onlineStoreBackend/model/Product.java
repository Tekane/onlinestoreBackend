package com.onlineStoreBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@JsonIgnoreProperties(value = {"categoryId","supplierId","description","file"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String code;
    @NotBlank(message = "Please enter product name!")
    private  String name;
    @NotBlank(message = "Please enter brand name!")
    private  String brand;
    @NotBlank(message = "Please enter description for product!")
    private  String description;
    @Column(name = "unit_price")
    @Min(value = 1,message = "The price cannot less be less than one!")
    private  double unitPrice;
    private  int quantity;
    @Column(name = "is_active")
    private String active;
    @Column(name = "category_id")
    private  int categoryId;
    @Column(name = "supplier_id")
    private  int supplierId;
    private  int purchases;
    private  int views;
    @Transient
    private  boolean isActive = false;
    @Transient
    private MultipartFile file;

    //Generating a unique Id for product code
    public Product() {
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getActive() { return active; }

    public void setActive(String active) { this.active = active; }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }

    public MultipartFile getFile() { return file; }

    public void setFile(MultipartFile file) { this.file = file; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", active='" + active + '\'' +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", purchases=" + purchases +
                ", views=" + views +
                ", isActive=" + isActive +
                '}';
    }
}
