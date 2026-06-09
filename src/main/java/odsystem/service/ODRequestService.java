package odsystem.service;

import odsystem.entity.ODRequest;
import odsystem.repository.ODRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ODRequestService {

    @Autowired
    private ODRequestRepository repository;

    // Save OD Request
    public ODRequest saveRequest(ODRequest request) {

        // Default status
        request.setStatus("PENDING_PROCTOR");

        return repository.save(request);
    }

    // Get all requests
    public List<ODRequest> getAllRequests() {
        return repository.findAll();
    }

    public ODRequest approveByProctor(Long id) {

        ODRequest request = repository.findById(id).orElse(null);
    
        if(request != null) {
            request.setStatus("PENDING_AC");
            return repository.save(request);
        }
    
        return null;
    }
    
    public ODRequest rejectByProctor(Long id, String reason) {

        ODRequest request = repository.findById(id).orElse(null);
    
        if(request != null) {
    
            request.setStatus("REJECTED_BY_PROCTOR");
            request.setRejectionReason(reason);
    
            return repository.save(request);
        }
    
        return null;
    }

    //ACaccept methods
    public ODRequest approveByAC(Long id) {

        ODRequest request = repository.findById(id).orElse(null);
    
        if(request != null) {
            request.setStatus("PENDING_HOD");
            return repository.save(request);
        }
    
        return null;
    }

    //RejectAC method
    public ODRequest rejectByAC(Long id, String reason) {

        ODRequest request = repository.findById(id).orElse(null);
    
        if(request != null) {
    
            request.setStatus("REJECTED_BY_AC");
            request.setRejectionReason(reason);
    
            return repository.save(request);
        }
    
        return null;
    }

    public ODRequest approveByHOD(Long id) {

        ODRequest request = repository.findById(id).orElse(null);
    
        if(request != null) {
            request.setStatus("APPROVED");
            return repository.save(request);
        }
    
        return null;
    }

    public ODRequest rejectByHOD(Long id, String reason) {

        ODRequest request = repository.findById(id).orElse(null);
    
        if(request != null) {
    
            request.setStatus("REJECTED_BY_HOD");
            request.setRejectionReason(reason);
    
            return repository.save(request);
        }
    
        return null;
    }

}