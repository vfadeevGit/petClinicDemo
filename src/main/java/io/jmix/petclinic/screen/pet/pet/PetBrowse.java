package io.jmix.petclinic.screen.pet.pet;

import io.jmix.petclinic.entity.owner.Owner;
import io.jmix.petclinic.entity.pet.Pet;
import io.jmix.petclinic.entity.pet.PetType;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.EntityComboBox;
import io.jmix.ui.component.Slider;
import io.jmix.ui.component.TextField;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("petclinic_Pet.browse")
@UiDescriptor("pet-browse.xml")
@LookupComponent("petsTable")
@Route(value = "pets")
public class PetBrowse extends StandardLookup<Pet> {

    @Inject
    protected Slider birthdateFilterField;

    @Inject
    protected TextField<String> idFilterField;

    @Inject
    protected EntityComboBox<Owner> ownerFilterField;

    @Inject
    protected EntityComboBox<PetType> typeFilterField;


    @Subscribe("petsTable.clearFilter")
    protected void onPetsTableClearFilter(Action.ActionPerformedEvent event) {
        typeFilterField.setValue(null);
        ownerFilterField.setValue(null);
        idFilterField.setValue(null);
        birthdateFilterField.setValue(null);
    }

}