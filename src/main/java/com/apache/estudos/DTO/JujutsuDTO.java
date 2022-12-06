package com.apache.estudos.DTO;


import com.apache.estudos.entity.CardJujutsu;
import com.apache.estudos.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JujutsuDTO {

    private Long id;

    private String sinopse;

    private String cardUrl;

    private List<CardJujutsu> cards;

    private List<Content> contentList = new ArrayList<>();
}
