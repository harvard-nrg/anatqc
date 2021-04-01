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
public abstract class AutoNeuroinfoAnatqc extends XnatMrassessordata implements org.nrg.xdat.model.NeuroinfoAnatqcI {
	public static final Logger logger = Logger.getLogger(AutoNeuroinfoAnatqc.class);
	public static final String SCHEMA_ELEMENT_NAME="neuroinfo:anatqc";

	public AutoNeuroinfoAnatqc(ItemI item)
	{
		super(item);
	}

	public AutoNeuroinfoAnatqc(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoNeuroinfoAnatqc(UserI user)
	 **/
	public AutoNeuroinfoAnatqc(){}

	public AutoNeuroinfoAnatqc(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "neuroinfo:anatqc";
	}
	 private org.nrg.xdat.om.XnatMrassessordata _Mrassessordata =null;

	/**
	 * mrAssessorData
	 * @return org.nrg.xdat.om.XnatMrassessordata
	 */
	public org.nrg.xdat.om.XnatMrassessordata getMrassessordata() {
		try{
			if (_Mrassessordata==null){
				_Mrassessordata=((XnatMrassessordata)org.nrg.xdat.base.BaseElement.GetGeneratedItem((XFTItem)getProperty("mrAssessorData")));
				return _Mrassessordata;
			}else {
				return _Mrassessordata;
			}
		} catch (Exception e1) {return null;}
	}

	/**
	 * Sets the value for mrAssessorData.
	 * @param v Value to Set.
	 */
	public void setMrassessordata(ItemI v) throws Exception{
		_Mrassessordata =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/mrAssessorData",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/mrAssessorData",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * mrAssessorData
	 * set org.nrg.xdat.model.XnatMrassessordataI
	 */
	public <A extends org.nrg.xdat.model.XnatMrassessordataI> void setMrassessordata(A item) throws Exception{
	setMrassessordata((ItemI)item);
	}

	/**
	 * Removes the mrAssessorData.
	 * */
	public void removeMrassessordata() {
		_Mrassessordata =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/mrAssessorData",0);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
		catch (java.lang.IndexOutOfBoundsException e1) {logger.error(e1);}
	}

	//FIELD

	private String _T1wScanId=null;

	/**
	 * @return Returns the t1w_scan_id.
	 */
	public String getT1wScanId(){
		try{
			if (_T1wScanId==null){
				_T1wScanId=getStringProperty("t1w_scan_id");
				return _T1wScanId;
			}else {
				return _T1wScanId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for t1w_scan_id.
	 * @param v Value to Set.
	 */
	public void setT1wScanId(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/t1w_scan_id",v);
		_T1wScanId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _VnavScanId=null;

	/**
	 * @return Returns the vnav_scan_id.
	 */
	public String getVnavScanId(){
		try{
			if (_VnavScanId==null){
				_VnavScanId=getStringProperty("vnav_scan_id");
				return _VnavScanId;
			}else {
				return _VnavScanId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav_scan_id.
	 * @param v Value to Set.
	 */
	public void setVnavScanId(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav_scan_id",v);
		_VnavScanId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _SessionLabel=null;

	/**
	 * @return Returns the session_label.
	 */
	public String getSessionLabel(){
		try{
			if (_SessionLabel==null){
				_SessionLabel=getStringProperty("session_label");
				return _SessionLabel;
			}else {
				return _SessionLabel;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for session_label.
	 * @param v Value to Set.
	 */
	public void setSessionLabel(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/session_label",v);
		_SessionLabel=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_cjv=null;

	/**
	 * @return Returns the mriqc/cjv.
	 */
	public Object getMriqc_cjv(){
		try{
			if (_Mriqc_cjv==null){
				_Mriqc_cjv=getProperty("mriqc/cjv");
				return _Mriqc_cjv;
			}else {
				return _Mriqc_cjv;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/cjv.
	 * @param v Value to Set.
	 */
	public void setMriqc_cjv(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/cjv",v);
		_Mriqc_cjv=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_cnr=null;

	/**
	 * @return Returns the mriqc/cnr.
	 */
	public Object getMriqc_cnr(){
		try{
			if (_Mriqc_cnr==null){
				_Mriqc_cnr=getProperty("mriqc/cnr");
				return _Mriqc_cnr;
			}else {
				return _Mriqc_cnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/cnr.
	 * @param v Value to Set.
	 */
	public void setMriqc_cnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/cnr",v);
		_Mriqc_cnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_efc=null;

	/**
	 * @return Returns the mriqc/efc.
	 */
	public Object getMriqc_efc(){
		try{
			if (_Mriqc_efc==null){
				_Mriqc_efc=getProperty("mriqc/efc");
				return _Mriqc_efc;
			}else {
				return _Mriqc_efc;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/efc.
	 * @param v Value to Set.
	 */
	public void setMriqc_efc(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/efc",v);
		_Mriqc_efc=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_fber=null;

	/**
	 * @return Returns the mriqc/fber.
	 */
	public Object getMriqc_fber(){
		try{
			if (_Mriqc_fber==null){
				_Mriqc_fber=getProperty("mriqc/fber");
				return _Mriqc_fber;
			}else {
				return _Mriqc_fber;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/fber.
	 * @param v Value to Set.
	 */
	public void setMriqc_fber(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/fber",v);
		_Mriqc_fber=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_fwhmAvg=null;

	/**
	 * @return Returns the mriqc/fwhm_avg.
	 */
	public Object getMriqc_fwhmAvg(){
		try{
			if (_Mriqc_fwhmAvg==null){
				_Mriqc_fwhmAvg=getProperty("mriqc/fwhm_avg");
				return _Mriqc_fwhmAvg;
			}else {
				return _Mriqc_fwhmAvg;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/fwhm_avg.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmAvg(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/fwhm_avg",v);
		_Mriqc_fwhmAvg=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_fwhmX=null;

	/**
	 * @return Returns the mriqc/fwhm_x.
	 */
	public Object getMriqc_fwhmX(){
		try{
			if (_Mriqc_fwhmX==null){
				_Mriqc_fwhmX=getProperty("mriqc/fwhm_x");
				return _Mriqc_fwhmX;
			}else {
				return _Mriqc_fwhmX;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/fwhm_x.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmX(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/fwhm_x",v);
		_Mriqc_fwhmX=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_fwhmY=null;

	/**
	 * @return Returns the mriqc/fwhm_y.
	 */
	public Object getMriqc_fwhmY(){
		try{
			if (_Mriqc_fwhmY==null){
				_Mriqc_fwhmY=getProperty("mriqc/fwhm_y");
				return _Mriqc_fwhmY;
			}else {
				return _Mriqc_fwhmY;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/fwhm_y.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmY(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/fwhm_y",v);
		_Mriqc_fwhmY=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_fwhmZ=null;

	/**
	 * @return Returns the mriqc/fwhm_z.
	 */
	public Object getMriqc_fwhmZ(){
		try{
			if (_Mriqc_fwhmZ==null){
				_Mriqc_fwhmZ=getProperty("mriqc/fwhm_z");
				return _Mriqc_fwhmZ;
			}else {
				return _Mriqc_fwhmZ;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/fwhm_z.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmZ(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/fwhm_z",v);
		_Mriqc_fwhmZ=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_icvsCsf=null;

	/**
	 * @return Returns the mriqc/icvs_csf.
	 */
	public Object getMriqc_icvsCsf(){
		try{
			if (_Mriqc_icvsCsf==null){
				_Mriqc_icvsCsf=getProperty("mriqc/icvs_csf");
				return _Mriqc_icvsCsf;
			}else {
				return _Mriqc_icvsCsf;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/icvs_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_icvsCsf(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/icvs_csf",v);
		_Mriqc_icvsCsf=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_icvsGm=null;

	/**
	 * @return Returns the mriqc/icvs_gm.
	 */
	public Object getMriqc_icvsGm(){
		try{
			if (_Mriqc_icvsGm==null){
				_Mriqc_icvsGm=getProperty("mriqc/icvs_gm");
				return _Mriqc_icvsGm;
			}else {
				return _Mriqc_icvsGm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/icvs_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_icvsGm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/icvs_gm",v);
		_Mriqc_icvsGm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_icvsWm=null;

	/**
	 * @return Returns the mriqc/icvs_wm.
	 */
	public Object getMriqc_icvsWm(){
		try{
			if (_Mriqc_icvsWm==null){
				_Mriqc_icvsWm=getProperty("mriqc/icvs_wm");
				return _Mriqc_icvsWm;
			}else {
				return _Mriqc_icvsWm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/icvs_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_icvsWm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/icvs_wm",v);
		_Mriqc_icvsWm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_inuMed=null;

	/**
	 * @return Returns the mriqc/inu_med.
	 */
	public Object getMriqc_inuMed(){
		try{
			if (_Mriqc_inuMed==null){
				_Mriqc_inuMed=getProperty("mriqc/inu_med");
				return _Mriqc_inuMed;
			}else {
				return _Mriqc_inuMed;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/inu_med.
	 * @param v Value to Set.
	 */
	public void setMriqc_inuMed(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/inu_med",v);
		_Mriqc_inuMed=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_inuRange=null;

	/**
	 * @return Returns the mriqc/inu_range.
	 */
	public Object getMriqc_inuRange(){
		try{
			if (_Mriqc_inuRange==null){
				_Mriqc_inuRange=getProperty("mriqc/inu_range");
				return _Mriqc_inuRange;
			}else {
				return _Mriqc_inuRange;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/inu_range.
	 * @param v Value to Set.
	 */
	public void setMriqc_inuRange(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/inu_range",v);
		_Mriqc_inuRange=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_qi1=null;

	/**
	 * @return Returns the mriqc/qi_1.
	 */
	public Object getMriqc_qi1(){
		try{
			if (_Mriqc_qi1==null){
				_Mriqc_qi1=getProperty("mriqc/qi_1");
				return _Mriqc_qi1;
			}else {
				return _Mriqc_qi1;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/qi_1.
	 * @param v Value to Set.
	 */
	public void setMriqc_qi1(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/qi_1",v);
		_Mriqc_qi1=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_qi2=null;

	/**
	 * @return Returns the mriqc/qi_2.
	 */
	public Object getMriqc_qi2(){
		try{
			if (_Mriqc_qi2==null){
				_Mriqc_qi2=getProperty("mriqc/qi_2");
				return _Mriqc_qi2;
			}else {
				return _Mriqc_qi2;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/qi_2.
	 * @param v Value to Set.
	 */
	public void setMriqc_qi2(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/qi_2",v);
		_Mriqc_qi2=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_rpveCsf=null;

	/**
	 * @return Returns the mriqc/rpve_csf.
	 */
	public Object getMriqc_rpveCsf(){
		try{
			if (_Mriqc_rpveCsf==null){
				_Mriqc_rpveCsf=getProperty("mriqc/rpve_csf");
				return _Mriqc_rpveCsf;
			}else {
				return _Mriqc_rpveCsf;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/rpve_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_rpveCsf(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/rpve_csf",v);
		_Mriqc_rpveCsf=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_rpveGm=null;

	/**
	 * @return Returns the mriqc/rpve_gm.
	 */
	public Object getMriqc_rpveGm(){
		try{
			if (_Mriqc_rpveGm==null){
				_Mriqc_rpveGm=getProperty("mriqc/rpve_gm");
				return _Mriqc_rpveGm;
			}else {
				return _Mriqc_rpveGm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/rpve_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_rpveGm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/rpve_gm",v);
		_Mriqc_rpveGm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_rpveWm=null;

	/**
	 * @return Returns the mriqc/rpve_wm.
	 */
	public Object getMriqc_rpveWm(){
		try{
			if (_Mriqc_rpveWm==null){
				_Mriqc_rpveWm=getProperty("mriqc/rpve_wm");
				return _Mriqc_rpveWm;
			}else {
				return _Mriqc_rpveWm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/rpve_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_rpveWm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/rpve_wm",v);
		_Mriqc_rpveWm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_sizeX=null;

	/**
	 * @return Returns the mriqc/size_x.
	 */
	public Object getMriqc_sizeX(){
		try{
			if (_Mriqc_sizeX==null){
				_Mriqc_sizeX=getProperty("mriqc/size_x");
				return _Mriqc_sizeX;
			}else {
				return _Mriqc_sizeX;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/size_x.
	 * @param v Value to Set.
	 */
	public void setMriqc_sizeX(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/size_x",v);
		_Mriqc_sizeX=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_sizeY=null;

	/**
	 * @return Returns the mriqc/size_y.
	 */
	public Object getMriqc_sizeY(){
		try{
			if (_Mriqc_sizeY==null){
				_Mriqc_sizeY=getProperty("mriqc/size_y");
				return _Mriqc_sizeY;
			}else {
				return _Mriqc_sizeY;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/size_y.
	 * @param v Value to Set.
	 */
	public void setMriqc_sizeY(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/size_y",v);
		_Mriqc_sizeY=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_sizeZ=null;

	/**
	 * @return Returns the mriqc/size_z.
	 */
	public Object getMriqc_sizeZ(){
		try{
			if (_Mriqc_sizeZ==null){
				_Mriqc_sizeZ=getProperty("mriqc/size_z");
				return _Mriqc_sizeZ;
			}else {
				return _Mriqc_sizeZ;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/size_z.
	 * @param v Value to Set.
	 */
	public void setMriqc_sizeZ(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/size_z",v);
		_Mriqc_sizeZ=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrCsf=null;

	/**
	 * @return Returns the mriqc/snr_csf.
	 */
	public Object getMriqc_snrCsf(){
		try{
			if (_Mriqc_snrCsf==null){
				_Mriqc_snrCsf=getProperty("mriqc/snr_csf");
				return _Mriqc_snrCsf;
			}else {
				return _Mriqc_snrCsf;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snr_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrCsf(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snr_csf",v);
		_Mriqc_snrCsf=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrGm=null;

	/**
	 * @return Returns the mriqc/snr_gm.
	 */
	public Object getMriqc_snrGm(){
		try{
			if (_Mriqc_snrGm==null){
				_Mriqc_snrGm=getProperty("mriqc/snr_gm");
				return _Mriqc_snrGm;
			}else {
				return _Mriqc_snrGm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snr_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrGm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snr_gm",v);
		_Mriqc_snrGm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrTotal=null;

	/**
	 * @return Returns the mriqc/snr_total.
	 */
	public Object getMriqc_snrTotal(){
		try{
			if (_Mriqc_snrTotal==null){
				_Mriqc_snrTotal=getProperty("mriqc/snr_total");
				return _Mriqc_snrTotal;
			}else {
				return _Mriqc_snrTotal;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snr_total.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrTotal(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snr_total",v);
		_Mriqc_snrTotal=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrWm=null;

	/**
	 * @return Returns the mriqc/snr_wm.
	 */
	public Object getMriqc_snrWm(){
		try{
			if (_Mriqc_snrWm==null){
				_Mriqc_snrWm=getProperty("mriqc/snr_wm");
				return _Mriqc_snrWm;
			}else {
				return _Mriqc_snrWm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snr_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrWm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snr_wm",v);
		_Mriqc_snrWm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrdCsf=null;

	/**
	 * @return Returns the mriqc/snrd_csf.
	 */
	public Object getMriqc_snrdCsf(){
		try{
			if (_Mriqc_snrdCsf==null){
				_Mriqc_snrdCsf=getProperty("mriqc/snrd_csf");
				return _Mriqc_snrdCsf;
			}else {
				return _Mriqc_snrdCsf;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snrd_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdCsf(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snrd_csf",v);
		_Mriqc_snrdCsf=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrdGm=null;

	/**
	 * @return Returns the mriqc/snrd_gm.
	 */
	public Object getMriqc_snrdGm(){
		try{
			if (_Mriqc_snrdGm==null){
				_Mriqc_snrdGm=getProperty("mriqc/snrd_gm");
				return _Mriqc_snrdGm;
			}else {
				return _Mriqc_snrdGm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snrd_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdGm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snrd_gm",v);
		_Mriqc_snrdGm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrdTotal=null;

	/**
	 * @return Returns the mriqc/snrd_total.
	 */
	public Object getMriqc_snrdTotal(){
		try{
			if (_Mriqc_snrdTotal==null){
				_Mriqc_snrdTotal=getProperty("mriqc/snrd_total");
				return _Mriqc_snrdTotal;
			}else {
				return _Mriqc_snrdTotal;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snrd_total.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdTotal(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snrd_total",v);
		_Mriqc_snrdTotal=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_snrdWm=null;

	/**
	 * @return Returns the mriqc/snrd_wm.
	 */
	public Object getMriqc_snrdWm(){
		try{
			if (_Mriqc_snrdWm==null){
				_Mriqc_snrdWm=getProperty("mriqc/snrd_wm");
				return _Mriqc_snrdWm;
			}else {
				return _Mriqc_snrdWm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/snrd_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdWm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/snrd_wm",v);
		_Mriqc_snrdWm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_spacingX=null;

	/**
	 * @return Returns the mriqc/spacing_x.
	 */
	public Object getMriqc_spacingX(){
		try{
			if (_Mriqc_spacingX==null){
				_Mriqc_spacingX=getProperty("mriqc/spacing_x");
				return _Mriqc_spacingX;
			}else {
				return _Mriqc_spacingX;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/spacing_x.
	 * @param v Value to Set.
	 */
	public void setMriqc_spacingX(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/spacing_x",v);
		_Mriqc_spacingX=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_spacingY=null;

	/**
	 * @return Returns the mriqc/spacing_y.
	 */
	public Object getMriqc_spacingY(){
		try{
			if (_Mriqc_spacingY==null){
				_Mriqc_spacingY=getProperty("mriqc/spacing_y");
				return _Mriqc_spacingY;
			}else {
				return _Mriqc_spacingY;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/spacing_y.
	 * @param v Value to Set.
	 */
	public void setMriqc_spacingY(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/spacing_y",v);
		_Mriqc_spacingY=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_spacingZ=null;

	/**
	 * @return Returns the mriqc/spacing_z.
	 */
	public Object getMriqc_spacingZ(){
		try{
			if (_Mriqc_spacingZ==null){
				_Mriqc_spacingZ=getProperty("mriqc/spacing_z");
				return _Mriqc_spacingZ;
			}else {
				return _Mriqc_spacingZ;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/spacing_z.
	 * @param v Value to Set.
	 */
	public void setMriqc_spacingZ(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/spacing_z",v);
		_Mriqc_spacingZ=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgK=null;

	/**
	 * @return Returns the mriqc/summary_bg_k.
	 */
	public Object getMriqc_summaryBgK(){
		try{
			if (_Mriqc_summaryBgK==null){
				_Mriqc_summaryBgK=getProperty("mriqc/summary_bg_k");
				return _Mriqc_summaryBgK;
			}else {
				return _Mriqc_summaryBgK;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgK(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_k",v);
		_Mriqc_summaryBgK=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgMad=null;

	/**
	 * @return Returns the mriqc/summary_bg_mad.
	 */
	public Object getMriqc_summaryBgMad(){
		try{
			if (_Mriqc_summaryBgMad==null){
				_Mriqc_summaryBgMad=getProperty("mriqc/summary_bg_mad");
				return _Mriqc_summaryBgMad;
			}else {
				return _Mriqc_summaryBgMad;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgMad(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_mad",v);
		_Mriqc_summaryBgMad=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgMean=null;

	/**
	 * @return Returns the mriqc/summary_bg_mean.
	 */
	public Object getMriqc_summaryBgMean(){
		try{
			if (_Mriqc_summaryBgMean==null){
				_Mriqc_summaryBgMean=getProperty("mriqc/summary_bg_mean");
				return _Mriqc_summaryBgMean;
			}else {
				return _Mriqc_summaryBgMean;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgMean(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_mean",v);
		_Mriqc_summaryBgMean=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgMedian=null;

	/**
	 * @return Returns the mriqc/summary_bg_median.
	 */
	public Object getMriqc_summaryBgMedian(){
		try{
			if (_Mriqc_summaryBgMedian==null){
				_Mriqc_summaryBgMedian=getProperty("mriqc/summary_bg_median");
				return _Mriqc_summaryBgMedian;
			}else {
				return _Mriqc_summaryBgMedian;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgMedian(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_median",v);
		_Mriqc_summaryBgMedian=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgN=null;

	/**
	 * @return Returns the mriqc/summary_bg_n.
	 */
	public Object getMriqc_summaryBgN(){
		try{
			if (_Mriqc_summaryBgN==null){
				_Mriqc_summaryBgN=getProperty("mriqc/summary_bg_n");
				return _Mriqc_summaryBgN;
			}else {
				return _Mriqc_summaryBgN;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgN(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_n",v);
		_Mriqc_summaryBgN=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgP05=null;

	/**
	 * @return Returns the mriqc/summary_bg_p05.
	 */
	public Object getMriqc_summaryBgP05(){
		try{
			if (_Mriqc_summaryBgP05==null){
				_Mriqc_summaryBgP05=getProperty("mriqc/summary_bg_p05");
				return _Mriqc_summaryBgP05;
			}else {
				return _Mriqc_summaryBgP05;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgP05(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_p05",v);
		_Mriqc_summaryBgP05=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgP95=null;

	/**
	 * @return Returns the mriqc/summary_bg_p95.
	 */
	public Object getMriqc_summaryBgP95(){
		try{
			if (_Mriqc_summaryBgP95==null){
				_Mriqc_summaryBgP95=getProperty("mriqc/summary_bg_p95");
				return _Mriqc_summaryBgP95;
			}else {
				return _Mriqc_summaryBgP95;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgP95(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_p95",v);
		_Mriqc_summaryBgP95=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryBgStdv=null;

	/**
	 * @return Returns the mriqc/summary_bg_stdv.
	 */
	public Object getMriqc_summaryBgStdv(){
		try{
			if (_Mriqc_summaryBgStdv==null){
				_Mriqc_summaryBgStdv=getProperty("mriqc/summary_bg_stdv");
				return _Mriqc_summaryBgStdv;
			}else {
				return _Mriqc_summaryBgStdv;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_bg_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgStdv(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_bg_stdv",v);
		_Mriqc_summaryBgStdv=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfK=null;

	/**
	 * @return Returns the mriqc/summary_csf_k.
	 */
	public Object getMriqc_summaryCsfK(){
		try{
			if (_Mriqc_summaryCsfK==null){
				_Mriqc_summaryCsfK=getProperty("mriqc/summary_csf_k");
				return _Mriqc_summaryCsfK;
			}else {
				return _Mriqc_summaryCsfK;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfK(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_k",v);
		_Mriqc_summaryCsfK=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfMad=null;

	/**
	 * @return Returns the mriqc/summary_csf_mad.
	 */
	public Object getMriqc_summaryCsfMad(){
		try{
			if (_Mriqc_summaryCsfMad==null){
				_Mriqc_summaryCsfMad=getProperty("mriqc/summary_csf_mad");
				return _Mriqc_summaryCsfMad;
			}else {
				return _Mriqc_summaryCsfMad;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfMad(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_mad",v);
		_Mriqc_summaryCsfMad=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfMean=null;

	/**
	 * @return Returns the mriqc/summary_csf_mean.
	 */
	public Object getMriqc_summaryCsfMean(){
		try{
			if (_Mriqc_summaryCsfMean==null){
				_Mriqc_summaryCsfMean=getProperty("mriqc/summary_csf_mean");
				return _Mriqc_summaryCsfMean;
			}else {
				return _Mriqc_summaryCsfMean;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfMean(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_mean",v);
		_Mriqc_summaryCsfMean=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfMedian=null;

	/**
	 * @return Returns the mriqc/summary_csf_median.
	 */
	public Object getMriqc_summaryCsfMedian(){
		try{
			if (_Mriqc_summaryCsfMedian==null){
				_Mriqc_summaryCsfMedian=getProperty("mriqc/summary_csf_median");
				return _Mriqc_summaryCsfMedian;
			}else {
				return _Mriqc_summaryCsfMedian;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfMedian(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_median",v);
		_Mriqc_summaryCsfMedian=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfN=null;

	/**
	 * @return Returns the mriqc/summary_csf_n.
	 */
	public Object getMriqc_summaryCsfN(){
		try{
			if (_Mriqc_summaryCsfN==null){
				_Mriqc_summaryCsfN=getProperty("mriqc/summary_csf_n");
				return _Mriqc_summaryCsfN;
			}else {
				return _Mriqc_summaryCsfN;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfN(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_n",v);
		_Mriqc_summaryCsfN=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfP05=null;

	/**
	 * @return Returns the mriqc/summary_csf_p05.
	 */
	public Object getMriqc_summaryCsfP05(){
		try{
			if (_Mriqc_summaryCsfP05==null){
				_Mriqc_summaryCsfP05=getProperty("mriqc/summary_csf_p05");
				return _Mriqc_summaryCsfP05;
			}else {
				return _Mriqc_summaryCsfP05;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfP05(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_p05",v);
		_Mriqc_summaryCsfP05=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfP95=null;

	/**
	 * @return Returns the mriqc/summary_csf_p95.
	 */
	public Object getMriqc_summaryCsfP95(){
		try{
			if (_Mriqc_summaryCsfP95==null){
				_Mriqc_summaryCsfP95=getProperty("mriqc/summary_csf_p95");
				return _Mriqc_summaryCsfP95;
			}else {
				return _Mriqc_summaryCsfP95;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfP95(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_p95",v);
		_Mriqc_summaryCsfP95=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryCsfStdv=null;

	/**
	 * @return Returns the mriqc/summary_csf_stdv.
	 */
	public Object getMriqc_summaryCsfStdv(){
		try{
			if (_Mriqc_summaryCsfStdv==null){
				_Mriqc_summaryCsfStdv=getProperty("mriqc/summary_csf_stdv");
				return _Mriqc_summaryCsfStdv;
			}else {
				return _Mriqc_summaryCsfStdv;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_csf_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfStdv(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_csf_stdv",v);
		_Mriqc_summaryCsfStdv=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmK=null;

	/**
	 * @return Returns the mriqc/summary_gm_k.
	 */
	public Object getMriqc_summaryGmK(){
		try{
			if (_Mriqc_summaryGmK==null){
				_Mriqc_summaryGmK=getProperty("mriqc/summary_gm_k");
				return _Mriqc_summaryGmK;
			}else {
				return _Mriqc_summaryGmK;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmK(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_k",v);
		_Mriqc_summaryGmK=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmMad=null;

	/**
	 * @return Returns the mriqc/summary_gm_mad.
	 */
	public Object getMriqc_summaryGmMad(){
		try{
			if (_Mriqc_summaryGmMad==null){
				_Mriqc_summaryGmMad=getProperty("mriqc/summary_gm_mad");
				return _Mriqc_summaryGmMad;
			}else {
				return _Mriqc_summaryGmMad;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmMad(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_mad",v);
		_Mriqc_summaryGmMad=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmMean=null;

	/**
	 * @return Returns the mriqc/summary_gm_mean.
	 */
	public Object getMriqc_summaryGmMean(){
		try{
			if (_Mriqc_summaryGmMean==null){
				_Mriqc_summaryGmMean=getProperty("mriqc/summary_gm_mean");
				return _Mriqc_summaryGmMean;
			}else {
				return _Mriqc_summaryGmMean;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmMean(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_mean",v);
		_Mriqc_summaryGmMean=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmMedian=null;

	/**
	 * @return Returns the mriqc/summary_gm_median.
	 */
	public Object getMriqc_summaryGmMedian(){
		try{
			if (_Mriqc_summaryGmMedian==null){
				_Mriqc_summaryGmMedian=getProperty("mriqc/summary_gm_median");
				return _Mriqc_summaryGmMedian;
			}else {
				return _Mriqc_summaryGmMedian;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmMedian(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_median",v);
		_Mriqc_summaryGmMedian=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmN=null;

	/**
	 * @return Returns the mriqc/summary_gm_n.
	 */
	public Object getMriqc_summaryGmN(){
		try{
			if (_Mriqc_summaryGmN==null){
				_Mriqc_summaryGmN=getProperty("mriqc/summary_gm_n");
				return _Mriqc_summaryGmN;
			}else {
				return _Mriqc_summaryGmN;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmN(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_n",v);
		_Mriqc_summaryGmN=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmP05=null;

	/**
	 * @return Returns the mriqc/summary_gm_p05.
	 */
	public Object getMriqc_summaryGmP05(){
		try{
			if (_Mriqc_summaryGmP05==null){
				_Mriqc_summaryGmP05=getProperty("mriqc/summary_gm_p05");
				return _Mriqc_summaryGmP05;
			}else {
				return _Mriqc_summaryGmP05;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmP05(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_p05",v);
		_Mriqc_summaryGmP05=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmP95=null;

	/**
	 * @return Returns the mriqc/summary_gm_p95.
	 */
	public Object getMriqc_summaryGmP95(){
		try{
			if (_Mriqc_summaryGmP95==null){
				_Mriqc_summaryGmP95=getProperty("mriqc/summary_gm_p95");
				return _Mriqc_summaryGmP95;
			}else {
				return _Mriqc_summaryGmP95;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmP95(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_p95",v);
		_Mriqc_summaryGmP95=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryGmStdv=null;

	/**
	 * @return Returns the mriqc/summary_gm_stdv.
	 */
	public Object getMriqc_summaryGmStdv(){
		try{
			if (_Mriqc_summaryGmStdv==null){
				_Mriqc_summaryGmStdv=getProperty("mriqc/summary_gm_stdv");
				return _Mriqc_summaryGmStdv;
			}else {
				return _Mriqc_summaryGmStdv;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_gm_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmStdv(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_gm_stdv",v);
		_Mriqc_summaryGmStdv=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmK=null;

	/**
	 * @return Returns the mriqc/summary_wm_k.
	 */
	public Object getMriqc_summaryWmK(){
		try{
			if (_Mriqc_summaryWmK==null){
				_Mriqc_summaryWmK=getProperty("mriqc/summary_wm_k");
				return _Mriqc_summaryWmK;
			}else {
				return _Mriqc_summaryWmK;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmK(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_k",v);
		_Mriqc_summaryWmK=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmMad=null;

	/**
	 * @return Returns the mriqc/summary_wm_mad.
	 */
	public Object getMriqc_summaryWmMad(){
		try{
			if (_Mriqc_summaryWmMad==null){
				_Mriqc_summaryWmMad=getProperty("mriqc/summary_wm_mad");
				return _Mriqc_summaryWmMad;
			}else {
				return _Mriqc_summaryWmMad;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmMad(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_mad",v);
		_Mriqc_summaryWmMad=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmMean=null;

	/**
	 * @return Returns the mriqc/summary_wm_mean.
	 */
	public Object getMriqc_summaryWmMean(){
		try{
			if (_Mriqc_summaryWmMean==null){
				_Mriqc_summaryWmMean=getProperty("mriqc/summary_wm_mean");
				return _Mriqc_summaryWmMean;
			}else {
				return _Mriqc_summaryWmMean;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmMean(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_mean",v);
		_Mriqc_summaryWmMean=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmMedian=null;

	/**
	 * @return Returns the mriqc/summary_wm_median.
	 */
	public Object getMriqc_summaryWmMedian(){
		try{
			if (_Mriqc_summaryWmMedian==null){
				_Mriqc_summaryWmMedian=getProperty("mriqc/summary_wm_median");
				return _Mriqc_summaryWmMedian;
			}else {
				return _Mriqc_summaryWmMedian;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmMedian(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_median",v);
		_Mriqc_summaryWmMedian=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmN=null;

	/**
	 * @return Returns the mriqc/summary_wm_n.
	 */
	public Object getMriqc_summaryWmN(){
		try{
			if (_Mriqc_summaryWmN==null){
				_Mriqc_summaryWmN=getProperty("mriqc/summary_wm_n");
				return _Mriqc_summaryWmN;
			}else {
				return _Mriqc_summaryWmN;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmN(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_n",v);
		_Mriqc_summaryWmN=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmP05=null;

	/**
	 * @return Returns the mriqc/summary_wm_p05.
	 */
	public Object getMriqc_summaryWmP05(){
		try{
			if (_Mriqc_summaryWmP05==null){
				_Mriqc_summaryWmP05=getProperty("mriqc/summary_wm_p05");
				return _Mriqc_summaryWmP05;
			}else {
				return _Mriqc_summaryWmP05;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmP05(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_p05",v);
		_Mriqc_summaryWmP05=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmP95=null;

	/**
	 * @return Returns the mriqc/summary_wm_p95.
	 */
	public Object getMriqc_summaryWmP95(){
		try{
			if (_Mriqc_summaryWmP95==null){
				_Mriqc_summaryWmP95=getProperty("mriqc/summary_wm_p95");
				return _Mriqc_summaryWmP95;
			}else {
				return _Mriqc_summaryWmP95;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmP95(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_p95",v);
		_Mriqc_summaryWmP95=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_summaryWmStdv=null;

	/**
	 * @return Returns the mriqc/summary_wm_stdv.
	 */
	public Object getMriqc_summaryWmStdv(){
		try{
			if (_Mriqc_summaryWmStdv==null){
				_Mriqc_summaryWmStdv=getProperty("mriqc/summary_wm_stdv");
				return _Mriqc_summaryWmStdv;
			}else {
				return _Mriqc_summaryWmStdv;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/summary_wm_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmStdv(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/summary_wm_stdv",v);
		_Mriqc_summaryWmStdv=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_tpmOverlapCsf=null;

	/**
	 * @return Returns the mriqc/tpm_overlap_csf.
	 */
	public Object getMriqc_tpmOverlapCsf(){
		try{
			if (_Mriqc_tpmOverlapCsf==null){
				_Mriqc_tpmOverlapCsf=getProperty("mriqc/tpm_overlap_csf");
				return _Mriqc_tpmOverlapCsf;
			}else {
				return _Mriqc_tpmOverlapCsf;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/tpm_overlap_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_tpmOverlapCsf(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/tpm_overlap_csf",v);
		_Mriqc_tpmOverlapCsf=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_tpmOverlapGm=null;

	/**
	 * @return Returns the mriqc/tpm_overlap_gm.
	 */
	public Object getMriqc_tpmOverlapGm(){
		try{
			if (_Mriqc_tpmOverlapGm==null){
				_Mriqc_tpmOverlapGm=getProperty("mriqc/tpm_overlap_gm");
				return _Mriqc_tpmOverlapGm;
			}else {
				return _Mriqc_tpmOverlapGm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/tpm_overlap_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_tpmOverlapGm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/tpm_overlap_gm",v);
		_Mriqc_tpmOverlapGm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_tpmOverlapWm=null;

	/**
	 * @return Returns the mriqc/tpm_overlap_wm.
	 */
	public Object getMriqc_tpmOverlapWm(){
		try{
			if (_Mriqc_tpmOverlapWm==null){
				_Mriqc_tpmOverlapWm=getProperty("mriqc/tpm_overlap_wm");
				return _Mriqc_tpmOverlapWm;
			}else {
				return _Mriqc_tpmOverlapWm;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/tpm_overlap_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_tpmOverlapWm(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/tpm_overlap_wm",v);
		_Mriqc_tpmOverlapWm=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Mriqc_wm2max=null;

	/**
	 * @return Returns the mriqc/wm2max.
	 */
	public Object getMriqc_wm2max(){
		try{
			if (_Mriqc_wm2max==null){
				_Mriqc_wm2max=getProperty("mriqc/wm2max");
				return _Mriqc_wm2max;
			}else {
				return _Mriqc_wm2max;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for mriqc/wm2max.
	 * @param v Value to Set.
	 */
	public void setMriqc_wm2max(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/mriqc/wm2max",v);
		_Mriqc_wm2max=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_mriCnrTot=null;

	/**
	 * @return Returns the morph/mri_cnr_tot.
	 */
	public Object getMorph_mriCnrTot(){
		try{
			if (_Morph_mriCnrTot==null){
				_Morph_mriCnrTot=getProperty("morph/mri_cnr_tot");
				return _Morph_mriCnrTot;
			}else {
				return _Morph_mriCnrTot;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/mri_cnr_tot.
	 * @param v Value to Set.
	 */
	public void setMorph_mriCnrTot(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/mri_cnr_tot",v);
		_Morph_mriCnrTot=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_wmAnatSnr=null;

	/**
	 * @return Returns the morph/wm_anat_snr.
	 */
	public Object getMorph_wmAnatSnr(){
		try{
			if (_Morph_wmAnatSnr==null){
				_Morph_wmAnatSnr=getProperty("morph/wm_anat_snr");
				return _Morph_wmAnatSnr;
			}else {
				return _Morph_wmAnatSnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/wm_anat_snr.
	 * @param v Value to Set.
	 */
	public void setMorph_wmAnatSnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/wm_anat_snr",v);
		_Morph_wmAnatSnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Morph_lhEulerHoles=null;

	/**
	 * @return Returns the morph/lh_euler_holes.
	 */
	public Integer getMorph_lhEulerHoles() {
		try{
			if (_Morph_lhEulerHoles==null){
				_Morph_lhEulerHoles=getIntegerProperty("morph/lh_euler_holes");
				return _Morph_lhEulerHoles;
			}else {
				return _Morph_lhEulerHoles;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/lh_euler_holes.
	 * @param v Value to Set.
	 */
	public void setMorph_lhEulerHoles(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/lh_euler_holes",v);
		_Morph_lhEulerHoles=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_lhCnr=null;

	/**
	 * @return Returns the morph/lh_cnr.
	 */
	public Object getMorph_lhCnr(){
		try{
			if (_Morph_lhCnr==null){
				_Morph_lhCnr=getProperty("morph/lh_cnr");
				return _Morph_lhCnr;
			}else {
				return _Morph_lhCnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/lh_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_lhCnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/lh_cnr",v);
		_Morph_lhCnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_lhGmWmCnr=null;

	/**
	 * @return Returns the morph/lh_gm_wm_cnr.
	 */
	public Object getMorph_lhGmWmCnr(){
		try{
			if (_Morph_lhGmWmCnr==null){
				_Morph_lhGmWmCnr=getProperty("morph/lh_gm_wm_cnr");
				return _Morph_lhGmWmCnr;
			}else {
				return _Morph_lhGmWmCnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/lh_gm_wm_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_lhGmWmCnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/lh_gm_wm_cnr",v);
		_Morph_lhGmWmCnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_lhGmCsfCnr=null;

	/**
	 * @return Returns the morph/lh_gm_csf_cnr.
	 */
	public Object getMorph_lhGmCsfCnr(){
		try{
			if (_Morph_lhGmCsfCnr==null){
				_Morph_lhGmCsfCnr=getProperty("morph/lh_gm_csf_cnr");
				return _Morph_lhGmCsfCnr;
			}else {
				return _Morph_lhGmCsfCnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/lh_gm_csf_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_lhGmCsfCnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/lh_gm_csf_cnr",v);
		_Morph_lhGmCsfCnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Morph_rhEulerHoles=null;

	/**
	 * @return Returns the morph/rh_euler_holes.
	 */
	public Integer getMorph_rhEulerHoles() {
		try{
			if (_Morph_rhEulerHoles==null){
				_Morph_rhEulerHoles=getIntegerProperty("morph/rh_euler_holes");
				return _Morph_rhEulerHoles;
			}else {
				return _Morph_rhEulerHoles;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/rh_euler_holes.
	 * @param v Value to Set.
	 */
	public void setMorph_rhEulerHoles(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/rh_euler_holes",v);
		_Morph_rhEulerHoles=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_rhCnr=null;

	/**
	 * @return Returns the morph/rh_cnr.
	 */
	public Object getMorph_rhCnr(){
		try{
			if (_Morph_rhCnr==null){
				_Morph_rhCnr=getProperty("morph/rh_cnr");
				return _Morph_rhCnr;
			}else {
				return _Morph_rhCnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/rh_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_rhCnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/rh_cnr",v);
		_Morph_rhCnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_rhGmWmCnr=null;

	/**
	 * @return Returns the morph/rh_gm_wm_cnr.
	 */
	public Object getMorph_rhGmWmCnr(){
		try{
			if (_Morph_rhGmWmCnr==null){
				_Morph_rhGmWmCnr=getProperty("morph/rh_gm_wm_cnr");
				return _Morph_rhGmWmCnr;
			}else {
				return _Morph_rhGmWmCnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/rh_gm_wm_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_rhGmWmCnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/rh_gm_wm_cnr",v);
		_Morph_rhGmWmCnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Morph_rhGmCsfCnr=null;

	/**
	 * @return Returns the morph/rh_gm_csf_cnr.
	 */
	public Object getMorph_rhGmCsfCnr(){
		try{
			if (_Morph_rhGmCsfCnr==null){
				_Morph_rhGmCsfCnr=getProperty("morph/rh_gm_csf_cnr");
				return _Morph_rhGmCsfCnr;
			}else {
				return _Morph_rhGmCsfCnr;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for morph/rh_gm_csf_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_rhGmCsfCnr(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/morph/rh_gm_csf_cnr",v);
		_Morph_rhGmCsfCnr=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Vnav_vnavMin=null;

	/**
	 * @return Returns the vnav/vnav_min.
	 */
	public Integer getVnav_vnavMin() {
		try{
			if (_Vnav_vnavMin==null){
				_Vnav_vnavMin=getIntegerProperty("vnav/vnav_min");
				return _Vnav_vnavMin;
			}else {
				return _Vnav_vnavMin;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav/vnav_min.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavMin(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav/vnav_min",v);
		_Vnav_vnavMin=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Vnav_vnavMax=null;

	/**
	 * @return Returns the vnav/vnav_max.
	 */
	public Integer getVnav_vnavMax() {
		try{
			if (_Vnav_vnavMax==null){
				_Vnav_vnavMax=getIntegerProperty("vnav/vnav_max");
				return _Vnav_vnavMax;
			}else {
				return _Vnav_vnavMax;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav/vnav_max.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavMax(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav/vnav_max",v);
		_Vnav_vnavMax=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Vnav_vnavAcqTot=null;

	/**
	 * @return Returns the vnav/vnav_acq_tot.
	 */
	public Integer getVnav_vnavAcqTot() {
		try{
			if (_Vnav_vnavAcqTot==null){
				_Vnav_vnavAcqTot=getIntegerProperty("vnav/vnav_acq_tot");
				return _Vnav_vnavAcqTot;
			}else {
				return _Vnav_vnavAcqTot;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav/vnav_acq_tot.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavAcqTot(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav/vnav_acq_tot",v);
		_Vnav_vnavAcqTot=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Vnav_vnavReacq=null;

	/**
	 * @return Returns the vnav/vnav_reacq.
	 */
	public Integer getVnav_vnavReacq() {
		try{
			if (_Vnav_vnavReacq==null){
				_Vnav_vnavReacq=getIntegerProperty("vnav/vnav_reacq");
				return _Vnav_vnavReacq;
			}else {
				return _Vnav_vnavReacq;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav/vnav_reacq.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavReacq(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav/vnav_reacq",v);
		_Vnav_vnavReacq=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Vnav_meanMotRmsPerMin=null;

	/**
	 * @return Returns the vnav/mean_mot_rms_per_min.
	 */
	public Object getVnav_meanMotRmsPerMin(){
		try{
			if (_Vnav_meanMotRmsPerMin==null){
				_Vnav_meanMotRmsPerMin=getProperty("vnav/mean_mot_rms_per_min");
				return _Vnav_meanMotRmsPerMin;
			}else {
				return _Vnav_meanMotRmsPerMin;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav/mean_mot_rms_per_min.
	 * @param v Value to Set.
	 */
	public void setVnav_meanMotRmsPerMin(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav/mean_mot_rms_per_min",v);
		_Vnav_meanMotRmsPerMin=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Vnav_meanMotMaxPerMin=null;

	/**
	 * @return Returns the vnav/mean_mot_max_per_min.
	 */
	public Object getVnav_meanMotMaxPerMin(){
		try{
			if (_Vnav_meanMotMaxPerMin==null){
				_Vnav_meanMotMaxPerMin=getProperty("vnav/mean_mot_max_per_min");
				return _Vnav_meanMotMaxPerMin;
			}else {
				return _Vnav_meanMotMaxPerMin;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav/mean_mot_max_per_min.
	 * @param v Value to Set.
	 */
	public void setVnav_meanMotMaxPerMin(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav/mean_mot_max_per_min",v);
		_Vnav_meanMotMaxPerMin=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Vnav_vnavFailed=null;

	/**
	 * @return Returns the vnav/vnav_failed.
	 */
	public Integer getVnav_vnavFailed() {
		try{
			if (_Vnav_vnavFailed==null){
				_Vnav_vnavFailed=getIntegerProperty("vnav/vnav_failed");
				return _Vnav_vnavFailed;
			}else {
				return _Vnav_vnavFailed;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for vnav/vnav_failed.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavFailed(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/vnav/vnav_failed",v);
		_Vnav_vnavFailed=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource> _Imageresource =null;

	/**
	 * imageResource
	 * @return Returns an List of org.nrg.xdat.om.NeuroinfoAnatqcImageresource
	 */
	public <A extends org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI> List<A> getImageresource() {
		try{
			if (_Imageresource==null){
				_Imageresource=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("imageResource"));
			}
			return (List<A>) _Imageresource;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.NeuroinfoAnatqcImageresource>();}
	}

	/**
	 * Sets the value for imageResource.
	 * @param v Value to Set.
	 */
	public void setImageresource(ItemI v) throws Exception{
		_Imageresource =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/imageResource",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/imageResource",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * imageResource
	 * Adds org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI
	 */
	public <A extends org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI> void addImageresource(A item) throws Exception{
	setImageresource((ItemI)item);
	}

	/**
	 * Removes the imageResource of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeImageresource(int index) throws java.lang.IndexOutOfBoundsException {
		_Imageresource =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/imageResource",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc> getAllNeuroinfoAnatqcs(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc> al = new ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc> getNeuroinfoAnatqcsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc> al = new ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc> getNeuroinfoAnatqcsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc> al = new ArrayList<org.nrg.xdat.om.NeuroinfoAnatqc>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static NeuroinfoAnatqc getNeuroinfoAnatqcsById(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("neuroinfo:anatqc/id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (NeuroinfoAnatqc) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
			else
				 return null;
		} catch (IllegalAccessException e) {
			final StackTraceElement[] stacktrace = e.getStackTrace();
			final String location = stacktrace == null || stacktrace.length == 0 ? "Unknown (no stack trace)" : stacktrace[0].toString();
			logger.error("The user " + user.getUsername() + " was denied access to the neuroinfo:anatqc/id instance with ID " + value + ". Occurred at: " + location + "\n" + e.getMessage());
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

	public org.w3c.dom.Document toJoinedXML() throws Exception
	{
		ArrayList al = new ArrayList();
		al.add(this.getItem());
		XFTItem mr = org.nrg.xft.search.ItemSearch.GetItem("xnat:mrSessionData.ID",getItem().getProperty("neuroinfo:anatqc.imageSession_ID"),getItem().getUser(),false);
		al.add(mr);
		al.add(org.nrg.xft.search.ItemSearch.GetItem("xnat:subjectData.ID",mr.getProperty("xnat:mrSessionData.subject_ID"),getItem().getUser(),false));
		al.trimToSize();
		return org.nrg.xft.schema.Wrappers.XMLWrapper.XMLWriter.ItemListToDOM(al);
	}
	public ArrayList<ResourceFile> getFileResources(String rootPath, boolean preventLoop){
ArrayList<ResourceFile> _return = new ArrayList<ResourceFile>();
	 boolean localLoop = preventLoop;
	        localLoop = preventLoop;
	
	        //mrAssessorData
	        XnatMrassessordata childMrassessordata = (XnatMrassessordata)this.getMrassessordata();
	            if (childMrassessordata!=null){
	              for(ResourceFile rf: ((XnatMrassessordata)childMrassessordata).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("mrAssessorData[" + ((XnatMrassessordata)childMrassessordata).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("mrAssessorData/" + ((XnatMrassessordata)childMrassessordata).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	
	        localLoop = preventLoop;
	
	        //imageResource
	        for(org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI childImageresource : this.getImageresource()){
	            if (childImageresource!=null){
	              for(ResourceFile rf: ((NeuroinfoAnatqcImageresource)childImageresource).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("imageResource[" + ((NeuroinfoAnatqcImageresource)childImageresource).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("imageResource/" + ((NeuroinfoAnatqcImageresource)childImageresource).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	return _return;
}
}
