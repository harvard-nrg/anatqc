/*
 * GENERATED FILE
 * Created on Thu Apr 01 09:57:06 GMT-05:00 2021
 *
 */
package org.nrg.xdat.om.base.auto;
import org.apache.log4j.Logger;
import org.nrg.xft.*;
import org.nrg.xft.security.UserI;
import org.nrg.xdat.om.*;
import org.nrg.xft.utils.ResourceFile;
import org.nrg.xft.exception.*;

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
public abstract class AutoNeuroinfoAnatqcImageresource extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI {
	public static final Logger logger = Logger.getLogger(AutoNeuroinfoAnatqcImageresource.class);
	public static final String SCHEMA_ELEMENT_NAME="neuroinfo:anatqc_imageResource";

	public AutoNeuroinfoAnatqcImageresource(ItemI item)
	{
		super(item);
	}

	public AutoNeuroinfoAnatqcImageresource(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoNeuroinfoAnatqcImageresource(UserI user)
	 **/
	public AutoNeuroinfoAnatqcImageresource(){}

	public AutoNeuroinfoAnatqcImageresource(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "neuroinfo:anatqc_imageResource";
	}

	//FIELD

	private String _Label=null;

	/**
	 * @return Returns the label.
	 */
	public String getLabel(){
		try{
			if (_Label==null){
				_Label=getStringProperty("label");
				return _Label;
			}else {
				return _Label;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for label.
	 * @param v Value to Set.
	 */
	public void setLabel(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/label",v);
		_Label=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Uri=null;

	/**
	 * @return Returns the uri.
	 */
	public String getUri(){
		try{
			if (_Uri==null){
				_Uri=getStringProperty("uri");
				return _Uri;
			}else {
				return _Uri;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for uri.
	 * @param v Value to Set.
	 */
	public void setUri(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/uri",v);
		_Uri=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _NeuroinfoAnatqcImageresourceId=null;

	/**
	 * @return Returns the neuroinfo_anatqc_imageResource_id.
	 */
	public Integer getNeuroinfoAnatqcImageresourceId() {
		try{
			if (_NeuroinfoAnatqcImageresourceId==null){
				_NeuroinfoAnatqcImageresourceId=getIntegerProperty("neuroinfo_anatqc_imageResource_id");
				return _NeuroinfoAnatqcImageresourceId;
			}else {
				return _NeuroinfoAnatqcImageresourceId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for neuroinfo_anatqc_imageResource_id.
	 * @param v Value to Set.
	 */
	public void setNeuroinfoAnatqcImageresourceId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/neuroinfo_anatqc_imageResource_id",v);
		_NeuroinfoAnatqcImageresourceId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource> getAllNeuroinfoAnatqcImageresources(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource> al = new ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource> getNeuroinfoAnatqcImageresourcesByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource> al = new ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource> getNeuroinfoAnatqcImageresourcesByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource> al = new ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static NeuroinfoAnatqcImageresource getNeuroinfoAnatqcImageresourcesByNeuroinfoAnatqcImageresourceId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("neuroinfo:anatqc_imageResource/neuroinfo_anatqc_imageResource_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (NeuroinfoAnatqcImageresource) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
			else
				 return null;
		} catch (IllegalAccessException e) {
			final StackTraceElement[] stacktrace = e.getStackTrace();
			final String location = stacktrace == null || stacktrace.length == 0 ? "Unknown (no stack trace)" : stacktrace[0].toString();
			logger.error("The user " + user.getUsername() + " was denied access to the neuroinfo:anatqc_imageResource/neuroinfo_anatqc_imageResource_id instance with ID " + value + ". Occurred at: " + location + "\n" + e.getMessage());
		} catch (Exception e) {
			logger.error("",e);
		}

		return null;
	}

	public static ArrayList wrapItems(ArrayList items)
	{
		ArrayList al = new ArrayList();
		al = org.nrg.xdat.base.BaseElement.WrapItems(items);
		al.trimToSize();
		return al;
	}

	public static ArrayList wrapItems(org.nrg.xft.collections.ItemCollection items)
	{
		return wrapItems(items.getItems());
	}
	public ArrayList<ResourceFile> getFileResources(String rootPath, boolean preventLoop){
ArrayList<ResourceFile> _return = new ArrayList<ResourceFile>();
	 boolean localLoop = preventLoop;
	        localLoop = preventLoop;
	
	return _return;
}
}
