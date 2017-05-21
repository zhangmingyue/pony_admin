package com.pony_admin.dao;

import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.SpecialQueryBean;
import com.pony_admin.AdvertisementAndSpecial.entity.Special;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialProduct;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialTextItem;
import com.pony_admin.Product.entity.ProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface SpecialDAO {



    /**
     * 按查询条件获取专题列表
     *
     * @param specialQueryBean
     * @return List<Product>
     */
    public List<Special> getSpecialList(SpecialQueryBean specialQueryBean);
    /**
     * 按专题ID获取文本项列表
     *
     * @param specialId
     * @return List<SpecialTextItem>
     */
    public List<SpecialTextItem> getSpecialTextItemListBySpecialId(@Param("specialId") int specialId);
    /**
     * 按专题ID获取产品列表
     *
     * @param specialId
     * @return List<Product>
     */
    public List<ProductEntity> getProductListBySpecialId(@Param("specialId") int specialId);
    /**
     * 按专题ID获取专题
     *
     * @param specialQueryBean
     * @return Special
     */
    public Special getSpecialBySpecialId(SpecialQueryBean specialQueryBean);
    /**
     * 添加专题
     *
     * @param special
     * @return void
     */
    public void addSpecial(Special special);
    /**
     * 删除专题
     *
     * @param specialId
     * @return void
     */
    public void deleteSpecialBySpecialId(@Param("specialId") int specialId);
    /**
     * 修改专题
     *
     * @param special
     * @return void
     */
    public void updateSpecialBySpecialId(Special special);
    /**
     * 添加专题文本项
     *
     * @param specialTextItem
     * @return void
     */
    public void addSpecialTextItem(SpecialTextItem specialTextItem);
    /**
     * 删除专题文本项
     *
     * @param specialTextItemId
     * @return void
     */
    public void deleteSpecialTextItemBySpecialTextItemId(@Param("specialTextItemId") int specialTextItemId);
    /**
     * 修改专题文本项
     *
     * @param specialTextItem
     * @return void
     */
    public void updateSpecialTextItemBySpecialTextItemId(SpecialTextItem specialTextItem);
    /**
     * 添加专题关联产品
     *
     * @param specialProduct
     * @return void
     */
    public void addSpecialProduct(SpecialProduct specialProduct);
    /**
     * 删除专题关联产品
     *
     * @param specialProductId
     * @return void
     */
    public void deleteSpecialProductBySpecialProductId(@Param("specialProductId") int specialProductId);

    /**
     * 删除专题关联产品
     *
     * @param specialId  productId
     * @return void
     */
    public void deleteSpecialProductBySpecialAndProductId(@Param("specialId") int specialId,@Param("productId") int productId);

}
