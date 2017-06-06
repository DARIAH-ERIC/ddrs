package eu.dariah.has.ddrs.persistence.model;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yoann on 29.05.17.
 */
@Entity
@Table(name = "result_type_hierarchical")
public class ResultTypeHierarchical implements Serializable {
    @Id
    @SequenceGenerator(name="result_type_hierarchical_id_seq", sequenceName="result_type_hierarchical_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="result_type_hierarchical_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;

    private String code;

    @Column(nullable = false)
    private int resultTypeHierarchicalOrder;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "question_translation_id")
    private QuestionTranslation questionTranslation;

    @ManyToOne
    private ResultTypeHierarchical parent;

    @OneToMany(fetch = FetchType.EAGER)
    @OrderBy("resultTypeHierarchicalOrder")
    private List<ResultTypeHierarchical> children;

    public ResultTypeHierarchical() {}

    public ResultTypeHierarchical(String code, int order, ResultTypeHierarchical parent) {
        this.code = code;
        this.resultTypeHierarchicalOrder = order;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getResultTypeHierarchicalOrder() {
        return resultTypeHierarchicalOrder;
    }

    public void setResultTypeHierarchicalOrder(int resultTypeHierarchicalOrder) {
        this.resultTypeHierarchicalOrder = resultTypeHierarchicalOrder;
    }

    public QuestionTranslation getQuestionTranslation() {
        return questionTranslation;
    }

    public void setQuestionTranslation(QuestionTranslation questionTranslation) {
        this.questionTranslation = questionTranslation;
    }

    public ResultTypeHierarchical getParent() {
        return parent;
    }

    public void setParent(ResultTypeHierarchical parent) {
        this.parent = parent;
    }

    public List<ResultTypeHierarchical> getChildren() {
        if(children == null)
            return new ArrayList<>();
        return children;
    }

    public void setChildren(List<ResultTypeHierarchical> children) {
        this.children = children;
    }

    public void addChild(ResultTypeHierarchical child) {
        addChildren(Collections.singletonList(child));
    }

    public void addChildren(List<ResultTypeHierarchical> newChildren) {
        List<ResultTypeHierarchical> oldChildren = getChildren();
        children = new ArrayList<>(oldChildren.size() + newChildren.size());
        children.addAll(oldChildren);
        children.addAll(newChildren);
    }

    public void removeChild(ResultTypeHierarchical oldChild) {
        List<ResultTypeHierarchical> oldChildren = getChildren();
        oldChildren.remove(oldChild);
        children = new ArrayList<>(oldChildren.size());
        children.addAll(oldChildren);
    }
}
