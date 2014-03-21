package com.skycloud.test.mybatis;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Blog")
public class Blog {
	private Long id;
	private String name;
	private Date datetime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", datetime=" + datetime + "]";
	}

}
