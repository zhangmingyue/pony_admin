package com.pony_admin.dao;

import com.pony_admin.AdvertisementAndSpecial.entity.Advertisement;
import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.AdvertisementQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface AdvertisementDAO {


    /**
     * 根据查询条件获取广告列表
     *
     * @param advertismentQueryBean
     * @return List<Advertisement>
     */
    public List<Advertisement> getAdvertisementList(AdvertisementQueryBean advertismentQueryBean);
    /**
     * 根据广告ID获取广告
     *
     * @param advertismentQueryBean
     * @return Advertisement
     */
    public Advertisement getAdvertisementByAdvertisementId(AdvertisementQueryBean advertismentQueryBean);
    /**
     * 添加广告
     *
     * @param advertisement
     * @return int
     */
    public int addAdvertisement (Advertisement advertisement);
    /**
     * 按广告ID删除广告
     *
     * @param advertisementId
     * @return void
     */
    public void deleteAdvertisementByAdvertisementId(@Param("advertisementId")int advertisementId);
    /**
     * 修改广告
     *
     * @param advertisement
     * @return void
     */
    public void updateAdvertisement(Advertisement advertisement);


}
