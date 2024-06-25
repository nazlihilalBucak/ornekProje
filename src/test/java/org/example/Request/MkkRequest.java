package org.example.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class MkkRequest {

    @JsonProperty("fromDate")
    private String fromDate;

    @JsonProperty("toDate")
    private String toDate;

    @JsonProperty("year")
    private String year;

    @JsonProperty("prd")
    private String prd;

    @JsonProperty("term")
    private String term;

    @JsonProperty("ruleType")
    private String ruleType;

    @JsonProperty("bdkReview")
    private String bdkReview;

    @JsonProperty("disclosureClass")
    private String disclosureClass;

    @JsonProperty("index")
    private String index;

    @JsonProperty("market")
    private String market;

    @JsonProperty("isLate")
    private String isLate;

    @JsonProperty("subjectList")
    private List<String> subjectList;

    @JsonProperty("mkkMemberOidList")
    private List<String> mkkMemberOidList;

    @JsonProperty("inactiveMkkMemberOidList")
    private List<String> inactiveMkkMemberOidList;

    @JsonProperty("bdkMemberOidList")
    private List<String> bdkMemberOidList;

    @JsonProperty("mainSector")
    private String mainSector;

    @JsonProperty("sector")
    private String sector;

    @JsonProperty("subSector")
    private String subSector;

    @JsonProperty("memberType")
    private String memberType;

    @JsonProperty("fromSrc")
    private String fromSrc;

    @JsonProperty("srcCategory")
    private String srcCategory;

    @JsonProperty("discIndex")
    private List<String> discIndex;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrd() {
        return prd;
    }

    public void setPrd(String prd) {
        this.prd = prd;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getBdkReview() {
        return bdkReview;
    }

    public void setBdkReview(String bdkReview) {
        this.bdkReview = bdkReview;
    }

    public String getDisclosureClass() {
        return disclosureClass;
    }

    public void setDisclosureClass(String disclosureClass) {
        this.disclosureClass = disclosureClass;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getIsLate() {
        return isLate;
    }

    public void setIsLate(String isLate) {
        this.isLate = isLate;
    }

    public List<String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }

    public List<String> getMkkMemberOidList() {
        return mkkMemberOidList;
    }

    public void setMkkMemberOidList(List<String> mkkMemberOidList) {
        this.mkkMemberOidList = mkkMemberOidList;
    }

    public List<String> getInactiveMkkMemberOidList() {
        return inactiveMkkMemberOidList;
    }

    public void setInactiveMkkMemberOidList(List<String> inactiveMkkMemberOidList) {
        this.inactiveMkkMemberOidList = inactiveMkkMemberOidList;
    }

    public List<String> getBdkMemberOidList() {
        return bdkMemberOidList;
    }

    public void setBdkMemberOidList(List<String> bdkMemberOidList) {
        this.bdkMemberOidList = bdkMemberOidList;
    }

    public String getMainSector() {
        return mainSector;
    }

    public void setMainSector(String mainSector) {
        this.mainSector = mainSector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSubSector() {
        return subSector;
    }

    public void setSubSector(String subSector) {
        this.subSector = subSector;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getFromSrc() {
        return fromSrc;
    }

    public void setFromSrc(String fromSrc) {
        this.fromSrc = fromSrc;
    }

    public String getSrcCategory() {
        return srcCategory;
    }

    public void setSrcCategory(String srcCategory) {
        this.srcCategory = srcCategory;
    }

    public List<String> getDiscIndex() {
        return discIndex;
    }

    public void setDiscIndex(List<String> discIndex) {
        this.discIndex = discIndex;
    }





}
