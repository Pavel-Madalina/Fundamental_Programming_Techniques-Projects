package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business_layer.ProductsBLL;
import business_layer.ProductsValidation;
import dao_package.ProductsAbstractDAO;
import model.Products;

public class ControllerViewProducts {
	private ViewProducts view;
	private ProductsBLL productBLL;

	public ControllerViewProducts(ViewProducts view) {
		super();
		this.view = view;
		this.view.addAddBtnListener(new ActionListenerAdd());
		this.view.addEditBtnListener(new ActionListenerEdit());
		this.view.addDeleteBtnListener(new ActionListenerDelete());
		this.view.addViewAllBtnListener(new ActionListenerViewAll());
		this.view.addBackBtnListener(new ActionListenerBack());
	}

	public class ActionListenerAdd implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String productID_s = view.getProductID().getText();
				int productID = Integer.parseInt(productID_s);
				String productName = view.getProductName().getText();
				String productPrice_s = view.getProductPrice().getText();
				float productPrice = Float.parseFloat(productPrice_s);
				String productStock_s = view.getProductStock().getText();
				int productStock = Integer.parseInt(productStock_s);
				Products product = new Products(productID, productName, productPrice, productStock);
				productBLL = new ProductsBLL(new ProductsAbstractDAO(), new ProductsValidation(product));
				productBLL.addNewProduct(product);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}
	}

	public class ActionListenerEdit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String productID_s = view.getProductIDEdit().getText();
				int productID = Integer.parseInt(productID_s);
				Products product = new Products(0, "", 0, 0);
				productBLL = new ProductsBLL(new ProductsAbstractDAO(), new ProductsValidation(product));
				if (!view.getNewProductName().getText().equals("")) {
					String productNewName = view.getNewProductName().getText();
					productBLL.editProductName(productID, productNewName);
				}
				if (!view.getNewProductPrice().getText().equals("")) {
					String productNewPrice_s = view.getNewProductPrice().getText();
					float productPrice = Float.parseFloat(productNewPrice_s);
					productBLL.editProductPrice(productID, productPrice);
				}
				if (!view.getNewProductStock().getText().equals("")) {
					String productNewStock_s = view.getNewProductStock().getText();
					int productStock = Integer.parseInt(productNewStock_s);
					productBLL.editProductStock(productID, productStock);
				}
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerDelete implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String productID_s = view.getProductIDDelete().getText();
				int productID = Integer.parseInt(productID_s);
				Products product = new Products(0, "", 0, 0);
				productBLL = new ProductsBLL(new ProductsAbstractDAO(), new ProductsValidation(product));
				productBLL.deleteProduct(productID);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
		}

	}

	public class ActionListenerViewAll implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.getModel().setRowCount(0);
			Object[][] rows = new Object[10000][];
			Products product = new Products(0, "", 0, 0);
			productBLL = new ProductsBLL(new ProductsAbstractDAO(), new ProductsValidation(product));
			rows = productBLL.viewAll();
			for (int i = 0; i < rows.length; i++) {
				view.getModel().addRow(rows[i]);
			}
		}

	}

	public class ActionListenerBack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			view.setVisible(false);
			ViewStart view = new ViewStart();
			ControllerViewStart controller = new ControllerViewStart(view);
		}

	}

}
