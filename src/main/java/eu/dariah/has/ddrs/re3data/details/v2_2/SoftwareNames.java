package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "softwareNames")
@XmlEnum
public enum SoftwareNames {

    CKAN("CKAN"),
    @XmlEnumValue("DataVerse")
    DATA_VERSE("DataVerse"),
    @XmlEnumValue("DigitalCommons")
    DIGITAL_COMMONS("DigitalCommons"),
    @XmlEnumValue("dLibra")
    D_LIBRA("dLibra"),
    @XmlEnumValue("DSpace")
    D_SPACE("DSpace"),
    @XmlEnumValue("EPrints")
    E_PRINTS("EPrints"),
    @XmlEnumValue("eSciDoc")
    E_SCI_DOC("eSciDoc"),
    @XmlEnumValue("Fedora")
    FEDORA("Fedora"),
    @XmlEnumValue("MySQL")
    MY_SQL("MySQL"),
    @XmlEnumValue("Nesstar")
    NESSTAR("Nesstar"),
    @XmlEnumValue("Opus")
    OPUS("Opus"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    SoftwareNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SoftwareNames fromValue(String v) {
        for (SoftwareNames c: SoftwareNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
