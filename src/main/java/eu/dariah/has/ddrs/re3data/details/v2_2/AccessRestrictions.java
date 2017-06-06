package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "accessRestrictions")
@XmlEnum
public enum AccessRestrictions {

    @XmlEnumValue("feeRequired")
    FEE_REQUIRED("feeRequired"),
    @XmlEnumValue("registration")
    REGISTRATION("registration"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    AccessRestrictions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessRestrictions fromValue(String v) {
        for (AccessRestrictions c: AccessRestrictions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
