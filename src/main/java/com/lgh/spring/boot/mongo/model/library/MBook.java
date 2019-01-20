package com.lgh.spring.boot.mongo.model.library;

import com.alibaba.fastjson.JSONArray;
import com.lgh.spring.boot.mongo.model.MBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "t_book")
public class MBook extends MBase {
    /**
     * id
     */
    private int number;
    private String addedAuthorOrEditor;
    private String addedCorpAuthor;
    private JSONArray authorList;
    private String bookRecNo;
    private String citation;
    private JSONArray classnoList;
    private long combinedTime;
    private long createTime;
    private String description;
    private String downloadLink;
    private String fromSource;
    private String gcxx;
    private String internetAccess;
    private boolean detailPageParsed;
    private JSONArray isbnList;
    private String issn;
    private String journalVolInfo;
    private JSONArray keywordList;
    private String language;
    private long lastAccessTime;
    private Object metaInfo;
    private String onlineLink;
    private int page;
    private String publicationDate;
    private String publicationYear;
    private String publisher;
    private JSONArray repeatParsedResultList;
    private int repeatSize;
    private String requestKey;
    private String resourceId;
    private String resourceName;
    private String series;
    private String sessionId;
    private int setNumber;
    private JSONArray subjectList;
    private String summary;
    private String title;
    private String titleHref;
    private JSONArray typeList;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddedAuthorOrEditor() {
        return addedAuthorOrEditor;
    }

    public void setAddedAuthorOrEditor(String addedAuthorOrEditor) {
        this.addedAuthorOrEditor = addedAuthorOrEditor;
    }

    public String getAddedCorpAuthor() {
        return addedCorpAuthor;
    }

    public void setAddedCorpAuthor(String addedCorpAuthor) {
        this.addedCorpAuthor = addedCorpAuthor;
    }

    public JSONArray getAuthorList() {
        return authorList;
    }

    public void setAuthorList(JSONArray authorList) {
        this.authorList = authorList;
    }

    public String getBookRecNo() {
        return bookRecNo;
    }

    public void setBookRecNo(String bookRecNo) {
        this.bookRecNo = bookRecNo;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public JSONArray getClassnoList() {
        return classnoList;
    }

    public void setClassnoList(JSONArray classnoList) {
        this.classnoList = classnoList;
    }

    public long getCombinedTime() {
        return combinedTime;
    }

    public void setCombinedTime(long combinedTime) {
        this.combinedTime = combinedTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    public String getGcxx() {
        return gcxx;
    }

    public void setGcxx(String gcxx) {
        this.gcxx = gcxx;
    }

    public String getInternetAccess() {
        return internetAccess;
    }

    public void setInternetAccess(String internetAccess) {
        this.internetAccess = internetAccess;
    }

    public boolean isDetailPageParsed() {
        return detailPageParsed;
    }

    public void setDetailPageParsed(boolean detailPageParsed) {
        this.detailPageParsed = detailPageParsed;
    }

    public JSONArray getIsbnList() {
        return isbnList;
    }

    public void setIsbnList(JSONArray isbnList) {
        this.isbnList = isbnList;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getJournalVolInfo() {
        return journalVolInfo;
    }

    public void setJournalVolInfo(String journalVolInfo) {
        this.journalVolInfo = journalVolInfo;
    }

    public JSONArray getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(JSONArray keywordList) {
        this.keywordList = keywordList;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Object getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(Object metaInfo) {
        this.metaInfo = metaInfo;
    }

    public String getOnlineLink() {
        return onlineLink;
    }

    public void setOnlineLink(String onlineLink) {
        this.onlineLink = onlineLink;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public JSONArray getRepeatParsedResultList() {
        return repeatParsedResultList;
    }

    public void setRepeatParsedResultList(JSONArray repeatParsedResultList) {
        this.repeatParsedResultList = repeatParsedResultList;
    }

    public int getRepeatSize() {
        return repeatSize;
    }

    public void setRepeatSize(int repeatSize) {
        this.repeatSize = repeatSize;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public JSONArray getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(JSONArray subjectList) {
        this.subjectList = subjectList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleHref() {
        return titleHref;
    }

    public void setTitleHref(String titleHref) {
        this.titleHref = titleHref;
    }

    public JSONArray getTypeList() {
        return typeList;
    }

    public void setTypeList(JSONArray typeList) {
        this.typeList = typeList;
    }
}
