package eu.dariah.has.ddrs.re3data.details.v2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "apiTypes")
@XmlEnum
public enum ApiTypes {

    FTP("FTP"),
    @XmlEnumValue("NetCDF")
    NET_CDF("NetCDF"),
    @XmlEnumValue("OAI-PMH")
    OAI_PMH("OAI-PMH"),
    @XmlEnumValue("OpenDAP")
    OPEN_DAP("OpenDAP"),
    REST("REST"),
    SOAP("SOAP"),
    SPARQL("SPARQL"),
    SWORD("SWORD"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ApiTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApiTypes fromValue(String v) {
        for (ApiTypes c: ApiTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
