package lk.ijse.carRent.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ImageDTO {
    private MultipartFile front_View;
    private MultipartFile back_View;
    private MultipartFile side_View;
    private MultipartFile interior;
}
