package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.SpecialtyType;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyTypeRepository extends CrudRepository<SpecialtyType, Long> {
}
