package no.rosenhoff.common.data;

import java.util.Arrays;
import java.util.List;

public enum Sesong {
    SESONG_2009("2010/2011"), // en liten bug
    SESONG_2011("2011/2012"),
    SESONG_2012("2012/2013"),
    SESONG_2013("2013/2014"),
    SESONG_2014("2014/2015"),
    SESONG_2015("2015/2016"),
    SESONG_2016("2016/2017"),
    SESONG_2017("2017/2018"),
    SESONG_2018("2018/2019"),
    SESONG_2019("2019/2020"),
    SESONG_2020("2020/2022"),
    SESONG_2021("2021/2022"),
    SESONG_2022("2022/2023");

    private final String displayText;

    Sesong(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    public static List<Sesong> getAllAsList() {
        return Arrays.asList(values());
    }

}
