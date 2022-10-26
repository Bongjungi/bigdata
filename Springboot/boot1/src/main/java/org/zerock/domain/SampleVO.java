package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString(exclude = {"val3"}) //sysout에는 제외되고 리턴에는 영향없음.
public class SampleVO {
	
	private String val1;
	private String val2;
	private String val3;
	
}
