package co.edu.uco.ucochallenge.primary.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import co.edu.uco.ucochallenge.secondary.ports.repository.*;


@RestController
@RequestMapping("/uco-challenge/api/v1/catalog")
public class CatalogController {

    private final CountryRepository countryRepo;
    private final StateRepository stateRepo;
    private final CityRepository cityRepo;
    private final IdTypeRepository idTypeRepo;

    public CatalogController(
            CountryRepository countryRepo,
            StateRepository stateRepo,
            CityRepository cityRepo,
            IdTypeRepository idTypeRepo) {
        this.countryRepo = countryRepo;
        this.stateRepo = stateRepo;
        this.cityRepo = cityRepo;
        this.idTypeRepo = idTypeRepo;
    }

    // -------------------------
    // 📍 Listar países
    // -------------------------
    @GetMapping("/countries")
    public List<Map<String, Object>> getCountries() {
        return countryRepo.findAll().stream()
                .map(country -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", country.getId());
                    map.put("name", country.getName());
                    return map;
                })
                .collect(Collectors.toList());
    }


    @GetMapping("/states")
    public List<Map<String, Object>> getStates(@RequestParam UUID countryId) {
        return stateRepo.findByCountryId(countryId).stream()
                .map(state -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", state.getId());
                    map.put("name", state.getName()); 
                    return map;
                })
                .collect(Collectors.toList());
    }


    @GetMapping("/cities")
    public List<Map<String, Object>> getCities(@RequestParam UUID stateId) {
        return cityRepo.findByState_Id(stateId).stream()
                .map(city -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", city.getId());
                    map.put("name", city.getName());
                    return map;
                })
                .collect(Collectors.toList());
    }

 
    @GetMapping("/id-types")
    public List<Map<String, Object>> getIdTypes() {
        return idTypeRepo.findAll().stream()
                .map(idType -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", idType.getId());
                    map.put("name", idType.getName());
                    return map;
                })
                .collect(Collectors.toList());
    }
}


