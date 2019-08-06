package com.siniothk.comm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ApiModel(description = "版本实体")
@Data
@ToString
@TableName(value = "tb_version")
public class VersionEntity {

    // 0：未发布；1：发布; 2:禁用
    public static int STATUS_INIT = 0;
    public static int STATUS_ENABLE = 1;
    public static int STATUS_DISABLE = 2;

//    Field          Type           Collation        Null    Key     Default  Extra           Privileges                       Comment
//-------------  -------------  ---------------  ------  ------  -------  --------------  -------------------------------  ---------
//    id             bigint(20)     (NULL)           NO      PRI     (NULL)   auto_increment  select,insert,update,references
//    versionCode    int(11)        (NULL)           YES             0                        select,insert,update,references
//    versionName    varchar(32)    utf8_general_ci  YES             (NULL)                   select,insert,update,references
//    versionSize    bigint(20)     (NULL)           YES             0                        select,insert,update,references
//    versionPath    varchar(512)   utf8_general_ci  YES             (NULL)                   select,insert,update,references
//    versionUrl     varchar(1024)  utf8_general_ci  YES             (NULL)                   select,insert,update,references
//    verCreateTime  datetime       (NULL)           YES             (NULL)                   select,insert,update,references
//    versionStatus  int(11)        (NULL)           YES             0                        select,insert,update,references


    @ApiModelProperty(value = "ID")
    @TableId(value="id", type= IdType.INPUT)
    private Long id;

    @ApiModelProperty(value = "版本号")
    @TableField("versionCode")
    private int versionCode;

    @ApiModelProperty(value = "版本名称")
    @TableField("versionName")
    private String versionName;

    @ApiModelProperty(value = "版本大小")
    @TableField("versionSize")
    private long versionSize;

    @ApiModelProperty(value = "版本路径")
    @TableField("versionPath")
    private String versionPath;

    @ApiModelProperty(value = "下载用户量")
    @TableField("versionUser")
    private int versionUser;

    @ApiModelProperty(value = "创建时间")
    @TableField("verCreateTime")
    private Date verCreateTime;

    @ApiModelProperty(value = "发布时间")
    @TableField("verPublicTime")
    private Date verPublicTime;

    @ApiModelProperty(value = "发布状态")
    @TableField("versionStatus") // 0：未发布；1：发布; 2:禁用
    private int versionStatus;
}
