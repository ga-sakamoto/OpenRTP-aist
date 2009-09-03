// -*-C++-*-
/*!
 * @file  MyServiceSVC_impl.h
 * @brief Service implementation header of MyService.idl
 *
 */

#include "MyServiceSkel.h"

#ifndef MYSERVICESVC_IMPL_H
#define MYSERVICESVC_IMPL_H
 
/*!
 * @class MyServiceTSVC_impl
 * Example class implementing IDL interface MyServiceT
 */
class MyServiceTSVC_impl
 : public virtual POA_MyServiceT,
   public virtual PortableServer::RefCountServantBase
{
 private:
   // Make sure all instances are built on the heap by making the
   // destructor non-public
   //virtual ~MyServiceTSVC_impl();

 public:
  /*!
   * @brief standard constructor
   */
   MyServiceTSVC_impl();
  /*!
   * @brief destructor
   */
   virtual ~MyServiceTSVC_impl();

   // attributes and operations
   char* echo(const char* msg);
   EchoList* get_echo_history();
   void set_value(CORBA::Float value);
   CORBA::Float get_value();
   ValueList* get_value_history();

};

/*!
 * @class MyServiceOpenSVC_impl
 * Example class implementing IDL interface MyServiceOpen
 */
class MyServiceOpenSVC_impl
 : public virtual POA_MyServiceOpen,
   public virtual PortableServer::RefCountServantBase
{
 private:
   // Make sure all instances are built on the heap by making the
   // destructor non-public
   //virtual ~MyServiceOpenSVC_impl();

 public:
  /*!
   * @brief standard constructor
   */
   MyServiceOpenSVC_impl();
  /*!
   * @brief destructor
   */
   virtual ~MyServiceOpenSVC_impl();

   // attributes and operations
   void AdOpen();

};



#endif // MYSERVICESVC_IMPL_H

