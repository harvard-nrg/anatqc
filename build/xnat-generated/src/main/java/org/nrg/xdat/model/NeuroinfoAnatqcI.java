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
public interface NeuroinfoAnatqcI extends XnatMrassessordataI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the t1w_scan_id.
	 */
	public String getT1wScanId();

	/**
	 * Sets the value for t1w_scan_id.
	 * @param v Value to Set.
	 */
	public void setT1wScanId(String v);

	/**
	 * @return Returns the vnav_scan_id.
	 */
	public String getVnavScanId();

	/**
	 * Sets the value for vnav_scan_id.
	 * @param v Value to Set.
	 */
	public void setVnavScanId(String v);

	/**
	 * @return Returns the session_label.
	 */
	public String getSessionLabel();

	/**
	 * Sets the value for session_label.
	 * @param v Value to Set.
	 */
	public void setSessionLabel(String v);

	/**
	 * @return Returns the mriqc/cjv.
	 */
	public Object getMriqc_cjv();

	/**
	 * Sets the value for mriqc/cjv.
	 * @param v Value to Set.
	 */
	public void setMriqc_cjv(Object v);

	/**
	 * @return Returns the mriqc/cnr.
	 */
	public Object getMriqc_cnr();

	/**
	 * Sets the value for mriqc/cnr.
	 * @param v Value to Set.
	 */
	public void setMriqc_cnr(Object v);

	/**
	 * @return Returns the mriqc/efc.
	 */
	public Object getMriqc_efc();

	/**
	 * Sets the value for mriqc/efc.
	 * @param v Value to Set.
	 */
	public void setMriqc_efc(Object v);

	/**
	 * @return Returns the mriqc/fber.
	 */
	public Object getMriqc_fber();

	/**
	 * Sets the value for mriqc/fber.
	 * @param v Value to Set.
	 */
	public void setMriqc_fber(Object v);

	/**
	 * @return Returns the mriqc/fwhm_avg.
	 */
	public Object getMriqc_fwhmAvg();

	/**
	 * Sets the value for mriqc/fwhm_avg.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmAvg(Object v);

	/**
	 * @return Returns the mriqc/fwhm_x.
	 */
	public Object getMriqc_fwhmX();

	/**
	 * Sets the value for mriqc/fwhm_x.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmX(Object v);

	/**
	 * @return Returns the mriqc/fwhm_y.
	 */
	public Object getMriqc_fwhmY();

	/**
	 * Sets the value for mriqc/fwhm_y.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmY(Object v);

	/**
	 * @return Returns the mriqc/fwhm_z.
	 */
	public Object getMriqc_fwhmZ();

	/**
	 * Sets the value for mriqc/fwhm_z.
	 * @param v Value to Set.
	 */
	public void setMriqc_fwhmZ(Object v);

	/**
	 * @return Returns the mriqc/icvs_csf.
	 */
	public Object getMriqc_icvsCsf();

	/**
	 * Sets the value for mriqc/icvs_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_icvsCsf(Object v);

	/**
	 * @return Returns the mriqc/icvs_gm.
	 */
	public Object getMriqc_icvsGm();

	/**
	 * Sets the value for mriqc/icvs_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_icvsGm(Object v);

	/**
	 * @return Returns the mriqc/icvs_wm.
	 */
	public Object getMriqc_icvsWm();

	/**
	 * Sets the value for mriqc/icvs_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_icvsWm(Object v);

	/**
	 * @return Returns the mriqc/inu_med.
	 */
	public Object getMriqc_inuMed();

	/**
	 * Sets the value for mriqc/inu_med.
	 * @param v Value to Set.
	 */
	public void setMriqc_inuMed(Object v);

	/**
	 * @return Returns the mriqc/inu_range.
	 */
	public Object getMriqc_inuRange();

	/**
	 * Sets the value for mriqc/inu_range.
	 * @param v Value to Set.
	 */
	public void setMriqc_inuRange(Object v);

	/**
	 * @return Returns the mriqc/qi_1.
	 */
	public Object getMriqc_qi1();

	/**
	 * Sets the value for mriqc/qi_1.
	 * @param v Value to Set.
	 */
	public void setMriqc_qi1(Object v);

	/**
	 * @return Returns the mriqc/qi_2.
	 */
	public Object getMriqc_qi2();

	/**
	 * Sets the value for mriqc/qi_2.
	 * @param v Value to Set.
	 */
	public void setMriqc_qi2(Object v);

	/**
	 * @return Returns the mriqc/rpve_csf.
	 */
	public Object getMriqc_rpveCsf();

	/**
	 * Sets the value for mriqc/rpve_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_rpveCsf(Object v);

	/**
	 * @return Returns the mriqc/rpve_gm.
	 */
	public Object getMriqc_rpveGm();

	/**
	 * Sets the value for mriqc/rpve_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_rpveGm(Object v);

	/**
	 * @return Returns the mriqc/rpve_wm.
	 */
	public Object getMriqc_rpveWm();

	/**
	 * Sets the value for mriqc/rpve_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_rpveWm(Object v);

	/**
	 * @return Returns the mriqc/size_x.
	 */
	public Object getMriqc_sizeX();

	/**
	 * Sets the value for mriqc/size_x.
	 * @param v Value to Set.
	 */
	public void setMriqc_sizeX(Object v);

	/**
	 * @return Returns the mriqc/size_y.
	 */
	public Object getMriqc_sizeY();

	/**
	 * Sets the value for mriqc/size_y.
	 * @param v Value to Set.
	 */
	public void setMriqc_sizeY(Object v);

	/**
	 * @return Returns the mriqc/size_z.
	 */
	public Object getMriqc_sizeZ();

	/**
	 * Sets the value for mriqc/size_z.
	 * @param v Value to Set.
	 */
	public void setMriqc_sizeZ(Object v);

	/**
	 * @return Returns the mriqc/snr_csf.
	 */
	public Object getMriqc_snrCsf();

	/**
	 * Sets the value for mriqc/snr_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrCsf(Object v);

	/**
	 * @return Returns the mriqc/snr_gm.
	 */
	public Object getMriqc_snrGm();

	/**
	 * Sets the value for mriqc/snr_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrGm(Object v);

	/**
	 * @return Returns the mriqc/snr_total.
	 */
	public Object getMriqc_snrTotal();

	/**
	 * Sets the value for mriqc/snr_total.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrTotal(Object v);

	/**
	 * @return Returns the mriqc/snr_wm.
	 */
	public Object getMriqc_snrWm();

	/**
	 * Sets the value for mriqc/snr_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrWm(Object v);

	/**
	 * @return Returns the mriqc/snrd_csf.
	 */
	public Object getMriqc_snrdCsf();

	/**
	 * Sets the value for mriqc/snrd_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdCsf(Object v);

	/**
	 * @return Returns the mriqc/snrd_gm.
	 */
	public Object getMriqc_snrdGm();

	/**
	 * Sets the value for mriqc/snrd_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdGm(Object v);

	/**
	 * @return Returns the mriqc/snrd_total.
	 */
	public Object getMriqc_snrdTotal();

	/**
	 * Sets the value for mriqc/snrd_total.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdTotal(Object v);

	/**
	 * @return Returns the mriqc/snrd_wm.
	 */
	public Object getMriqc_snrdWm();

	/**
	 * Sets the value for mriqc/snrd_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_snrdWm(Object v);

	/**
	 * @return Returns the mriqc/spacing_x.
	 */
	public Object getMriqc_spacingX();

	/**
	 * Sets the value for mriqc/spacing_x.
	 * @param v Value to Set.
	 */
	public void setMriqc_spacingX(Object v);

	/**
	 * @return Returns the mriqc/spacing_y.
	 */
	public Object getMriqc_spacingY();

	/**
	 * Sets the value for mriqc/spacing_y.
	 * @param v Value to Set.
	 */
	public void setMriqc_spacingY(Object v);

	/**
	 * @return Returns the mriqc/spacing_z.
	 */
	public Object getMriqc_spacingZ();

	/**
	 * Sets the value for mriqc/spacing_z.
	 * @param v Value to Set.
	 */
	public void setMriqc_spacingZ(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_k.
	 */
	public Object getMriqc_summaryBgK();

	/**
	 * Sets the value for mriqc/summary_bg_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgK(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_mad.
	 */
	public Object getMriqc_summaryBgMad();

	/**
	 * Sets the value for mriqc/summary_bg_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgMad(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_mean.
	 */
	public Object getMriqc_summaryBgMean();

	/**
	 * Sets the value for mriqc/summary_bg_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgMean(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_median.
	 */
	public Object getMriqc_summaryBgMedian();

	/**
	 * Sets the value for mriqc/summary_bg_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgMedian(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_n.
	 */
	public Object getMriqc_summaryBgN();

	/**
	 * Sets the value for mriqc/summary_bg_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgN(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_p05.
	 */
	public Object getMriqc_summaryBgP05();

	/**
	 * Sets the value for mriqc/summary_bg_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgP05(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_p95.
	 */
	public Object getMriqc_summaryBgP95();

	/**
	 * Sets the value for mriqc/summary_bg_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgP95(Object v);

	/**
	 * @return Returns the mriqc/summary_bg_stdv.
	 */
	public Object getMriqc_summaryBgStdv();

	/**
	 * Sets the value for mriqc/summary_bg_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryBgStdv(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_k.
	 */
	public Object getMriqc_summaryCsfK();

	/**
	 * Sets the value for mriqc/summary_csf_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfK(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_mad.
	 */
	public Object getMriqc_summaryCsfMad();

	/**
	 * Sets the value for mriqc/summary_csf_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfMad(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_mean.
	 */
	public Object getMriqc_summaryCsfMean();

	/**
	 * Sets the value for mriqc/summary_csf_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfMean(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_median.
	 */
	public Object getMriqc_summaryCsfMedian();

	/**
	 * Sets the value for mriqc/summary_csf_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfMedian(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_n.
	 */
	public Object getMriqc_summaryCsfN();

	/**
	 * Sets the value for mriqc/summary_csf_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfN(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_p05.
	 */
	public Object getMriqc_summaryCsfP05();

	/**
	 * Sets the value for mriqc/summary_csf_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfP05(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_p95.
	 */
	public Object getMriqc_summaryCsfP95();

	/**
	 * Sets the value for mriqc/summary_csf_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfP95(Object v);

	/**
	 * @return Returns the mriqc/summary_csf_stdv.
	 */
	public Object getMriqc_summaryCsfStdv();

	/**
	 * Sets the value for mriqc/summary_csf_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryCsfStdv(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_k.
	 */
	public Object getMriqc_summaryGmK();

	/**
	 * Sets the value for mriqc/summary_gm_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmK(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_mad.
	 */
	public Object getMriqc_summaryGmMad();

	/**
	 * Sets the value for mriqc/summary_gm_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmMad(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_mean.
	 */
	public Object getMriqc_summaryGmMean();

	/**
	 * Sets the value for mriqc/summary_gm_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmMean(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_median.
	 */
	public Object getMriqc_summaryGmMedian();

	/**
	 * Sets the value for mriqc/summary_gm_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmMedian(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_n.
	 */
	public Object getMriqc_summaryGmN();

	/**
	 * Sets the value for mriqc/summary_gm_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmN(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_p05.
	 */
	public Object getMriqc_summaryGmP05();

	/**
	 * Sets the value for mriqc/summary_gm_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmP05(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_p95.
	 */
	public Object getMriqc_summaryGmP95();

	/**
	 * Sets the value for mriqc/summary_gm_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmP95(Object v);

	/**
	 * @return Returns the mriqc/summary_gm_stdv.
	 */
	public Object getMriqc_summaryGmStdv();

	/**
	 * Sets the value for mriqc/summary_gm_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryGmStdv(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_k.
	 */
	public Object getMriqc_summaryWmK();

	/**
	 * Sets the value for mriqc/summary_wm_k.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmK(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_mad.
	 */
	public Object getMriqc_summaryWmMad();

	/**
	 * Sets the value for mriqc/summary_wm_mad.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmMad(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_mean.
	 */
	public Object getMriqc_summaryWmMean();

	/**
	 * Sets the value for mriqc/summary_wm_mean.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmMean(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_median.
	 */
	public Object getMriqc_summaryWmMedian();

	/**
	 * Sets the value for mriqc/summary_wm_median.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmMedian(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_n.
	 */
	public Object getMriqc_summaryWmN();

	/**
	 * Sets the value for mriqc/summary_wm_n.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmN(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_p05.
	 */
	public Object getMriqc_summaryWmP05();

	/**
	 * Sets the value for mriqc/summary_wm_p05.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmP05(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_p95.
	 */
	public Object getMriqc_summaryWmP95();

	/**
	 * Sets the value for mriqc/summary_wm_p95.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmP95(Object v);

	/**
	 * @return Returns the mriqc/summary_wm_stdv.
	 */
	public Object getMriqc_summaryWmStdv();

	/**
	 * Sets the value for mriqc/summary_wm_stdv.
	 * @param v Value to Set.
	 */
	public void setMriqc_summaryWmStdv(Object v);

	/**
	 * @return Returns the mriqc/tpm_overlap_csf.
	 */
	public Object getMriqc_tpmOverlapCsf();

	/**
	 * Sets the value for mriqc/tpm_overlap_csf.
	 * @param v Value to Set.
	 */
	public void setMriqc_tpmOverlapCsf(Object v);

	/**
	 * @return Returns the mriqc/tpm_overlap_gm.
	 */
	public Object getMriqc_tpmOverlapGm();

	/**
	 * Sets the value for mriqc/tpm_overlap_gm.
	 * @param v Value to Set.
	 */
	public void setMriqc_tpmOverlapGm(Object v);

	/**
	 * @return Returns the mriqc/tpm_overlap_wm.
	 */
	public Object getMriqc_tpmOverlapWm();

	/**
	 * Sets the value for mriqc/tpm_overlap_wm.
	 * @param v Value to Set.
	 */
	public void setMriqc_tpmOverlapWm(Object v);

	/**
	 * @return Returns the mriqc/wm2max.
	 */
	public Object getMriqc_wm2max();

	/**
	 * Sets the value for mriqc/wm2max.
	 * @param v Value to Set.
	 */
	public void setMriqc_wm2max(Object v);

	/**
	 * @return Returns the morph/mri_cnr_tot.
	 */
	public Object getMorph_mriCnrTot();

	/**
	 * Sets the value for morph/mri_cnr_tot.
	 * @param v Value to Set.
	 */
	public void setMorph_mriCnrTot(Object v);

	/**
	 * @return Returns the morph/wm_anat_snr.
	 */
	public Object getMorph_wmAnatSnr();

	/**
	 * Sets the value for morph/wm_anat_snr.
	 * @param v Value to Set.
	 */
	public void setMorph_wmAnatSnr(Object v);

	/**
	 * @return Returns the morph/lh_euler_holes.
	 */
	public Integer getMorph_lhEulerHoles();

	/**
	 * Sets the value for neuroinfo:anatqc/morph/lh_euler_holes.
	 * @param v Value to Set.
	 */
	public void setMorph_lhEulerHoles(Integer v) ;

	/**
	 * @return Returns the morph/lh_cnr.
	 */
	public Object getMorph_lhCnr();

	/**
	 * Sets the value for morph/lh_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_lhCnr(Object v);

	/**
	 * @return Returns the morph/lh_gm_wm_cnr.
	 */
	public Object getMorph_lhGmWmCnr();

	/**
	 * Sets the value for morph/lh_gm_wm_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_lhGmWmCnr(Object v);

	/**
	 * @return Returns the morph/lh_gm_csf_cnr.
	 */
	public Object getMorph_lhGmCsfCnr();

	/**
	 * Sets the value for morph/lh_gm_csf_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_lhGmCsfCnr(Object v);

	/**
	 * @return Returns the morph/rh_euler_holes.
	 */
	public Integer getMorph_rhEulerHoles();

	/**
	 * Sets the value for neuroinfo:anatqc/morph/rh_euler_holes.
	 * @param v Value to Set.
	 */
	public void setMorph_rhEulerHoles(Integer v) ;

	/**
	 * @return Returns the morph/rh_cnr.
	 */
	public Object getMorph_rhCnr();

	/**
	 * Sets the value for morph/rh_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_rhCnr(Object v);

	/**
	 * @return Returns the morph/rh_gm_wm_cnr.
	 */
	public Object getMorph_rhGmWmCnr();

	/**
	 * Sets the value for morph/rh_gm_wm_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_rhGmWmCnr(Object v);

	/**
	 * @return Returns the morph/rh_gm_csf_cnr.
	 */
	public Object getMorph_rhGmCsfCnr();

	/**
	 * Sets the value for morph/rh_gm_csf_cnr.
	 * @param v Value to Set.
	 */
	public void setMorph_rhGmCsfCnr(Object v);

	/**
	 * @return Returns the vnav/vnav_min.
	 */
	public Integer getVnav_vnavMin();

	/**
	 * Sets the value for neuroinfo:anatqc/vnav/vnav_min.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavMin(Integer v) ;

	/**
	 * @return Returns the vnav/vnav_max.
	 */
	public Integer getVnav_vnavMax();

	/**
	 * Sets the value for neuroinfo:anatqc/vnav/vnav_max.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavMax(Integer v) ;

	/**
	 * @return Returns the vnav/vnav_acq_tot.
	 */
	public Integer getVnav_vnavAcqTot();

	/**
	 * Sets the value for neuroinfo:anatqc/vnav/vnav_acq_tot.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavAcqTot(Integer v) ;

	/**
	 * @return Returns the vnav/vnav_reacq.
	 */
	public Integer getVnav_vnavReacq();

	/**
	 * Sets the value for neuroinfo:anatqc/vnav/vnav_reacq.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavReacq(Integer v) ;

	/**
	 * @return Returns the vnav/mean_mot_rms_per_min.
	 */
	public Object getVnav_meanMotRmsPerMin();

	/**
	 * Sets the value for vnav/mean_mot_rms_per_min.
	 * @param v Value to Set.
	 */
	public void setVnav_meanMotRmsPerMin(Object v);

	/**
	 * @return Returns the vnav/mean_mot_max_per_min.
	 */
	public Object getVnav_meanMotMaxPerMin();

	/**
	 * Sets the value for vnav/mean_mot_max_per_min.
	 * @param v Value to Set.
	 */
	public void setVnav_meanMotMaxPerMin(Object v);

	/**
	 * @return Returns the vnav/vnav_failed.
	 */
	public Integer getVnav_vnavFailed();

	/**
	 * Sets the value for neuroinfo:anatqc/vnav/vnav_failed.
	 * @param v Value to Set.
	 */
	public void setVnav_vnavFailed(Integer v) ;

	/**
	 * imageResource
	 * @return Returns an List of org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI
	 */
	public <A extends org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI> List<A> getImageresource();

	/**
	 * imageResource
	 * @return Returns an List of org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI
	 */
	public <A extends org.nrg.xdat.model.NeuroinfoAnatqcImageresourceI> void addImageresource(A item) throws Exception;
}
