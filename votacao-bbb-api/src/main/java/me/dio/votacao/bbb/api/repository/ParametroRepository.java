package me.dio.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import me.dio.votacao.bbb.api.model.ParametroModel;

public interface ParametroRepository extends MongoRepository<ParametroModel, String> {

}
