package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "certificates")
@XmlEnum
public enum Certificates {

    @XmlEnumValue("CLARIN certificate B")
    CLARIN_CERTIFICATE_B("CLARIN certificate B"),
    @XmlEnumValue("DIN 31644")
    DIN_31644("DIN 31644"),
    @XmlEnumValue("DINI Certificate")
    DINI_CERTIFICATE("DINI Certificate"),
    DRAMBORA("DRAMBORA"),
    DSA("DSA"),
    @XmlEnumValue("ISO 16363")
    ISO_16363("ISO 16363"),
    @XmlEnumValue("ISO 16919")
    ISO_16919("ISO 16919"),
    @XmlEnumValue("RatSWD")
    RAT_SWD("RatSWD"),
    TRAC("TRAC"),
    @XmlEnumValue("Trusted Digital Repository")
    TRUSTED_DIGITAL_REPOSITORY("Trusted Digital Repository"),
    WDS("WDS"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    Certificates(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Certificates fromValue(String v) {
        for (Certificates c: Certificates.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
