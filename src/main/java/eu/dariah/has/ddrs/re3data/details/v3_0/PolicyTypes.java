package eu.dariah.has.ddrs.re3data.details.v3_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "policyTypes")
@XmlEnum
public enum PolicyTypes {

    @XmlEnumValue("Access policy")
    ACCESS_POLICY("Access policy"),
    @XmlEnumValue("Collection policy")
    COLLECTION_POLICY("Collection policy"),
    @XmlEnumValue("Data policy")
    DATA_POLICY("Data policy"),
    @XmlEnumValue("Metadata policy")
    METADATA_POLICY("Metadata policy"),
    @XmlEnumValue("Preservation policy")
    PRESERVATION_POLICY("Preservation policy"),
    @XmlEnumValue("Submission policy")
    SUBMISSION_POLICY("Submission policy"),
    @XmlEnumValue("Terms of use")
    TERMS_OF_USE("Terms of use"),
    @XmlEnumValue("Usage policy")
    USAGE_POLICY("Usage policy"),
    @XmlEnumValue("Quality policy")
    QUALITY_POLICY("Quality policy");
    private final String value;

    PolicyTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PolicyTypes fromValue(String v) {
        for (PolicyTypes c: PolicyTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
