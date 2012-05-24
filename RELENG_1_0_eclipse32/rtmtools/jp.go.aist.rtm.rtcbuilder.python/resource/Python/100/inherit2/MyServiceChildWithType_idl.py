# Python stubs generated by omniidl from MyServiceChildWithType.idl

import omniORB, _omnipy
from omniORB import CORBA, PortableServer
_0_CORBA = CORBA

_omnipy.checkVersion(2,0, __file__)

try:
    _omniORB_StructBase = omniORB.StructBase
except AttributeError:
    class _omniORB_StructBase: pass


#
# Start of module "_GlobalIDL"
#
__name__ = "_GlobalIDL"
_0__GlobalIDL = omniORB.openModule("_GlobalIDL", r"MyServiceChildWithType.idl")
_0__GlobalIDL__POA = omniORB.openModule("_GlobalIDL__POA", r"MyServiceChildWithType.idl")


# typedef ... ValueList
class ValueList:
    _NP_RepositoryId = "IDL:ValueList:1.0"
    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")
_0__GlobalIDL.ValueList = ValueList
_0__GlobalIDL._d_ValueList  = (omniORB.tcInternal.tv_sequence, omniORB.tcInternal.tv_float, 0)
_0__GlobalIDL._ad_ValueList = (omniORB.tcInternal.tv_alias, ValueList._NP_RepositoryId, "ValueList", (omniORB.tcInternal.tv_sequence, omniORB.tcInternal.tv_float, 0))
_0__GlobalIDL._tc_ValueList = omniORB.tcInternal.createTypeCode(_0__GlobalIDL._ad_ValueList)
omniORB.registerType(ValueList._NP_RepositoryId, _0__GlobalIDL._ad_ValueList, _0__GlobalIDL._tc_ValueList)
del ValueList

# typedef ... EchoList
class EchoList:
    _NP_RepositoryId = "IDL:EchoList:1.0"
    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")
_0__GlobalIDL.EchoList = EchoList
_0__GlobalIDL._d_EchoList  = (omniORB.tcInternal.tv_sequence, (omniORB.tcInternal.tv_string,0), 0)
_0__GlobalIDL._ad_EchoList = (omniORB.tcInternal.tv_alias, EchoList._NP_RepositoryId, "EchoList", (omniORB.tcInternal.tv_sequence, (omniORB.tcInternal.tv_string,0), 0))
_0__GlobalIDL._tc_EchoList = omniORB.tcInternal.createTypeCode(_0__GlobalIDL._ad_EchoList)
omniORB.registerType(EchoList._NP_RepositoryId, _0__GlobalIDL._ad_EchoList, _0__GlobalIDL._tc_EchoList)
del EchoList

# interface MyServiceWithType
_0__GlobalIDL._d_MyServiceWithType = (omniORB.tcInternal.tv_objref, "IDL:MyServiceWithType:1.0", "MyServiceWithType")
omniORB.typeMapping["IDL:MyServiceWithType:1.0"] = _0__GlobalIDL._d_MyServiceWithType
_0__GlobalIDL.MyServiceWithType = omniORB.newEmptyClass()
class MyServiceWithType :
    _NP_RepositoryId = _0__GlobalIDL._d_MyServiceWithType[1]

    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")

    _nil = CORBA.Object._nil


_0__GlobalIDL.MyServiceWithType = MyServiceWithType
_0__GlobalIDL._tc_MyServiceWithType = omniORB.tcInternal.createTypeCode(_0__GlobalIDL._d_MyServiceWithType)
omniORB.registerType(MyServiceWithType._NP_RepositoryId, _0__GlobalIDL._d_MyServiceWithType, _0__GlobalIDL._tc_MyServiceWithType)

# MyServiceWithType operations and attributes
MyServiceWithType._d_get_echo_history = ((), (omniORB.typeMapping["IDL:EchoList:1.0"], ), None)
MyServiceWithType._d_get_value_history = ((), (omniORB.typeMapping["IDL:ValueList:1.0"], ), None)

# MyServiceWithType object reference
class _objref_MyServiceWithType (CORBA.Object):
    _NP_RepositoryId = MyServiceWithType._NP_RepositoryId

    def __init__(self):
        CORBA.Object.__init__(self)

    def get_echo_history(self, *args):
        return _omnipy.invoke(self, "get_echo_history", _0__GlobalIDL.MyServiceWithType._d_get_echo_history, args)

    def get_value_history(self, *args):
        return _omnipy.invoke(self, "get_value_history", _0__GlobalIDL.MyServiceWithType._d_get_value_history, args)

    __methods__ = ["get_echo_history", "get_value_history"] + CORBA.Object.__methods__

omniORB.registerObjref(MyServiceWithType._NP_RepositoryId, _objref_MyServiceWithType)
_0__GlobalIDL._objref_MyServiceWithType = _objref_MyServiceWithType
del MyServiceWithType, _objref_MyServiceWithType

