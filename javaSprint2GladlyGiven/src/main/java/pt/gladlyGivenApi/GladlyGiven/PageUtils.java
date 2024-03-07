// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
    public static <T> List<T> pageToList(Page<T> page) {
        ArrayList<T> list = new ArrayList<>();

        for (T element : page) {
            list.add(element);
        }

        return list;
    }
}
