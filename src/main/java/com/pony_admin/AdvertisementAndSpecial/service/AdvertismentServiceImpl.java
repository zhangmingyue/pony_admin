package com.pony_admin.AdvertisementAndSpecial.service;

import com.pony_admin.AdvertisementAndSpecial.entity.Advertisement;
import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.AdvertisementQueryBean;
import com.pony_admin.dao.AdvertisementDAO;
import com.pony_admin.dao.ProductDAO;
import com.pony_admin.Product.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告serviceImpl
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class AdvertismentServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementDAO advertismentDAO;
    @Autowired
    private ProductDAO productDAO;



    /**
     * 根据查询条件获取广告列表
     *
     * @param advertismentQueryBean
     * @return List<Advertisement>
     */
    public List<Advertisement> getAdvertisementList(AdvertisementQueryBean advertismentQueryBean){

        List<Advertisement> advertisementList = advertismentDAO.getAdvertisementList(advertismentQueryBean);
//        ProductEntity productEntity;
//        for(Advertisement advertisement:advertisementList){
//            productEntity = null;
//            productEntity = productDAO.getProductById(advertisement.getProductId());
//            advertisement.setProductEntity(productEntity);
//        }
        return advertisementList;

    }

    /**
     * 根据广告ID获取广告
     *
     * @param advertismentQueryBean
     * @return Advertisemen
     */
    public Advertisement getAdvertisementByAdvertisementId(AdvertisementQueryBean advertismentQueryBean){

        Advertisement advertisement = advertismentDAO.getAdvertisementByAdvertisementId(advertismentQueryBean);
        ProductEntity productEntity = productDAO.getProductById(advertisement.getProductId());
        advertisement.setProductEntity(productEntity);
        return advertisement;

    }

    /**
     * 添加广告
     *
     * @param advertisement
     * @return int
     */
    public int addAdvertisement (Advertisement advertisement){
        return advertismentDAO.addAdvertisement(advertisement);
    }

    /**
     * 批量删除广告
     *
     * @param advertisementIdList
     * @return Advertisement
     */
    public void deleteAdvertisementByAdvertisementId(List<Integer> advertisementIdList){
        for(Integer advertisementId : advertisementIdList) {
            advertismentDAO.deleteAdvertisementByAdvertisementId(advertisementId);
        }
    }

    /**
     * 修改广告
     *
     * @param advertisement
     * @return void
     */
    public void updateAdvertisement(Advertisement advertisement){
        advertismentDAO.updateAdvertisement(advertisement);
    }

}
