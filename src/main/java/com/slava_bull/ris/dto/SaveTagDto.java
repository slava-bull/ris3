package com.slava_bull.ris.dto;

import lombok.Data;

@Data
public class SaveTagDto {
    private Long nodeId;
    private String key;
    private String value;
}
