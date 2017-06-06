package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "responsibilityTypes")
@XmlEnum
public enum ResponsibilityTypes {

    @XmlEnumValue("funding")
    FUNDING("funding"),
    @XmlEnumValue("general")
    GENERAL("general"),
    @XmlEnumValue("main")
    MAIN("main"),
    @XmlEnumValue("sponsoring")
    SPONSORING("sponsoring"),
    @XmlEnumValue("technical")
    TECHNICAL("technical");
    private final String value;

    ResponsibilityTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResponsibilityTypes fromValue(String v) {
        for (ResponsibilityTypes c: ResponsibilityTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
