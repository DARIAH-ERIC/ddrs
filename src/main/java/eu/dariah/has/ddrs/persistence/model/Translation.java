package eu.dariah.has.ddrs.persistence.model;

import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yoann on 30.05.17.
 */
@Entity
@Table(name = "translation")
public class Translation implements Serializable {
    @Id
    @SequenceGenerator(name="translation_id_seq", sequenceName="translation_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="translation_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(nullable = false)
    private String en;

    private String de;
    private String fr;
    private String nl;

    public Translation() {}

    public Translation(String englishTranslation) {
        this.en = englishTranslation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String get(String language) {
        try {
            String translation = "";
            switch (language.split("_")[0]) {
                case "de": translation = getDe();break;
                case "fr": translation = getFr();break;
                case "nl": translation = getNl();break;
            }
            if(StringUtils.isNotEmpty(translation))
                return translation;
            return getEn();
        } catch (Exception e) {
            return getEn();
        }
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }
}
