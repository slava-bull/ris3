package com.slava_bull.ris.dto;

import lombok.Data;

@Data
public class EditNodeDto {
    private Long id;
    private double lat;
    private double lon;
    private String user;
}
