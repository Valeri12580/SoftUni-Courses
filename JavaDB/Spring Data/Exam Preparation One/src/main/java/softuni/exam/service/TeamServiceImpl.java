package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.Picture;
import softuni.exam.domain.Team;
import softuni.exam.domain.dtos.importDtos.ImportTeamRootDto;
import softuni.exam.domain.dtos.importDtos.TeamImportDto;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;
import softuni.exam.util.interfaces.XMLParser;


import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final FileUtil fileUtil;
    private final XMLParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, FileUtil fileUtil, XMLParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
    }


    @Override
    
    public String importTeams() throws JAXBException, FileNotFoundException {
        ImportTeamRootDto importTeamRootDto=this.xmlParser.read(ImportTeamRootDto.class,"src/main/resources/files/xml/teams.xml");


        for (TeamImportDto teamImportDto : importTeamRootDto.getTeams()) {
            Team team =this.modelMapper.map(teamImportDto,Team.class);
            String pictureUrl=team.getPicture().getUrl();
            Picture pictureFromDb=this.pictureService.getPictureByUrl(pictureUrl);
            team.setPicture(pictureFromDb);

            if(this.validationUtil.isValid(team)){
                this.teamRepository.save(team);
                System.out.println("Successfully imported - "+" "+team.getName());
            }else{
                System.out.println("Invalid team!");
            }

        }


       return "“Successfully imported teams";
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count()>0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/xml/teams.xml");
    }

    @Override
    public Team getTeamByName(String name) {

        return this.teamRepository.getByName(name);
    }

}
