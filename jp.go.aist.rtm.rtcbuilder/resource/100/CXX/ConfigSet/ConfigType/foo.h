// -*- C++ -*-
// <rtc-template block="description">
/*!
 * @file  foo.h
 * @brief MDesc
 *
 */
// </rtc-template>
#ifndef FOO_H
#define FOO_H
#include <rtm/idl/BasicDataTypeSkel.h>
#include <rtm/idl/ExtendedDataTypesSkel.h>
#include <rtm/idl/InterfaceDataTypesSkel.h>
// Service implementation headers
// <rtc-template block="service_impl_h">
// </rtc-template>
// Service Consumer stub headers
// <rtc-template block="consumer_stub_h">
// </rtc-template>
#include <rtm/Manager.h>
#include <rtm/DataFlowComponentBase.h>
#include <rtm/CorbaPort.h>
#include <rtm/DataInPort.h>
#include <rtm/DataOutPort.h>
// <rtc-template block="component_description">
/*!
 * @class foo
 * @brief MDesc
 *
 */
// </rtc-template>
class foo
  : public RTC::DataFlowComponentBase
{
 public:
  /*!
   * @brief constructor
   * @param manager Maneger Object
   */
  foo(RTC::Manager* manager);
  /*!
   * @brief destructor
   */
  ~foo() override;
  // <rtc-template block="public_attribute">
  // </rtc-template>
  // <rtc-template block="public_operation">
  // </rtc-template>
  // <rtc-template block="activity">
  /***
   *
   * The initialize action (on CREATED->ALIVE transition)
   *
   * @return RTC::ReturnCode_t
   *   *   */
   RTC::ReturnCode_t onInitialize() override;
  /***
   *
   * The finalize action (on ALIVE->END transition)
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onFinalize() override;
  /***
   *
   * The startup action when ExecutionContext startup
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onStartup(RTC::UniqueId ec_id) override;
  /***
   *
   * The shutdown action when ExecutionContext stop
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onShutdown(RTC::UniqueId ec_id) override;
  /***
   *
   * The activated action (Active state entry action)
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onActivated(RTC::UniqueId ec_id) override;
  /***
   *
   * The deactivated action (Active state exit action)
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onDeactivated(RTC::UniqueId ec_id) override;
  /***
   *
   * The execution action that is invoked periodically
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onExecute(RTC::UniqueId ec_id) override;
  /***
   *
   * The aborting action when main logic error occurred.
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onAborting(RTC::UniqueId ec_id) override;
  /***
   *
   * The error action in ERROR state
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onError(RTC::UniqueId ec_id) override;
  /***
   *
   * The reset action that is invoked resetting
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onReset(RTC::UniqueId ec_id) override;
  /***
   *
   * The state update action that is invoked after onExecute() action
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onStateUpdate(RTC::UniqueId ec_id) override;
  /***
   *
   * The action that is invoked when execution context's rate is changed
   *
   * @param ec_id target ExecutionContext Id
   *
   * @return RTC::ReturnCode_t
   *   *   */
  // RTC::ReturnCode_t onRateChanged(RTC::UniqueId ec_id) override;
  // </rtc-template>
 protected:
  // <rtc-template block="protected_attribute">
  // </rtc-template>
  // <rtc-template block="protected_operation">
  // </rtc-template>
  // Configuration variable declaration
  // <rtc-template block="config_declare">
  /*!
   *   * - Name:  short_param
   * - DefaultValue: 0
   */
  short int m_short_param;
  /*!
   *   * - Name:  int_param
   * - DefaultValue: 1
   */
  int m_int_param;
  /*!
   *   * - Name:  long_param
   * - DefaultValue: 14
   */
  long int m_long_param;
  /*!
   *   * - Name:  float_param
   * - DefaultValue: 0.11
   */
  float m_float_param;
  /*!
   *   * - Name:  double_param
   * - DefaultValue: 4.11
   */
  double m_double_param;
  /*!
   *   * - Name:  str_param0
   * - DefaultValue: hoge
   */
  std::string m_str_param0;
  /*!
   *   * - Name:  str_param1
   * - DefaultValue: dara
   */
  std::string m_str_param1;
  // </rtc-template>
  // DataInPort declaration
  // <rtc-template block="inport_declare">
  // </rtc-template>
  // DataOutPort declaration
  // <rtc-template block="outport_declare">
  // </rtc-template>
  // CORBA Port declaration
  // <rtc-template block="corbaport_declare">
  // </rtc-template>
  // Service declaration
  // <rtc-template block="service_declare">
  // </rtc-template>
  // Consumer declaration
  // <rtc-template block="consumer_declare">
  // </rtc-template>
 private:
  // <rtc-template block="private_attribute">
  // </rtc-template>
  // <rtc-template block="private_operation">
  // </rtc-template>
};
extern "C"
{
  DLL_EXPORT void fooInit(RTC::Manager* manager);
};
#endif // FOO_H
