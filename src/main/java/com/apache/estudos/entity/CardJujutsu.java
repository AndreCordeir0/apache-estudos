package com.apache.estudos.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "NOME")
    private String nome;

    @Column(name = "INFO")
    private String info;

    @Column(name = "JAPANESE_NAME")
    private String japeneseName;

    @Column(name = "ROMAJI_NAME")
    private String romajiName;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "TAMANHO")
    private String tamanho;

    @Column(name = "VOLUMES")
    private String volumes;

    @Column(name = "GENRE")
    private String genre;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_JUJUTSU_KAISEN")
    private Jujutsu idJujutsu;
}
