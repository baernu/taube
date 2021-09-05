package messerli.database1.cashier;

public interface StateChangedListener {
    void updatedValues(DataModel data, String taubeId, String flugId);
}
