package org.example.Response;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MkkResponse {

    @JsonProperty("publishDate")
    private String publishDate;

    @JsonProperty("kapTitle")
    private String kapTitle;

    @JsonProperty("isOldKap")
    private boolean isOldKap;

    @JsonProperty("disclosureClass")
    private String disclosureClass;

    @JsonProperty("disclosureType")
    private String disclosureType;

    @JsonProperty("disclosureCategory")
    private String disclosureCategory;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("ruleTypeTerm")
    private String ruleTypeTerm;

    @JsonProperty("disclosureIndex")
    private int disclosureIndex;

    @JsonProperty("isLate")
    private boolean isLate;

    @JsonProperty("stockCodes")
    private String stockCodes;

    @JsonProperty("hasMultiLanguageSupport")
    private boolean hasMultiLanguageSupport;

    @JsonProperty("attachmentCount")
    private int attachmentCount;

    @JsonProperty("year")
    private int year;

    @JsonProperty("relatedStocks")
    private String relatedStocks;

    @JsonProperty("isModified")
    private String isModified;


    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getKapTitle() {
        return kapTitle;
    }

    public void setKapTitle(String kapTitle) {
        this.kapTitle = kapTitle;
    }

    public boolean isOldKap() {
        return isOldKap;
    }

    public void setOldKap(boolean oldKap) {
        isOldKap = oldKap;
    }

    public String getDisclosureClass() {
        return disclosureClass;
    }

    public void setDisclosureClass(String disclosureClass) {
        this.disclosureClass = disclosureClass;
    }

    public String getDisclosureType() {
        return disclosureType;
    }

    public void setDisclosureType(String disclosureType) {
        this.disclosureType = disclosureType;
    }

    public String getDisclosureCategory() {
        return disclosureCategory;
    }

    public void setDisclosureCategory(String disclosureCategory) {
        this.disclosureCategory = disclosureCategory;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRuleTypeTerm() {
        return ruleTypeTerm;
    }

    public void setRuleTypeTerm(String ruleTypeTerm) {
        this.ruleTypeTerm = ruleTypeTerm;
    }

    public int getDisclosureIndex() {
        return disclosureIndex;
    }

    public void setDisclosureIndex(int disclosureIndex) {
        this.disclosureIndex = disclosureIndex;
    }

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }

    public String getStockCodes() {
        return stockCodes;
    }

    public void setStockCodes(String stockCodes) {
        this.stockCodes = stockCodes;
    }

    public boolean isHasMultiLanguageSupport() {
        return hasMultiLanguageSupport;
    }

    public void setHasMultiLanguageSupport(boolean hasMultiLanguageSupport) {
        this.hasMultiLanguageSupport = hasMultiLanguageSupport;
    }

    public int getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRelatedStocks() {
        return relatedStocks;
    }

    public void setRelatedStocks(String relatedStocks) {
        this.relatedStocks = relatedStocks;
    }

    public String getIsModified() {
        return isModified;
    }

    public void setIsModified(String isModified) {
        this.isModified = isModified;
    }

    public String toString() {
        return "MkkResponse{" +
                "publishDate='" + publishDate + '\'' +
                ", kapTitle='" + kapTitle + '\'' +
                ", isOldKap=" + isOldKap +
                ", disclosureClass='" + disclosureClass + '\'' +
                ", disclosureType='" + disclosureType + '\'' +
                ", disclosureCategory='" + disclosureCategory + '\'' +
                ", summary='" + summary + '\'' +
                ", subject='" + subject + '\'' +
                ", ruleTypeTerm='" + ruleTypeTerm + '\'' +
                ", disclosureIndex=" + disclosureIndex +
                ", isLate=" + isLate +
                ", stockCodes='" + stockCodes + '\'' +
                ", hasMultiLanguageSupport=" + hasMultiLanguageSupport +
                ", attachmentCount=" + attachmentCount +
                ", year=" + year +
                ", relatedStocks=" + relatedStocks +
                ", isModified=" + isModified +
        '}';
    }

}
