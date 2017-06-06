package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "databaseLicenseNames")
@XmlEnum
public enum DatabaseLicenseNames {

    @XmlEnumValue("Apache License 2.0")
    APACHE_LICENSE_2_0("Apache License 2.0"),
    BSD("BSD"),
    CC("CC"),
    @XmlEnumValue("CC0")
    CC_0("CC0"),
    @XmlEnumValue("Copyrights")
    COPYRIGHTS("Copyrights"),
    ODC("ODC"),
    @XmlEnumValue("Public Domain")
    PUBLIC_DOMAIN("Public Domain"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    DatabaseLicenseNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DatabaseLicenseNames fromValue(String v) {
        for (DatabaseLicenseNames c: DatabaseLicenseNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
