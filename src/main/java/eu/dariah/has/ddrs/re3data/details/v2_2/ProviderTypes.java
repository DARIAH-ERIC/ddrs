package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "providerTypes")
@XmlEnum
public enum ProviderTypes {

    @XmlEnumValue("dataProvider")
    DATA_PROVIDER("dataProvider"),
    @XmlEnumValue("serviceProvider")
    SERVICE_PROVIDER("serviceProvider");
    private final String value;

    ProviderTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProviderTypes fromValue(String v) {
        for (ProviderTypes c: ProviderTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
