package com.softuni.judgeversiontwo.services.interfaces;

import com.softuni.judgeversiontwo.models.service.RoleServiceModel;

public interface RoleService {

    RoleServiceModel findByName(String name);

}
