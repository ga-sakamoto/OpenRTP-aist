  
import jp.go.aist.rtm.RTC.jfsm.Event;
import jp.go.aist.rtm.RTC.jfsm.State;


/**
 * 
 */
  
public class State01 extends Top {
    @Override
    public void Event01_02() {
        setState(new State(State02.class));
    }

//    @Override
//    public void onInit() {
//    }

//    @Override
//    public void onEntry() {
//    }

//    @Override
//    public void onExit() {
//    }

}