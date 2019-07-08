package org.jb.rest.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Builder
public class PersonData {
	@Getter private long id = 0;
	private String name = "?";
	private String email = "?";
	private String phone = "?";
	private String address = "?";
	private String date_of_birth = "?";
	private String descr = "";
}
