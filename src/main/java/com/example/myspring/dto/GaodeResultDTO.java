package com.example.myspring.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.util.Pair;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 高德返回结果，需要说明的是，高德返回空字段时返回的是一个空list而不是空字符串，所以解析到结果就是成了"[]"
 *
 * @author rorschach
 * @date 2023-03-15
 */
public class GaodeResultDTO {
    @Data
    @ApiModel(value = "高德地理编码返回结果", description = "通过地址反查经纬度")
    public static class Geo implements Serializable {
        private static final long serialVersionUID = -485613941329859100L;

        @ApiModelProperty("国家。国内地址默认返回中国")
        private String country;

        @ApiModelProperty("地址所在的省份名。例如：北京市。此处需要注意的是，中国的四大直辖市也算作省级单位。")
        private String province;

        @ApiModelProperty("地址所在的城市名。例如：北京市")
        private String city;

        @ApiModelProperty("城市编码。例如：010")
        private String citycode;

        @ApiModelProperty("地址所在的区。例如：朝阳区")
        private String district;

        @ApiModelProperty("街道。例如：阜通东大街")
        private List<String> street;

        @ApiModelProperty("门牌。例如：6号")
        private String number;

        @ApiModelProperty("区域编码。例如：110101")
        private String adcode;

        @ApiModelProperty("坐标点。经度，纬度")
        private String location;

        @ApiModelProperty("匹配级别。表格：https://lbs.amap.com/api/webservice/guide/api/georegeo#geo_list")
        private String level;

        /**
         * 获取解析后的坐标
         *
         * @return key=经度，value=纬度
         */
        public Pair<BigDecimal, BigDecimal> getCoordinate() {
            if (StringUtils.isEmpty(this.location)) {
                return null;
            }
            try {
                String[] split = StringUtils.split(this.location, ",");
                return new Pair<>(new BigDecimal(split[0]), new BigDecimal(split[1]));
            } catch (Exception ignore) {
                return null;
            }
        }
    }

    /**
     * 该接口返回结果较多，仅加了基础字段，如果有其他字段需求，再添加即可
     */
    @Data
    @ApiModel(value = "高德逆地理编码返回结果", description = "通过经纬度反查地址")
    public static class Regeo implements Serializable {
        @ApiModelProperty("地址元素列表")
        private AddressComponent addressComponent;

        @ApiModelProperty("完整地址")
        private String formatted_address;
    }

    @Data
    @ApiModel(value = "高德逆地理编码-地址元素列表", description = "通过经纬度反查地址")
    public static class AddressComponent implements Serializable {
        private static final long serialVersionUID = 3022899200267647503L;

        @ApiModelProperty("国家")
        private String country;

        @ApiModelProperty("坐标点所在省名称")
        private String province;

        @ApiModelProperty("坐标点所在城市名称")
        private String city;

        @ApiModelProperty("城市编码")
        private String citycode;

        @ApiModelProperty("坐标点所在区")
        private String district;

        @ApiModelProperty("行政区编码")
        private String adcode;

        @ApiModelProperty("坐标点所在乡镇/街道（此街道为社区街道，不是道路信息）")
        private String township;

        @ApiModelProperty("乡镇街道编码")
        private String towncode;
    }

    @Data
    @ApiModel(value = "高德驾车路线规划方案", description = "高德驾车路线规划方案")
    public static class DrivingRoutePlan implements Serializable {
        @ApiModelProperty("起始点经纬度坐标。经度在前，纬度在后，经纬度间以“,”分割")
        private String origin;

        @ApiModelProperty(value = "终点经纬度坐标。经度在前，纬度在后，经纬度间以“,”分割")
        private String destination;

        @ApiModelProperty("预计出租车费用，单位：元")
        private String taxiCost;

        @ApiModelProperty("算路方案详情")
        List<DrivingRoutePlan.Path> paths;

        @ApiModel("算路方案详情")
        @Data
        static class Path implements Serializable {
            @ApiModelProperty("方案距离，单位：米")
            private String distance;

            @ApiModelProperty("0 代表限行已规避或未限行，即该路线没有限行路段 1 代表限行无法规避，即该线路有限行路段")
            private String restriction;

            @ApiModelProperty("路线分段")
            private Step step;
        }

        @ApiModel("路线分段")
        @Data
        static class Step implements Serializable {

            @ApiModelProperty("行驶指示")
            private String instruction;

            @ApiModelProperty("进入道路方向")
            private String orientation;

            @ApiModelProperty("分段道路名称")
            private String roadName;

            @ApiModelProperty("分段距离信息")
            private String stepDistance;
        }
    }
}
