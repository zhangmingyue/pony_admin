package com.pony_admin.BusinessOutletAndWarehouse.service;

import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.SpecialQueryBean;
import com.pony_admin.AdvertisementAndSpecial.entity.Special;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialProduct;
import com.pony_admin.AdvertisementAndSpecial.entity.SpecialTextItem;
import com.pony_admin.BusinessOutletAndWarehouse.entity.BusinessOutlet;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.BusinessOutletQueryBean;

import java.util.List;

/**
 * 专题service
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface BusinessOutletService {


    /**
    * 根据查询条件获取自提点列表
    *
    * @param businessOutletQueryBean
    * @return List<Advertisement>
    */
    public List<BusinessOutlet> getBusinessOutletList(BusinessOutletQueryBean businessOutletQueryBean);
    /**
     * 根据自提点ID获取自提点
     *
     * @param businessOutletId
     * @return Advertisement
     */
    public BusinessOutlet getBusinessOutletByBusinessOutletId(int businessOutletId);
    /**
     * 添加自提点
     *
     * @param businessOutlet
     * @return int
     */
    public int addBusinessOutlet(BusinessOutlet businessOutlet);
    /**
     * 修改自提点
     *
     * @param businessOutlet
     * @return void
     */
    public void updateBusinessOutlet(BusinessOutlet businessOutlet);

}
