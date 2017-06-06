package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "contentType_Text")
@XmlEnum
public enum ContentTypeText {

    @XmlEnumValue("Standard office documents")
    STANDARD_OFFICE_DOCUMENTS("Standard office documents"),
    @XmlEnumValue("Networkbased data")
    NETWORKBASED_DATA("Networkbased data"),
    @XmlEnumValue("Databases")
    DATABASES("Databases"),
    @XmlEnumValue("Images")
    IMAGES("Images"),
    @XmlEnumValue("Structured graphics")
    STRUCTURED_GRAPHICS("Structured graphics"),
    @XmlEnumValue("Audiovisual data")
    AUDIOVISUAL_DATA("Audiovisual data"),
    @XmlEnumValue("Scientific and statistical data formats")
    SCIENTIFIC_AND_STATISTICAL_DATA_FORMATS("Scientific and statistical data formats"),
    @XmlEnumValue("Raw data")
    RAW_DATA("Raw data"),
    @XmlEnumValue("Plain text")
    PLAIN_TEXT("Plain text"),
    @XmlEnumValue("Structured text")
    STRUCTURED_TEXT("Structured text"),
    @XmlEnumValue("Archived data")
    ARCHIVED_DATA("Archived data"),
    @XmlEnumValue("Software applications")
    SOFTWARE_APPLICATIONS("Software applications"),
    @XmlEnumValue("Source code")
    SOURCE_CODE("Source code"),
    @XmlEnumValue("Configuration data")
    CONFIGURATION_DATA("Configuration data"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ContentTypeText(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContentTypeText fromValue(String v) {
        for (ContentTypeText c: ContentTypeText.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
