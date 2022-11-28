package com.apache.estudos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TB_CONTENTS_JJT")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "dept_seq" , allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name ="CONTENT" )
    private String content;
}
