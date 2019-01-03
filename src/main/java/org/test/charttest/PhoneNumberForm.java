package org.test.charttest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.validator.StringLengthValidator;

public class PhoneNumberForm extends VerticalLayout {
    protected TextField descriptionField = new TextField("Title");
    protected TextField countryCodeField = new TextField("Country code");
    protected TextField phoneNumberField = new TextField("Number");

    private PhoneNumber number = new PhoneNumber("Test", "+358", "504111111");
    Binder<PhoneNumber> binder;
    private Button saveButton = new Button("Save");

    public PhoneNumberForm() {
        binder = new Binder<>(PhoneNumber.class);
        binder.readBean(number);

        binder.bind(descriptionField, "description");
        binder.forField(countryCodeField).asRequired().withValidator(new StringLengthValidator("Too long", 0, 3)).bind("countryCode");
        binder.forField(countryCodeField).asRequired().withValidator(new StringLengthValidator("Too long", 0, 10)).bind("number");

        saveButton.addClickListener(e -> {
            try {
                binder.writeBean(number);
                System.out.println(number.toString());
            } catch (ValidationException e1) {
                //...
            }
        });

        add(descriptionField, countryCodeField, phoneNumberField, saveButton);
    }
}
