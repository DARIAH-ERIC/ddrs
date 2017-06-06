package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "institutionTypes")
@XmlEnum
public enum InstitutionTypes {

    @XmlEnumValue("commercial")
    COMMERCIAL("commercial"),
    @XmlEnumValue("non-profit")
    NON_PROFIT("non-profit");
    private final String value;

    InstitutionTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InstitutionTypes fromValue(String v) {
        for (InstitutionTypes c: InstitutionTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
