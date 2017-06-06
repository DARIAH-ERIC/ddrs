package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "aidSystems")
@XmlEnum
public enum AidSystems {

    @XmlEnumValue("AuthorClaim")
    AUTHOR_CLAIM("AuthorClaim"),
    ISNI("ISNI"),
    ORCID("ORCID"),
    @XmlEnumValue("ResearcherID")
    RESEARCHER_ID("ResearcherID"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    AidSystems(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AidSystems fromValue(String v) {
        for (AidSystems c: AidSystems.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
