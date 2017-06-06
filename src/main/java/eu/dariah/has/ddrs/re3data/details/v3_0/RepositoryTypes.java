package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "repositoryTypes")
@XmlEnum
public enum RepositoryTypes {

    @XmlEnumValue("disciplinary")
    DISCIPLINARY("disciplinary"),
    @XmlEnumValue("governmental")
    GOVERNMENTAL("governmental"),
    @XmlEnumValue("institutional")
    INSTITUTIONAL("institutional"),
    @XmlEnumValue("multidisciplinary")
    MULTIDISCIPLINARY("multidisciplinary"),
    @XmlEnumValue("project-related")
    PROJECT_RELATED("project-related"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    RepositoryTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RepositoryTypes fromValue(String v) {
        for (RepositoryTypes c: RepositoryTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
