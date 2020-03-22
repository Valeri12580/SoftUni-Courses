package com.softuni.xmlprocessing;

import com.softuni.xmlprocessing.entities.Address;
import com.softuni.xmlprocessing.entities.User;
import com.softuni.xmlprocessing.entities.Users;
import com.softuni.xmlprocessing.entities.dtos.UserDto;
import com.softuni.xmlprocessing.utils.XMLParser;
import com.softuni.xmlprocessing.utils.XMLParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class init implements CommandLineRunner {
    private ModelMapper modelMapper=new ModelMapper();
    private XMLParser xmlParser=new XMLParserImpl();
    @Override
    public void run(String... args) throws Exception {

        //write user to file
//        User user =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
//
//        UserDto userDto=this.modelMapper.map(user,UserDto.class);
//        System.out.println();
//        JAXBContext jaxbContext=JAXBContext.newInstance(UserDto.class);
//
//        Marshaller marshaller=jaxbContext.createMarshaller();
//
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
//
//        marshaller.marshal(userDto,new File("src/main/resources/files/output.xml"));
//        System.out.println();

//        ----------------
        //using my parser:
//        User user =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
////
//        UserDto userDto=this.modelMapper.map(user,UserDto.class);
//        this.xmlParser.write(userDto,"src/main/resources/files/output.xml");
//        System.out.println();



        //get user  from file
//        File file = new File("src/main/resources/files/output.xml");
//        JAXBContext jaxbContext=JAXBContext.newInstance(UserDto.class);
//
//        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
//
//        UserDto dto= (UserDto) unmarshaller.unmarshal(file);
//        System.out.println();

        //-----------
        //get user with parser

//
//        UserDto dto= (UserDto) this.xmlParser.read(UserDto.class,"src/main/resources/files/output.xml");
//        System.out.println();


        //write some users

//        User user =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
//        User user2 =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
//        User user3 =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
//
//        User[] users = {user,user2,user3};
//
//       UserDto[]usersDtos= this.modelMapper.map(users, UserDto[].class);
//
//        Users usersList=new Users(Arrays.asList(usersDtos));
//
//        System.out.println();
//
//        JAXBContext jaxbContext=JAXBContext.newInstance(Users.class);
//        Marshaller marshaller=jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
////
//        marshaller.marshal(usersList,new File("src/main/resources/files/output.xml"));

        //----------------
        //write some users using parser:

//        User user =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
//        User user2 =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
//        User user3 =new User("Valeri",18,"Tesla", List.of(new Address("Strqma 8 ","Klisura"),new Address("Carevo 10","Plovdiv")));
//
//        User[] users = {user,user2,user3};
//
//       UserDto[]usersDtos= this.modelMapper.map(users, UserDto[].class);
//
//        Users usersList=new Users(Arrays.asList(usersDtos));
//
//        System.out.println();
//
//        this.xmlParser.write(usersList,"src/main/resources/files/output.xml");
//
//


//        //get some users
//        File file = new File("src/main/resources/files/output.xml");
//
//        JAXBContext jaxbContext=JAXBContext.newInstance(Users.class);
//        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
//        Users users= (Users) unmarshaller.unmarshal(file);
//        System.out.println();

        //---------------------------------------

        Users users= (Users) this.xmlParser.read(Users.class,"src/main/resources/files/output.xml");
        System.out.println();

    }


}
