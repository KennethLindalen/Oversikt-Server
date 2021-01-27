package dev.kennethlindalen.rkupongoversikt.Service;

import dev.kennethlindalen.rkupongoversikt.Repository.TreningRepository;
import dev.kennethlindalen.rkupongoversikt.Models.Trening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreningService {

    @Autowired
    private TreningRepository treningRepository;

    public Trening create(String dato,String stil, String tid, Boolean fullfort, Boolean planlagt){
        return treningRepository.save(new Trening(dato, stil, tid, fullfort, planlagt));
    }

    public List<Trening> getAll(){
        return treningRepository.findAll();
    }

    public Trening update(String id, String dato, String stil, String tid, Boolean fullfort, Boolean planlagt){
        Trening trening = treningRepository.findById(id).get();
        trening.setDato(dato);
        trening.setStil(stil);
        trening.setTid(tid);
        trening.setFullfort(fullfort);
        trening.setPlanlagt(planlagt);

        return treningRepository.save(trening);
    }

    public void delete(String id){
        Trening trening = treningRepository.findById(id).get();
        treningRepository.delete(trening);
    }

}
