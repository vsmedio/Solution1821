
/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Byte, Integer> frequencyMap = new TreeMap<Byte, Integer>();
        FileInputStream f = new FileInputStream(args[0]);

        while (f.available() > 0) {
            byte[] buf = new byte[f.available()];
            f.read(buf);

            for (int i = 0; i < buf.length; i++) {
                if (frequencyMap.containsKey(buf[i]))
                    frequencyMap.put(buf[i], frequencyMap.get(buf[i]) + 1);
                else
                    frequencyMap.put(buf[i], 1);
            }
        }
        f.close();

        for (Map.Entry pair : frequencyMap.entrySet()) {
            System.out.println((char)((byte) pair.getKey()) + " " + pair.getValue());
        }
    }
}