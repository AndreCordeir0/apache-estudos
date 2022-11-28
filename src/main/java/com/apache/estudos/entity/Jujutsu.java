package com.apache.estudos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TB_JUJUTSU_KAISEN")
public class Jujutsu implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "jujutsu_sequence")
@SequenceGenerator(name = "jujutsu_sequence", sequenceName = "dept_seq" , allocationSize = 1)
@Column(name = "ID")
private Long id;

@Column(name="RESUMO")
@Size(max = 1000)
private String sinopse;

@Column(name="CARD_BLOB")
private byte[] cardUrl;



@OneToMany(cascade = CascadeType.ALL
        ,fetch = FetchType.LAZY,mappedBy = "idJujutsu",orphanRemoval = true)
private List<CardJujutsu> cards;

@Transient
private List<Content> contentList = new ArrayList<>();
}
