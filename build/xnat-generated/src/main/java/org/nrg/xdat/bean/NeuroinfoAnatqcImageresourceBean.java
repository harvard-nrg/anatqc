/*
 * GENERATED FILE
 * Created on Thu Apr 01 09:57:06 GMT-05:00 2021
 *
 */
package org.nrg.xdat.bean;
import org.apache.log4j.Logger;
import org.nrg.xdat.bean.base.BaseElement;

import java.util.*;

/**
 * @author XDAT
 *
 *//*
 ******************************** 
 * DO NOT MODIFY THIS FILE 
 *
 ********************************/
@SuppressWarnings({"unchecked","rawtypes"})
public class NeuroinfoAnatqcImageresourceBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI {
	public static final Logger logger = Logger.getLogger(NeuroinfoAnatqcImageresourceBean.class);
	public static final String SCHEMA_ELEMENT_NAME="neuroinfo:anatqc_imageResource";

	public String getSchemaElementName(){
		return "anatqc_imageResource";
	}

	public String getFullSchemaElementName(){
		return "neuroinfo:anatqc_imageResource";
	}

	//FIELD

	private String _Label=null;

	/**
	 * @return Returns the label.
	 */
	public String getLabel(){
		return _Label;
	}

	/**
	 * Sets the value for label.
	 * @param v Value to Set.
	 */
	public void setLabel(String v){
		_Label=v;
	}

	//FIELD

	private String _Uri=null;

	/**
	 * @return Returns the uri.
	 */
	public String getUri(){
		return _Uri;
	}

	/**
	 * Sets the value for uri.
	 * @param v Value to Set.
	 */
	public void setUri(String v){
		_Uri=v;
	}

	//FIELD

	private Integer _NeuroinfoAnatqcImageresourceId=null;

	/**
	 * @return Returns the neuroinfo_anatqc_imageResource_id.
	 */
	public Integer getNeuroinfoAnatqcImageresourceId() {
		return _NeuroinfoAnatqcImageresourceId;
	}

	/**
	 * Sets the value for neuroinfo_anatqc_imageResource_id.
	 * @param v Value to Set.
	 */
	public void setNeuroinfoAnatqcImageresourceId(Integer v){
		_NeuroinfoAnatqcImageresourceId=v;
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("label")){
			setLabel(v);
		}else if (xmlPath.equals("uri")){
			setUri(v);
		}
		else{
			super.setDataField(xmlPath,v);
		}
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setReferenceField(String xmlPath,BaseElement v) throws BaseElement.UnknownFieldException{
			super.setReferenceField(xmlPath,v);
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public Object getDataFieldValue(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("label")){
			return getLabel();
		}else if (xmlPath.equals("uri")){
			return getUri();
		}
		else{
			return super.getDataFieldValue(xmlPath);
		}
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public Object getReferenceField(String xmlPath) throws BaseElement.UnknownFieldException{
			return super.getReferenceField(xmlPath);
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public String getReferenceFieldName(String xmlPath) throws BaseElement.UnknownFieldException{
			return super.getReferenceFieldName(xmlPath);
	}

	/**
	 * Returns whether or not this is a reference field
	 */
	public String getFieldType(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("label")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("uri")){
			return BaseElement.field_data;
		}
		else{
			return super.getFieldType(xmlPath);
		}
	}

	/**
	 * Returns arraylist of all fields
	 */
	public ArrayList getAllFields() {
		ArrayList all_fields=new ArrayList();
		all_fields.add("label");
		all_fields.add("uri");
		all_fields.addAll(super.getAllFields());
		return all_fields;
	}


	public String toString(){
		java.io.StringWriter sw = new java.io.StringWriter();
		try{this.toXML(sw,true);}catch(java.io.IOException e){}
		return sw.toString();
	}


	public void toXML(java.io.Writer writer,boolean prettyPrint) throws java.io.IOException{
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.write("\n<neuroinfo:anatqc_imageResource");
		TreeMap map = new TreeMap();
		map.putAll(getXMLAtts());
		map.put("xmlns:arc","http://nrg.wustl.edu/arc");
		map.put("xmlns:cat","http://nrg.wustl.edu/catalog");
		map.put("xmlns:neuroinfo","http://nrg.wustl.edu/neuroinfo");
		map.put("xmlns:pipe","http://nrg.wustl.edu/pipe");
		map.put("xmlns:prov","http://www.nbirn.net/prov");
		map.put("xmlns:scr","http://nrg.wustl.edu/scr");
		map.put("xmlns:val","http://nrg.wustl.edu/val");
		map.put("xmlns:wrk","http://nrg.wustl.edu/workflow");
		map.put("xmlns:xdat","http://nrg.wustl.edu/security");
		map.put("xmlns:xnat","http://nrg.wustl.edu/xnat");
		map.put("xmlns:xnat_a","http://nrg.wustl.edu/xnat_assessments");
		map.put("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		java.util.Iterator iter =map.keySet().iterator();
		while(iter.hasNext()){
			String key = (String)iter.next();
			writer.write(" " + key + "=\"" + map.get(key) + "\"");
		}
		int header = 0;
		if (prettyPrint)header++;
		writer.write(">");
		addXMLBody(writer,header);
		if (prettyPrint)header--;
		writer.write("\n</neuroinfo:anatqc_imageResource>");
	}


	protected void addXMLAtts(java.io.Writer writer) throws java.io.IOException{
		TreeMap map = this.getXMLAtts();
		java.util.Iterator iter =map.keySet().iterator();
		while(iter.hasNext()){
			String key = (String)iter.next();
			writer.write(" " + key + "=\"" + map.get(key) + "\"");
		}
	}


	protected TreeMap getXMLAtts() {
		TreeMap map = super.getXMLAtts();
		return map;
	}


	protected boolean addXMLBody(java.io.Writer writer, int header) throws java.io.IOException{
		super.addXMLBody(writer,header);
		if (_Label!=null){
			writer.write("\n" + createHeader(header++) + "<neuroinfo:label");
			writer.write(">");
			writer.write(ValueParser(_Label,"string"));
			writer.write("</neuroinfo:label>");
			header--;
		}
		if (_Uri!=null){
			writer.write("\n" + createHeader(header++) + "<neuroinfo:uri");
			writer.write(">");
			writer.write(ValueParser(_Uri,"string"));
			writer.write("</neuroinfo:uri>");
			header--;
		}
	return true;
	}


	protected boolean hasXMLBodyContent(){
		if (_Label!=null) return true;
		if (_Uri!=null) return true;
		if(super.hasXMLBodyContent())return true;
		return false;
	}
}
