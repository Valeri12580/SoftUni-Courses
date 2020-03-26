package softuni.exam.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamImportDto {

    @Expose
    @XmlElement(name="name")
    private String name;

    @Expose
    @XmlElement(name="picture")
    private ImportPictureDto picture;



    public TeamImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImportPictureDto getPicture() {
        return picture;
    }

    public void setPicture(ImportPictureDto picture) {
        this.picture = picture;
    }
}
