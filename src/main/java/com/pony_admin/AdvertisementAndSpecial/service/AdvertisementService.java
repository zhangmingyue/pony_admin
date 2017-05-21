package com.pony_admin.AdvertisementAndSpecial.service;

import com.pony_admin.AdvertisementAndSpecial.entity.Advertisement;
import com.pony_admin.AdvertisementAndSpecial.entity.QueryBean.AdvertisementQueryBean;

import java.util.List;

/**
 * 广告service
 * Created by zhangmingyue on 2017/3/1 0001.
 */
public interface AdvertisementService {


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
     * @return Advertisemen
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
     * 批量删除广告
     *
     * @param advertisementId
     * @return void
     */
    public void deleteAdvertisementByAdvertisementId(List<Integer> advertisementId);

    /**
     * 修改广告
     *
     * @param advertisement
     * @return void
     */
    public void updateAdvertisement(Advertisement advertisement);

}
