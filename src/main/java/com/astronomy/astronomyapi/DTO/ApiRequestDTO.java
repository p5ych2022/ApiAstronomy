package com.astronomy.astronomyapi.DTO;

public class ApiRequestDTO {
    private String birthday; // 格式为 yyyy-MM-dd HH:mm
    private String longitude; // 经度
    private String latitude;  // 纬度
    private String tz;        // 时区
    // 构造方法
    public ApiRequestDTO() {
    }

    public ApiRequestDTO(String birthday, String longitude, String latitude) {
        this.birthday = birthday;
        this.longitude = longitude;
        this.latitude = latitude;
        this.tz = tz;
    }

    // Getter 和 Setter
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getTz() {
        return tz;
    }
}
