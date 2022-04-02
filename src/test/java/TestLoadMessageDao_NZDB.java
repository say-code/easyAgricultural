import com.eaproject.dao.LoadMessageDao_NZDB;

import java.io.IOException;

public class TestLoadMessageDao_NZDB {
    public static void main(String[] args) {
        try {
            LoadMessageDao_NZDB loadMessageDao_nzdb = new LoadMessageDao_NZDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
