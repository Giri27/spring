package com.xworkz.newspaperApp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "newspaper_table")
@NamedQueries({ 
@NamedQuery(name = "NewspaperEntity.getNewspaperObject", query = "from NewspaperEntity where newspaperName=:name"),
@NamedQuery(name = "NewspaperEntity.getAllNewspaper", query = "from NewspaperEntity"),
@NamedQuery(name = "NewspaperEntity.deleteNewspaperEntity", query = "from NewspaperEntity where newspaperName=:name"),
@NamedQuery(name = "NewspaperEntity.updateNewspaperEntity", query = "update NewspaperEntity set price=:price, language=:lang, noOfPages=:pages where newspaperName=:name") })
//@NamedQuery(name = "NewspaperEntity.getNewspaperObjectForLang", query = "from NewspaperEntity where language=:lang") })

@Data
public class NewspaperEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newspaper_id")
	private int newspaperId;
	@Column(name = "newspaper_name")
	private String newspaperName;
	@Column(name = "newspaper_price")
	private double price;
	@Column(name = "newspaper_lang")
	private String language;
	@Column(name = "newspaper_pages")
	private int noOfPages;
	
}
