package com.slava_bull.ris.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tags")
public class Tag extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "node_id")
    private Node node;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;
}
