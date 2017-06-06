package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "dataAccessTypes")
@XmlEnum
public enum DataAccessTypes {

    @XmlEnumValue("open")
    OPEN("open"),
    @XmlEnumValue("embargoed")
    EMBARGOED("embargoed"),
    @XmlEnumValue("restricted")
    RESTRICTED("restricted"),
    @XmlEnumValue("closed")
    CLOSED("closed");
    private final String value;

    DataAccessTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataAccessTypes fromValue(String v) {
        for (DataAccessTypes c: DataAccessTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
