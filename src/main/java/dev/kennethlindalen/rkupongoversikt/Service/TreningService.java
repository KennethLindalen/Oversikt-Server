package dev.kennethlindalen.rkupongoversikt.Service;

import dev.kennethlindalen.rkupongoversikt.Models.TreningDocumentModel;
import dev.kennethlindalen.rkupongoversikt.Repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {

    @Autowired
    private TreningRepository treningRepository;

    public TreningDocumentModel create(String dato, String stil, String tid, Boolean fullfort, Boolean planlagt){
        return treningRepository.save(new TreningDocumentModel(dato, stil, tid, fullfort, planlagt));
    }

    public List<TreningDocumentModel> getAll(){
        return treningRepository.findAll();
    }

    public TreningDocumentModel update(String id, String dato, String stil, String tid, Boolean fullfort, Boolean planlagt){
        TreningDocumentModel treningDocumentModel = treningRepository.findById(id).get();
        treningDocumentModel.setDato(dato);
        treningDocumentModel.setStil(stil);
        treningDocumentModel.setTid(tid);
        treningDocumentModel.setFullfort(fullfort);
        treningDocumentModel.setPlanlagt(planlagt);

        return treningRepository.save(treningDocumentModel);
    }

    public void delete(String id){
        TreningDocumentModel treningDocumentModel = treningRepository.findById(id).get();
        treningRepository.delete(treningDocumentModel);
    }

}
