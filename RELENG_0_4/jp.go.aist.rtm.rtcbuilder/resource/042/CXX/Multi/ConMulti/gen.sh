rtc-template -bcxx --module-name=foo --module-desc='test module' --module-version=1.0.1 --module-vendor=TA --module-category=sample --module-comp-type=STATIC --module-act-type=PERIODIC --module-max-inst=2 --inport=in1:TimedShort --outport=out1:TimedLong --consumer-idl=MyService.idl --consumer-idl=DAQService.idl --consumer=MyConPro:myservice0:MyService --consumer=MyConPro2:myservice2:DAQService 