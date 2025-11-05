package co.edu.uco.ucochallenge.primary.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucochallenge.secondary.ports.repository.CityRepository;
import co.edu.uco.ucochallenge.secondary.ports.repository.CountryRepository;
import co.edu.uco.ucochallenge.secondary.ports.repository.DepartmentRepository;
import co.edu.uco.ucochallenge.secondary.ports.repository.IdTypeRepository;

@RestController
@RequestMapping("/uco-challenge/api/v1/catalog")
public class CatalogController {

    private final CountryRepository countryRepo;
    private final DepartmentRepository deptRepo;
    private final CityRepository cityRepo;
    private final IdTypeRepository idTypeRepo;


    public CatalogController(
            CountryRepository countryRepo,
            DepartmentRepository deptRepo,
            CityRepository cityRepo,
            IdTypeRepository idTypeRepo) {
        this.countryRepo = countryRepo;
        this.deptRepo = deptRepo;
        this.cityRepo = cityRepo;
        this.idTypeRepo = idTypeRepo;
    }

 
    @GetMapping("/countries")
    public List<Map<String,Object>> getCountries() {
        return countryRepo.findAll().stream()
                .map(c -> Map.of(
                        "id", c.getId(),
                        "name", c.getName()
                ))
                .collect(Collectors.toList());
    }


    @GetMapping("/departments")
    public List<Map<String, Object>> getDepartments(@RequestParam UUID countryId) {
        return deptRepo.findByCountryId(countryId).stream()
                .map(d -> Map.of(
                        "id", d.getId(),
                        "name", d.getName()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/cities")
    public List<Map<String, Object>> getCities(@RequestParam UUID departmentId) {
        return cityRepo.findByDepartmentId(departmentId).stream()
                .map(ci -> Map.of(
                        "id", ci.getId(),
                        "name", ci.getName()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/id-types")
    public List<Map<String, Object>> getIdTypes() {
        return idTypeRepo.findAll().stream()
                .map(t -> Map.of(
                        "id", t.getId(),
                        "name", t.getName()
                ))
                .collect(Collectors.toList());
    }
}


