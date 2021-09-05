package messerli.database1.model;

public final class Taube {

    private final String nation;
    private final String jahrgang;
    private final String nummer;

    public Taube(String nation, String jahrgang, String nummer) {
        this.nation = nation;
        this.jahrgang = jahrgang;
        this.nummer = nummer;
    }

    public String getNation() {
        return this.nation;
    }

    public String getJahrgang() {
        return this.jahrgang;
    }

    public String getNummer() {
        return this.nummer;
    }

    @Override
    public String toString() {
        return "{" + " nation='" + getNation() + "'" + ", jahrgang='" + getJahrgang() + "'" + ", nummer='" + getNummer()
                + "'" + "}";
    }

    public String getTaubenId() {
        return nation + "-" + jahrgang + "-" + nummer;
    }

}
