package org.atctech.lowinternettv.model;

public class CategoryDetails {

    private String id;

    private String image;

    private String icon;

    private String name;

    private String order;

    private String parentId;

    private String totalProducts;

    public CategoryDetails(String id, String image, String icon, String name, String order, String parentId, String totalProducts) {
        this.id = id;
        this.image = image;
        this.icon = icon;
        this.name = name;
        this.order = order;
        this.parentId = parentId;
        this.totalProducts = totalProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(String totalProducts) {
        this.totalProducts = totalProducts;
    }

}
