package com.astronomy.astronomyapi.DTO;

public class UserParamDTO {
    private String longitude;
    private String latitude;
    private String tz;
    private String birthday;

    // 构造方法
    public UserParamDTO() {}

    public UserParamDTO(String longitude, String latitude, String tz, String birthday) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.tz = tz;
        this.birthday = birthday;
    }

    // Getter 和 Setter
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

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
