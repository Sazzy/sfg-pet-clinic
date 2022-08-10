package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyTypeService specialtyTypeService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService,
					  VetService vetService,
					  PetTypeService petTypeService,
					  SpecialtyTypeService specialtyTypeService,
					  VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyTypeService = specialtyTypeService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		System.out.println("Loaded pet types...");

		SpecialtyType radiology = new SpecialtyType();
		radiology.setDescription("Radiology");
		SpecialtyType savedRadiology = specialtyTypeService.save(radiology);

		SpecialtyType surgery = new SpecialtyType();
		surgery.setDescription("Surgery");
		SpecialtyType savedSurgery = specialtyTypeService.save(surgery);

		SpecialtyType dentistry = new SpecialtyType();
		dentistry.setDescription("Dentistry");
		SpecialtyType savedDentistry = specialtyTypeService.save(dentistry);

		System.out.println("Loaded specialty types");

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setPhone("1231231230");

		Pet mikesPet = new Pet();
		mikesPet.setName("Rosco");
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("321 Brickerel");
		owner2.setCity("London");
		owner2.setPhone("4564564560");

		Pet fionasPet = new Pet();
		fionasPet.setName("Just cat");
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now());
		owner2.getPets().add(fionasPet);

		ownerService.save(owner2);

		System.out.println("Loaded owners...");

		Visit catVisit = new Visit();
		catVisit.setPet(fionasPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");

		visitService.save(catVisit);

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedRadiology);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialties().add(savedSurgery);
		vetService.save(vet2);

		System.out.println("Loaded vets...");
	}
}
