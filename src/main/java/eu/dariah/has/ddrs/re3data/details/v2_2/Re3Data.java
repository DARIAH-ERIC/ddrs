package eu.dariah.has.ddrs.re3data.details.v2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "repository"
})
@XmlRootElement(name = "re3data")
public class Re3Data {

    protected List<Re3Data.Repository> repository;

//    private Boolean hasError = false;
//    public Boolean getHasError() {
//        return hasError;
//    }
//    public void setHasError(Boolean hasError) {
//        this.hasError = hasError;
//    }

    /**
     * Gets the value of the repository property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the repository property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRepository().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Re3Data.Repository }
     * 
     * 
     */
    public List<Re3Data.Repository> getRepository() {
        if (repository == null) {
            repository = new ArrayList<Re3Data.Repository>();
        }
        return this.repository;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="re3data.orgIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="repositoryName">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="additionalName" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="repositoryURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *         &lt;element name="repositoryIdentifier" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="description" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.re3data.org/schema/2-2>StringL1000">
     *                 &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="repositoryContact" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="type" type="{http://www.re3data.org/schema/2-2}repositoryTypes" maxOccurs="unbounded"/>
     *         &lt;element name="size" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="updated" use="required" type="{http://www.re3data.org/schema/2-2}dateFormat" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="startDate" type="{http://www.re3data.org/schema/2-2}dateFormat" minOccurs="0"/>
     *         &lt;element name="endDate" type="{http://www.re3data.org/schema/2-2}dateFormat" minOccurs="0"/>
     *         &lt;element name="repositoryLanguage" type="{http://www.re3data.org/schema/2-2}languages" maxOccurs="unbounded"/>
     *         &lt;element name="subject" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.re3data.org/schema/2-2>subject_text">
     *                 &lt;attribute name="subjectScheme" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="DFG"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="missionStatementURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *         &lt;element name="contentType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.re3data.org/schema/2-2>contentType_Text">
     *                 &lt;attribute name="contentTypeScheme" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="parse"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="providerType" type="{http://www.re3data.org/schema/2-2}providerTypes" maxOccurs="2"/>
     *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="institution" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="institutionName">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="institutionAdditionalName" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="institutionCountry" type="{http://www.re3data.org/schema/2-2}countries"/>
     *                   &lt;element name="responsibilityType" type="{http://www.re3data.org/schema/2-2}responsibilityTypes" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="institutionType" type="{http://www.re3data.org/schema/2-2}institutionTypes" minOccurs="0"/>
     *                   &lt;element name="institutionURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *                   &lt;element name="institutionIdentifier" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="responsibilityStartDate" type="{http://www.re3data.org/schema/2-2}dateFormat" minOccurs="0"/>
     *                   &lt;element name="responsibilityEndDate" type="{http://www.re3data.org/schema/2-2}dateFormat" minOccurs="0"/>
     *                   &lt;element name="institutionContact" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="policy" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="policyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="policyURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="databaseAccess">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="databaseAccessType" type="{http://www.re3data.org/schema/2-2}accessTypes"/>
     *                   &lt;element name="databaseAccessRestriction" type="{http://www.re3data.org/schema/2-2}accessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="databaseLicense" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="databaseLicenseName" type="{http://www.re3data.org/schema/2-2}databaseLicenseNames"/>
     *                   &lt;element name="databaseLicenseURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="dataAccess" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="dataAccessType" type="{http://www.re3data.org/schema/2-2}dataAccessTypes"/>
     *                   &lt;element name="dataAccessRestriction" type="{http://www.re3data.org/schema/2-2}dataAccessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="dataLicense" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="dataLicenseName" type="{http://www.re3data.org/schema/2-2}dataLicenseNames"/>
     *                   &lt;element name="dataLicenseURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="dataUpload" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="dataUploadType" type="{http://www.re3data.org/schema/2-2}accessTypes"/>
     *                   &lt;element name="dataUploadRestriction" type="{http://www.re3data.org/schema/2-2}dataUploadRestrictions" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="dataUploadLicense" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="dataUploadLicenseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="dataUploadLicenseURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="software" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="softwareName" type="{http://www.re3data.org/schema/2-2}softwareNames"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="versioning" type="{http://www.re3data.org/schema/2-2}yesno" minOccurs="0"/>
     *         &lt;element name="api" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>anyURI">
     *                 &lt;attribute name="apiType" use="required" type="{http://www.re3data.org/schema/2-2}apiTypes" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="pidSystem" type="{http://www.re3data.org/schema/2-2}pidSystems" maxOccurs="unbounded"/>
     *         &lt;element name="citationGuidelineURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *         &lt;element name="aidSystem" type="{http://www.re3data.org/schema/2-2}aidSystems" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="enhancedPublication" type="{http://www.re3data.org/schema/2-2}yesnoun" minOccurs="0"/>
     *         &lt;element name="qualityManagement" type="{http://www.re3data.org/schema/2-2}yesnoun" minOccurs="0"/>
     *         &lt;element name="certificate" type="{http://www.re3data.org/schema/2-2}certificates" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="metadataStandard" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="metadataStandardName">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.re3data.org/schema/2-2>metadataStandardDCCNames">
     *                           &lt;attribute name="metadataStandardScheme" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="DCC"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="metadataStandardURL" type="{http://www.re3data.org/schema/2-2}metadataStandardDCCURLs"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="syndication" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>anyURI">
     *                 &lt;attribute name="syndicationType" use="required" type="{http://www.re3data.org/schema/2-2}syndicationTypes" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="entryDate" type="{http://www.re3data.org/schema/2-2}dateFormat"/>
     *         &lt;element name="lastUpdate" type="{http://www.re3data.org/schema/2-2}dateFormat"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "re3DataOrgIdentifier",
        "repositoryName",
        "additionalName",
        "repositoryURL",
        "repositoryIdentifier",
        "description",
        "repositoryContact",
        "type",
        "size",
        "startDate",
        "endDate",
        "repositoryLanguage",
        "subject",
        "missionStatementURL",
        "contentType",
        "providerType",
        "keyword",
        "institution",
        "policy",
        "databaseAccess",
        "databaseLicense",
        "dataAccess",
        "dataLicense",
        "dataUpload",
        "dataUploadLicense",
        "software",
        "versioning",
        "api",
        "pidSystem",
        "citationGuidelineURL",
        "aidSystem",
        "enhancedPublication",
        "qualityManagement",
        "certificate",
        "metadataStandard",
        "syndication",
        "remarks",
        "entryDate",
        "lastUpdate"
    })
    public static class Repository {

        @XmlElement(name = "re3data.orgIdentifier", required = true)
        protected String re3DataOrgIdentifier;
        @XmlElement(required = true)
        protected Re3Data.Repository.RepositoryName repositoryName;
        protected List<Re3Data.Repository.AdditionalName> additionalName;
        @XmlElement(required = true)
        @XmlSchemaType(name = "anyURI")
        protected String repositoryURL;
        @XmlSchemaType(name = "anyURI")
        protected List<String> repositoryIdentifier;
        protected Re3Data.Repository.Description description;
        protected List<String> repositoryContact;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<RepositoryTypes> type;
        protected Re3Data.Repository.Size size;
        protected String startDate;
        protected String endDate;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<Languages> repositoryLanguage;
        @XmlElement(required = true)
        protected List<Re3Data.Repository.Subject> subject;
        @XmlSchemaType(name = "anyURI")
        protected String missionStatementURL;
        protected List<Re3Data.Repository.ContentType> contentType;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<ProviderTypes> providerType;
        protected List<String> keyword;
        @XmlElement(required = true)
        protected List<Re3Data.Repository.Institution> institution;
        protected List<Re3Data.Repository.Policy> policy;
        @XmlElement(required = true)
        protected Re3Data.Repository.DatabaseAccess databaseAccess;
        protected List<Re3Data.Repository.DatabaseLicense> databaseLicense;
        @XmlElement(required = true)
        protected List<Re3Data.Repository.DataAccess> dataAccess;
        @XmlElement(required = true)
        protected List<Re3Data.Repository.DataLicense> dataLicense;
        @XmlElement(required = true)
        protected List<Re3Data.Repository.DataUpload> dataUpload;
        protected List<Re3Data.Repository.DataUploadLicense> dataUploadLicense;
        protected List<Re3Data.Repository.Software> software;
        @XmlSchemaType(name = "string")
        protected Yesno versioning;
        protected List<Re3Data.Repository.Api> api;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<PidSystems> pidSystem;
        @XmlSchemaType(name = "anyURI")
        protected String citationGuidelineURL;
        @XmlSchemaType(name = "string")
        protected List<AidSystems> aidSystem;
        @XmlSchemaType(name = "string")
        protected Yesnoun enhancedPublication;
        @XmlSchemaType(name = "string")
        protected Yesnoun qualityManagement;
        @XmlSchemaType(name = "string")
        protected List<Certificates> certificate;
        protected List<Re3Data.Repository.MetadataStandard> metadataStandard;
        protected List<Re3Data.Repository.Syndication> syndication;
        protected String remarks;
        @XmlElement(required = true)
        protected String entryDate;
        @XmlElement(required = true)
        protected String lastUpdate;

        /**
         * Gets the value of the re3DataOrgIdentifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRe3DataOrgIdentifier() {
            return re3DataOrgIdentifier;
        }

        /**
         * Sets the value of the re3DataOrgIdentifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRe3DataOrgIdentifier(String value) {
            this.re3DataOrgIdentifier = value;
        }

        /**
         * Gets the value of the repositoryName property.
         * 
         * @return
         *     possible object is
         *     {@link Re3Data.Repository.RepositoryName }
         *     
         */
        public Re3Data.Repository.RepositoryName getRepositoryName() {
            return repositoryName;
        }

        /**
         * Sets the value of the repositoryName property.
         * 
         * @param value
         *     allowed object is
         *     {@link Re3Data.Repository.RepositoryName }
         *     
         */
        public void setRepositoryName(Re3Data.Repository.RepositoryName value) {
            this.repositoryName = value;
        }

        /**
         * Gets the value of the additionalName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the additionalName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdditionalName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.AdditionalName }
         * 
         * 
         */
        public List<Re3Data.Repository.AdditionalName> getAdditionalName() {
            if (additionalName == null) {
                additionalName = new ArrayList<Re3Data.Repository.AdditionalName>();
            }
            return this.additionalName;
        }

        /**
         * Gets the value of the repositoryURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRepositoryURL() {
            return repositoryURL;
        }

        /**
         * Sets the value of the repositoryURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRepositoryURL(String value) {
            this.repositoryURL = value;
        }

        /**
         * Gets the value of the repositoryIdentifier property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the repositoryIdentifier property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRepositoryIdentifier().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRepositoryIdentifier() {
            if (repositoryIdentifier == null) {
                repositoryIdentifier = new ArrayList<String>();
            }
            return this.repositoryIdentifier;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link Re3Data.Repository.Description }
         *     
         */
        public Re3Data.Repository.Description getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link Re3Data.Repository.Description }
         *     
         */
        public void setDescription(Re3Data.Repository.Description value) {
            this.description = value;
        }

        /**
         * Gets the value of the repositoryContact property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the repositoryContact property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRepositoryContact().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRepositoryContact() {
            if (repositoryContact == null) {
                repositoryContact = new ArrayList<String>();
            }
            return this.repositoryContact;
        }

        /**
         * Gets the value of the type property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the type property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RepositoryTypes }
         * 
         * 
         */
        public List<RepositoryTypes> getType() {
            if (type == null) {
                type = new ArrayList<RepositoryTypes>();
            }
            return this.type;
        }

        /**
         * Gets the value of the size property.
         * 
         * @return
         *     possible object is
         *     {@link Re3Data.Repository.Size }
         *     
         */
        public Re3Data.Repository.Size getSize() {
            return size;
        }

        /**
         * Sets the value of the size property.
         * 
         * @param value
         *     allowed object is
         *     {@link Re3Data.Repository.Size }
         *     
         */
        public void setSize(Re3Data.Repository.Size value) {
            this.size = value;
        }

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStartDate(String value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the endDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEndDate() {
            return endDate;
        }

        /**
         * Sets the value of the endDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEndDate(String value) {
            this.endDate = value;
        }

        /**
         * Gets the value of the repositoryLanguage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the repositoryLanguage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRepositoryLanguage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Languages }
         * 
         * 
         */
        public List<Languages> getRepositoryLanguage() {
            if (repositoryLanguage == null) {
                repositoryLanguage = new ArrayList<Languages>();
            }
            return this.repositoryLanguage;
        }

        /**
         * Gets the value of the subject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the subject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSubject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.Subject }
         * 
         * 
         */
        public List<Re3Data.Repository.Subject> getSubject() {
            if (subject == null) {
                subject = new ArrayList<Re3Data.Repository.Subject>();
            }
            return this.subject;
        }

        /**
         * Gets the value of the missionStatementURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMissionStatementURL() {
            return missionStatementURL;
        }

        /**
         * Sets the value of the missionStatementURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMissionStatementURL(String value) {
            this.missionStatementURL = value;
        }

        /**
         * Gets the value of the contentType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contentType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContentType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.ContentType }
         * 
         * 
         */
        public List<Re3Data.Repository.ContentType> getContentType() {
            if (contentType == null) {
                contentType = new ArrayList<Re3Data.Repository.ContentType>();
            }
            return this.contentType;
        }

        /**
         * Gets the value of the providerType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the providerType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProviderType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ProviderTypes }
         * 
         * 
         */
        public List<ProviderTypes> getProviderType() {
            if (providerType == null) {
                providerType = new ArrayList<ProviderTypes>();
            }
            return this.providerType;
        }

        /**
         * Gets the value of the keyword property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keyword property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeyword().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getKeyword() {
            if (keyword == null) {
                keyword = new ArrayList<String>();
            }
            return this.keyword;
        }

        /**
         * Gets the value of the institution property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the institution property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInstitution().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.Institution }
         * 
         * 
         */
        public List<Re3Data.Repository.Institution> getInstitution() {
            if (institution == null) {
                institution = new ArrayList<Re3Data.Repository.Institution>();
            }
            return this.institution;
        }

        /**
         * Gets the value of the policy property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the policy property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPolicy().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.Policy }
         * 
         * 
         */
        public List<Re3Data.Repository.Policy> getPolicy() {
            if (policy == null) {
                policy = new ArrayList<Re3Data.Repository.Policy>();
            }
            return this.policy;
        }

        /**
         * Gets the value of the databaseAccess property.
         * 
         * @return
         *     possible object is
         *     {@link Re3Data.Repository.DatabaseAccess }
         *     
         */
        public Re3Data.Repository.DatabaseAccess getDatabaseAccess() {
            return databaseAccess;
        }

        /**
         * Sets the value of the databaseAccess property.
         * 
         * @param value
         *     allowed object is
         *     {@link Re3Data.Repository.DatabaseAccess }
         *     
         */
        public void setDatabaseAccess(Re3Data.Repository.DatabaseAccess value) {
            this.databaseAccess = value;
        }

        /**
         * Gets the value of the databaseLicense property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the databaseLicense property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDatabaseLicense().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.DatabaseLicense }
         * 
         * 
         */
        public List<Re3Data.Repository.DatabaseLicense> getDatabaseLicense() {
            if (databaseLicense == null) {
                databaseLicense = new ArrayList<Re3Data.Repository.DatabaseLicense>();
            }
            return this.databaseLicense;
        }

        /**
         * Gets the value of the dataAccess property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataAccess property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataAccess().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.DataAccess }
         * 
         * 
         */
        public List<Re3Data.Repository.DataAccess> getDataAccess() {
            if (dataAccess == null) {
                dataAccess = new ArrayList<Re3Data.Repository.DataAccess>();
            }
            return this.dataAccess;
        }

        /**
         * Gets the value of the dataLicense property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataLicense property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataLicense().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.DataLicense }
         * 
         * 
         */
        public List<Re3Data.Repository.DataLicense> getDataLicense() {
            if (dataLicense == null) {
                dataLicense = new ArrayList<Re3Data.Repository.DataLicense>();
            }
            return this.dataLicense;
        }

        /**
         * Gets the value of the dataUpload property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataUpload property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataUpload().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.DataUpload }
         * 
         * 
         */
        public List<Re3Data.Repository.DataUpload> getDataUpload() {
            if (dataUpload == null) {
                dataUpload = new ArrayList<Re3Data.Repository.DataUpload>();
            }
            return this.dataUpload;
        }

        /**
         * Gets the value of the dataUploadLicense property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataUploadLicense property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataUploadLicense().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.DataUploadLicense }
         * 
         * 
         */
        public List<Re3Data.Repository.DataUploadLicense> getDataUploadLicense() {
            if (dataUploadLicense == null) {
                dataUploadLicense = new ArrayList<Re3Data.Repository.DataUploadLicense>();
            }
            return this.dataUploadLicense;
        }

        /**
         * Gets the value of the software property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the software property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSoftware().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.Software }
         * 
         * 
         */
        public List<Re3Data.Repository.Software> getSoftware() {
            if (software == null) {
                software = new ArrayList<Re3Data.Repository.Software>();
            }
            return this.software;
        }

        /**
         * Gets the value of the versioning property.
         * 
         * @return
         *     possible object is
         *     {@link Yesno }
         *     
         */
        public Yesno getVersioning() {
            return versioning;
        }

        /**
         * Sets the value of the versioning property.
         * 
         * @param value
         *     allowed object is
         *     {@link Yesno }
         *     
         */
        public void setVersioning(Yesno value) {
            this.versioning = value;
        }

        /**
         * Gets the value of the api property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the api property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getApi().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.Api }
         * 
         * 
         */
        public List<Re3Data.Repository.Api> getApi() {
            if (api == null) {
                api = new ArrayList<Re3Data.Repository.Api>();
            }
            return this.api;
        }

        /**
         * Gets the value of the pidSystem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pidSystem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPidSystem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PidSystems }
         * 
         * 
         */
        public List<PidSystems> getPidSystem() {
            if (pidSystem == null) {
                pidSystem = new ArrayList<PidSystems>();
            }
            return this.pidSystem;
        }

        /**
         * Gets the value of the citationGuidelineURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCitationGuidelineURL() {
            return citationGuidelineURL;
        }

        /**
         * Sets the value of the citationGuidelineURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCitationGuidelineURL(String value) {
            this.citationGuidelineURL = value;
        }

        /**
         * Gets the value of the aidSystem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the aidSystem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAidSystem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AidSystems }
         * 
         * 
         */
        public List<AidSystems> getAidSystem() {
            if (aidSystem == null) {
                aidSystem = new ArrayList<AidSystems>();
            }
            return this.aidSystem;
        }

        /**
         * Gets the value of the enhancedPublication property.
         * 
         * @return
         *     possible object is
         *     {@link Yesnoun }
         *     
         */
        public Yesnoun getEnhancedPublication() {
            return enhancedPublication;
        }

        /**
         * Sets the value of the enhancedPublication property.
         * 
         * @param value
         *     allowed object is
         *     {@link Yesnoun }
         *     
         */
        public void setEnhancedPublication(Yesnoun value) {
            this.enhancedPublication = value;
        }

        /**
         * Gets the value of the qualityManagement property.
         * 
         * @return
         *     possible object is
         *     {@link Yesnoun }
         *     
         */
        public Yesnoun getQualityManagement() {
            return qualityManagement;
        }

        /**
         * Sets the value of the qualityManagement property.
         * 
         * @param value
         *     allowed object is
         *     {@link Yesnoun }
         *     
         */
        public void setQualityManagement(Yesnoun value) {
            this.qualityManagement = value;
        }

        /**
         * Gets the value of the certificate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the certificate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCertificate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Certificates }
         * 
         * 
         */
        public List<Certificates> getCertificate() {
            if (certificate == null) {
                certificate = new ArrayList<Certificates>();
            }
            return this.certificate;
        }

        /**
         * Gets the value of the metadataStandard property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the metadataStandard property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMetadataStandard().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.MetadataStandard }
         * 
         * 
         */
        public List<Re3Data.Repository.MetadataStandard> getMetadataStandard() {
            if (metadataStandard == null) {
                metadataStandard = new ArrayList<Re3Data.Repository.MetadataStandard>();
            }
            return this.metadataStandard;
        }

        /**
         * Gets the value of the syndication property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the syndication property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSyndication().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Re3Data.Repository.Syndication }
         * 
         * 
         */
        public List<Re3Data.Repository.Syndication> getSyndication() {
            if (syndication == null) {
                syndication = new ArrayList<Re3Data.Repository.Syndication>();
            }
            return this.syndication;
        }

        /**
         * Gets the value of the remarks property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemarks() {
            return remarks;
        }

        /**
         * Sets the value of the remarks property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemarks(String value) {
            this.remarks = value;
        }

        /**
         * Gets the value of the entryDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEntryDate() {
            return entryDate;
        }

        /**
         * Sets the value of the entryDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEntryDate(String value) {
            this.entryDate = value;
        }

        /**
         * Gets the value of the lastUpdate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastUpdate() {
            return lastUpdate;
        }

        /**
         * Sets the value of the lastUpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastUpdate(String value) {
            this.lastUpdate = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class AdditionalName {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "language", required = true)
            protected Languages language;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the language property.
             * 
             * @return
             *     possible object is
             *     {@link Languages }
             *     
             */
            public Languages getLanguage() {
                return language;
            }

            /**
             * Sets the value of the language property.
             * 
             * @param value
             *     allowed object is
             *     {@link Languages }
             *     
             */
            public void setLanguage(Languages value) {
                this.language = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>anyURI">
         *       &lt;attribute name="apiType" use="required" type="{http://www.re3data.org/schema/2-2}apiTypes" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Api {

            @XmlValue
            @XmlSchemaType(name = "anyURI")
            protected String value;
            @XmlAttribute(name = "apiType", required = true)
            protected ApiTypes apiType;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the apiType property.
             * 
             * @return
             *     possible object is
             *     {@link ApiTypes }
             *     
             */
            public ApiTypes getApiType() {
                return apiType;
            }

            /**
             * Sets the value of the apiType property.
             * 
             * @param value
             *     allowed object is
             *     {@link ApiTypes }
             *     
             */
            public void setApiType(ApiTypes value) {
                this.apiType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.re3data.org/schema/2-2>contentType_Text">
         *       &lt;attribute name="contentTypeScheme" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="parse"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class ContentType {

            @XmlValue
            protected ContentTypeText value;
            @XmlAttribute(name = "contentTypeScheme", required = true)
            protected String contentTypeScheme;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link ContentTypeText }
             *     
             */
            public ContentTypeText getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link ContentTypeText }
             *     
             */
            public void setValue(ContentTypeText value) {
                this.value = value;
            }

            /**
             * Gets the value of the contentTypeScheme property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContentTypeScheme() {
                return contentTypeScheme;
            }

            /**
             * Sets the value of the contentTypeScheme property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContentTypeScheme(String value) {
                this.contentTypeScheme = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="dataAccessType" type="{http://www.re3data.org/schema/2-2}dataAccessTypes"/>
         *         &lt;element name="dataAccessRestriction" type="{http://www.re3data.org/schema/2-2}dataAccessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dataAccessType",
            "dataAccessRestriction"
        })
        public static class DataAccess {

            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected DataAccessTypes dataAccessType;
            @XmlSchemaType(name = "string")
            protected List<DataAccessRestrictions> dataAccessRestriction;

            /**
             * Gets the value of the dataAccessType property.
             * 
             * @return
             *     possible object is
             *     {@link DataAccessTypes }
             *     
             */
            public DataAccessTypes getDataAccessType() {
                return dataAccessType;
            }

            /**
             * Sets the value of the dataAccessType property.
             * 
             * @param value
             *     allowed object is
             *     {@link DataAccessTypes }
             *     
             */
            public void setDataAccessType(DataAccessTypes value) {
                this.dataAccessType = value;
            }

            /**
             * Gets the value of the dataAccessRestriction property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dataAccessRestriction property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDataAccessRestriction().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link DataAccessRestrictions }
             * 
             * 
             */
            public List<DataAccessRestrictions> getDataAccessRestriction() {
                if (dataAccessRestriction == null) {
                    dataAccessRestriction = new ArrayList<DataAccessRestrictions>();
                }
                return this.dataAccessRestriction;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="databaseAccessType" type="{http://www.re3data.org/schema/2-2}accessTypes"/>
         *         &lt;element name="databaseAccessRestriction" type="{http://www.re3data.org/schema/2-2}accessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "databaseAccessType",
            "databaseAccessRestriction"
        })
        public static class DatabaseAccess {

            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected AccessTypes databaseAccessType;
            @XmlSchemaType(name = "string")
            protected List<AccessRestrictions> databaseAccessRestriction;

            /**
             * Gets the value of the databaseAccessType property.
             * 
             * @return
             *     possible object is
             *     {@link AccessTypes }
             *     
             */
            public AccessTypes getDatabaseAccessType() {
                return databaseAccessType;
            }

            /**
             * Sets the value of the databaseAccessType property.
             * 
             * @param value
             *     allowed object is
             *     {@link AccessTypes }
             *     
             */
            public void setDatabaseAccessType(AccessTypes value) {
                this.databaseAccessType = value;
            }

            /**
             * Gets the value of the databaseAccessRestriction property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the databaseAccessRestriction property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDatabaseAccessRestriction().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AccessRestrictions }
             * 
             * 
             */
            public List<AccessRestrictions> getDatabaseAccessRestriction() {
                if (databaseAccessRestriction == null) {
                    databaseAccessRestriction = new ArrayList<AccessRestrictions>();
                }
                return this.databaseAccessRestriction;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="databaseLicenseName" type="{http://www.re3data.org/schema/2-2}databaseLicenseNames"/>
         *         &lt;element name="databaseLicenseURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "databaseLicenseName",
            "databaseLicenseURL"
        })
        public static class DatabaseLicense {

            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected DatabaseLicenseNames databaseLicenseName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String databaseLicenseURL;

            /**
             * Gets the value of the databaseLicenseName property.
             * 
             * @return
             *     possible object is
             *     {@link DatabaseLicenseNames }
             *     
             */
            public DatabaseLicenseNames getDatabaseLicenseName() {
                return databaseLicenseName;
            }

            /**
             * Sets the value of the databaseLicenseName property.
             * 
             * @param value
             *     allowed object is
             *     {@link DatabaseLicenseNames }
             *     
             */
            public void setDatabaseLicenseName(DatabaseLicenseNames value) {
                this.databaseLicenseName = value;
            }

            /**
             * Gets the value of the databaseLicenseURL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatabaseLicenseURL() {
                return databaseLicenseURL;
            }

            /**
             * Sets the value of the databaseLicenseURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatabaseLicenseURL(String value) {
                this.databaseLicenseURL = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="dataLicenseName" type="{http://www.re3data.org/schema/2-2}dataLicenseNames"/>
         *         &lt;element name="dataLicenseURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dataLicenseName",
            "dataLicenseURL"
        })
        public static class DataLicense {

            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected DataLicenseNames dataLicenseName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String dataLicenseURL;

            /**
             * Gets the value of the dataLicenseName property.
             * 
             * @return
             *     possible object is
             *     {@link DataLicenseNames }
             *     
             */
            public DataLicenseNames getDataLicenseName() {
                return dataLicenseName;
            }

            /**
             * Sets the value of the dataLicenseName property.
             * 
             * @param value
             *     allowed object is
             *     {@link DataLicenseNames }
             *     
             */
            public void setDataLicenseName(DataLicenseNames value) {
                this.dataLicenseName = value;
            }

            /**
             * Gets the value of the dataLicenseURL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataLicenseURL() {
                return dataLicenseURL;
            }

            /**
             * Sets the value of the dataLicenseURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataLicenseURL(String value) {
                this.dataLicenseURL = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="dataUploadType" type="{http://www.re3data.org/schema/2-2}accessTypes"/>
         *         &lt;element name="dataUploadRestriction" type="{http://www.re3data.org/schema/2-2}dataUploadRestrictions" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dataUploadType",
            "dataUploadRestriction"
        })
        public static class DataUpload {

            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected AccessTypes dataUploadType;
            @XmlSchemaType(name = "string")
            protected List<DataUploadRestrictions> dataUploadRestriction;

            /**
             * Gets the value of the dataUploadType property.
             * 
             * @return
             *     possible object is
             *     {@link AccessTypes }
             *     
             */
            public AccessTypes getDataUploadType() {
                return dataUploadType;
            }

            /**
             * Sets the value of the dataUploadType property.
             * 
             * @param value
             *     allowed object is
             *     {@link AccessTypes }
             *     
             */
            public void setDataUploadType(AccessTypes value) {
                this.dataUploadType = value;
            }

            /**
             * Gets the value of the dataUploadRestriction property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dataUploadRestriction property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDataUploadRestriction().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link DataUploadRestrictions }
             * 
             * 
             */
            public List<DataUploadRestrictions> getDataUploadRestriction() {
                if (dataUploadRestriction == null) {
                    dataUploadRestriction = new ArrayList<DataUploadRestrictions>();
                }
                return this.dataUploadRestriction;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="dataUploadLicenseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="dataUploadLicenseURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dataUploadLicenseName",
            "dataUploadLicenseURL"
        })
        public static class DataUploadLicense {

            @XmlElement(required = true)
            protected String dataUploadLicenseName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String dataUploadLicenseURL;

            /**
             * Gets the value of the dataUploadLicenseName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataUploadLicenseName() {
                return dataUploadLicenseName;
            }

            /**
             * Sets the value of the dataUploadLicenseName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataUploadLicenseName(String value) {
                this.dataUploadLicenseName = value;
            }

            /**
             * Gets the value of the dataUploadLicenseURL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataUploadLicenseURL() {
                return dataUploadLicenseURL;
            }

            /**
             * Sets the value of the dataUploadLicenseURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataUploadLicenseURL(String value) {
                this.dataUploadLicenseURL = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.re3data.org/schema/2-2>StringL1000">
         *       &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Description {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "language", required = true)
            protected Languages language;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the language property.
             * 
             * @return
             *     possible object is
             *     {@link Languages }
             *     
             */
            public Languages getLanguage() {
                return language;
            }

            /**
             * Sets the value of the language property.
             * 
             * @param value
             *     allowed object is
             *     {@link Languages }
             *     
             */
            public void setLanguage(Languages value) {
                this.language = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="institutionName">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="institutionAdditionalName" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="institutionCountry" type="{http://www.re3data.org/schema/2-2}countries"/>
         *         &lt;element name="responsibilityType" type="{http://www.re3data.org/schema/2-2}responsibilityTypes" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="institutionType" type="{http://www.re3data.org/schema/2-2}institutionTypes" minOccurs="0"/>
         *         &lt;element name="institutionURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
         *         &lt;element name="institutionIdentifier" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="responsibilityStartDate" type="{http://www.re3data.org/schema/2-2}dateFormat" minOccurs="0"/>
         *         &lt;element name="responsibilityEndDate" type="{http://www.re3data.org/schema/2-2}dateFormat" minOccurs="0"/>
         *         &lt;element name="institutionContact" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "institutionName",
            "institutionAdditionalName",
            "institutionCountry",
            "responsibilityType",
            "institutionType",
            "institutionURL",
            "institutionIdentifier",
            "responsibilityStartDate",
            "responsibilityEndDate",
            "institutionContact"
        })
        public static class Institution {

            @XmlElement(required = true)
            protected Re3Data.Repository.Institution.InstitutionName institutionName;
            protected List<Re3Data.Repository.Institution.InstitutionAdditionalName> institutionAdditionalName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected Countries institutionCountry;
            @XmlSchemaType(name = "string")
            protected List<ResponsibilityTypes> responsibilityType;
            @XmlSchemaType(name = "string")
            protected InstitutionTypes institutionType;
            @XmlSchemaType(name = "anyURI")
            protected String institutionURL;
            @XmlSchemaType(name = "anyURI")
            protected List<String> institutionIdentifier;
            protected String responsibilityStartDate;
            protected String responsibilityEndDate;
            protected List<String> institutionContact;

            /**
             * Gets the value of the institutionName property.
             * 
             * @return
             *     possible object is
             *     {@link Re3Data.Repository.Institution.InstitutionName }
             *     
             */
            public Re3Data.Repository.Institution.InstitutionName getInstitutionName() {
                return institutionName;
            }

            /**
             * Sets the value of the institutionName property.
             * 
             * @param value
             *     allowed object is
             *     {@link Re3Data.Repository.Institution.InstitutionName }
             *     
             */
            public void setInstitutionName(Re3Data.Repository.Institution.InstitutionName value) {
                this.institutionName = value;
            }

            /**
             * Gets the value of the institutionAdditionalName property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the institutionAdditionalName property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInstitutionAdditionalName().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Re3Data.Repository.Institution.InstitutionAdditionalName }
             * 
             * 
             */
            public List<Re3Data.Repository.Institution.InstitutionAdditionalName> getInstitutionAdditionalName() {
                if (institutionAdditionalName == null) {
                    institutionAdditionalName = new ArrayList<Re3Data.Repository.Institution.InstitutionAdditionalName>();
                }
                return this.institutionAdditionalName;
            }

            /**
             * Gets the value of the institutionCountry property.
             * 
             * @return
             *     possible object is
             *     {@link Countries }
             *     
             */
            public Countries getInstitutionCountry() {
                return institutionCountry;
            }

            /**
             * Sets the value of the institutionCountry property.
             * 
             * @param value
             *     allowed object is
             *     {@link Countries }
             *     
             */
            public void setInstitutionCountry(Countries value) {
                this.institutionCountry = value;
            }

            /**
             * Gets the value of the responsibilityType property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the responsibilityType property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getResponsibilityType().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ResponsibilityTypes }
             * 
             * 
             */
            public List<ResponsibilityTypes> getResponsibilityType() {
                if (responsibilityType == null) {
                    responsibilityType = new ArrayList<ResponsibilityTypes>();
                }
                return this.responsibilityType;
            }

            /**
             * Gets the value of the institutionType property.
             * 
             * @return
             *     possible object is
             *     {@link InstitutionTypes }
             *     
             */
            public InstitutionTypes getInstitutionType() {
                return institutionType;
            }

            /**
             * Sets the value of the institutionType property.
             * 
             * @param value
             *     allowed object is
             *     {@link InstitutionTypes }
             *     
             */
            public void setInstitutionType(InstitutionTypes value) {
                this.institutionType = value;
            }

            /**
             * Gets the value of the institutionURL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInstitutionURL() {
                return institutionURL;
            }

            /**
             * Sets the value of the institutionURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInstitutionURL(String value) {
                this.institutionURL = value;
            }

            /**
             * Gets the value of the institutionIdentifier property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the institutionIdentifier property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInstitutionIdentifier().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getInstitutionIdentifier() {
                if (institutionIdentifier == null) {
                    institutionIdentifier = new ArrayList<String>();
                }
                return this.institutionIdentifier;
            }

            /**
             * Gets the value of the responsibilityStartDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getResponsibilityStartDate() {
                return responsibilityStartDate;
            }

            /**
             * Sets the value of the responsibilityStartDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setResponsibilityStartDate(String value) {
                this.responsibilityStartDate = value;
            }

            /**
             * Gets the value of the responsibilityEndDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getResponsibilityEndDate() {
                return responsibilityEndDate;
            }

            /**
             * Sets the value of the responsibilityEndDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setResponsibilityEndDate(String value) {
                this.responsibilityEndDate = value;
            }

            /**
             * Gets the value of the institutionContact property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the institutionContact property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInstitutionContact().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getInstitutionContact() {
                if (institutionContact == null) {
                    institutionContact = new ArrayList<String>();
                }
                return this.institutionContact;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class InstitutionAdditionalName {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "language", required = true)
                protected Languages language;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the language property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Languages }
                 *     
                 */
                public Languages getLanguage() {
                    return language;
                }

                /**
                 * Sets the value of the language property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Languages }
                 *     
                 */
                public void setLanguage(Languages value) {
                    this.language = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class InstitutionName {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "language", required = true)
                protected Languages language;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the language property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Languages }
                 *     
                 */
                public Languages getLanguage() {
                    return language;
                }

                /**
                 * Sets the value of the language property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Languages }
                 *     
                 */
                public void setLanguage(Languages value) {
                    this.language = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="metadataStandardName">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.re3data.org/schema/2-2>metadataStandardDCCNames">
         *                 &lt;attribute name="metadataStandardScheme" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="DCC"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="metadataStandardURL" type="{http://www.re3data.org/schema/2-2}metadataStandardDCCURLs"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "metadataStandardName",
            "metadataStandardURL"
        })
        public static class MetadataStandard {

            @XmlElement(required = true)
            protected Re3Data.Repository.MetadataStandard.MetadataStandardName metadataStandardName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected MetadataStandardDCCURLs metadataStandardURL;

            /**
             * Gets the value of the metadataStandardName property.
             * 
             * @return
             *     possible object is
             *     {@link Re3Data.Repository.MetadataStandard.MetadataStandardName }
             *     
             */
            public Re3Data.Repository.MetadataStandard.MetadataStandardName getMetadataStandardName() {
                return metadataStandardName;
            }

            /**
             * Sets the value of the metadataStandardName property.
             * 
             * @param value
             *     allowed object is
             *     {@link Re3Data.Repository.MetadataStandard.MetadataStandardName }
             *     
             */
            public void setMetadataStandardName(Re3Data.Repository.MetadataStandard.MetadataStandardName value) {
                this.metadataStandardName = value;
            }

            /**
             * Gets the value of the metadataStandardURL property.
             * 
             * @return
             *     possible object is
             *     {@link MetadataStandardDCCURLs }
             *     
             */
            public MetadataStandardDCCURLs getMetadataStandardURL() {
                return metadataStandardURL;
            }

            /**
             * Sets the value of the metadataStandardURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link MetadataStandardDCCURLs }
             *     
             */
            public void setMetadataStandardURL(MetadataStandardDCCURLs value) {
                this.metadataStandardURL = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.re3data.org/schema/2-2>metadataStandardDCCNames">
             *       &lt;attribute name="metadataStandardScheme" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="DCC"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class MetadataStandardName {

                @XmlValue
                protected MetadataStandardDCCNames value;
                @XmlAttribute(name = "metadataStandardScheme", required = true)
                protected String metadataStandardScheme;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link MetadataStandardDCCNames }
                 *     
                 */
                public MetadataStandardDCCNames getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link MetadataStandardDCCNames }
                 *     
                 */
                public void setValue(MetadataStandardDCCNames value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the metadataStandardScheme property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMetadataStandardScheme() {
                    return metadataStandardScheme;
                }

                /**
                 * Sets the value of the metadataStandardScheme property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMetadataStandardScheme(String value) {
                    this.metadataStandardScheme = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="policyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="policyURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "policyName",
            "policyURL"
        })
        public static class Policy {

            @XmlElement(required = true)
            protected String policyName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String policyURL;

            /**
             * Gets the value of the policyName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPolicyName() {
                return policyName;
            }

            /**
             * Sets the value of the policyName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPolicyName(String value) {
                this.policyName = value;
            }

            /**
             * Gets the value of the policyURL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPolicyURL() {
                return policyURL;
            }

            /**
             * Sets the value of the policyURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPolicyURL(String value) {
                this.policyURL = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="language" use="required" type="{http://www.re3data.org/schema/2-2}languages" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class RepositoryName {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "language", required = true)
            protected Languages language;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the language property.
             * 
             * @return
             *     possible object is
             *     {@link Languages }
             *     
             */
            public Languages getLanguage() {
                return language;
            }

            /**
             * Sets the value of the language property.
             * 
             * @param value
             *     allowed object is
             *     {@link Languages }
             *     
             */
            public void setLanguage(Languages value) {
                this.language = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="updated" use="required" type="{http://www.re3data.org/schema/2-2}dateFormat" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Size {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "updated", required = true)
            protected String updated;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the updated property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUpdated() {
                return updated;
            }

            /**
             * Sets the value of the updated property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUpdated(String value) {
                this.updated = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="softwareName" type="{http://www.re3data.org/schema/2-2}softwareNames"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "softwareName"
        })
        public static class Software {

            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected SoftwareNames softwareName;

            /**
             * Gets the value of the softwareName property.
             * 
             * @return
             *     possible object is
             *     {@link SoftwareNames }
             *     
             */
            public SoftwareNames getSoftwareName() {
                return softwareName;
            }

            /**
             * Sets the value of the softwareName property.
             * 
             * @param value
             *     allowed object is
             *     {@link SoftwareNames }
             *     
             */
            public void setSoftwareName(SoftwareNames value) {
                this.softwareName = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.re3data.org/schema/2-2>subject_text">
         *       &lt;attribute name="subjectScheme" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="DFG"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Subject {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "subjectScheme", required = true)
            protected String subjectScheme;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the subjectScheme property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubjectScheme() {
                return subjectScheme;
            }

            /**
             * Sets the value of the subjectScheme property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubjectScheme(String value) {
                this.subjectScheme = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>anyURI">
         *       &lt;attribute name="syndicationType" use="required" type="{http://www.re3data.org/schema/2-2}syndicationTypes" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Syndication {

            @XmlValue
            @XmlSchemaType(name = "anyURI")
            protected String value;
            @XmlAttribute(name = "syndicationType", required = true)
            protected SyndicationTypes syndicationType;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the syndicationType property.
             * 
             * @return
             *     possible object is
             *     {@link SyndicationTypes }
             *     
             */
            public SyndicationTypes getSyndicationType() {
                return syndicationType;
            }

            /**
             * Sets the value of the syndicationType property.
             * 
             * @param value
             *     allowed object is
             *     {@link SyndicationTypes }
             *     
             */
            public void setSyndicationType(SyndicationTypes value) {
                this.syndicationType = value;
            }

        }

    }

}
