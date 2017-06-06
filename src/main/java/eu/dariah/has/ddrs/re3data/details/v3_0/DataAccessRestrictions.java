package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "dataAccessRestrictions")
@XmlEnum
public enum DataAccessRestrictions {

    @XmlEnumValue("feeRequired")
    FEE_REQUIRED("feeRequired"),
    @XmlEnumValue("institutional membership")
    INSTITUTIONAL_MEMBERSHIP("institutional membership"),
    @XmlEnumValue("registration")
    REGISTRATION("registration"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    DataAccessRestrictions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataAccessRestrictions fromValue(String v) {
        for (DataAccessRestrictions c: DataAccessRestrictions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
