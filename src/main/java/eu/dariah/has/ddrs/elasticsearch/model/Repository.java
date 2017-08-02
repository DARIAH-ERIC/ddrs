package eu.dariah.has.ddrs.elasticsearch.model;

import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import io.searchbox.annotations.JestId;

import java.util.List;

/**
 * Created by yoann on 18.07.17.
 */
public class Repository {
    private List<AdditionalName> additionalNames;
    private List<Re3dataText> aidSystems;
    private List<Re3dataType> apis;
    private List<Re3dataType> certificates;
    private String citationGuidelineUrl;
    private List<ContentType> contentTypes;
    private String created;
    private List<DataAccess> dataAccesses;
    private List<Re3dataName> dataLicenses;
    private List<Re3dataName> dataUploadLicenses;
    private List<DataUpload> dataUploads;
    private DatabaseAccess databaseAccess;
    private List<DatabaseLicense> databaseLicenses;
    private String description;
    private String descriptionLanguage;
    private String endDate;
    private String enhancedPublication;
    private Identifier identifier;
    private List<Institution> institutions;
    private List<Re3dataText> keywords;
    private List<MetadataStandard> metadataStandards;
    private String missionStatementUrl;
    private List<Re3dataText> pidSystems;
    private List<Policy> policies;
    private List<Re3dataText> providerTypes;
    private String qualityManagement;
    private String remarks;
    private List<Re3dataText> repositoryContacts;
    private List<Re3dataText> repositoryIdentifiers;
    private List<Re3dataText> repositoryLanguages;
    private String repositoryNameLanguage;
    private String repositoryUrl;
    private String size;
    private String sizeUpdated;
    private List<Re3dataName> software;
    private String startDate;
    private List<Subject> subjects;
    private List<Syndication> syndications;
    private List<Re3dataType> types;
    private String updated;
    private String versioning;


    public Repository() {
    }

    public List<AdditionalName> getAdditionalNames() {
        return additionalNames;
    }

    public void setAdditionalNames(List<AdditionalName> additionalNames) {
        this.additionalNames = additionalNames;
    }

    public List<Re3dataText> getAidSystems() {
        return aidSystems;
    }

    public void setAidSystems(List<Re3dataText> aidSystems) {
        this.aidSystems = aidSystems;
    }

    public List<Re3dataType> getApis() {
        return apis;
    }

    public void setApis(List<Re3dataType> apis) {
        this.apis = apis;
    }

