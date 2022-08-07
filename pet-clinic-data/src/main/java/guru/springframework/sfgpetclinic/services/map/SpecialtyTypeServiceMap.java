package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.SpecialtyType;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyTypeServiceMap extends AbstractMapService<SpecialtyType, Long> implements SpecialtyService {
	@Override
	public Set<SpecialtyType> findAll() {
		return super.findAll();
	}

	@Override
	public SpecialtyType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public SpecialtyType save(SpecialtyType object) {
		return super.save(object);
	}

	@Override
	public void delete(SpecialtyType object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
