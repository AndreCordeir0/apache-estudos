package com.apache.estudos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardJujutsuDTO {

    private Long id;

    private String key;

    private String value;
}
