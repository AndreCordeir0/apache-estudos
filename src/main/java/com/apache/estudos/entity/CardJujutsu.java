package com.apache.estudos.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TB_CARD_JJT")
public class CardJujutsu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @SequenceGenerator(name = "sequence",sequenceName = "dept_seq",allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEY")
    @Size(max = 100)
    private String key;

    @Column(name = "VALUE")
    @Size(max = 100)
    private String value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_JUJUTSU_KAISEN")
    private Jujutsu idJujutsu;
}
