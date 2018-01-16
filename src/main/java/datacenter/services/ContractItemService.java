package datacenter.services;

import datacenter.models.Constants;
import datacenter.models.Sport;
import datacenter.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContractItemService {

    @Autowired
    private AgeGroupRepository ageGroupRepository;

    @Autowired
    private AlternativeTransportRepository alternativeTransportRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private InsuranceAmountRepository insuranceAmountRepository;

    @Autowired
    private ObjectAgeGroupRepository objectAgeGroupRepository;

    @Autowired
    private ObjectValueRepository objectValueRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private RepairmentRepository repairmentRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private SurfaceRepository surfaceRepository;

    @Autowired
    private TowingRepository towingRepository;


    public Object[] findAll(String itemName) {
        switch (itemName) {
            case Constants.AGE_GROUP :
                return ageGroupRepository.findAll().toArray();
            case Constants.ALTERNATIVE_TRANSPORT:
                return alternativeTransportRepository.findAll().toArray();
            case Constants.HOTEL:
                return hotelRepository.findAll().toArray();
            case Constants.INSURANCE_AMOUNT:
                return insuranceAmountRepository.findAll().toArray();
            case Constants.OBJECT_AGE_GROUP:
                return objectAgeGroupRepository.findAll().toArray();
            case Constants.OBJECT_VALUE:
                return objectValueRepository.findAll().toArray();
            case Constants.REGION:
                return regionRepository.findAll().toArray();
            case Constants.REPAIRMENT:
                return repairmentRepository.findAll().toArray();
            case Constants.RISK:
                return riskRepository.findAll().toArray();
            case Constants.SPORT:
                return sportRepository.findAll().toArray();
            case Constants.SURFACE:
                return surfaceRepository.findAll().toArray();
            case Constants.TOWING:
                return towingRepository.findAll().toArray();
            default:
                return null;

        }
    }

}
