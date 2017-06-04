package com.pony_admin.BusinessOutletAndWarehouse.service;

import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.SpecialQueryBean;
import com.pony_admin.AdvertisementAndSpecial.entity.Special;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialProduct;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialTextItem;
import com.pony_admin.BusinessOutletAndWarehouse.entity.BusinessOutlet;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.BusinessOutletQueryBean;
import com.pony_admin.Product.entity.ProductEntity;
import com.pony_admin.dao.BusinessOutletDAO;
import com.pony_admin.dao.SpecialDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专题serviceImpl
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class BusinessOutletServiceImpl implements BusinessOutletService {

    @Autowired
    private BusinessOutletDAO businessOutletDAO;

    /**
     * 根据查询条件获取自提点列表
     *
     * @param businessOutletQueryBean
     * @return List<Advertisement>
     */
    public List<BusinessOutlet> getBusinessOutletList(BusinessOutletQueryBean businessOutletQueryBean){
        return  businessOutletDAO.getBusinessOutletList(businessOutletQueryBean);
    }
    /**
     * 根据自提点ID获取自提点
     *
     * @param businessOutletId
     * @return Advertisement
     */
    public BusinessOutlet getBusinessOutletByBusinessOutletId(int businessOutletId){
        return  businessOutletDAO.getBusinessOutletByBusinessOutletId(businessOutletId);
    }
    /**
     * 添加自提点
     *
     * @param businessOutlet
     * @return int
     */
    public int addBusinessOutlet(BusinessOutlet businessOutlet){
        return  businessOutletDAO.addBusinessOutlet(businessOutlet);
    }
    /**
     * 修改自提点
     *
     * @param businessOutlet
     * @return void
     */
    public void updateBusinessOutlet(BusinessOutlet businessOutlet){
        businessOutletDAO.updateBusinessOutlet(businessOutlet);
    }
}
