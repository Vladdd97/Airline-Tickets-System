package com.airiline.tickets.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @SequenceGenerator(name = "ats_generator", sequenceName = "ats_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ats_generator")
    private Long id;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date updateDate;
}
