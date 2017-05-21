package com.pony_admin.AdvertisementAndSpecial.service;

import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.SpecialQueryBean;
import com.pony_admin.AdvertisementAndSpecial.entity.Special;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialProduct;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialTextItem;
import com.pony_admin.dao.SpecialDAO;
import com.pony_admin.Product.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专题serviceImpl
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class SpecialServiceImpl implements SpecialService{

    @Autowired
    private SpecialDAO specialDAO;


    /**
     * 按查询条件获取专题列表
     *
     * @param specialQueryBean
     * @return List<Product>
     */
    public List<Special> getSpecialList(SpecialQueryBean specialQueryBean){

        List<Special> specialList = specialDAO.getSpecialList(specialQueryBean);
        return specialList;

    }

    /**
     * 按专题ID获取专题
     *
     * @param specialQueryBean
     * @return Special
     */
    public Special getSpecialBySpecialId(SpecialQueryBean specialQueryBean){

        Special special = specialDAO.getSpecialBySpecialId(specialQueryBean);
        List<SpecialTextItem> SpecialTextItemList = specialDAO.getSpecialTextItemListBySpecialId(special.getId());
        List<ProductEntity> productList = specialDAO.getProductListBySpecialId(special.getId());
        special.setProductList(productList);
        special.setSpecialTextItemList(SpecialTextItemList);
        return special;

    }

    /**
     * 添加专题
     *
     * @param special
     * @return void
     */
    public void addSpecial(Special special) {
        specialDAO.addSpecial(special);
    }

    /**
     * 删除专题
     *
     * @param specialIdList
     * @return void
     */
    public void deleteSpecialBySpecialId(List<Integer> specialIdList){
        for(int specialId : specialIdList) {
            specialDAO.deleteSpecialBySpecialId(specialId);
        }
    }

    /**
     * 修改专题
     *
     * @param special
     * @return void
     */
    public void updateSpecialBySpecialId(Special special){
        specialDAO.updateSpecialBySpecialId(special);
    }

    /**
     * 添加专题文本项
     *
     * @param specialTextItem
     * @return void
     */
    public void addSpecialTextItem(SpecialTextItem specialTextItem){
        specialDAO.addSpecialTextItem(specialTextItem);
    }

    /**
     * 删除专题文本项
     *
     * @param specialTextItemId
     * @return void
     */
    public void deleteSpecialTextItemBySpecialTextItemId( int specialTextItemId){
        specialDAO.deleteSpecialTextItemBySpecialTextItemId(specialTextItemId);
    }

    /**
     * 修改专题文本项
     *
     * @param specialTextItem
     * @return void
     */
    public void updateSpecialTextItemBySpecialTextItemId(SpecialTextItem specialTextItem){
        specialDAO.updateSpecialTextItemBySpecialTextItemId(specialTextItem);
    }

    /**
     * 添加专题关联产品
     *
     * @param specialProduct
     * @return void
     */
    public void addSpecialProduct(SpecialProduct specialProduct){
        specialDAO.addSpecialProduct(specialProduct);
    }

    /**
     * 删除专题关联产品
     *
     * @param SpecialProductId
     * @return void
     */
    public void deleteSpecialProductBySpecialProductId(int SpecialProductId){
        specialDAO.deleteSpecialProductBySpecialProductId(SpecialProductId);
    }

    /**
     * 删除专题关联产品
     *
     * @param specialId productId
     * @return void
     */
    public void deleteSpecialProductBySpecialAndProductId( int specialId,int productId){
        specialDAO.deleteSpecialProductBySpecialAndProductId(specialId,productId);
    }
}
