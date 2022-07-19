package me.dio.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import me.dio.votacao.bbb.api.model.ParticipanteModel;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String> {

}
