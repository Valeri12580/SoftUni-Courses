package softuni.exam.domain.dtos.importDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPictureRootDto {
    public ImportPictureRootDto() {
    }

    @XmlElement(name="picture")
    private List<ImportPictureDto> pictures;

    public ImportPictureRootDto(List<ImportPictureDto> pictures) {
        this.pictures = pictures;
    }


    public List<ImportPictureDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<ImportPictureDto> pictures) {
        this.pictures = pictures;
    }
}
