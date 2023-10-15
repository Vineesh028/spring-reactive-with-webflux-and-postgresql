package com.reactive.test.entity;


import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "users")
public class UserEntity {

	@Column("id")
	private Integer id;

	@Column("name")
	private String name;

	@Column("email")
	private String email;
	

}
