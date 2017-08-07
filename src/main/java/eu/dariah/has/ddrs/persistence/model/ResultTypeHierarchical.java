package eu.dariah.has.ddrs.persistence.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

/**
 * Created by yoann on 29.05.17.
 */
@Entity
@Table(name = "result_type_hierarchical")
public class ResultTypeHierarchical implements Serializable {
    @Id
    @GenericGenerator(
            name = "result_type_hierarchical_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "result_type_hierarchical_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator="result_type_hierarchical_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;

    private String code;

    @Column(nullable = false)
    private int resultTypeHierarchicalOrder;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "translation_id")
    private Translation translation;

    @ManyToOne
    private ResultTypeHierarchical parent;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("resultTypeHierarchicalOrder")
    private Set<ResultTypeHierarchical> children;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "resultTypeHierarchical", cascade = CascadeType.REMOVE)
    private Set<DefaultRepository> defaultRepositories;

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

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    public ResultTypeHierarchical getParent() {
        return parent;
    }

    public void setParent(ResultTypeHierarchical parent) {
        this.parent = parent;
    }

    public Set<ResultTypeHierarchical> getChildren() {
        if(children == null)
            return new LinkedHashSet<>();
        return children;
    }

    public void setChildren(Set<ResultTypeHierarchical> children) {
        this.children = children;
    }

    public Set<DefaultRepository> getDefaultRepositories() {
        return defaultRepositories;
    }

    public void setDefaultRepositories(Set<DefaultRepository> defaultRepositories) {
        this.defaultRepositories = defaultRepositories;
    }

    public void addChild(ResultTypeHierarchical child) {
        addChildren(Collections.singleton(child));
    }

    public void addChildren(Set<ResultTypeHierarchical> newChildren) {
        Set<ResultTypeHierarchical> oldChildren = getChildren();
        children = new LinkedHashSet<>(oldChildren.size() + newChildren.size());
        children.addAll(oldChildren);
        children.addAll(newChildren);
    }

    public void removeChild(ResultTypeHierarchical oldChild) {
        Set<ResultTypeHierarchical> oldChildren = getChildren();
        oldChildren.remove(oldChild);
        children = new LinkedHashSet<>(oldChildren.size());
        children.addAll(oldChildren);
    }

    public void addDefaultRepository(DefaultRepository defaultRepository) {
        Set<DefaultRepository> oldDefaultRepositories = getDefaultRepositories();
        defaultRepositories = new LinkedHashSet<>(defaultRepositories.size() + 1);
        defaultRepositories.addAll(oldDefaultRepositories);
        defaultRepositories.add(defaultRepository);
    }

    public void removeDefaultRepository(DefaultRepository oldDefaultRepository) {
        Set<DefaultRepository> oldDefaultRepositories = getDefaultRepositories();
        oldDefaultRepositories.remove(oldDefaultRepository);
        defaultRepositories = new LinkedHashSet<>(oldDefaultRepositories.size());
        defaultRepositories.addAll(oldDefaultRepositories);
    }
}
