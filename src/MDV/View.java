
package MDV;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.print.attribute.AttributeSet;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class View extends JFrame {
	
    // -- North Components ----- //
    private JPanel northPanel;
    private JButton chargerDonnées;
    private JButton sauvegarderDonnées;
    private JButton elements_btn;
    private JButton chaines_btn;
    private JButton prix_btn;
    
    // -- West Components ----- //
    private JPanel westPanel;
    private CardLayout cardLayout;
    private GridBagConstraints gbc;
    private JPanel elementsCard;
    private JPanel chainesCard;
    
    // -- Center Components ----- //
    private JPanel centerPanel;
    private JPanel centerRow;
    private JButton doChaineProd;
    private JLabel chaineCode;
    private JLabel chainePlanned;
    private HashMap<String, JTextField> numberOfOrdersJTextField = new HashMap<String, JTextField>();
    private HashMap<String, JLabel> numberOfOrdersJLabel = new HashMap<String, JLabel>();

    
    // -- East Components ----- //
    private JPanel eastPanel;
    
    // -- South Components ----- //
    private JPanel southPanel;

    public View() {
        super("Gestionnaire de production"); 				 	
        this.setLayout(new BorderLayout());

        this.setNorthPannel();
        this.setWestPanel();
        this.setCenterPanel();
        
        this.setView();
    }
    
    public void setView() {
    	this.pack();
        this.setVisible(true);
    }
    
    // -- NORTH ----- //
    
    public void setNorthPannel() {
    	this.northPanel = new JPanel(new GridBagLayout());    	
    	this.setGBC();
    	this.setNorthFirstRow();
    	this.setNorthSecondRow();
        this.add(this.northPanel, BorderLayout.NORTH);
    }
    
    public void setGBC() {
    	this.gbc = new GridBagConstraints();
    	this.gbc.gridwidth = GridBagConstraints.REMAINDER;
    	this.gbc.fill = GridBagConstraints.HORIZONTAL;
    }
    
    public void setNorthFirstRow() {
    	JPanel firtsRow = new JPanel(new GridLayout());
    	this.chargerDonnées = new JButton("Charger les données");
    	this.sauvegarderDonnées = new JButton("Sauvegarder les données");
    	firtsRow.add(chargerDonnées);
    	firtsRow.add(sauvegarderDonnées);
    	this.northPanel.add(firtsRow, this.gbc);
    }
    
    public void setNorthSecondRow() {
    	JPanel secondRow = new JPanel(new GridLayout());
        this.elements_btn = new JButton("Elements");
        this.chaines_btn = new JButton("Chaines");
        this.prix_btn = new JButton("Prix");
        secondRow.add(elements_btn);
        secondRow.add(chaines_btn);
        secondRow.add(prix_btn);
    	this.northPanel.add(secondRow, this.gbc);
    }
    
    public JButton getBtnChargerDonnées() {
        return this.chargerDonnées;
    }
    
    public JButton getBtnElements() {
    	return this.elements_btn;
    }
    
    public JButton getBtnChaines() {
    	return this.chaines_btn;
    }
    
    public JButton getBtnPrix() {
    	return this.prix_btn;
    }
    
    // -- WEST ----- //
    
    public void setWestPanel() {
    	this.cardLayout = new CardLayout();
    	this.westPanel = new JPanel(cardLayout);
    	this.setElementsCard();
    	this.setChainesCard();
    	this.add(this.westPanel, BorderLayout.WEST);
    }    
    
    public void setElementsCard() {
    	this.elementsCard = new JPanel(new GridLayout(0,5));
    	this.topTableElements();
    	this.westPanel.add(elementsCard, "elements");
    }
    
    public void setChainesCard() {
    	this.chainesCard = new JPanel(new GridLayout(0,4));
    	this.topTableChaines();
    	this.westPanel.add(chainesCard, "chaines");
    }
    
    private void topTable(JPanel panel) {
    	panel.add(new JLabel(String.valueOf("Code")));
    	panel.add(new JLabel(String.valueOf("Nom")));
    }
    
    public void topTableElements() {
    	this.topTable(elementsCard);
    	this.elementsCard.add(new JLabel(String.valueOf("Quantité")));
    	this.elementsCard.add(new JLabel(String.valueOf("Achat")));
    	this.elementsCard.add(new JLabel(String.valueOf("Vente")));
    	this.setBorder(elementsCard, true);
    }
    
    public void topTableChaines() {
    	this.topTable(chainesCard);
    	this.chainesCard.add(new JLabel(String.valueOf("Entrée (code, qte)")));
    	this.chainesCard.add(new JLabel(String.valueOf("Sortie (code, qte)")));
    	this.setBorder(chainesCard, true);
    }
    
    public void setStockElement(Stock StockEle) {
    	this.elementsCard.removeAll();
    	this.topTableElements();
    	TreeMap<String, CSVFile> sortedStock = new TreeMap<>(StockEle.getStock());
		StringBuilder result = new StringBuilder();
	    for (String key : sortedStock.keySet()) {
	    	this.elementsCard.add(new JLabel(String.valueOf(StockEle.getElement(key).getCode())));
	    	this.elementsCard.add(new JLabel(String.valueOf(StockEle.getElement(key).getNom())));
	    	this.elementsCard.add(new JLabel(String.valueOf(StockEle.getElement(key).getQuantite())));
	    	this.elementsCard.add(new JLabel(String.valueOf(StockEle.getElement(key).getToStringAchat())));
	    	this.elementsCard.add(new JLabel(String.valueOf(StockEle.getElement(key).getToStringVente())));
	    }
    	this.setBorder(elementsCard, false);
    }
    
    public void setStockChaines(Stock StockCha) {
		this.chainesCard.removeAll();
		this.topTableChaines();
		TreeMap<String, CSVFile> sortedStock = new TreeMap<>(StockCha.getStock());
		StringBuilder result = new StringBuilder();
		for (String key : sortedStock.keySet()) {
	    	this.chainesCard.add(new JLabel(String.valueOf(StockCha.getChaine(key).getCode())));
	    	this.chainesCard.add(new JLabel(String.valueOf(StockCha.getChaine(key).getNom())));
	    	this.chainesCard.add(new JLabel(String.valueOf(StockCha.getChaine(key).getInToString())));
	    	this.chainesCard.add(new JLabel(String.valueOf(StockCha.getChaine(key).getOut())));
		}
		this.setBorder(chainesCard, false);
	}
    
    public void setBorder(JPanel panel, boolean topTable) {
    	for (Component label : panel.getComponents()) {
    		if (label instanceof JLabel) {
    			((JLabel) label).setBorder(BorderFactory.createDashedBorder(Color.BLACK));
    			if (topTable) {
    				((JLabel) label).setOpaque(true);
    				label.setBackground(Color.BLUE);
    				label.setForeground(Color.WHITE);
    			}
    				
    		}
    	}
    }
    
    public void setShowElements() {
    	this.cardLayout.show(westPanel, "elements");
    }
    
    public void setShowChaines() {
    	this.cardLayout.show(westPanel, "chaines");
    }
	
    
    // -- CENTER ----- //
    
    public void setCenterPanel() {
    	this.centerPanel = new JPanel(new GridBagLayout());
    	this.setGBC();
    	this.doChaineProd = new JButton("Réalisation de la chaîne de production");
    	this.centerPanel.add(doChaineProd, this.gbc);
    	this.setCenterTopTable();
    	//this.addCenterRows();  	
    	this.add(this.centerPanel, BorderLayout.CENTER);
    }
    
    public void setCenterTopTable() {
    	JPanel centerTopTable = new JPanel(new GridLayout());
    	centerTopTable.add(new JLabel("Code"));
    	centerTopTable.add(new JLabel("Nombre à produire"));
    	centerTopTable.add(new JLabel("Indicateur Commande"));
    	this.setBorder(centerTopTable, true);
    	this.centerPanel.add(centerTopTable, this.gbc);
    }
    
    public void setCenterRows(Stock StockCha) {
    	this.centerRow = new JPanel(new GridLayout(0,3));
    	TreeMap<String, CSVFile> sortedStock = new TreeMap<>(StockCha.getStock());
		StringBuilder result = new StringBuilder();
		for (String key : sortedStock.keySet()) {
			JTextField numbersChaineProd = new JTextField();
			JLabel numbersChainPlanned = new JLabel("0.0%");
	    	this.centerRow.add(new JLabel(String.valueOf(StockCha.getChaine(key).getCode())));
	    	this.centerRow.add(numbersChaineProd);
	    	this.centerRow.add(numbersChainPlanned);
	    	this.setConstraintTextFieldInteger(numbersChaineProd);
	 
	    	this.numberOfOrdersJTextField.put(key, numbersChaineProd);
	    	this.numberOfOrdersJLabel.put(key, numbersChainPlanned);
		}
  	
    	this.setBorder(centerRow, false);
    	this.centerPanel.add(centerRow, this.gbc);
    	
    }
    
    public HashMap<String, JTextField> getNumberOfOrdersJTextField() {
    	return this.numberOfOrdersJTextField;
    }
    
    public HashMap<String, JLabel> getNumberOfOrdersJLabel() {
    	return this.numberOfOrdersJLabel;
    }
    
    public void setConstraintTextFieldInteger(JTextField textField) {
    	// TODO
    }
      
    public JButton getBtnDoChaineProd() {
    	return this.doChaineProd;
    }   
    
    public void setChainePlanned(JPanel row) {
    	
    }
      
    public void refreshView() {
    	this.elementsCard.revalidate(); 
    	this.elementsCard.repaint();	
    	    	
    	this.pack();					
    	
    	
    }
}
