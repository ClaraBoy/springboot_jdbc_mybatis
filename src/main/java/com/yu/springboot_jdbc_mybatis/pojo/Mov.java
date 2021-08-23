package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Mov {
    private int mov_id;
    private String  mov_name;
    private String mov_img;
    private String mov_Director;
    private String mov_Screenwriter;
    private String mov_Starring;
    private String mov_Type;
    private String mov_Area;
    private String mov_Release_date;
    private String mov_Film_length;
    private String mov_Synopsis;
    private String mov_Download_link1;
    private String mov_Download_link2;
    private String mov_Download_link3;

    @Override
    public String toString() {
        return "Mov{" +
                "mov_id=" + mov_id +
                ", mov_name='" + mov_name + '\'' +
                ", mov_img='" + mov_img + '\'' +
                ", mov_Director='" + mov_Director + '\'' +
                ", mov_Screenwriter='" + mov_Screenwriter + '\'' +
                ", mov_Starring='" + mov_Starring + '\'' +
                ", mov_Type='" + mov_Type + '\'' +
                ", mov_Area='" + mov_Area + '\'' +
                ", mov_Release_date='" + mov_Release_date + '\'' +
                ", mov_Film_length='" + mov_Film_length + '\'' +
                ", mov_Synopsis='" + mov_Synopsis + '\'' +
                ", mov_Download_link1='" + mov_Download_link1 + '\'' +
                ", mov_Download_link2='" + mov_Download_link2 + '\'' +
                ", mov_Download_link3='" + mov_Download_link3 + '\'' +
                '}';
    }
};
