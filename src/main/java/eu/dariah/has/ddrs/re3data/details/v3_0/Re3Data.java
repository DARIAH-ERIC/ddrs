package eu.dariah.has.ddrs.re3data.details.v3_0;

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
     *         &lt;element name="identifiers">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="re3data" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="doi" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="repositoryName">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="additionalName" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="repositoryUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *         &lt;element name="repositoryIdentifier" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="repositoryIdentifierType" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="repositoryIdentifierValue" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="description" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.re3data.org/schema/3-0>StringL2000">
     *                 &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="repositoryContact" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="type" type="{http://www.re3data.org/schema/3-0}repositoryTypes" maxOccurs="unbounded"/>
     *         &lt;element name="size" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="updated" use="required" type="{http://www.re3data.org/schema/3-0}dateFormat" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="startDate" type="{http://www.re3data.org/schema/3-0}dateFormat" minOccurs="0"/>
     *         &lt;element name="endDate" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="closed" type="{http://www.re3data.org/schema/3-0}dateFormatEmpty" minOccurs="0"/>
     *                   &lt;element name="offline" type="{http://www.re3data.org/schema/3-0}dateFormatEmpty" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="repositoryLanguage" type="{http://www.re3data.org/schema/3-0}languages" maxOccurs="unbounded"/>
     *         &lt;element name="subject" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="subjectId" type="{http://www.re3data.org/schema/3-0}subjectIds"/>
     *                   &lt;element name="subjectName" type="{http://www.re3data.org/schema/3-0}subjectNames"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="subjectScheme">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="DFG"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="missionStatementUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *         &lt;element name="contentType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.re3data.org/schema/3-0>contentType_Text">
     *                 &lt;attribute name="contentTypeScheme">
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
     *         &lt;element name="providerType" type="{http://www.re3data.org/schema/3-0}providerTypes" maxOccurs="2"/>
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
     *                           &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="institutionAdditionalName" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="institutionCountry" type="{http://www.re3data.org/schema/3-0}countries"/>
     *                   &lt;element name="responsibilityType" type="{http://www.re3data.org/schema/3-0}responsibilityTypes" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="institutionType" type="{http://www.re3data.org/schema/3-0}institutionTypes" minOccurs="0"/>
     *                   &lt;element name="institutionUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *                   &lt;element name="institutionIdentifier" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="institutionIdentifierType" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                             &lt;element name="institutionIdentifierValue" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="responsibilityStartDate" type="{http://www.re3data.org/schema/3-0}dateFormat" minOccurs="0"/>
     *                   &lt;element name="responsibilityEndDate" type="{http://www.re3data.org/schema/3-0}dateFormat" minOccurs="0"/>
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
     *                   &lt;element name="policyType" type="{http://www.re3data.org/schema/3-0}policyTypes" maxOccurs="unbounded"/>
     *                   &lt;element name="policyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="policyUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
     *                   &lt;element name="databaseAccessType" type="{http://www.re3data.org/schema/3-0}accessTypes"/>
     *                   &lt;element name="databaseAccessRestriction" type="{http://www.re3data.org/schema/3-0}accessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
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
     *                   &lt;element name="databaseLicenseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="databaseLicenseUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
     *                   &lt;element name="dataAccessType" type="{http://www.re3data.org/schema/3-0}dataAccessTypes"/>
     *                   &lt;element name="dataAccessRestriction" type="{http://www.re3data.org/schema/3-0}dataAccessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
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
     *                   &lt;element name="dataLicenseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="dataLicenseUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
     *                   &lt;element name="dataUploadType" type="{http://www.re3data.org/schema/3-0}accessTypes"/>
     *                   &lt;element name="dataUploadRestriction" type="{http://www.re3data.org/schema/3-0}dataAccessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
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
     *                   &lt;element name="dataUploadLicenseUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="software" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="versioning" type="{http://www.re3data.org/schema/3-0}yesnoun"/>
     *         &lt;element name="api" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="apiType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="apiUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                   &lt;element name="apiDocumentation" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="pidSystem" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="citationReference" type="{http://www.re3data.org/schema/3-0}citationReferences" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="metrics" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="citationGuidelineUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *         &lt;element name="aidSystem" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="enhancedPublication" type="{http://www.re3data.org/schema/3-0}yesnoun"/>
     *         &lt;element name="qualityManagement" type="{http://www.re3data.org/schema/3-0}yesnoun"/>
     *         &lt;element name="certificate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="metadataStandard" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="metadataStandardName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="metadataStandardUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="syndication" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="syndicationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="syndicationUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="entryDate" type="{http://www.re3data.org/schema/3-0}dateFormat"/>
     *         &lt;element name="lastUpdate" type="{http://www.re3data.org/schema/3-0}dateFormat"/>
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
        "identifiers",
        "repositoryName",
        "additionalName",
        "repositoryUrl",
        "repositoryIdentifier",
        "description",
        "repositoryContact",
        "type",
        "size",
        "startDate",
        "endDate",
        "repositoryLanguage",
        "subject",
        "missionStatementUrl",
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
        "citationReference",
        "metrics",
        "citationGuidelineUrl",
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

        @XmlElement(required = true)
        protected Re3Data.Repository.Identifiers identifiers;
        @XmlElement(required = true)
        protected Re3Data.Repository.RepositoryName repositoryName;
        protected List<Re3Data.Repository.AdditionalName> additionalName;
        @XmlElement(required = true)
        @XmlSchemaType(name = "anyURI")
        protected String repositoryUrl;
        protected List<Re3Data.Repository.RepositoryIdentifier> repositoryIdentifier;
        protected Re3Data.Repository.Description description;
        protected List<String> repositoryContact;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<RepositoryTypes> type;
        protected Re3Data.Repository.Size size;
        protected String startDate;
        protected Re3Data.Repository.EndDate endDate;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<Languages> repositoryLanguage;
        @XmlElement(required = true, nillable = true)
        protected List<Re3Data.Repository.Subject> subject;
        @XmlSchemaType(name = "anyURI")
        protected String missionStatementUrl;
        @XmlElement(nillable = true)
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
        protected List<String> software;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected Yesnoun versioning;
        protected List<Re3Data.Repository.Api> api;
        protected List<String> pidSystem;
        @XmlSchemaType(name = "string")
        protected List<CitationReferences> citationReference;
        protected List<String> metrics;
        @XmlSchemaType(name = "anyURI")
        protected String citationGuidelineUrl;
        protected List<String> aidSystem;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected Yesnoun enhancedPublication;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected Yesnoun qualityManagement;
        protected List<String> certificate;
        protected List<Re3Data.Repository.MetadataStandard> metadataStandard;
        protected List<Re3Data.Repository.Syndication> syndication;
        protected String remarks;
        @XmlElement(required = true)
        protected String entryDate;
        @XmlElement(required = true)
        protected String lastUpdate;

        /**
         * Gets the value of the identifiers property.
         * 
         * @return
         *     possible object is
         *     {@link Re3Data.Repository.Identifiers }
         *     
         */
        public Re3Data.Repository.Identifiers getIdentifiers() {
            return identifiers;
        }

        /**
         * Sets the value of the identifiers property.
         * 
         * @param value
         *     allowed object is
         *     {@link Re3Data.Repository.Identifiers }
         *     
         */
        public void setIdentifiers(Re3Data.Repository.Identifiers value) {
            this.identifiers = value;
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
         * Gets the value of the repositoryUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRepositoryUrl() {
            return repositoryUrl;
        }

        /**
         * Sets the value of the repositoryUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRepositoryUrl(String value) {
            this.repositoryUrl = value;
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
         * {@link Re3Data.Repository.RepositoryIdentifier }
         * 
         * 
         */
        public List<Re3Data.Repository.RepositoryIdentifier> getRepositoryIdentifier() {
            if (repositoryIdentifier == null) {
                repositoryIdentifier = new ArrayList<Re3Data.Repository.RepositoryIdentifier>();
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
         *     {@link Re3Data.Repository.EndDate }
         *     
         */
        public Re3Data.Repository.EndDate getEndDate() {
            return endDate;
        }

        /**
         * Sets the value of the endDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link Re3Data.Repository.EndDate }
         *     
         */
        public void setEndDate(Re3Data.Repository.EndDate value) {
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
         * Gets the value of the missionStatementUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMissionStatementUrl() {
            return missionStatementUrl;
        }

        /**
         * Sets the value of the missionStatementUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMissionStatementUrl(String value) {
            this.missionStatementUrl = value;
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
         * {@link String }
         * 
         * 
         */
        public List<String> getSoftware() {
            if (software == null) {
                software = new ArrayList<String>();
            }
            return this.software;
        }

        /**
         * Gets the value of the versioning property.
         * 
         * @return
         *     possible object is
         *     {@link Yesnoun }
         *     
         */
        public Yesnoun getVersioning() {
            return versioning;
        }

        /**
         * Sets the value of the versioning property.
         * 
         * @param value
         *     allowed object is
         *     {@link Yesnoun }
         *     
         */
        public void setVersioning(Yesnoun value) {
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
         * {@link String }
         * 
         * 
         */
        public List<String> getPidSystem() {
            if (pidSystem == null) {
                pidSystem = new ArrayList<String>();
            }
            return this.pidSystem;
        }

        /**
         * Gets the value of the citationReference property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the citationReference property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCitationReference().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CitationReferences }
         * 
         * 
         */
        public List<CitationReferences> getCitationReference() {
            if (citationReference == null) {
                citationReference = new ArrayList<CitationReferences>();
            }
            return this.citationReference;
        }

        /**
         * Gets the value of the metrics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the metrics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMetrics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getMetrics() {
            if (metrics == null) {
                metrics = new ArrayList<String>();
            }
            return this.metrics;
        }

        /**
         * Gets the value of the citationGuidelineUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCitationGuidelineUrl() {
            return citationGuidelineUrl;
        }

        /**
         * Sets the value of the citationGuidelineUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCitationGuidelineUrl(String value) {
            this.citationGuidelineUrl = value;
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
         * {@link String }
         * 
         * 
         */
        public List<String> getAidSystem() {
            if (aidSystem == null) {
                aidSystem = new ArrayList<String>();
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
         * {@link String }
         * 
         * 
         */
        public List<String> getCertificate() {
            if (certificate == null) {
                certificate = new ArrayList<String>();
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
         *       &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
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
            @XmlAttribute(name = "language")
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
         *         &lt;element name="apiType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="apiUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *         &lt;element name="apiDocumentation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "apiType",
            "apiUrl",
            "apiDocumentation"
        })
        public static class Api {

            @XmlElement(required = true)
            protected String apiType;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String apiUrl;
            @XmlElement(required = true)
            protected String apiDocumentation;

            /**
             * Gets the value of the apiType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApiType() {
                return apiType;
            }

            /**
             * Sets the value of the apiType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApiType(String value) {
                this.apiType = value;
            }

            /**
             * Gets the value of the apiUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApiUrl() {
                return apiUrl;
            }

            /**
             * Sets the value of the apiUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApiUrl(String value) {
                this.apiUrl = value;
            }

            /**
             * Gets the value of the apiDocumentation property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApiDocumentation() {
                return apiDocumentation;
            }

            /**
             * Sets the value of the apiDocumentation property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApiDocumentation(String value) {
                this.apiDocumentation = value;
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
         *     &lt;extension base="&lt;http://www.re3data.org/schema/3-0>contentType_Text">
         *       &lt;attribute name="contentTypeScheme">
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
            @XmlAttribute(name = "contentTypeScheme")
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
         *         &lt;element name="dataAccessType" type="{http://www.re3data.org/schema/3-0}dataAccessTypes"/>
         *         &lt;element name="dataAccessRestriction" type="{http://www.re3data.org/schema/3-0}dataAccessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
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
         *         &lt;element name="databaseAccessType" type="{http://www.re3data.org/schema/3-0}accessTypes"/>
         *         &lt;element name="databaseAccessRestriction" type="{http://www.re3data.org/schema/3-0}accessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
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
         *         &lt;element name="databaseLicenseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="databaseLicenseUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
            "databaseLicenseUrl"
        })
        public static class DatabaseLicense {

            @XmlElement(required = true)
            protected String databaseLicenseName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String databaseLicenseUrl;

            /**
             * Gets the value of the databaseLicenseName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatabaseLicenseName() {
                return databaseLicenseName;
            }

            /**
             * Sets the value of the databaseLicenseName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatabaseLicenseName(String value) {
                this.databaseLicenseName = value;
            }

            /**
             * Gets the value of the databaseLicenseUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatabaseLicenseUrl() {
                return databaseLicenseUrl;
            }

            /**
             * Sets the value of the databaseLicenseUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatabaseLicenseUrl(String value) {
                this.databaseLicenseUrl = value;
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
         *         &lt;element name="dataLicenseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="dataLicenseUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
            "dataLicenseUrl"
        })
        public static class DataLicense {

            @XmlElement(required = true)
            protected String dataLicenseName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String dataLicenseUrl;

            /**
             * Gets the value of the dataLicenseName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataLicenseName() {
                return dataLicenseName;
            }

            /**
             * Sets the value of the dataLicenseName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataLicenseName(String value) {
                this.dataLicenseName = value;
            }

            /**
             * Gets the value of the dataLicenseUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataLicenseUrl() {
                return dataLicenseUrl;
            }

            /**
             * Sets the value of the dataLicenseUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataLicenseUrl(String value) {
                this.dataLicenseUrl = value;
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
         *         &lt;element name="dataUploadType" type="{http://www.re3data.org/schema/3-0}accessTypes"/>
         *         &lt;element name="dataUploadRestriction" type="{http://www.re3data.org/schema/3-0}dataAccessRestrictions" maxOccurs="unbounded" minOccurs="0"/>
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
            protected List<DataAccessRestrictions> dataUploadRestriction;

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
             * {@link DataAccessRestrictions }
             * 
             * 
             */
            public List<DataAccessRestrictions> getDataUploadRestriction() {
                if (dataUploadRestriction == null) {
                    dataUploadRestriction = new ArrayList<DataAccessRestrictions>();
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
         *         &lt;element name="dataUploadLicenseUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
            "dataUploadLicenseUrl"
        })
        public static class DataUploadLicense {

            @XmlElement(required = true)
            protected String dataUploadLicenseName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String dataUploadLicenseUrl;

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
             * Gets the value of the dataUploadLicenseUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDataUploadLicenseUrl() {
                return dataUploadLicenseUrl;
            }

            /**
             * Sets the value of the dataUploadLicenseUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDataUploadLicenseUrl(String value) {
                this.dataUploadLicenseUrl = value;
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
         *     &lt;extension base="&lt;http://www.re3data.org/schema/3-0>StringL2000">
         *       &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
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
            @XmlAttribute(name = "language")
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
         *         &lt;element name="closed" type="{http://www.re3data.org/schema/3-0}dateFormatEmpty" minOccurs="0"/>
         *         &lt;element name="offline" type="{http://www.re3data.org/schema/3-0}dateFormatEmpty" minOccurs="0"/>
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
            "closed",
            "offline"
        })
        public static class EndDate {

            protected String closed;
            protected String offline;

            /**
             * Gets the value of the closed property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClosed() {
                return closed;
            }

            /**
             * Sets the value of the closed property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClosed(String value) {
                this.closed = value;
            }

            /**
             * Gets the value of the offline property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOffline() {
                return offline;
            }

            /**
             * Sets the value of the offline property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOffline(String value) {
                this.offline = value;
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
         *         &lt;element name="re3data" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="doi" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "re3Data",
            "doi"
        })
        public static class Identifiers {

            @XmlElement(name = "re3data", required = true)
            protected String re3Data;
            @XmlElement(required = true)
            protected String doi;

            /**
             * Gets the value of the re3Data property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRe3Data() {
                return re3Data;
            }

            /**
             * Sets the value of the re3Data property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRe3Data(String value) {
                this.re3Data = value;
            }

            /**
             * Gets the value of the doi property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDoi() {
                return doi;
            }

            /**
             * Sets the value of the doi property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDoi(String value) {
                this.doi = value;
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
         *                 &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="institutionAdditionalName" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="institutionCountry" type="{http://www.re3data.org/schema/3-0}countries"/>
         *         &lt;element name="responsibilityType" type="{http://www.re3data.org/schema/3-0}responsibilityTypes" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="institutionType" type="{http://www.re3data.org/schema/3-0}institutionTypes" minOccurs="0"/>
         *         &lt;element name="institutionUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
         *         &lt;element name="institutionIdentifier" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="institutionIdentifierType" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *                   &lt;element name="institutionIdentifierValue" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="responsibilityStartDate" type="{http://www.re3data.org/schema/3-0}dateFormat" minOccurs="0"/>
         *         &lt;element name="responsibilityEndDate" type="{http://www.re3data.org/schema/3-0}dateFormat" minOccurs="0"/>
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
            "institutionUrl",
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
            protected String institutionUrl;
            protected List<Re3Data.Repository.Institution.InstitutionIdentifier> institutionIdentifier;
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
             * Gets the value of the institutionUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInstitutionUrl() {
                return institutionUrl;
            }

            /**
             * Sets the value of the institutionUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInstitutionUrl(String value) {
                this.institutionUrl = value;
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
             * {@link Re3Data.Repository.Institution.InstitutionIdentifier }
             * 
             * 
             */
            public List<Re3Data.Repository.Institution.InstitutionIdentifier> getInstitutionIdentifier() {
                if (institutionIdentifier == null) {
                    institutionIdentifier = new ArrayList<Re3Data.Repository.Institution.InstitutionIdentifier>();
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
             *       &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
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
                @XmlAttribute(name = "language")
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
             *         &lt;element name="institutionIdentifierType" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
             *         &lt;element name="institutionIdentifierValue" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
                "institutionIdentifierType",
                "institutionIdentifierValue"
            })
            public static class InstitutionIdentifier {

                @XmlElement(required = true)
                protected Object institutionIdentifierType;
                @XmlElement(required = true)
                @XmlSchemaType(name = "anyURI")
                protected String institutionIdentifierValue;

                /**
                 * Gets the value of the institutionIdentifierType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Object }
                 *     
                 */
                public Object getInstitutionIdentifierType() {
                    return institutionIdentifierType;
                }

                /**
                 * Sets the value of the institutionIdentifierType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Object }
                 *     
                 */
                public void setInstitutionIdentifierType(Object value) {
                    this.institutionIdentifierType = value;
                }

                /**
                 * Gets the value of the institutionIdentifierValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getInstitutionIdentifierValue() {
                    return institutionIdentifierValue;
                }

                /**
                 * Sets the value of the institutionIdentifierValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setInstitutionIdentifierValue(String value) {
                    this.institutionIdentifierValue = value;
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
             *       &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
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
                @XmlAttribute(name = "language")
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
         *         &lt;element name="metadataStandardName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="metadataStandardUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
            "metadataStandardUrl"
        })
        public static class MetadataStandard {

            @XmlElement(required = true)
            protected String metadataStandardName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String metadataStandardUrl;

            /**
             * Gets the value of the metadataStandardName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMetadataStandardName() {
                return metadataStandardName;
            }

            /**
             * Sets the value of the metadataStandardName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMetadataStandardName(String value) {
                this.metadataStandardName = value;
            }

            /**
             * Gets the value of the metadataStandardUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMetadataStandardUrl() {
                return metadataStandardUrl;
            }

            /**
             * Sets the value of the metadataStandardUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMetadataStandardUrl(String value) {
                this.metadataStandardUrl = value;
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
         *         &lt;element name="policyType" type="{http://www.re3data.org/schema/3-0}policyTypes" maxOccurs="unbounded"/>
         *         &lt;element name="policyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="policyUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
            "policyType",
            "policyName",
            "policyUrl"
        })
        public static class Policy {

            @XmlElement(required = true)
            @XmlSchemaType(name = "string")
            protected List<PolicyTypes> policyType;
            @XmlElement(required = true)
            protected String policyName;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String policyUrl;

            /**
             * Gets the value of the policyType property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the policyType property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPolicyType().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PolicyTypes }
             * 
             * 
             */
            public List<PolicyTypes> getPolicyType() {
                if (policyType == null) {
                    policyType = new ArrayList<PolicyTypes>();
                }
                return this.policyType;
            }

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
             * Gets the value of the policyUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPolicyUrl() {
                return policyUrl;
            }

            /**
             * Sets the value of the policyUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPolicyUrl(String value) {
                this.policyUrl = value;
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
         *         &lt;element name="repositoryIdentifierType" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="repositoryIdentifierValue" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
            "repositoryIdentifierType",
            "repositoryIdentifierValue"
        })
        public static class RepositoryIdentifier {

            @XmlElement(required = true)
            protected Object repositoryIdentifierType;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String repositoryIdentifierValue;

            /**
             * Gets the value of the repositoryIdentifierType property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getRepositoryIdentifierType() {
                return repositoryIdentifierType;
            }

            /**
             * Sets the value of the repositoryIdentifierType property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setRepositoryIdentifierType(Object value) {
                this.repositoryIdentifierType = value;
            }

            /**
             * Gets the value of the repositoryIdentifierValue property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRepositoryIdentifierValue() {
                return repositoryIdentifierValue;
            }

            /**
             * Sets the value of the repositoryIdentifierValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRepositoryIdentifierValue(String value) {
                this.repositoryIdentifierValue = value;
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
         *       &lt;attribute name="language" type="{http://www.re3data.org/schema/3-0}languages" />
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
            @XmlAttribute(name = "language")
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
         *       &lt;attribute name="updated" use="required" type="{http://www.re3data.org/schema/3-0}dateFormat" />
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
         *         &lt;element name="subjectId" type="{http://www.re3data.org/schema/3-0}subjectIds"/>
         *         &lt;element name="subjectName" type="{http://www.re3data.org/schema/3-0}subjectNames"/>
         *       &lt;/sequence>
         *       &lt;attribute name="subjectScheme">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="DFG"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "subjectId",
            "subjectName"
        })
        public static class Subject {

            @XmlElement(required = true)
            protected String subjectId;
            @XmlElement(required = true)
            protected String subjectName;
            @XmlAttribute(name = "subjectScheme")
            protected String subjectScheme;

            /**
             * Gets the value of the subjectId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubjectId() {
                return subjectId;
            }

            /**
             * Sets the value of the subjectId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubjectId(String value) {
                this.subjectId = value;
            }

            /**
             * Gets the value of the subjectName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubjectName() {
                return subjectName;
            }

            /**
             * Sets the value of the subjectName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubjectName(String value) {
                this.subjectName = value;
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
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="syndicationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="syndicationUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
            "syndicationType",
            "syndicationUrl"
        })
        public static class Syndication {

            @XmlElement(required = true)
            protected String syndicationType;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String syndicationUrl;

            /**
             * Gets the value of the syndicationType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSyndicationType() {
                return syndicationType;
            }

            /**
             * Sets the value of the syndicationType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSyndicationType(String value) {
                this.syndicationType = value;
            }

            /**
             * Gets the value of the syndicationUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSyndicationUrl() {
                return syndicationUrl;
            }

            /**
             * Sets the value of the syndicationUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSyndicationUrl(String value) {
                this.syndicationUrl = value;
            }

        }

    }

}
