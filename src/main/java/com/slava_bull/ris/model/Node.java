package com.slava_bull.ris.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "nodes")
public class Node extends AbstractEntity {
    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    @Column(name = "username")
    private String user;

    @OneToMany(mappedBy = "node")
    private List<Tag> tags;
}
