package softuni.exam.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPictureDto {

    @Expose
    @XmlElement(name="url")
    private String url;

    public ImportPictureDto(String url) {
        this.url = url;
    }

    public ImportPictureDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
