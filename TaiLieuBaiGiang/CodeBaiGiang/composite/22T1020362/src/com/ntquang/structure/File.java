package com.ntquang.structure;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File implements Component {
	private String tenFile;
	private double dungLuongCuaFile;
	private String duongDanCha; // bổ sung

	@Override
	public double getDungLuong() {
		return this.dungLuongCuaFile;
	}

	@Override
	public String getDuongDan() {
		return duongDanCha + "/" + tenFile;
	}
}
