package com.zero.barrageserver.activeapi.dao;

import com.zero.barrageserver.activeapi.mapper.CMSActiveMapper;
import com.zero.barrageserver.common.entity.activeresponse.BaseActiveResponseEntity;
import com.zero.barrageserver.common.entity.activerequest.DownloadImageEntity;
import com.zero.barrageserver.common.entity.VersionEntity;
import com.zero.barrageserver.common.utils.HttpUtil;
import com.zero.barrageserver.activeapi.mapper.CMSActiveMapper;
import com.zero.barrageserver.common.entity.VersionEntity;
import com.zero.barrageserver.common.entity.activerequest.DownloadImageEntity;
import com.zero.barrageserver.common.utils.HttpUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by zero大神 on 2017/12/1.
 */
@Component
@Log4j2
public class CMSActiveDao {
    private CMSActiveMapper cmsActiveMapper = HttpUtil.getCMSService(CMSActiveMapper.class);

    public List<DownloadImageEntity> getDownloadInfoList() {
        try {
            Response<BaseActiveResponseEntity<List<DownloadImageEntity>>> response = cmsActiveMapper.getDownloadAnimList().execute();
            log.info("response:" + response.body().getResult());
            return response.body().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public VersionEntity getVersion() {
        try {
            Response<BaseActiveResponseEntity<VersionEntity>> response = cmsActiveMapper.getVersion().execute();
            return response.body().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
