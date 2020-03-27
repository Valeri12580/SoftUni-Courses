package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.domain.entities.dtos.importDtos.ImportBranchDto;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.interfaces.FileUtil;
import hiberspring.util.interfaces.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/branches.json");
    }

    @Override
    public String importBranches(String branchesFileContent) throws FileNotFoundException {
        ImportBranchDto[] importBranchDtos = this.gson.fromJson(new FileReader("src/main/resources/files/branches.json"), ImportBranchDto[].class);
        StringBuilder sb = new StringBuilder();
        for (ImportBranchDto importBranchDto : importBranchDtos) {
            Branch branch = this.modelMapper.map(importBranchDto, Branch.class);
            Town town = this.townService.getTownByName(importBranchDto.getTown());
            branch.setTown(town);
            if (this.validationUtil.isValid(branch)) {


                this.branchRepository.save(branch);
                sb.append(String.format("Successfully imported Branch  %s.", branch.getName()));
            } else {
                sb.append("Error: Invalid data.");
            }
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }

    @Override
    public Branch getBranchByName(String name) {
        return this.branchRepository.findBranchByName(name);
    }
}
