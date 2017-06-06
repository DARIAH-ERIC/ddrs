package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "syndicationTypes")
@XmlEnum
public enum SyndicationTypes {

    ATOM("ATOM"),
    RSS("RSS"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    SyndicationTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SyndicationTypes fromValue(String v) {
        for (SyndicationTypes c: SyndicationTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
