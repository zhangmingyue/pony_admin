package com.pony_admin.Product.entity;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/8
 */
public class ProductPictureEntity {
    private int id;
    private String productPictureUrl;
    private int coverpicture;
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductPictureUrl() {
        return productPictureUrl;
    }

    public void setProductPictureUrl(String productPictureUrl) {
        this.productPictureUrl = productPictureUrl;
    }

    public int getCoverpicture() {
        return coverpicture;
    }

    public void setCoverpicture(int coverpicture) {
        this.coverpicture = coverpicture;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProduct_id() {
        return productId;
    }

    public void setProduct_id(int product_id) {
        this.productId = product_id;
    }

    @Override
    public String toString() {
        return "ProductPictureEntity{" +
                "id=" + id +
                ", productPictureUrl='" + productPictureUrl + '\'' +
                ", coverPicture=" + coverpicture +
                ", product_id=" + productId +
                '}';
    }
}
