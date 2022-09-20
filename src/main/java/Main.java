import list.ExtArrayList;
import list.ExtList;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import static utils.DataProvider.generateRandomIntArray;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ExtList<Integer> extList = new ExtArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for(Integer val: generateRandomIntArray(101, 10)) {
            extList.add(val);
            expected.add(val);
        }
        log.info("extList: {}", extList);

        expected.sort(null);

        for(int i = 10; i<37; i++)
            extList.delete(i);
        log.info("extList: {}", extList);

        log.info("1 elem: {}, 3 elem: {}, extList size: {}", extList.get(0), extList.get(2), extList.size());
        extList.clearAll();
        log.info("1 elem: {}, 3 elem: {}, extList size: {}", extList.get(0), extList.get(2), extList.size());
    }
}
