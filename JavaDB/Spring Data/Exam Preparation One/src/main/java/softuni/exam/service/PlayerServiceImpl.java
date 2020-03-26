package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.Picture;
import softuni.exam.domain.Player;
import softuni.exam.domain.Team;
import softuni.exam.domain.dtos.importDtos.ImportPlayerDto;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;


import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final PictureService pictureService;
    private final TeamService teamService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private  StringBuilder stringBuilder;



    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, FileUtil fileUtil, Gson gson, PictureService pictureService, TeamService teamService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.playerRepository = playerRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.pictureService = pictureService;
        this.teamService = teamService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;

    }


    @Override
    public String importPlayers() throws IOException {
        ImportPlayerDto[] importPlayerDtos = this.gson.fromJson(new FileReader("src/main/resources/files/json/players.json"), ImportPlayerDto[].class);
        for (ImportPlayerDto importPlayerDto : importPlayerDtos) {
            Picture pictureFromDb=this.pictureService.getPictureByUrl(importPlayerDto.getPicture().getUrl());
            Team teamFromDb=this.teamService.getTeamByName(importPlayerDto.getTeam().getName());
            Player player=this.modelMapper.map(importPlayerDto,Player.class);

            player.setPicture(pictureFromDb);
            player.setTeam(teamFromDb);

            if(this.validationUtil.isValid(player)){
                this.playerRepository.save(player);
                System.out.println("Successfully imported player: "+player.getFirstName()+" "+player.getLastName());
            }else{
                System.out.println("Invalid player");
            }

        }
        return "Successfully imported players";
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/json/players.json");
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {

        List<Player>players=this.playerRepository.findAllBySalaryGreaterThan(new BigDecimal("100000"));
        this.stringBuilder=new StringBuilder();

        players.forEach(p->{
            stringBuilder.append(String.format("Player name: %s %s" +
                    "\n\tNumber: %d" +
                    "\n\tSalary: %s" +
                    "\n\tTeam: %s\n", p.getFirstName(),p.getLastName(),p.getNumber(),p.getSalary(),p.getTeam().getName()));
        });

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        List<Player>players=this.playerRepository.findAllByTeamName("North Hub");
        stringBuilder=new StringBuilder();
        stringBuilder.append("Team: ").append("North Hub\n");
        players.forEach(p->{
            stringBuilder.append(String.format("\tPlayer name: %s %s - %s\n\tNumber: %d\n",p.getFirstName(),p.getLastName(),p.getPosition(),p.getNumber()));
        });
        return stringBuilder.toString().trim();
    }


}
