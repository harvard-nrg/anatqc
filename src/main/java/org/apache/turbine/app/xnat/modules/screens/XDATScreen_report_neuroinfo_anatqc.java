package org.apache.turbine.app.xnat.modules.screens;

import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;
import org.nrg.xdat.model.XnatAbstractresourceI;
import org.nrg.xdat.om.NeuroinfoAnatqc;
import org.nrg.xdat.om.XnatResource;
import org.nrg.xdat.turbine.modules.screens.SecureReport;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import java.text.SimpleDateFormat;
//import java.util.Date;

public class XDATScreen_report_neuroinfo_anatqc extends SecureReport {
    @Override
    public void finalProcessing(RunData data, Context context) {
        NeuroinfoAnatqc neuroinfoAnatqc = new NeuroinfoAnatqc( item);
        context.put("om",om);
        List<XnatAbstractresourceI> out_file = neuroinfoAnatqc.getOut_file();
        Map<String,String> map = out_file.stream()
                .filter( f -> f instanceof XnatResource)
                .map( f -> (XnatResource) f)
                .collect( Collectors.toMap( XnatResource::getLabel, XnatResource::getUri));
        context.put( "fileMap", map);
//        map.forEach( context::put);
    }

//    @Override
//    public void doBuildTemplate(final RunData data, final Context context) {
//        context.put("dateTime", DATE_FORMAT.format(new Date()));
//    }
//
//    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd_hhmmss");

}