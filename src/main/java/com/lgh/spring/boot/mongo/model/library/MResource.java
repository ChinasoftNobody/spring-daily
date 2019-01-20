package com.lgh.spring.boot.mongo.model.library;

import com.lgh.spring.boot.mongo.model.MBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "t_resource")
public class MResource extends MBase {
    private String name;
    private String description;
    private String homePageLink;
    private int interlibSsoSysId;
    private boolean isNeedParseDetailPage;
    private int prior;
    private String  redirectInterlibSsoUrl;
    private String resourceGroupName;
    private String resourceId;
    private int show;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomePageLink() {
        return homePageLink;
    }

    public void setHomePageLink(String homePageLink) {
        this.homePageLink = homePageLink;
    }

    public int getInterlibSsoSysId() {
        return interlibSsoSysId;
    }

    public void setInterlibSsoSysId(int interlibSsoSysId) {
        this.interlibSsoSysId = interlibSsoSysId;
    }

    public boolean isNeedParseDetailPage() {
        return isNeedParseDetailPage;
    }

    public void setNeedParseDetailPage(boolean needParseDetailPage) {
        isNeedParseDetailPage = needParseDetailPage;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }

    public String getRedirectInterlibSsoUrl() {
        return redirectInterlibSsoUrl;
    }

    public void setRedirectInterlibSsoUrl(String redirectInterlibSsoUrl) {
        this.redirectInterlibSsoUrl = redirectInterlibSsoUrl;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
