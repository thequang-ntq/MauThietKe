package com.ntquang.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhanTu {
	private int id;
    private String ten;
    private Integer idCha; // có thể null
    private double dungLuong;
    private String loai;
}
