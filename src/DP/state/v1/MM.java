package DP.state.v1;

/**
 * 当增加新的状态时不方便
 */
public class MM {
    String name;
    MMState state;
    public void smile(){
        state.smile();
    }

    public void cry(){
        state.cry();
    }

    public void say(){
        state.say();
    }
}

abstract class MMState{
    abstract void smile();
    abstract void cry();
    abstract void say();
}

class MMHappyState extends MMState{
    @Override
    void smile() {

    }

    @Override
    void cry() {

    }

    @Override
    void say() {

    }
}

class MMSadState extends MMState{
    @Override
    void smile() {

    }

    @Override
    void cry() {

    }

    @Override
    void say() {

    }
}
