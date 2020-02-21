package com.example.demo.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Welcome {
    @Id
    private Long groupId;
    @Column
    private String sentence;
}
