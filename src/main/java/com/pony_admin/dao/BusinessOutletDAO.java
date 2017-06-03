package com.pony_admin.dao;


import com.pony_admin.BusinessOutletAndWarehouse.entity.BusinessOutlet;
import com.pony_admin.BusinessOutletAndWarehouse.entity.QueryBean.BusinessOutletQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface BusinessOutletDAO {


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
    public BusinessOutlet getBusinessOutletByBusinessOutletId(@Param("businessOutletId") int businessOutletId);
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
