package dp.thudiep.th_tuan03;

import java.io.Serializable;

public class Taylor implements Serializable {
    private int anh;
    private String name, song;

    public Taylor(int anh, String name, String song) {
        this.anh = anh;
        this.name = name;
        this.song = song;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
