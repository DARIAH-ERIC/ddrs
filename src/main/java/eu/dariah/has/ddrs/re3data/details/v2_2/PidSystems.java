package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "pidSystems")
@XmlEnum
public enum PidSystems {

    ARK("ARK"),
    DOI("DOI"),
    @XmlEnumValue("hdl")
    HDL("hdl"),
    PURL("PURL"),
    URN("URN"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    PidSystems(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PidSystems fromValue(String v) {
        for (PidSystems c: PidSystems.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
