package MDV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Controler {
    private Production prod;
    private View view;
    
    public Controler(Production prod, View view) {
        this.prod = prod;
        this.view = view;
        
        this.chargerDonnées();
        
        // -- NORTH ----- //
        
        view.getBtnChargerDonnées().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	chargerDonnées();
            }
        });
        
        view.getBtnElements().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showElements();
			}
		});

        view.getBtnChaines().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showChaines();	
			}
		});
        
        // -- CENTER ----- //
        view.getBtnDoChaineProd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doChaineProd();	
			}
		});
        
        for (String key : view.getNumberOfOrdersJTextField().keySet()) {
        	view.getNumberOfOrdersJTextField().get(key).getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					checkAndExecute();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					checkAndExecute();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					checkAndExecute();
				}
				
				private void checkAndExecute() {
			        view.getNumberOfOrdersJLabel().get(key).setText(prod.doProductionNTimesPlanned(key, Integer.valueOf(view.getNumberOfOrdersJTextField().get(key).getText())));
				}
			});
        }

    }

	private void chargerDonnées() {
        this.prod.chargementDonnées();
        this.view.setStockElement(prod.getElement());
        this.view.setStockChaines(prod.getChaine());
        this.view.setCenterRows(prod.getChaine());
        //vue.setValeur(prod.getValeur());
        this.refreshView();
    }
    
    private void showElements() {
    	this.view.setShowElements();
    	this.refreshView();
    }
    
    private void showChaines() {
    	this.view.setShowChaines();
    	this.refreshView();
    }
    
    private void doChaineProd() {
    	//this.view.addCenterRow();
    	//this.refreshView();
    }
    
    private void refreshView() {
    	this.view.refreshView();
    }
    
    
}
