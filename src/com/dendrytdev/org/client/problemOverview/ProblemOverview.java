package com.dendrytdev.org.client.problemOverview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;

public class ProblemOverview extends Composite {
	TextBox _produktTextBox;
	TextBox _firstNameTextBox;
	TextBox _surnameTextBox;
	TextBox _phoneTextBox;
	TextBox _ratioTextBox;
	TextBox _dateTextBox;

	public ProblemOverview() {
		_produktTextBox = new TextBox();
		_firstNameTextBox = new TextBox();
		_surnameTextBox = new TextBox();
		_phoneTextBox = new TextBox();
		_ratioTextBox = new TextBox();
		_dateTextBox = new TextBox();
		
		{
			HorizontalPanel horizontalPanel = new HorizontalPanel();
			initWidget(horizontalPanel);
			{
				VerticalPanel verticalPanel = new VerticalPanel();
				horizontalPanel.add(verticalPanel);
				verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				{
					
					AbsolutePanel absolutePanel = new AbsolutePanel();
					verticalPanel.add(absolutePanel);
					absolutePanel.setSize("200", "320");
					ListBox listBox = new ListBox();
					absolutePanel.add(listBox);
					listBox.setSize("200", "300");
					listBox.setVisibleItemCount(5);
					
					HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
					verticalPanel.add(horizontalPanel_1);
					horizontalPanel_1.setWidth("200");
					
					Label label = new Label("Wyszukaj:");
					horizontalPanel_1.add(label);
					SuggestBox suggestBox = new SuggestBox();
					horizontalPanel_1.add(suggestBox);
					suggestBox.setWidth("120");
				}
			}
			{
				VerticalPanel verticalPanel = new VerticalPanel();
				horizontalPanel.add(verticalPanel);
				verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				
				addProblemPropertiesFields(verticalPanel);
			}
		}
	}

	
	
	static HorizontalPanel addProblemPropertyField(String labelName, TextBox textBox){
		HorizontalPanel horizontalPane = new HorizontalPanel();
		horizontalPane.add(new Label(labelName));
		horizontalPane.add(textBox);		
		return horizontalPane;
	}
	
	void addProblemPropertiesFields(VerticalPanel panel) {
		
//		Nawet tak nie dziala, co za syf!!!
		panel.add(addProblemPropertyField("Produkt:", _produktTextBox));
		panel.add(addProblemPropertyField("Imie zglaszajacego:", _firstNameTextBox));
//		addProblemPropertyField(panel, "Nazwisko zglaszajacego:", _surnameTextBox);
//		addProblemPropertyField(panel, "Telefon zglaszajacego:", _phoneTextBox);
//		addProblemPropertyField(panel, "Waga zglaszajacego:", _ratioTextBox);
//		addProblemPropertyField(panel, "Data zgloszenia:", _dateTextBox);
	}
	
	

}
