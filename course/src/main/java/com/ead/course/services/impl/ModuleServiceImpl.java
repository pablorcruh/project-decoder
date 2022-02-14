package com.ead.course.services.impl;

import com.ead.course.models.ModuleModel;
import com.ead.course.repositories.ModuleRepository;
import com.ead.course.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public List<ModuleModel> findAllModulesIntoCourse(UUID courseId) {
        return null;
    }
}
