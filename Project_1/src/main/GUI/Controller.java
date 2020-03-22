package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ro.tuc.tp.assig_1.*;

public class Controller {
	private View view;

	public Controller(View v) {
		this.view = v;
		view.addAddListener(new ActionListenerBtn());
		view.addSubListener(new ActionListenerBtn());
		view.addMulListener(new ActionListenerBtn());
		view.addDivListener(new ActionListenerBtn());
		view.addDerivListener(new ActionListenerBtn());
		view.addIntListener(new ActionListenerBtn());
		view.addClearListener(new ClearListener());
	}

	class ActionListenerBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				this.readPolinom();
			} catch (Exceptie ex) {
				System.out.println(ex.getMessage());
				return;
			}
			Polinom p1 = new Polinom(new ArrayList<Monom>(Arrays.asList(new Monom(0, 0))));
			Polinom p2 = new Polinom(new ArrayList<Monom>(Arrays.asList(new Monom(0, 0))));
			p1.getTerms().remove(0);
			p2.getTerms().remove(0);
			Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(\\d+\\b)");
			Matcher m1 = p.matcher(view.getPolinom1TF().getText());
			Matcher m2 = p.matcher(view.getPolinom2TF().getText());
			while (m1.find()) {
				p1.getTerms().add(new Monom(Float.parseFloat(m1.group(1)), Integer.parseInt(m1.group(2))));
			}
			while (m2.find()) {
				p2.getTerms().add(new Monom(Float.parseFloat(m2.group(1)), Integer.parseInt(m2.group(2))));
			}
			String s = e.getActionCommand();
			IOperation op = this.getInstance(s);
			Result r = op.compute(p1, p2);
			if (r instanceof ResultDiv) {
				view.setResultTF(r.getP().toString());
				view.setRestTF(((ResultDiv) r).getR().toString());
			} else if (r != null) {
				view.setResultTF(r.getP().toString());
				view.setRestTF(null);
			}
		}

		public IOperation getInstance(String s) {
			if (s.equals("+")) {
				return new AddOperation();
			} else if (s.equals("-")) {
				return new SubOperation();
			} else if (s.equals("*")) {
				return new MulOperation();
			} else if (s.equals("/")) {
				return new DivOperation();
			} else if (s.equals("'")) {
				return new DerivOperation();
			} else if (s.equals("∫")) {
				return new IntOperation();
			}
			return null;
		}

		public void readPolinom() throws Exceptie {
			if (view.getPolinom1TF().getText().equals("")) {
				throw new Exceptie("Introduceti cel putin un polinom!");
			}
		}
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.setResultTF(null);
			view.setRestTF(null);
		}
	}
}
