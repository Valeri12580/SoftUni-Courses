package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.entities.Town;
import hiberspring.domain.entities.dtos.importDtos.ImportTownDto;
import hiberspring.repository.TownRepository;
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
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private  final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, FileUtil fileUtil, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count()>0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/towns.json");
    }

    @Override
    public String importTowns(String townsFileContent) throws FileNotFoundException {
        ImportTownDto[]importTownDtos=this.gson.fromJson(new FileReader("src/main/resources/files/towns.json"),ImportTownDto[].class);
        StringBuilder sb=new StringBuilder();
        for (ImportTownDto importTownDto : importTownDtos) {
            Town town=this.modelMapper.map(importTownDto,Town.class);

            if(this.validationUtil.isValid(town)){
                this.townRepository.save(town);
                sb.append(String.format("Successfully imported Town %s.",town.getName()));
            }else{
                sb.append("Error: Invalid data.");
            }
            sb.append(System.lineSeparator());


        }


        return sb.toString();
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.getTownByName(name);
    }
}
