package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "accessTypes")
@XmlEnum
public enum AccessTypes {

    @XmlEnumValue("open")
    OPEN("open"),
    @XmlEnumValue("restricted")
    RESTRICTED("restricted"),
    @XmlEnumValue("closed")
    CLOSED("closed");
    private final String value;

    AccessTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessTypes fromValue(String v) {
        for (AccessTypes c: AccessTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
