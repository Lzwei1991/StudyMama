package sg.com.studymama.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture{
    @Field(type = FieldType.Text)
    public String link1;
    @Field(type = FieldType.Text)
    public String link2;
}