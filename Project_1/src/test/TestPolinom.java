package ro.tuc.tp.assig_1;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;

public class TestPolinom {
	private static Polinom p1;
	private static Polinom p2;
	private static Result p3;
	private static ResultDiv p4;

	public TestPolinom() {
		List<Monom> l1 = new ArrayList<Monom>(Arrays.asList(new Monom(2, 2), new Monom(3, 1)));
		p1 = new Polinom(l1);
		List<Monom> l2 = new ArrayList<Monom>(Arrays.asList(new Monom(1, 2), new Monom(1, 0)));
		p2 = new Polinom(l2);
		Polinom p = new Polinom(new ArrayList<Monom>(Arrays.asList(new Monom(0, 0))));
		p3 = new Result(p);
		p4 = new ResultDiv(p, p);
	}

	@Test
	public void testAddOperation() {
		IOperation op = new AddOperation();
		p3 = op.compute(p1, p2);
		System.out.println("Test adunare: " + p3.getP().toString());
		assertNotNull(p3.getP().toString());
		assertEquals(p3.getP().toString(), "+3.0x^2+3.0x^1+1.0x^0");
	}

	@Test
	public void testSubOperation() {
		IOperation op = new SubOperation();
		p3 = op.compute(p1, p2);
		System.out.println("Test scadere: " + p3.getP().toString());
		assertNotNull(p3.getP().toString());
		assertEquals(p3.getP().toString(), "+1.0x^2+3.0x^1-1.0x^0");
	}

	@Test
	public void testMulOperation() {
		IOperation op = new MulOperation();
		p3 = op.compute(p1, p2);
		System.out.println("Test inmultire: " + p3.getP().toString());
		assertNotNull(p3.getP().toString());
		assertEquals(p3.getP().toString(), "+2.0x^4+3.0x^3+2.0x^2+3.0x^1");
	}

	@Test
	public void testDivOperation() {
		IOperation op = new DivOperation();
		p4 = (ResultDiv) op.compute(p1, p2);
		System.out.println("Test impartire: \n" + "q= " + p4.getP().toString() + "\nr= " + p4.getR().toString());
		assertEquals(p4.getP().toString(), "+2.0x^0");
		assertEquals(p4.getR().toString(), "+3.0x^1-2.0x^0");
	}

	@Test
	public void testDerivOperation() {
		IOperation op = new DerivOperation();
		p3 = op.compute(p1, null);
		System.out.println("Test derivare: " + p3.getP().toString());
		assertEquals(p3.getP().toString(), "+4.0x^1+3.0x^0");
	}

	@Test
	public void testIntOperation() {
		IOperation op = new IntOperation();
		p3 = op.compute(p1, null);
		System.out.println("Test integrare: " + p3.getP().toString());
		assertEquals(p3.getP().toString(), "+0.6666667x^3+1.5x^2");
	}
}