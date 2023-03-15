package org.propertyservice.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class InnerProperty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "innerProperty", optional = false)
    private Property property;


}
