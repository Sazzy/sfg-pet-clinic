package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
	private Set<SpecialtyType> specialties = new HashSet<>();

	public Set<SpecialtyType> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<SpecialtyType> specialties) {
		this.specialties = specialties;
	}
}
