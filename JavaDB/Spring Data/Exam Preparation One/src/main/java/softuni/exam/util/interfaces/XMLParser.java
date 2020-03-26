package softuni.exam.util.interfaces;

import javax.xml.bind.JAXBException;

public interface XMLParser {

     <T> void write(T object, String pathName) throws JAXBException;

     <T> T read(Class objectClass, String pathName) throws JAXBException;
}
