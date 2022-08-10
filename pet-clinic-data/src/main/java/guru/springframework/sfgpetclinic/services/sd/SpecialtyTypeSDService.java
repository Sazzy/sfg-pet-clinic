package guru.springframework.sfgpetclinic.services.sd;

import guru.springframework.sfgpetclinic.model.SpecialtyType;
import guru.springframework.sfgpetclinic.repositories.SpecialtyTypeRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SpringDataJPA")
public class SpecialtyTypeSDService implements SpecialtyTypeService {
	private final SpecialtyTypeRepository specialtyTypeRepository;

	public SpecialtyTypeSDService(SpecialtyTypeRepository specialtyTypeRepository) {
		this.specialtyTypeRepository = specialtyTypeRepository;
	}

	@Override
	public Set<SpecialtyType> findAll() {
		Set<SpecialtyType> specialtyTypes = new HashSet<>();
		specialtyTypeRepository.findAll().forEach(specialtyTypes::add);
		return specialtyTypes;
	}

	@Override
	public SpecialtyType findById(Long id) {
		return specialtyTypeRepository.findById(id).orElse(null);
	}

	@Override
	public SpecialtyType save(SpecialtyType specialtyType) {
		return specialtyTypeRepository.save(specialtyType);
	}

	@Override
	public void delete(SpecialtyType specialtyType) {
		specialtyTypeRepository.delete(specialtyType);
	}

	@Override
	public void deleteById(Long id) {
		specialtyTypeRepository.deleteById(id);
	}
}