# MyServiceWithType skeleton
__name__ = "_GlobalIDL__POA"
class MyServiceWithType (PortableServer.Servant):
    _NP_RepositoryId = _0__GlobalIDL.MyServiceWithType._NP_RepositoryId


    _omni_op_d = {"get_echo_history": _0__GlobalIDL.MyServiceWithType._d_get_echo_history, "get_value_history": _0__GlobalIDL.MyServiceWithType._d_get_value_history}

MyServiceWithType._omni_skeleton = MyServiceWithType
_0__GlobalIDL__POA.MyServiceWithType = MyServiceWithType
del MyServiceWithType
__name__ = "_GlobalIDL"

# interface MyServiceWithTypeChild
_0__GlobalIDL._d_MyServiceWithTypeChild = (omniORB.tcInternal.tv_objref, "IDL:MyServiceWithTypeChild:1.0", "MyServiceWithTypeChild")
omniORB.typeMapping["IDL:MyServiceWithTypeChild:1.0"] = _0__GlobalIDL._d_MyServiceWithTypeChild
_0__GlobalIDL.MyServiceWithTypeChild = omniORB.newEmptyClass()
class MyServiceWithTypeChild :
    _NP_RepositoryId = _0__GlobalIDL._d_MyServiceWithTypeChild[1]

    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")

    _nil = CORBA.Object._nil


_0__GlobalIDL.MyServiceWithTypeChild = MyServiceWithTypeChild
_0__GlobalIDL._tc_MyServiceWithTypeChild = omniORB.tcInternal.createTypeCode(_0__GlobalIDL._d_MyServiceWithTypeChild)
omniORB.registerType(MyServiceWithTypeChild._NP_RepositoryId, _0__GlobalIDL._d_MyServiceWithTypeChild, _0__GlobalIDL._tc_MyServiceWithTypeChild)

# MyServiceWithTypeChild operations and attributes
MyServiceWithTypeChild._d_setPos = ((omniORB.tcInternal.tv_float, ), (), None)
MyServiceWithTypeChild._d_getPos = ((), (omniORB.typeMapping["IDL:EchoList:1.0"], ), None)
MyServiceWithTypeChild._d_get_echo_history = ((), (omniORB.typeMapping["IDL:EchoList:1.0"], ), None)
MyServiceWithTypeChild._d_get_value_history = ((), (omniORB.typeMapping["IDL:ValueList:1.0"], ), None)

# MyServiceWithTypeChild object reference
class _objref_MyServiceWithTypeChild (CORBA.Object):
    _NP_RepositoryId = MyServiceWithTypeChild._NP_RepositoryId

    def __init__(self):
        CORBA.Object.__init__(self)

    def setPos(self, *args):
        return _omnipy.invoke(self, "setPos", _0__GlobalIDL.MyServiceWithTypeChild._d_setPos, args)

    def getPos(self, *args):
        return _omnipy.invoke(self, "getPos", _0__GlobalIDL.MyServiceWithTypeChild._d_getPos, args)

    def get_echo_history(self, *args):
        return _omnipy.invoke(self, "get_echo_history", _0__GlobalIDL.MyServiceWithTypeChild._d_get_echo_history, args)

    def get_value_history(self, *args):
        return _omnipy.invoke(self, "get_value_history", _0__GlobalIDL.MyServiceWithTypeChild._d_get_value_history, args)

    __methods__ = ["setPos", "getPos", "get_echo_history", "get_value_history"] + CORBA.Object.__methods__

omniORB.registerObjref(MyServiceWithTypeChild._NP_RepositoryId, _objref_MyServiceWithTypeChild)
_0__GlobalIDL._objref_MyServiceWithTypeChild = _objref_MyServiceWithTypeChild
del MyServiceWithTypeChild, _objref_MyServiceWithTypeChild

# MyServiceWithTypeChild skeleton
__name__ = "_GlobalIDL__POA"
class MyServiceWithTypeChild (PortableServer.Servant):
    _NP_RepositoryId = _0__GlobalIDL.MyServiceWithTypeChild._NP_RepositoryId


    _omni_op_d = {"setPos": _0__GlobalIDL.MyServiceWithTypeChild._d_setPos, "getPos": _0__GlobalIDL.MyServiceWithTypeChild._d_getPos, "get_echo_history": _0__GlobalIDL.MyServiceWithTypeChild._d_get_echo_history, "get_value_history": _0__GlobalIDL.MyServiceWithTypeChild._d_get_value_history}

MyServiceWithTypeChild._omni_skeleton = MyServiceWithTypeChild
_0__GlobalIDL__POA.MyServiceWithTypeChild = MyServiceWithTypeChild
del MyServiceWithTypeChild
__name__ = "_GlobalIDL"

#
# End of module "_GlobalIDL"
#
__name__ = "MyServiceChildWithType_idl"

_exported_modules = ( "_GlobalIDL", )

# The end.