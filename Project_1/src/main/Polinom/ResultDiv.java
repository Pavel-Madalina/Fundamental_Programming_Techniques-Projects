package ro.tuc.tp.assig_1;

public class ResultDiv extends Result {
	private Polinom r;

	public ResultDiv(Polinom p, Polinom r) {
		super(p);
		this.r = r;
	}

	public Polinom getR() {
		return r;
	}

	public void setR(Polinom r) {
		this.r = r;
	}

}
