// -*- Java -*-
/*!
 * @file  fooImpl.java
 * @brief test module
 * @date  $Date$
 *
 * $Id$
 */

import RTC.TimedShort;
import RTC.TimedLong;
import jp.go.aist.rtm.RTC.DataFlowComponentBase;
import jp.go.aist.rtm.RTC.Manager;
import jp.go.aist.rtm.RTC.port.InPort;
import jp.go.aist.rtm.RTC.port.OutPort;
import jp.go.aist.rtm.RTC.util.DataRef;
import jp.go.aist.rtm.RTC.port.CorbaPort;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/*!
 * @class fooImpl
 * @brief test module
 *
 */
public class fooImpl extends DataFlowComponentBase {

  /*!
   * @brief constructor
   * @param manager Maneger Object
   */
	public fooImpl(Manager manager) {  
        super(manager);
        // <rtc-template block="initializer">
        m_in1_val = new TimedShort();
        m_in1 = new DataRef<TimedShort>(m_in1_val);
        m_in1In = new InPort<TimedShort>("in1", m_in1);
        m_out1_val = new TimedLong();
        m_out1 = new DataRef<TimedLong>(m_out1_val);
        m_out1Out = new OutPort<TimedLong>("out1", m_out1);
        m_Port = new CorbaPort("");
        // </rtc-template>

        // Registration: InPort/OutPort/Service
        // <rtc-template block="registration">
        // Set InPort buffers
        try {
			registerInPort(TimedShort.class, "in1", m_in1In);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        // Set OutPort buffer
        try {
			registerOutPort(TimedLong.class, "out1", m_out1Out);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        // Set service provider to Ports
        try {
        	m_Port.registerProvider("myservice0", "MyService", m_myservice0);
        } catch (ServantAlreadyActive e) {
            e.printStackTrace();
        } catch (WrongPolicy e) {
            e.printStackTrace();
        } catch (ObjectNotActive e) {
            e.printStackTrace();
        }
        
        // Set service consumers to Ports
        
        // Set CORBA Service Ports
        registerPort(m_Port);
        
        // </rtc-template>
    }

    /**
     *
     * The initialize action (on CREATED->ALIVE transition)
     * formaer rtc_init_entry() 
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onInitialize() {
//        return super.onInitialize();
//    }

    /***
     *
     * The finalize action (on ALIVE->END transition)
     * formaer rtc_exiting_entry()
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onFinalize() {
//        return super.onFinalize();
//    }

    /***
     *
     * The startup action when ExecutionContext startup
     * former rtc_starting_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onStartup(int ec_id) {
//        return super.onStartup(ec_id);
//    }

    /***
     *
     * The shutdown action when ExecutionContext stop
     * former rtc_stopping_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onShutdown(int ec_id) {
//        return super.onShutdown(ec_id);
//    }

    /***
     *
     * The activated action (Active state entry action)
     * former rtc_active_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onActivated(int ec_id) {
//        return super.onActivated(ec_id);
//    }

    /***
     *
     * The deactivated action (Active state exit action)
     * former rtc_active_exit()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onDeactivated(int ec_id) {
//        return super.onDeactivated(ec_id);
//    }

    /***
     *
     * The execution action that is invoked periodically
     * former rtc_active_do()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onExecute(int ec_id) {
//        return super.onExecute(ec_id);
//    }

    /***
     *
     * The aborting action when main logic error occurred.
     * former rtc_aborting_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//  @Override
//  public ReturnCode_t onAborting(int ec_id) {
//      return super.onAborting(ec_id);
//  }

    /***
     *
     * The error action in ERROR state
     * former rtc_error_do()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    public ReturnCode_t onError(int ec_id) {
//        return super.onError(ec_id);
//    }

    /***
     *
     * The reset action that is invoked resetting
     * This is same but different the former rtc_init_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onReset(int ec_id) {
//        return super.onReset(ec_id);
//    }

    /***
     *
     * The state update action that is invoked after onExecute() action
     * no corresponding operation exists in OpenRTm-aist-0.2.0
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onStateUpdate(int ec_id) {
//        return super.onStateUpdate(ec_id);
//    }

    /***
     *
     * The action that is invoked when execution context's rate is changed
     * no corresponding operation exists in OpenRTm-aist-0.2.0
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onRateChanged(int ec_id) {
//        return super.onRateChanged(ec_id);
//    }
//
    // DataInPort declaration
    // <rtc-template block="inport_declare">
    protected TimedShort m_in1_val;
    protected DataRef<TimedShort> m_in1;
    /*!
     */
    protected InPort<TimedShort> m_in1In;

    
    // </rtc-template>

    // DataOutPort declaration
    // <rtc-template block="outport_declare">
    protected TimedLong m_out1_val;
    protected DataRef<TimedLong> m_out1;
    /*!
     */
    protected OutPort<TimedLong> m_out1Out;

    
    // </rtc-template>

    // CORBA Port declaration
    // <rtc-template block="corbaport_declare">
    /*!
     */
    protected CorbaPort m_Port;
    
    // </rtc-template>

    // Service declaration
    // <rtc-template block="service_declare">
    /*!
     */
    protected MyServiceSVC_impl m_myservice0 = new MyServiceSVC_impl();
    
    // </rtc-template>

    // Consumer declaration
    // <rtc-template block="consumer_declare">
    
    // </rtc-template>


}
