package messerli.database1.data;

import java.util.HashSet;
import java.util.Set;

import messerli.database1.cashier.DataModel;
import messerli.database1.cashier.StateChangedListener;
import messerli.database1.model.Flug;
import messerli.database1.model.Taube;

public class DataClass implements DataModel {
    private Set<StateChangedListener> listeners = new HashSet<>();
    private Taube taube;
    private Flug flug;

    public DataClass(Taube taube, Flug flug) {
        this.taube = taube;
        this.flug = flug;
    }

    @Override
    public void addStateChangedLister(StateChangedListener listener) {
        listeners.add(listener);

    }

    private void notifyListeners() {
        for (StateChangedListener l : listeners) {
            l.updatedValues(this, taube.getTaubenId(), flug.getFlugId());
        }
    }

    @Override
    public String getTaubenId() {

        return taube.getTaubenId();
    }

    @Override
    public String getFlugId() {

        return flug.getFlugId();
    }
    /*
     * @Override public void updateValues(Taube taube, Flug flug) { this.taube =
     * taube; this.flug = flug;
     * 
     * }
     */

}
