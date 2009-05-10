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

	public ProblemOverview() {
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

	TextBox _produktTextBox;
	TextBox _firstNameTextBox;
	TextBox _surnameTextBox;
	TextBox _phoneTextBox;
	TextBox _ratioTextBox;
	TextBox _dateTextBox;
	
	
	void addProblemPropertyField(VerticalPanel panel, String labelName, TextBox t){
		HorizontalPanel horizontalPane = new HorizontalPanel();
		panel.add(horizontalPane);
		horizontalPane.add(new Label(labelName));
		_produktTextBox = new TextBox();
		horizontalPane.add(t);		
	}
	
	void addProblemPropertiesFields(VerticalPanel panel) {
		HorizontalPanel horizontalPane = new HorizontalPanel();
		panel.add(horizontalPane);
		horizontalPane.add(new Label("Produkt:"));
		_produktTextBox = new TextBox();
		horizontalPane.add(_produktTextBox);
		
		HorizontalPanel horizontalPane2 = new HorizontalPanel();
		panel.add(horizontalPane2);
		horizontalPane2.add(new Label("Imie zglaszajacego:"));
		_produktTextBox = new TextBox();
		horizontalPane2.add(_produktTextBox);
		
		HorizontalPanel horizontalPane = new HorizontalPanel();
		panel.add(horizontalPane);
		horizontalPane.add(new Label("Nazwisko zglaszajacego:"));
		_produktTextBox = new TextBox();
		horizontalPane.add(_produktTextBox);
		
		HorizontalPanel horizontalPane = new HorizontalPanel();
		panel.add(horizontalPane);
		horizontalPane.add(new Label("Telefon zglaszajacego:"));
		_produktTextBox = new TextBox();
		horizontalPane.add(_produktTextBox);
		
		HorizontalPanel horizontalPane = new HorizontalPanel();
		panel.add(horizontalPane);
		horizontalPane.add(new Label("Waga zglaszajacego:"));
		_produktTextBox = new TextBox();
		horizontalPane.add(_produktTextBox);
		
		HorizontalPanel horizontalPane = new HorizontalPanel();
		panel.add(horizontalPane);
		horizontalPane.add(new Label("Data zgloszenia:"));
		_produktTextBox = new TextBox();
		horizontalPane.add(_produktTextBox);
		
		
	}
	
	

}