    public List<Re3dataType> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Re3dataType> certificates) {
        this.certificates = certificates;
    }

    public String getCitationGuidelineUrl() {
        return citationGuidelineUrl;
    }

    public void setCitationGuidelineUrl(String citationGuidelineUrl) {
        this.citationGuidelineUrl = citationGuidelineUrl;
    }

    public List<ContentType> getContentTypes() {
        return contentTypes;
    }

    public void setContentTypes(List<ContentType> contentTypes) {
        this.contentTypes = contentTypes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<DataAccess> getDataAccesses() {
        return dataAccesses;
    }

    public void setDataAccesses(List<DataAccess> dataAccesses) {
        this.dataAccesses = dataAccesses;
    }

    public List<Re3dataName> getDataLicenses() {
        return dataLicenses;
    }

    public void setDataLicenses(List<Re3dataName> dataLicenses) {
        this.dataLicenses = dataLicenses;
    }

    public List<Re3dataName> getDataUploadLicenses() {
        return dataUploadLicenses;
    }

    public void setDataUploadLicenses(List<Re3dataName> dataUploadLicenses) {
        this.dataUploadLicenses = dataUploadLicenses;
    }

    public List<DataUpload> getDataUploads() {
        return dataUploads;
    }

    public void setDataUploads(List<DataUpload> dataUploads) {
        this.dataUploads = dataUploads;
    }

    public DatabaseAccess getDatabaseAccess() {
        return databaseAccess;
    }

    public void setDatabaseAccess(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public List<DatabaseLicense> getDatabaseLicenses() {
        return databaseLicenses;
    }

    public void setDatabaseLicenses(List<DatabaseLicense> databaseLicenses) {
        this.databaseLicenses = databaseLicenses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionLanguage() {
        return descriptionLanguage;
    }

    public void setDescriptionLanguage(String descriptionLanguage) {
        this.descriptionLanguage = descriptionLanguage;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEnhancedPublication() {
        return enhancedPublication;
    }

    public void setEnhancedPublication(String enhancedPublication) {
        this.enhancedPublication = enhancedPublication;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public List<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(List<Institution> institutions) {
        this.institutions = institutions;
    }

    public List<Re3dataText> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Re3dataText> keywords) {
        this.keywords = keywords;
    }

    public List<MetadataStandard> getMetadataStandards() {
        return metadataStandards;
    }

    public void setMetadataStandards(List<MetadataStandard> metadataStandards) {
        this.metadataStandards = metadataStandards;
    }

    public String getMissionStatementUrl() {
        return missionStatementUrl;
    }

    public void setMissionStatementUrl(String missionStatementUrl) {
        this.missionStatementUrl = missionStatementUrl;
    }

    public List<Re3dataText> getPidSystems() {
        return pidSystems;
    }

    public void setPidSystems(List<Re3dataText> pidSystems) {
        this.pidSystems = pidSystems;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public List<Re3dataText> getProviderTypes() {
        return providerTypes;
    }

    public void setProviderTypes(List<Re3dataText> providerTypes) {
        this.providerTypes = providerTypes;
    }

    public String getQualityManagement() {
        return qualityManagement;
    }

    public void setQualityManagement(String qualityManagement) {
        this.qualityManagement = qualityManagement;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Re3dataText> getRepositoryContacts() {
        return repositoryContacts;
    }

    public void setRepositoryContacts(List<Re3dataText> repositoryContacts) {
        this.repositoryContacts = repositoryContacts;
    }

    public List<Re3dataText> getRepositoryIdentifiers() {
        return repositoryIdentifiers;
    }

    public void setRepositoryIdentifiers(List<Re3dataText> repositoryIdentifiers) {
        this.repositoryIdentifiers = repositoryIdentifiers;
    }

    public List<Re3dataText> getRepositoryLanguages() {
        return repositoryLanguages;
    }

    public void setRepositoryLanguages(List<Re3dataText> repositoryLanguages) {
        this.repositoryLanguages = repositoryLanguages;
    }

    public String getRepositoryNameLanguage() {
        return repositoryNameLanguage;
    }

    public void setRepositoryNameLanguage(String repositoryNameLanguage) {
        this.repositoryNameLanguage = repositoryNameLanguage;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeUpdated() {
        return sizeUpdated;
    }

    public void setSizeUpdated(String sizeUpdated) {
        this.sizeUpdated = sizeUpdated;
    }

    public List<Re3dataName> getSoftware() {
        return software;
    }

    public void setSoftware(List<Re3dataName> software) {
        this.software = software;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Syndication> getSyndications() {
        return syndications;
    }

    public void setSyndications(List<Syndication> syndications) {
        this.syndications = syndications;
    }

    public List<Re3dataType> getTypes() {
        return types;
    }

    public void setTypes(List<Re3dataType> types) {
        this.types = types;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getVersioning() {
        return versioning;
    }

    public void setVersioning(String versioning) {
        this.versioning = versioning;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "additionalNames=" + additionalNames +
                ", aidSystems=" + aidSystems +
                ", apis=" + apis +
                ", certificates=" + certificates +
                ", citationGuidelineUrl='" + citationGuidelineUrl + '\'' +
                ", contentTypes=" + contentTypes +
                ", created='" + created + '\'' +
                ", dataAccesses=" + dataAccesses +
                ", dataLicenses=" + dataLicenses +
                ", dataUploadLicenses=" + dataUploadLicenses +
                ", dataUploads=" + dataUploads +
                ", databaseAccess=" + databaseAccess +
                ", databaseLicenses=" + databaseLicenses +
                ", description='" + description + '\'' +
                ", descriptionLanguage='" + descriptionLanguage + '\'' +
                ", endDate='" + endDate + '\'' +
                ", enhancedPublication='" + enhancedPublication + '\'' +
                ", identifier=" + identifier +
                ", institutions=" + institutions +
                ", keywords=" + keywords +
                ", metadataStandards=" + metadataStandards +
                ", missionStatementUrl='" + missionStatementUrl + '\'' +
                ", pidSystems=" + pidSystems +
                ", policies=" + policies +
                ", providerTypes=" + providerTypes +
                ", qualityManagement='" + qualityManagement + '\'' +
                ", remarks='" + remarks + '\'' +
                ", repositoryContacts=" + repositoryContacts +
                ", repositoryIdentifiers=" + repositoryIdentifiers +
                ", repositoryLanguages=" + repositoryLanguages +
                ", repositoryNameLanguage='" + repositoryNameLanguage + '\'' +
                ", repositoryUrl='" + repositoryUrl + '\'' +
                ", size='" + size + '\'' +
                ", sizeUpdated='" + sizeUpdated + '\'' +
                ", software=" + software +
                ", startDate='" + startDate + '\'' +
                ", subjects=" + subjects +
                ", syndications=" + syndications +
                ", types=" + types +
                ", updated='" + updated + '\'' +
                ", versioning='" + versioning + '\'' +
                '}';
    }
}
