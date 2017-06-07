package eu.dariah.has.ddrs.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yoann on 29.05.17.
 */
@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @SequenceGenerator(name="question_id_seq", sequenceName="question_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="question_id_seq")
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

    public Question() {}

    public Question(String name, Boolean isEditable, Boolean isInUse, int questionOrder, int priority, ResultTypeHierarchical resultTypeHierarchical, Translation translation) {
        this.name = name;
        this.isEditable = isEditable;
        this.isInUse = isInUse;
        this.questionOrder = questionOrder;
        this.priority = priority;
        this.resultTypeHierarchical = resultTypeHierarchical;
        this.translation = translation;
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
