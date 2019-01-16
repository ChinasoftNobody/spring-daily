package com.lgh.spring.boot.service.library.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lgh.spring.boot.mapper.ResourceMapper;
import com.lgh.spring.boot.model.library.MResource;
import com.lgh.spring.boot.service.library.ResourceService;
import com.lgh.spring.boot.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Value("${url.getResourceInfo}")
    private String externalGetResourceUrl;
    @Resource
    private ResourceMapper resourceMapper;

    @Override
    public List<MResource> queryExternalResource() {
        try {
            String externalJsonStr = RestTemplateUtil.get(externalGetResourceUrl + "?noCacheId" + System.currentTimeMillis());
            JSONObject jsonObject = JSONObject.parseObject(externalJsonStr);
            List<MResource> resources = new ArrayList<>();
            if (jsonObject != null){
                JSONArray jsonArray = jsonObject.getJSONArray("resourceInfoList");
                if (jsonArray != null && !jsonArray.isEmpty()){
                    Iterator<Object> iterator = jsonArray.iterator();
                    while (iterator.hasNext()){
                        JSONObject object = (JSONObject)iterator.next();
                        MResource mResource = new MResource();
                        mResource.setDescription(object.getString("description"));
                        mResource.setHomePageLink(object.getString("homePageLink"));
                        mResource.setInterlibSsoSysId(object.getInteger("interlibSsoSysId"));
                        mResource.setName(object.getString("name"));
                        mResource.setNeedParseDetailPage(object.getBoolean("isNeedParseDetailPage"));
                        mResource.setPrior(object.getInteger("prior"));
                        mResource.setRedirectInterlibSsoUrl(object.getString("redirectInterlibSsoUrl"));
                        mResource.setResourceGroupName(object.getString("resourceGroupName"));
                        mResource.setResourceId(object.getString("resourceId"));
                        mResource.setShow(object.getInteger("show"));
                        mResource.setState(object.getString("state"));
                        resources.add(mResource);
                    }
                }
            }
            return resources;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void dropAll() {
        resourceMapper.dropAll();
    }

    @Override
    public void save(List<MResource> resources) {
        resourceMapper.save(resources);
    }

}
