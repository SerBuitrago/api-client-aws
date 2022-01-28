package com.pragma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
	private Long id;
	private String name;
	private String subname;
	private String type;
	private Long document;
	private Integer age;
	private String cityBirth;
}
