package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "dataUploadRestrictions")
@XmlEnum
public enum DataUploadRestrictions {

    @XmlEnumValue("feeRequired")
    FEE_REQUIRED("feeRequired"),
    @XmlEnumValue("institutional membership")
    INSTITUTIONAL_MEMBERSHIP("institutional membership"),
    @XmlEnumValue("registration")
    REGISTRATION("registration"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    DataUploadRestrictions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataUploadRestrictions fromValue(String v) {
        for (DataUploadRestrictions c: DataUploadRestrictions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
