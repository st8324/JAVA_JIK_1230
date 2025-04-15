package kr.kh.spring2.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {

	private int fi_num;
	private String fi_ori_name;
	private String fi_name;
	private int fi_po_num;
	
	public FileVO(String fi_ori_name, String fi_name, int fi_po_num) {
		this.fi_ori_name = fi_ori_name;
		this.fi_name = fi_name;
		this.fi_po_num = fi_po_num;
	}
	
	
}
