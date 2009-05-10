package com.dendrytdev.org.client.problemOverview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;

/**
 * ProblemOverview composite
 * gives client opportunity to search for dendryt-Problems
 * @author michal
 *
 */
public class ProblemOverview extends Composite {
	TextBox _produktTextBox;
	TextBox _firstNameTextBox;
	TextBox _surnameTextBox;
	TextBox _phoneTextBox;
	TextBox _ratioTextBox;
	TextBox _dateTextBox;

	public ProblemOverview() {
		
		// initialize textboxes
		_produktTextBox = new TextBox();
		_firstNameTextBox = new TextBox();
		_surnameTextBox = new TextBox();
		_phoneTextBox = new TextBox();
		_ratioTextBox = new TextBox();
		_dateTextBox = new TextBox();

		
		HorizontalPanel mainPanel = new HorizontalPanel();
		initWidget(mainPanel);
		mainPanel.setWidth("500");

		//wrapp by decorator LEFT Panel and add it to the mainPanel
		DecoratorPanel leftWrapper = new DecoratorPanel();
		Panel leftPanel = generateLeftVerticalPanel(); // creating leftPanel HERE
		leftWrapper.setWidget(leftPanel);
		mainPanel.add(leftWrapper);
		
		//create RIGHT Panel
		VerticalPanel rightVerticalPanel = new VerticalPanel();
		mainPanel.add(rightVerticalPanel);

		//add labels with textboxes on up of RIGHT Panel
		rightVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		DecoratorPanel rightWrapper = new DecoratorPanel();
		rightWrapper.setWidget(generatePropertiesFieldsPanel()); // creating panel HERE
		rightVerticalPanel.add(rightWrapper);

		HorizontalPanel rightDownPanel = new HorizontalPanel();
		rightVerticalPanel.add(rightDownPanel);

		VerticalPanel assignmentPanel = new VerticalPanel();
		DecoratorPanel assignmentWrapper = new DecoratorPanel();
		assignmentWrapper.setWidget(assignmentPanel);
		rightDownPanel.add(assignmentWrapper);

		VerticalPanel descriptionPanel = new VerticalPanel();
		DecoratorPanel descriptionWrapper = new DecoratorPanel();
		descriptionWrapper.setWidget(descriptionPanel);
		rightDownPanel.add(descriptionWrapper);

		setWidth("500");
	}
	
	VerticalPanel generateLeftVerticalPanel(){
		VerticalPanel leftVerticalPanel = new VerticalPanel();

		leftVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		leftVerticalPanel.add(absolutePanel);
		absolutePanel.setSize("200", "320");
		ListBox listBox = new ListBox();
		absolutePanel.add(listBox);
		listBox.setSize("200", "300");
		listBox.setVisibleItemCount(5);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		leftVerticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("200");

		Label label = new Label("Wyszukaj:");
		horizontalPanel_1.add(label);
		SuggestBox suggestBox = new SuggestBox();
		horizontalPanel_1.add(suggestBox);
		suggestBox.setWidth("120");
		
		return leftVerticalPanel;
	}
	
	
	

	/**
	 * 
	 * DAMN DAMN DAMN!!!
	 * Workaround used to extract method from addProblemPropertiesFields()-method
	 * and still work with instantine-GWT plugin
	 * 
	 * all other tries to do it in simply way failed.
	 * I tried to extract non-static method in ProblemOverview - failed.
	 * I tried to extract static method in ProblemOverview - failed.
	 * 
	 * Obviously it worked normally (when executing application) but
	 * DESIGN-mode in instantine-GWT plugin blowed up (DAMN!)
	 * @author michal
	 *
	 */
	static class StaticHelperClass{
		static HorizontalPanel generate(String labelName, TextBox textBox){
			HorizontalPanel horizontalPane = new HorizontalPanel();
			Label l = new Label(labelName);
			l.setWidth("200");
			horizontalPane.add(l);
			horizontalPane.add(textBox);		
			return horizontalPane;
		}		
	}
	
	
	/**
	 * Generates a set of horizontal panels with labels and textboxes.
	 * All it is connected with content of Problem-bean	 * 
	 * @param panel - panel to which it adds this hPanels
	 */
	VerticalPanel generatePropertiesFieldsPanel() {
		VerticalPanel panel = new VerticalPanel();
		panel.add(StaticHelperClass.generate("Produkt:", _produktTextBox));
		panel.add(StaticHelperClass.generate("Imie zglaszajacego:", _firstNameTextBox));
		panel.add(StaticHelperClass.generate("Nazwisko zglaszajacego:", _surnameTextBox));
		panel.add(StaticHelperClass.generate("Telefon zglaszajacego:", _phoneTextBox));
		panel.add(StaticHelperClass.generate("Waga zglaszajacego:", _ratioTextBox));
		panel.add(StaticHelperClass.generate("Data zgloszenia:", _dateTextBox));
		return panel;
	}
}
