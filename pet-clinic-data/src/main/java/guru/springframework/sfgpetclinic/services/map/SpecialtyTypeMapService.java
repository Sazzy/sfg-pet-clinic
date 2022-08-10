package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.SpecialtyType;
import guru.springframework.sfgpetclinic.services.SpecialtyTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialtyTypeMapService extends AbstractMapService<SpecialtyType, Long> implements SpecialtyTypeService {
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
