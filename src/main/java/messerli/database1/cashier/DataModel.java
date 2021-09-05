package messerli.database1.cashier;

public interface DataModel {

    void addStateChangedLister(StateChangedListener stateChangedListener);

    String getTaubenId();

    String getFlugId();

}
