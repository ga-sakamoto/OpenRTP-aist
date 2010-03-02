// -*-C++-*-
/*!
 * @file  MyService3SVC_impl.h
 * @brief Service implementation header of MyService3.idl
 *
 */

#include "MyService3Skel.h"

#ifndef MYSERVICE3SVC_IMPL_H
#define MYSERVICE3SVC_IMPL_H
 
/*!
 * @class MyServiceSVC_impl
 * Example class implementing IDL interface MyService
 */
class MyServiceSVC_impl
 : public virtual POA_MyService,
   public virtual PortableServer::RefCountServantBase
{
 private:
   // Make sure all instances are built on the heap by making the
   // destructor non-public
   //virtual ~MyServiceSVC_impl();

 public:
  /*!
   * @brief standard constructor
   */
   MyServiceSVC_impl();
  /*!
   * @brief destructor
   */
   virtual ~MyServiceSVC_impl();

   // attributes and operations
   void setGain(CORBA::Float gain);
   CORBA::Float getGain();

};



#endif // MYSERVICE3SVC_IMPL_H


