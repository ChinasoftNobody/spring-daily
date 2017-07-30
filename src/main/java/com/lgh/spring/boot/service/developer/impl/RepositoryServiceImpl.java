package com.lgh.spring.boot.service.developer.impl;

import com.lgh.spring.boot.model.MRepository;
import com.lgh.spring.boot.pojo.developer.RepositoryRequest;
import com.lgh.spring.boot.repo.RepositoryRepo;
import com.lgh.spring.boot.service.developer.RepositoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Resource
    private RepositoryRepo repositoryRepo;

    @Override
    public Page<MRepository> list(RepositoryRequest request) {
        return repositoryRepo.findByNameContaining(new PageRequest(request.getPageNumber(), request.getPageSize()), request.getKeywords());
    }

    @Override
    public boolean createOrUpdateRepository(MRepository repository) {
        return repositoryRepo.save(repository) == null;
    }

    @Override
    public boolean deleteRepositories(List<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            for (String id:ids){
                repositoryRepo.delete(id);
            }
            return true;
        }
        return false;
    }
}
