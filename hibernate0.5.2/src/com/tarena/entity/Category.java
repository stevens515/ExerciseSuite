package com.tarena.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Category generated by MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;

	private Integer turn;

	private String enName;

	private String name;

	private String description;

	private Integer parentId;

	//追加属性,用于存放子类别
	private Set<Category> subCats =
					new HashSet<Category>();
	private List<Category> listCats = 
					new ArrayList<Category>();
	
	// Constructors

	public Set<Category> getSubCats() {
		return subCats;
	}

	public void setSubCats(Set<Category> subCats) {
		this.subCats = subCats;
	}

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(Integer turn, String enName, String name) {
		this.turn = turn;
		this.enName = enName;
		this.name = name;
	}

	/** full constructor */
	public Category(Integer turn, String enName, String name,
			String description, Integer parentId) {
		this.turn = turn;
		this.enName = enName;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurn() {
		return this.turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Category> getListCats() {
		return listCats;
	}

	public void setListCats(List<Category> listCats) {
		this.listCats = listCats;
	}

}