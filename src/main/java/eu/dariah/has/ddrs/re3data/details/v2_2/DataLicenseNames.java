package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "dataLicenseNames")
@XmlEnum
public enum DataLicenseNames {

    @XmlEnumValue("Apache License 2.0")
    APACHE_LICENSE_2_0("Apache License 2.0"),
    BSD("BSD"),
    CC("CC"),
    @XmlEnumValue("CC0")
    CC_0("CC0"),
    @XmlEnumValue("Copyrights")
    COPYRIGHTS("Copyrights"),
    ODC("ODC"),
    OGL("OGL"),
    OGLC("OGLC"),
    @XmlEnumValue("Public Domain")
    PUBLIC_DOMAIN("Public Domain"),
    RL("RL"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    DataLicenseNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataLicenseNames fromValue(String v) {
        for (DataLicenseNames c: DataLicenseNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
