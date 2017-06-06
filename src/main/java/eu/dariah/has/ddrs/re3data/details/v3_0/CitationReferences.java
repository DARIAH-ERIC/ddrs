package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "citationReferences")
@XmlEnum
public enum CitationReferences {

    @XmlEnumValue("Data Citation Index")
    DATA_CITATION_INDEX("Data Citation Index"),
    SCOPUS("SCOPUS");
    private final String value;

    CitationReferences(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CitationReferences fromValue(String v) {
        for (CitationReferences c: CitationReferences.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
