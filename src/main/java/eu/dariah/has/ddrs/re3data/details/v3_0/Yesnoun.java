package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "yesnoun")
@XmlEnum
public enum Yesnoun {

    @XmlEnumValue("yes")
    YES("yes"),
    @XmlEnumValue("no")
    NO("no"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    Yesnoun(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Yesnoun fromValue(String v) {
        for (Yesnoun c: Yesnoun.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
