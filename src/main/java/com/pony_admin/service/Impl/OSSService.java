package com.pony_admin.service.Impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/1
 */
@Service
public class OSSService {
    static Logger logger = Logger.getLogger(OSSService.class);

    private static final String ACCESS_KEY_ID = "LTAIWJwgxakkV5n3";
    private static final String ACCESS_KEY_SECRET = "YLwNLhTpKAD6Mhvml136RgFW19Jh1V";
    private static final String ENDPOINT = "oss-cn-qingdao.aliyuncs.com";

    /**
     * 上传文件,返回文件的url,返回null证明存储失败
     *
     * @param inputStream
     * @return
     * @throws FileNotFoundException
     */
    public String savePicAndGetUrl(InputStream inputStream, String bucketName,String bucketKey) throws FileNotFoundException {
        try {
            OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            PutObjectResult result = ossClient.putObject(bucketName, bucketKey, inputStream);
            if (result == null || result.getETag() == null) {
                return null;
            }

            OSSObject ossObject = ossClient.getObject(bucketName,bucketKey);
            String url = ossObject==null?null:ossObject.getResponse().getUri();
            return url;
        } catch (Exception e) {
            logger.info(" OSSService Exception e={}", e);
            return null;
        }
    }

}
