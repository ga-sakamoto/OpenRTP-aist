// -*- Java -*-
// <rtc-template block="description">
/*!
 * @file ModuleName.java
 * @date $Date$
 *
 * $Id$
 */
// </rtc-template>
import jp.go.aist.rtm.RTC.Manager;
import jp.go.aist.rtm.RTC.RTObject_impl;
import jp.go.aist.rtm.RTC.RtcDeleteFunc;
import jp.go.aist.rtm.RTC.RtcNewFunc;
import jp.go.aist.rtm.RTC.RegisterModuleFunc;
import jp.go.aist.rtm.RTC.util.Properties;
//  Module specification
//  <rtc-template block="module_spec">
public static String modulename_conf[] = {
        "implementation_id", "ModuleName",
        "type_name",         "ModuleName",
        "description",       "ModuleDescription",
        "version",           "1.0.0",
        "vendor",            "VenderName",
        "category",          "Category",
        "activity_type",     "STATIC",
        "max_instance",      "1",
        "language",          "Java",
        "lang_type",         "compile",
	    ""
};
//  </rtc-template>
/**
 * ModuleName
 * <p> 
 * ModuleDescription
 */
public class ModuleName implements RtcNewFunc, RtcDeleteFunc, RegisterModuleFunc {
    public RTObject_impl createRtc(Manager mgr) {
        return new ModuleNameImpl(mgr);
    }
    public void deleteRtc(RTObject_impl rtcBase) {
        rtcBase = null;
    }
    public void registerModule() {
        Properties prop = new Properties(modulename_conf);
        final Manager manager = Manager.instance();
        manager.registerFactory(prop, new ModuleName(), new ModuleName());
    }
}
