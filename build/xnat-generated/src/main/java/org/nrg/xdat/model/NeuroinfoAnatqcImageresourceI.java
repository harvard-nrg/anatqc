/*
 * GENERATED FILE
 * Created on Thu Apr 01 09:57:06 GMT-05:00 2021
 *
 */
package org.nrg.xdat.model;

import java.util.List;

/**
 * @author XDAT
 *
 */
public interface NeuroinfoAnatqcImageresourceI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the label.
	 */
	public String getLabel();

	/**
	 * Sets the value for label.
	 * @param v Value to Set.
	 */
	public void setLabel(String v);

	/**
	 * @return Returns the uri.
	 */
	public String getUri();

	/**
	 * Sets the value for uri.
	 * @param v Value to Set.
	 */
	public void setUri(String v);

	/**
	 * @return Returns the neuroinfo_anatqc_imageResource_id.
	 */
	public Integer getNeuroinfoAnatqcImageresourceId();
}
