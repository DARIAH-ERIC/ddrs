package eu.dariah.has.ddrs.persistence.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yoann on 29.05.17.
 */
@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @GenericGenerator(
            name = "question_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "question_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator="question_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private String name;

    @Column(nullable = false)
    private Boolean isEditable;

    @Column(unique = true, nullable = false)
    private int questionOrder;

    @Column(nullable = false)
    private Boolean isInUse;

    @Column(nullable = false)
    private int priority;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "result_type_hierarchical_id")
    private ResultTypeHierarchical resultTypeHierarchical;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "translation_id")
    private Translation translation;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "tooltip_id")
    private Translation tooltip;

    public Question() {}

    public Question(String name, Boolean isEditable, Boolean isInUse, int questionOrder, int priority, ResultTypeHierarchical resultTypeHierarchical, Translation translation, Translation tooltip) {
        this.name = name;
        this.isEditable = isEditable;
        this.isInUse = isInUse;
        this.questionOrder = questionOrder;
        this.priority = priority;
        this.resultTypeHierarchical = resultTypeHierarchical;
        this.translation = translation;
        this.tooltip = tooltip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResultTypeHierarchical getResultTypeHierarchical() {
        return resultTypeHierarchical;
    }

    public void setResultTypeHierarchical(ResultTypeHierarchical resultTypeHierarchical) {
        this.resultTypeHierarchical = resultTypeHierarchical;
    }

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    public Translation getTooltip() {
        return tooltip;
    }

    public void setTooltip(Translation tooltip) {
        this.tooltip = tooltip;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public Boolean getInUse() {
        return isInUse;
    }

    public void setInUse(Boolean inUse) {
        isInUse = inUse;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Boolean getEditable() {
        return isEditable;
    }

    public void setEditable(Boolean editable) {
        isEditable = editable;
    }
}
