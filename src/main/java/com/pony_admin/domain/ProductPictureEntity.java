package com.pony_admin.domain;

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

    public int getCoverPicture() {
        return coverpicture;
    }

    public void setCoverPicture(int coverPicture) {
        this.coverpicture = coverPicture;
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
