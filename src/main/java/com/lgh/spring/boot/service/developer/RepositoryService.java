package com.lgh.spring.boot.service.developer;

import com.lgh.spring.boot.model.MRepository;
import com.lgh.spring.boot.pojo.developer.RepositoryRequest;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2017/7/29.
 */
public interface RepositoryService {
    Page<MRepository> list(RepositoryRequest request);

    boolean createOrUpdateRepository(MRepository repository);
}
